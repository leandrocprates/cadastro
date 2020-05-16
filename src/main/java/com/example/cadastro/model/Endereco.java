package com.example.cadastro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String cep ;
    private String endereco ;
    private String bairro ;

    @ManyToOne
    @JsonBackReference
    private Usuario usuario ;

}
