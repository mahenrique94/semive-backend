# semive-backend
Projeto para controle de clientes, fornecedores, produtos e pedidos, feito para a faculdade.

Tecnologias:

- Java 10
- Spring
- Spring Boot
- MySQL
- Docker

## Subindo a API

#### Com Maven

Faça o clone do projeto e rode os comandos:

```
mvn clean package
```

Assim o Maven irá criar o `.jar` dentro de `target`.

Feito isso, configure o banco de dados, pode ser via Docker para mais facilidade.

```
docker run -d -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=semive mysql:5.6
```

E por fim, rode o `.jar`:

```
java -jar target/*.jar
```

#### Com Docker

Para rodar o projeto com docker, basta utilizar o `docker-compose` que tudo será feito automáticamente:

```
docker-compose up
```
