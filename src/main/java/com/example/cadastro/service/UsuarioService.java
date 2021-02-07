package com.example.cadastro.service;


import com.example.cadastro.converter.UsuarioConverter;
import com.example.cadastro.dto.UsuarioDTO;
import com.example.cadastro.exception.ObjectNotFoundException;
import com.example.cadastro.model.Usuario;
import com.example.cadastro.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    UsuarioRepository usuarioRepository ;

    @Autowired
    UsuarioConverter usuarioConverter ;


    public UsuarioDTO salvar(UsuarioDTO usuarioDTO){
        Usuario usuario = (Usuario) usuarioConverter.convertToEntity(usuarioDTO) ;
        usuario = usuarioRepository.save(usuario);
        usuarioDTO = (UsuarioDTO) usuarioConverter.convertToDTO(usuario);
        return usuarioDTO ;
    }

    public UsuarioDTO getUsuarioById(Long id){
        UsuarioDTO usuarioDTO = null ;
        logger.info("Buscando Usuario com ID {}" , id);
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);

        if ( optUsuario.isPresent() ) {
            Usuario usuario = optUsuario.get() ;
            usuarioDTO = (UsuarioDTO) usuarioConverter.convertToDTO(usuario);
        } else {
            throw new ObjectNotFoundException(String.format("Usuario ID [%d] nao encontrado." , id) ) ;
        }
        return usuarioDTO ;
    }

    public List<UsuarioDTO> listarTodos(){
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        List<UsuarioDTO> listaUsuariosDTO = (List<UsuarioDTO>) usuarioConverter.convertToListDTO(listaUsuarios);

        if ( listaUsuariosDTO.isEmpty() ) {
            throw new ObjectNotFoundException("Nenhum Usuario encontrado no Banco de Dados."  ) ;
        }
        return listaUsuariosDTO ;
    }


    public void deleteById(Long id){
        try{
            usuarioRepository.deleteById(id);
        }catch(EmptyResultDataAccessException ex){
            throw new ObjectNotFoundException(String.format("Usuario ID [%d] nao encontrado para exclusao " , id) ) ;
        }
    }

}
