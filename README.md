<h1 style="color: orange">Teste Npi Sócios e Dependentes</h1>

![proejto npi](https://user-images.githubusercontent.com/112403510/229511951-db7b8df0-1df1-4972-ad67-f2be60b574c0.gif)

## Tecnologias usadas:

#### Back end
- Java 17.0.0
- Spring-Boot 3.0.5
- Spring-MVC
- Maven
- Hibernate JPA
- MySql

#### Front end
- Angular 15.2.5
- Bootstrap
- Npm
- Typescript

### Ambiente de desenvolvimento
- Windows Server
- NodeJs: versão 18.13.10

### Interfaces utilizadas
- Intellij (back end)
- VsCode (Front end)


### Requisitos Funcionais:

<strong><em style="color: blue ">Cadastro do Sócio:</em></strong>
Deverá conter os seguintes campos:
⦁ Id, inteiro, auto incremento
⦁ Nome, texto, mínimo de 5 caracteres e máximo de 50 caracteres, obrigatório
⦁ Renda, decimal, obrigatório, maior ou igual a zero
⦁ Ativo, booleano
<br>
<strong><em style="color: blue ">Cadastro de dependente:</em></strong>
Deverá conter os seguintes campos:
⦁ Id, inteiro, auto incremento
⦁ Nome, texto, mínimo de 5 caracteres e máximo de 50 caracteres, obrigatório
⦁ Idade, inteiro, obrigatório, maior ou igual a zero

 <h3 style="color:red">Testando os endpoints do back end</h3>

- Para fazer as requisições POST,GET,PUT,DELETE utilize os aplicativos <strong style="color:red">Insomnia ou Postman.
</strong>

Com o código do backend <strong> em execução</strong> na sua IDE de preferência, abra seu app Insomnia ou Postman.

Utilize o endereço para o endpoint -> <http://localhost/8080/socios>, e se preferir fazer as consultas e requisições para os <strong>dependentes</strong> basta alterar para http://localhost/8080/dependentes.

Com a opção <strong>Post </strong>selecionada, é possível persistir os dados no SGBD:

![alt text](https://i.imgur.com/bywcnqa.png)

Aqui no método <strong>Get</strong> podemos listar <strong>todos</strong>, somente por <strong>id</strong>, e também por <strong>nome</strong>:

Listar Todos
![alt text](https://i.imgur.com/aukKraa.png)

Buscar por id
![alt text](https://i.imgur.com/sIVxIjV.png)

Buscar por Nome
![alt text](https://i.imgur.com/Z3CVaC0.png)

Atualizar
![alt text](https://i.imgur.com/KQGknh3.png)

Deletar
![alt text](https://i.imgur.com/dyctveS.png)

<h3 style="color: red">Configurando o Front end</h3>

   - Acesse pelo terminal Windows a pasta Front End Node e Angular que se encontra no Projeto
 
    Digite os seguintes comandos:
   - npm install 
   - ng serve (para rodar a aplicação Front End)
   - É necessário estar com o projeto do Backend em execução para conseguir inserir e manipular os dados.
   
#### Acesso ao Front-End
   
   http://localhost:4200/socios => acessar a pagina principal do sistema

    Lista dos Associados: 
    Nela é possível ver detalhes, atualizar ou deletar qualquer sócio.
   ![alt text](https://i.imgur.com/M8gjqM5.png)
  
    Lista dos Dependentes:
   ![alt text](https://i.imgur.com/LU5CgQr.png)

    Form para cadastrar sócios
   ![alt text](https://i.imgur.com/QCfkSXE.png)

    Form para cadastrar dependentes
   ![alt text](https://i.imgur.com/KL2uqvt.png)
   
   
   
   
    Atualizar Dependentes
   ![alt text](https://i.imgur.com/IRcVzzM.png)
  
     Atualizar Sócio:
   ![alt text](https://i.imgur.com/SPuk1Yd.png)

![alt text](https://i.imgur.com/IuyOCmG.gif)
