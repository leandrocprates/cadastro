package com.example.cadastro.controller;

import com.example.cadastro.dto.UsuarioDTO;
import com.example.cadastro.model.Usuario;
import com.example.cadastro.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioService usuarioService ;

    @RequestMapping("")
    public ResponseEntity<Object> listarTodos(){
        List<Usuario> listUsuarios = usuarioService.listarTodos();
        return new ResponseEntity<>(listUsuarios , HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Object> getUsuarioById(@PathVariable Long id){
        UsuarioDTO usuarioDTO =  usuarioService.getUsuarioById(id);
        return new ResponseEntity<>( usuarioDTO, HttpStatus.OK ) ;
    }

    /**
     * Modelo json para cadastro e update
     *
     * Header :
     * Content-Type : application/json
     *
     * body:
     * {
     * 	    "id" : "5"   ,
     *      "nome": "Vanessa teste cadeira ",
     *      "ativo": "true",
     * 	    "data" : "2020-04-30T20:50:30"
     * }
     *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> salvar(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuarioDTOCreated =  usuarioService.salvar(usuarioDTO);
        return new ResponseEntity<>(usuarioDTOCreated, HttpStatus.CREATED );
    }

    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleleById(@PathVariable  Long id){
        usuarioService.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK );
    }

}
