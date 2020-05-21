package com.example.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO extends GenericDTO {
    private Long id ;
    private String nome ;
    private boolean ativo ;
    private Date data ;
    private List<EnderecoDTO> enderecoDTO =  new ArrayList<EnderecoDTO>();
}
