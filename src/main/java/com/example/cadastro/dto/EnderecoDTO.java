package com.example.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO extends GenericDTO {
    private Long id ;
    private String cep ;
    private String endereco ;
    private String bairro ;

}
