package com.example.cadastro.converter;

import com.example.cadastro.dto.EnderecoDTO;
import com.example.cadastro.dto.GenericDTO;
import com.example.cadastro.model.Endereco;
import com.example.cadastro.model.GenericEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EnderecoConverter  implements Converter {

    @Override
    public GenericDTO convertToDTO(GenericEntity entity) {
        Endereco endereco = (Endereco) entity ;
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        BeanUtils.copyProperties(endereco,enderecoDTO);
        return enderecoDTO;
    }

    @Override
    public GenericEntity convertToEntity(GenericDTO dto) {
        EnderecoDTO enderecoDTO = (EnderecoDTO) dto  ;
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO,endereco);
        return endereco;
    }

    @Override
    public List<? extends GenericDTO> convertToListDTO(List<? extends GenericEntity> listEntity) {
        List<EnderecoDTO> listaEnderecosDTO = new ArrayList<EnderecoDTO>();

        Optional< List<? extends GenericEntity> > listEntity1  = Optional.ofNullable(listEntity);
        if ( listEntity1.isPresent() ){
            listEntity.stream().forEach(endereco -> {
                EnderecoDTO enderecoDTO = ( EnderecoDTO ) convertToDTO(endereco);
                listaEnderecosDTO.add(enderecoDTO);
            });
        }

        return listaEnderecosDTO;
    }

}
