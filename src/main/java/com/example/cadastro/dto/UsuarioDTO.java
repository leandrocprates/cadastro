package com.example.cadastro.dto;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "Código do Usuario")
    private Long id ;
    @ApiModelProperty(value = "Nome do Usuario")
    private String nome ;
    @ApiModelProperty(value = "Retorna se Usuario esta Ativo ou Inativo no Sistema")
    private boolean ativo ;
    @ApiModelProperty(value = "Data de Criação do Usuario no Sistema")
    private Date data ;
    @ApiModelProperty(value = "Endereço vinculado ao Usuario")
    private List<EnderecoDTO> enderecoDTO =  new ArrayList<EnderecoDTO>();
}
