# semive-backend
A Spring project working like a API with Java and Spring Boot.

## Setup project

#### Configuring database

```
docker run -d -p 3306:3006 --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=semive mysql:5.6
```