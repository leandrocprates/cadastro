package com.example.cadastro.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nome ;

    private boolean ativo ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Endereco> enderecos ;


}
