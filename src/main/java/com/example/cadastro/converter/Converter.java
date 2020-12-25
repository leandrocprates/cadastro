package com.example.cadastro.converter;

import com.example.cadastro.dto.GenericDTO;
import com.example.cadastro.model.GenericEntity;

import java.util.List;

public interface Converter {
        public GenericDTO convertToDTO(GenericEntity entity);
        public GenericEntity convertToEntity(GenericDTO dto);
        public List<?extends GenericDTO> convertToListDTO(List<? extends GenericEntity>  listEntity);
        public List<? extends GenericEntity> convertToListEntity(List<? extends GenericDTO> listDTO) ;
}
