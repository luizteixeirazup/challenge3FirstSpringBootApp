## challenge3FirstSpringBootApp ##

PGG - Challenge 3 - First Spring Boot Application

A aplicação em questão, baseada em Spring Boot, registra em um arquivo .txt criado no Desktop informações de chave e valor.

As funções disponíveis na aplicação nos permitem além de registrar, retornar valor de uma chave específica, deletar uma chave, e listar todas as chaves contidas no arquivo citado acima.

## Tecnologias:

* JDK 13.0.1

* Apache Maven 3.6.2

## Passos para setup da aplicação:

* 1) Clonar o repositório 

git clone https://github.com/luizteixeirazup/challenge3FirstSpringBootApp.git

* 2) Compilar e empacotar o projeto usando o Maven

folder challenge3FirstSpringBootApp

mvn clean install

* 3) Executar a extensão .jar por linha de comando, adicionando a função que será executada conforme informações abaixo

java -jar challenge3FirstSpringBootApp-0.0.1-SNAPSHOT.jar set chave:valor

java -jar challenge3FirstSpringBootApp-0.0.1-SNAPSHOT.jar get chave

java -jar challenge3FirstSpringBootApp-0.0.1-SNAPSHOT.jar delete chave

java -jar challenge3FirstSpringBootApp-0.0.1-SNAPSHOT.jar list