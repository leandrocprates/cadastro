package com.example.cadastro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nome ;

    private boolean ativo ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data ;

    @OneToMany(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL)
    @JoinColumn(name="USUARIO_ID")
    private List<Endereco> enderecos ;


}
