package com.example.cadastro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Endereco extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String cep ;
    private String endereco ;
    private String bairro ;

    //@ManyToOne
    //@JoinColumn(name="USUARIO_ID")
    //@JsonBackReference
    //private Usuario usuario ;

}
