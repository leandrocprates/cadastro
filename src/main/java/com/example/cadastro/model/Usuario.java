package com.example.cadastro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nome ;

    private boolean ativo ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data ;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "usuario")
    @JsonManagedReference
    private List<Endereco> enderecos ;


}
