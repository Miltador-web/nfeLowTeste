# API de Gerenciamento de Notas Fiscais (NFEs)
Esta API permite criar, consultar, listar, alterar e excluir Notas Fiscais Eletrônicas (NFEs). Você pode interagir com a API usando chamadas HTTP e fornecemos exemplos de URLs e corpos de solicitação para cada operação.

### Endpoints Disponíveis
Criar uma NFE
Endpoint: POST /nfe

Exemplo de Chamada HTTP:

**POST** `localhost:8080/api/nfe/`
**Content-Type:** `application/json`

```json
{
  "razaoSocial": "Exemplo Empresas Ltda",
  "cnpj": "12345678901234",
  "endereco": "Rua Exemplo, 123",
  "valor": 1000.0,
  "numeroSerie": 123456789
}
```

### Consultar Todas as NFEs
**GET** `/localhost:8080/api/nfe`

Exemplo de Chamada HTTP:

#### Endpoint: GET /nfe

###

### Consultar uma NFE Específica
Exemplo de Chamada HTTP:
#### Endpoint: GET /nfe/{1}

Exemplo de Chamada HTTP:

**GET** `/localhost:8080/api/nfe/1`

###


### Alterar uma NFE
Exemplo de Chamada HTTP:

#### Endpoint: PUT /nfe/{id}

Exemplo de Chamada HTTP:

**PUT** `/localhost:8080/api/nfe/1`
**Content-Type:** `application/json`

```json
{
  "razaoSocial": "Exemplo Empresas Ltda",
  "cnpj": "19.372.323/0001-34",
  "endereco": "Rua Exemplo, 123",
  "valor": 1000.0,
  "numeroSerie": 111111
}
```

###

### Excluir uma NFE

Exemplo de Chamada HTTP:
#### Endpoint: DELETE /nfe/{id}

**DELETE** `/localhost:8080/api/nfe/1`
**Content-Type:** `application/json`

```json
{
  "razaoSocial": "Exemplo Empresas Ltda",
  "cnpj": "19.372.323/0001-34",
  "endereco": "Rua Exemplo, 123",
  "valor": 1000.0,
  "numeroSerie": 111111
}
```

###

### Estrutura da Entidade NFE
A entidade NFE possui os seguintes campos:

``numeroNota`` (Gerado automaticamente)
####
``razaoSocial`` (Nome da empresa)
####
``cnpj`` (CNPJ da empresa)
####
``endereco`` (Endereço da empresa)
####
``valor`` (Valor da NFE)
####
``numeroSerie`` (Número de série da NFE)

###
Exemplo de payload JSON para criação de uma NFE:
```
{
"razaoSocial": "Exemplo Empresas Ltda",
"cnpj": "19.372.323/0001-34",
"endereco": "Rua Exemplo, 123",
"valor": 1000.0,
"numeroSerie": 1
} 
```
Este script SQL criará o banco de dados nfe_database e a tabela nfe com os campos correspondentes que você especificou na entidade NFE.
####
Antes de usar a API, certifique-se de criar o banco de dados e a tabela necessários. Você pode usar o seguinte script SQL para criar o banco de dados e a tabela:
```
-- Versão do MySQL: 8.0.34

-- Crie o banco de dados nfe_database
CREATE DATABASE nfe_database;

-- Use o banco de dados nfe_database
USE nfe_database;

-- Crie a tabela de NFEs
CREATE TABLE nfe (
    numero_nota BIGINT AUTO_INCREMENT PRIMARY KEY,
    razao_social VARCHAR(255),
    cnpj_empresa VARCHAR(18),
    endereco_empresa VARCHAR(255),
    valor_nfe DOUBLE,
    numero_serie_nfe BIGINT
);
```




