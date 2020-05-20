package com.example.cadastro.controller;

import com.example.cadastro.dto.UsuarioDTO;
import com.example.cadastro.model.Usuario;
import com.example.cadastro.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioService usuarioService ;

    @ApiOperation(value = "Retorna a lista de Usuarios." )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de Usuarios"),
            @ApiResponse(code = 404, message = "Nenhum Usuario Encontrado"),
            @ApiResponse(code = 500, message = "Erro Interno no Servidor")
    })
    @RequestMapping(value="", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDTO>> listarTodos(){
        List<UsuarioDTO> listUsuariosDTO = usuarioService.listarTodos();
        return new ResponseEntity<>(listUsuariosDTO , HttpStatus.OK);
    }

    @ApiOperation(value = "Retorno o usuario pelo id informado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o usuario pelo Id informado"),
            @ApiResponse(code = 404, message = "Usuario nao Encontrado"),
            @ApiResponse(code = 500, message = "Erro Interno no Servidor")
    })
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id){
        UsuarioDTO usuarioDTO =  usuarioService.getUsuarioById(id);
        return new ResponseEntity<UsuarioDTO>( usuarioDTO, HttpStatus.OK ) ;
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
    @ApiOperation(value="Salva um usuario . Retornando o usuario com o Id gerando no banco.")
    @ApiResponses(value = {
            @ApiResponse(code = 200 , message = "Salva usuario no Banco de Dados "),
            @ApiResponse(code = 500, message = "Erro Interno no Servidor")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuarioDTOCreated =  usuarioService.salvar(usuarioDTO);
        return new ResponseEntity<UsuarioDTO>(usuarioDTOCreated, HttpStatus.CREATED );
    }

    @ApiOperation(value = "Deleta usuario pelo Id informado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Excluir usuario pelo ID informado"),
            @ApiResponse(code = 404, message = "Usuario nao Encontrado"),
            @ApiResponse(code = 500, message = "Erro Interno no Servidor")
    })
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleleById(@PathVariable  Long id){
        usuarioService.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK );
    }

}
