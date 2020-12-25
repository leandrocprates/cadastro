package com.example.cadastro.converter;

import com.example.cadastro.dto.EnderecoDTO;
import com.example.cadastro.dto.GenericDTO;
import com.example.cadastro.dto.UsuarioDTO;
import com.example.cadastro.model.Endereco;
import com.example.cadastro.model.GenericEntity;
import com.example.cadastro.model.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsuarioConverter implements Converter {

    @Autowired
    EnderecoConverter enderecoConverter ;

    @Override
    public GenericDTO convertToDTO(GenericEntity entity) {
        Usuario usuario = (Usuario) entity ;
        UsuarioDTO usuarioDTO = new UsuarioDTO() ;
        BeanUtils.copyProperties( usuario , usuarioDTO ) ;

        List<EnderecoDTO> listaEnderecosDTO = (List<EnderecoDTO>) enderecoConverter.convertToListDTO(usuario.getEnderecos()) ;
        usuarioDTO.setEnderecoDTO(listaEnderecosDTO);
        return usuarioDTO ;
    }

    @Override
    public GenericEntity convertToEntity(GenericDTO dto) {
        UsuarioDTO usuarioDTO = (UsuarioDTO) dto ;
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties( usuarioDTO , usuario ) ;

        List<Endereco>  listEndereco = (List<Endereco>) enderecoConverter.convertToListEntity(usuarioDTO.getEnderecoDTO()) ;
        usuario.setEnderecos(listEndereco);
        return usuario ;
    }

    @Override
    public List<? extends GenericDTO> convertToListDTO(List<? extends GenericEntity>  listEntity  ){
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<UsuarioDTO>();
        listEntity.stream().forEach(usuario -> {
            UsuarioDTO usuarioDTO = (UsuarioDTO) convertToDTO(usuario) ;
            listaUsuariosDTO.add(usuarioDTO);
        });
        return listaUsuariosDTO ;
    }

    @Override
    public List<? extends GenericEntity> convertToListEntity(List<? extends GenericDTO> listDTO) {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();

        Optional< List<? extends GenericDTO> > optionalListDto  = Optional.ofNullable(listDTO);
        if ( optionalListDto.isPresent() ){
            List<? extends GenericDTO>  listDtoUsuario = optionalListDto.get() ;

            listDtoUsuario.stream().forEach(usuarioDto -> {
                Usuario usuario = ( Usuario ) convertToEntity(usuarioDto);
                listaUsuarios.add(usuario);
            });
        }
        return listaUsuarios;
    }




}
