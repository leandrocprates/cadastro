package com.example.cadastro.model;

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
    @JoinColumn(name = "usuario_id")
    private Usuario usuario ;




}
