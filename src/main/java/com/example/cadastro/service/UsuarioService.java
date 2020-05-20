package com.example.cadastro.service;


import com.example.cadastro.dto.EnderecoDTO;
import com.example.cadastro.dto.UsuarioDTO;
import com.example.cadastro.exception.ObjectNotFoundException;
import com.example.cadastro.model.Usuario;
import com.example.cadastro.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario );
        usuario = usuarioRepository.save(usuario);
        BeanUtils.copyProperties(usuario, usuarioDTO);
        return usuarioDTO ;
    }

    public UsuarioDTO getUsuarioById(Long id){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        logger.info("Buscando Usuario com ID {}" , id);
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if ( optUsuario.isPresent() ) {
            Usuario usuario = optUsuario.get() ;
            BeanUtils.copyProperties(usuario , usuarioDTO ) ;
            usuario.getEnderecos().stream().forEach(endereco ->  {
                EnderecoDTO enderecoDTO = new EnderecoDTO();
                BeanUtils.copyProperties(endereco , enderecoDTO ) ;
                usuarioDTO.getEnderecoDTO().add(enderecoDTO) ;
            } );

        } else {
            throw new ObjectNotFoundException(String.format("Usuario ID [%d] nao encontrado." , id) ) ;
        }
        return usuarioDTO ;
    }

    public List<UsuarioDTO> listarTodos(){
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<UsuarioDTO>();
        listaUsuarios.stream().forEach(usuario -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            BeanUtils.copyProperties(usuario , usuarioDTO ) ;
            listaUsuariosDTO.add(usuarioDTO);
        });
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
