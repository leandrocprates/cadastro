package com.example.cadastro.controller;

import com.example.cadastro.dto.UsuarioDTO;
import com.example.cadastro.model.Usuario;
import com.example.cadastro.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioService usuarioService ;

    @RequestMapping("")
    public List<Usuario> listarTodos(){
        return usuarioService.listarTodos();
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public UsuarioDTO getUsuarioById(@PathVariable Long id){
        return usuarioService.getUsuarioById(id);
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
    public UsuarioDTO salvar(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.salvar(usuarioDTO);
    }

    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public void deleleById(@PathVariable  Long id){
        usuarioService.deleteById(id);
    }

}
