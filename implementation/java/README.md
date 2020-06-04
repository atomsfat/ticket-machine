# Vanilla Spring boot

JPA power to create DB schema.

## Project structure

* [api-pojos](api-pojos) Jackson pojos generated with [swagger-codegen](https://swagger.io/tools/swagger-codegen/).
* [api-server](api-server)

  * First attemp this is going to run on beanstalk
  * JPA PSQL with support to JSONB
  * [ModelMapper](http://modelmapper.org/getting-started/) to transform DTO to entities.

## Local Setup
```shell script
docker run --name pg-ticket -e POSTGRES_DB=dev_data -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=D3V_P4ss -d -p 15432:5432 postgres
```
* If it is already created
```shell script
docker container start pg-ticket
```

## Run
```shell script
gradle bootRun
```
