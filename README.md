# cadastro


<p>Este projeto consiste num projeto Spring boot com APIs REST criando num modelo de  <b>DTO</b> pattern , documentação com <b>Swagger 2</b> e acesso ao Banco com <b>Spring Data</b>.</p> 


<ol>
<li>
  Executar o start do projeto . A documentação do projeto feita com Swagger 2 esta acessivel na seguinte URL: <p>
  <a href="http://localhost:9096/swagger-ui.html">http://localhost:9096/swagger-ui.html</a>
</li>


<li>
  Metodo GET : <a href="http://localhost:9096/usuario">http://localhost:9096/usuario</a>
  
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
  Metodo GET : <a href="http://localhost:9096/usuario/1">http://localhost:9096/usuario/1</a>
  
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





</ol>




