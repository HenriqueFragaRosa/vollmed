# 🏥 VollMed

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-brightgreen)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)
![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow)

## 📄 Descrição

Esta API REST foi desenvolvida como parte do curso de Spring Boot 3 da Alura. O objetivo do projeto é [descreva o objetivo principal], permitindo o gerenciamento completo de [entidade principal].

A aplicação utiliza **PostgreSQL** como banco de dados relacional para persistência das informações.

## 🔨 Funcionalidades

- [x] CRUD de médicos
- [x] CRUD de pacientes

## 🚀 Tecnologias Utilizadas

* **[Java 17](https://www.oracle.com/java/technologies/)**
* **[Spring Boot 3](https://spring.io/projects/spring-boot)**
* **[Spring Data JPA](https://spring.io/projects/spring-data-jpa)**
* **[PostgreSQL](https://www.postgresql.org/)**
* **[Flyway](https://flywaydb.org/)** (Gerenciamento de Migrations)
* **[Lombok](https://projectlombok.org/)**
* **[Validation](https://beanvalidation.org/)**

## 📋 Pré-requisitos

Para rodar essa aplicação, você vai precisar ter instalado:

* [Java JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [PostgreSQL](https://www.postgresql.org/download/) (ou Container Docker)
* Um cliente para testar a API: [Insomnia](https://insomnia.rest/download) ou [Postman](https://www.postman.com/downloads/)

## 🔧 Como Executar o Projeto

1.  **Clone o repositório:**

    ```bash
    git clone [https://docs.github.com/pt/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github](https://docs.github.com/pt/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github)
    cd [nome-da-pasta-do-projeto]
    ```

2.  **Configure o Banco de Dados:**

    Crie um banco de dados no PostgreSQL (ex: via pgAdmin ou terminal).
    Em seguida, configure o arquivo `src/main/resources/application.properties`:

    ```properties
    # Configuração do PostgreSQL
    spring.datasource.url=jdbc:postgresql://localhost:5432/[nome_do_banco]
    spring.datasource.username=postgres
    spring.datasource.password=[sua_senha]
    spring.datasource.driver-class-name=org.postgresql.Driver

    # Flyway e JPA
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    spring.jpa.hibernate.ddl-auto=validate
    ```

3.  **Execute o Projeto:**

    ```bash
    mvn spring-boot:run
    ```

## Endpoints Principais

### 1. Listar médicos
* **Método:** `GET`
* **URL:** `/medicos`
* **Exemplo de Resposta:**

    ```json
    {
      "content": [
        {
            "id": 1,
            "nome": "Rodrigo Ferreira",
            "email": "rodrigo.ferreira@voll.med",
            "crm": "123456",
            "especialidade": "ORTOPEDIA"
        }
      ],
      "empty": false,
      "first": true,
      "last": true,
      "number": 0,
      "numberOfElements": 1,
      "pageable": {},
      "size": 2,
      "sort": {},
      "totalElements": 1,
      "totalPages": 1
    }
    ```

### 2. Cadastrar médico
* **Método:** `POST`
* **URL:** `/medicos`
* **Corpo da Requisição:**

    ```json
    {
      "nome": "Rodrigo Ferreira",
      "email": "rodrigo.ferreira2@voll.med",
      "telefone": "1132132142141",
      "crm": "123457",
      "especialidade": "ORTOPEDIA",
      "endereco": {
          "logradouro": "rua 1",
          "bairro": "bairro",
          "cep": "12345678",
          "cidade": "Brasilia",
          "uf": "DF",
          "numero": "1",
          "complemento": "complemento"
      }
    }
    ```


### 3. Atualizar médico
* **Método:** `PUT`
* **URL:** `/medicos/{id}`
* **Corpo da Requisição:**

    ```json
    {
      "nome": "Rodrigo Ferreira",
      "telefone": "1132132142141",
      "endereco": {
          "logradouro": "rua 1",
          "bairro": "bairro",
          "cep": "12345678",
          "cidade": "Brasilia",
          "uf": "DF",
          "numero": "2",
          "complemento": "complemento 2"
      }
    }
    ```

### 4. Deletar médico
* **Método:** `DELETE`
* **URL:** `/medicos/{id}`

### 5. Listar Pacientes
* **Método:** `GET`
* **URL:** `/pacientes`
* **Exemplo de Resposta:**

    ```json
    {
      "content": [
        {
            "id": 1,
            "nome": "Rodrigo Ferreira",
            "email": "rodrigo.ferreira@gmail.com",
            "cpf": "12345678910"
        }
      ],
      "empty": false,
      "first": true,
      "last": true,
      "number": 0,
      "numberOfElements": 1,
      "pageable": {},
      "size": 2,
      "sort": {},
      "totalElements": 1,
      "totalPages": 1
    }
    ```

### 6. Cadastrar médico
* **Método:** `POST`
* **URL:** `/pacientes`
* **Corpo da Requisição:**

    ```json
    {
      "nome": "Rodrigo Ferreira",
      "email": "rodrigo.ferreira@gmail.com",
      "telefone": "51992170598",
      "cpf": "12345678910",    
      "endereco": {
          "logradouro": "rua 1",
          "bairro": "bairro",
          "cep": "12345678",
          "cidade": "Brasilia",
          "uf": "DF",
          "numero": "1",
          "complemento": "complemento"
      }
    }
    ```


### 7. Atualizar paciente
* **Método:** `PUT`
* **URL:** `/pacientes/{id}`
* **Corpo da Requisição:**

    ```json
    {
      "nome": "Rodrigo Ferreira",
      "telefone": "1132132142141",
      "endereco": {
          "logradouro": "rua 1",
          "bairro": "bairro",
          "cep": "12345678",
          "cidade": "Brasilia",
          "uf": "DF",
          "numero": "3",
          "complemento": "complemento 2"
      }
    }
    ```

### 8. Deletar paciente
* **Método:** `DELETE`
* **URL:** `/pacientes/{id}`
