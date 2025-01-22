# Tech Challenge - Desenvolvedor Java

## Descrição
Sistema de gerenciamento de usuários com funcionalidades de cadastro, atualização, exclusão e validação de login.

## Endpoints da API
- `POST /api/user`: Cria um novo usuário.
- `PUT /api/user/{id}`: Atualiza um usuário existente.
- `DELETE /api/user/{id}`: Exclui um usuário pelo ID.
- `POST /api/user/login`: Valida as credenciais de login.

## Configuração do Docker
1. Build da imagem Docker:
   ```sh
   docker-compose build

Arquitetura do Projeto
A arquitetura desse projeto é baseada no padrão MVC (Model-View-Controller), utilizando o Spring Boot como framework principal. Aqui estão os componentes principais:  
1. Model: Representa os dados da aplicação e a lógica de negócios. No seu projeto, isso é representado pelas entidades JPA, como a classe User.  
2. View: Não há uma camada de visualização explícita mencionada no código fornecido, o que sugere que este projeto pode ser uma API REST sem uma interface de usuário.  
3. Controller: Controla a lógica de fluxo da aplicação, recebendo as requisições HTTP, processando-as e retornando as respostas apropriadas. Embora não tenha sido fornecido um exemplo de controlador, geralmente no Spring Boot, isso seria representado por classes anotadas com @RestController.  
4. Service: Contém a lógica de negócios e interage com a camada de persistência (repositórios). No seu projeto, isso é representado pela classe UserService.  
5. Repository: Interage com o banco de dados para realizar operações CRUD. No seu projeto, isso é representado pela interface UserRepository.  
Além disso, o projeto utiliza o Spring Data JPA para a persistência de dados e o H2 como banco de dados em memória para testes.
