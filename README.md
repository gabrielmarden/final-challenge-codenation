# Codenation : Central de Logs API
Projeto prático proposto pela **Aceleradev Codenation Java** com o intuito de testar todo o conhecimento adquirido durante a aceleração.

 Principais Funcionalidades:
-   Deve permitir a autenticação do sistema que deseja utilizar a API gerando o Token de Acesso
-   Pode ser acessado por multiplos sistemas
-   Deve permitir gravar registros de eventos de log salvando informações de  **Level(error, warning, info), Descrição do Evento, LOG do Evento, ORIGEM(Sistema ou Serviço que originou o evento), DATA(Data do evento), QUANTIDADE(Quantidade de Eventos de mesmo tipo)**
-   Deve permitir a listagem dos eventos juntamente com a filtragem de eventos por qualquer parâmetro especificado acima
-   Deve suportar Paginação
-   Deve suportar Ordenação por diferentes tipos de atributos
-   A consulta de listagem  **não deve retornar os LOGs**  dos Eventos
-   Deve permitir a busca de um evento por um ID, dessa maneira exibindo o LOG desse evento em específico 

## Tecnologias 
- Spring Boot
- Spring Security
- JPA
- Postgresql
- OAuth2
- Apache Maven
- Heroku

## Requisitos
- JDK 8 ou versões mais recentes para Windows, MAC ou Linux
- Apache Maven
- Postgresql para Windows, MAC ou Linux


## Rodando aplicação
 Para rodar o projeto usamos o **Apache Maven** como gerenciador de pacotes e executamos o comando:
 `mvn spring-boot:run`


## Detalhes da Aplicação e Deploy

- O **Heroku** foi a plataforma escolhida para o deploy da aplicação. Você pode ter acesso a API pela URL: [http://central-de-logs-api.herokuapp.com/](http://central-de-logs-api.herokuapp.com/)

- A documentação **Swagger**  com todos os detalhamentos referentes aos endpoints da API pode ser encontrada na seguinte URL: [https://central-de-logs-api.herokuapp.com/swagger-ui.html](https://central-de-logs-api.herokuapp.com/swagger-ui.html)

