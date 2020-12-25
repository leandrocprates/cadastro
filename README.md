# cadastro


<p>Este projeto consiste num projeto Spring boot com APIs REST criando num modelo de  <b>DTO</b> pattern , documentação com <b>Swagger 2</b> e acesso ao Banco com <b>Spring Data</b>.</p> 


Swagger inicializado na classe do pacote abaixo 

<b>com.example.cadastro.config.SwaggerConfig</b>

```html
@Configuration
@EnableSwagger2
public class SwaggerConfig {
```

No pacote DTO esta implementada as classes de Transferencia de Dados entre entrada dos Serviços Rest e Saida de Dados como Resposta. Modelo de <b>UsuarioDTO</b> 
Pacote : <b>com.example.cadastro.dto.UsuarioDTO</b>



```html 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO extends GenericDTO {
    @ApiModelProperty(value = "Código do Usuario")
    private Long id ;
    @ApiModelProperty(value = "Nome do Usuario")
    private String nome ;
    @ApiModelProperty(value = "Retorna se Usuario esta Ativo ou Inativo no Sistema")
    private boolean ativo ;
    @ApiModelProperty(value = "Data de Criação do Usuario no Sistema")
    private Date data ;
    @ApiModelProperty(value = "Endereço vinculado ao Usuario")
    private List<EnderecoDTO> enderecoDTO =  new ArrayList<EnderecoDTO>();
}

```








<ol>
<li>
  Executar o start do projeto . A documentação do projeto feita com Swagger 2 esta acessivel na seguinte URL: <p>
  <a href="http://localhost:9096/swagger-ui.html">http://localhost:9096/swagger-ui.html</a>
</li>


<li>
  Metodo <b>GET</b> : <a href="http://localhost:9096/usuario">http://localhost:9096/usuario</a>
  
  Recupera todos os usuarios na base de dados. 

Response Body : 

```json
[
  {
    "id": 1,
    "nome": "Leandro",
    "ativo": true,
    "data": "2020-04-19T15:35:26.000+0000",
    "enderecoDTO": [
      {
        "id": 30,
        "cep": "01040-060",
        "endereco": "Avenida Paulista",
        "bairro": "Bela Vista"
      }
    ]
  },
  {
    "id": 2,
    "nome": "Ariane",
    "ativo": false,
    "data": "2020-04-19T15:35:26.000+0000",
    "enderecoDTO": []
  }
]

```
</li> 



<li>
  Metodo <b>GET</b> : <a href="http://localhost:9096/usuario/1">http://localhost:9096/usuario/1</a>
  
  Recupera usuario pelo id 
  
  Response Body :
  
  ```json 
  {
    "id": 1,
    "nome": "Leandro Cesar Prates",
    "ativo": true,
    "data": "2020-04-19T15:35:26.000+0000",
    "enderecoDTO": [
      {
        "id": 30,
        "cep": "02440-050",
        "endereco": "Avenida Joao Pessoa",
        "bairro": "Lauzane Paulista"
      }
    ]
  }
  
  ``` 
  
  
</li> 



<li>
  
  Metodo <b>POST</b> : <a href="http://localhost:9096/usuario">http://localhost:9096/usuario</a>

  Insere um novo Usuario com Endereço no Banco de Dados 


  Content-Type : application/json

  Response Body  : 

```json 
    {
       "nome":"Senhro neves ",
       "ativo":"true",
       "data":"2020-04-30T20:50:30",
       "enderecoDTO":[
          {
             "cep":"01040-060",
             "endereco":"Avenida Barrao de Limeira",
             "bairro":"Ibirapuera"
          }
       ]

    }  
  
```   
  
</li>  


<li>
  Metodo <b>DELETE</b> : <a href="http://localhost:9096/usuario/24">http://localhost:9096/usuario/24</a>

  Deleta usuario pelo id informado no path   
  
</li>  
  




</ol>




