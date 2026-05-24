# 📚 Biblioteca Escolar — API REST com Spring Boot

API REST de uma biblioteca escolar desenvolvida com Spring Boot, seguindo arquitetura em camadas. Projeto didático da disciplina **Engenharia de Software II**.

---

## 🧱 Arquitetura

O projeto segue o padrão de **arquitetura em camadas**:

```
Cliente HTTP
    ↓
Controller       ← recebe a requisição HTTP
    ↓
Service          ← executa as regras de negócio
    ↓
Repository       ← acessa o banco de dados
    ↓
Banco de Dados (H2 em memória)
```

Além das camadas, o projeto usa:

- **Entity** — representa os dados persistidos no banco
- **RequestDTO** — representa os dados que entram pela API
- **ResponseDTO** — representa os dados que saem pela API

---

## 📁 Estrutura de pacotes

```
br.edu.exemplo.biblioteca
├── controller
│   ├── LivroController.java
│   └── AlunoController.java
├── dto
│   ├── LivroRequestDTO.java
│   ├── LivroResponseDTO.java
│   ├── AlunoRequestDTO.java
│   └── AlunoResponseDTO.java
├── entity
│   ├── Livro.java
│   └── Aluno.java
├── exception
│   ├── ErroResponse.java
│   └── TratadorGlobalDeErros.java
├── repository
│   ├── LivroRepository.java
│   └── AlunoRepository.java
└── service
    ├── LivroService.java
    └── AlunoService.java
```

---

## ⚙️ Tecnologias utilizadas

| Tecnologia | Versão | Finalidade |
|---|---|---|
| Java | 17+ | Linguagem principal |
| Spring Boot | 3.5.x | Framework backend |
| Spring Web | — | Criação de endpoints REST |
| Spring Data JPA | — | Acesso ao banco de dados |
| H2 Database | — | Banco em memória para testes |
| Validation | — | Validação dos dados de entrada |
| Maven | — | Gerenciamento de dependências |

---

## 🚀 Como executar

### Pré-requisitos

- Java 17 ou superior instalado
- VS Code com **Extension Pack for Java** e **Spring Boot Extension Pack**

### Pelo terminal

**Windows:**
```bash
mvnw.cmd spring-boot:run
```

**Linux / macOS:**
```bash
./mvnw spring-boot:run
```

### Pelo VS Code

Abra o **Spring Boot Dashboard** no painel lateral e clique no botão de execução ao lado da aplicação `biblioteca`.

### Verificando se está rodando

No terminal, procure a mensagem:
```
Tomcat started on port 8080
Started BibliotecaApplication
```

A API estará disponível em: `http://localhost:8080`

---

## 📋 Endpoints disponíveis

### Livros

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/livros` | Lista todos os livros |
| `GET` | `/livros/{id}` | Busca livro por ID |
| `POST` | `/livros` | Cadastra um novo livro |
| `PUT` | `/livros/{id}` | Atualiza dados de um livro |
| `PUT` | `/livros/{id}/emprestar` | Realiza empréstimo do livro |
| `PUT` | `/livros/{id}/devolver` | Registra devolução do livro |

### Alunos

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/alunos` | Lista todos os alunos |
| `GET` | `/alunos/{id}` | Busca aluno por ID |
| `POST` | `/alunos` | Cadastra um novo aluno |

---

## 📨 Exemplos de requisição

### Cadastrar livro

**POST** `/livros`

```json
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "anoPublicacao": 1899
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "anoPublicacao": 1899,
  "disponivel": true
}
```

### Cadastrar aluno

**POST** `/alunos`

```json
{
  "nome": "Maria Silva",
  "matricula": "2024001",
  "turma": "3A"
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "nome": "Maria Silva",
  "matricula": "2024001",
  "turma": "3A"
}
```

### Emprestar livro

**PUT** `/livros/1/emprestar`

```json
{
  "id": 1,
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "anoPublicacao": 1899,
  "disponivel": false
}
```

---

## 🔒 Regras de negócio

1. Um livro novo começa sempre **disponível**
2. Um livro disponível pode ser **emprestado**
3. Um livro já emprestado **não pode** ser emprestado novamente
4. Um livro emprestado pode ser **devolvido**
5. Um livro disponível **não pode** ser devolvido

---

## 🗄️ Banco de dados H2

O banco H2 roda em memória — os dados são perdidos ao encerrar a aplicação.

**Acesse o console em:** `http://localhost:8080/h2-console`

| Campo | Valor |
|---|---|
| JDBC URL | `jdbc:h2:mem:bibliotecadb` |
| User Name | `sa` |
| Password | *(deixar em branco)* |

Para visualizar os livros cadastrados, execute:
```sql
SELECT * FROM LIVRO;
```

---

## ❗ Erros comuns

**Porta 8080 já em uso:**
```properties
# Altere em application.properties
server.port=8081
```

**Erro em `jakarta.persistence`:** verifique se a dependência `spring-boot-starter-data-jpa` está no `pom.xml`.

**Erro em `jakarta.validation`:** verifique se a dependência `spring-boot-starter-validation` está no `pom.xml`.

---

## 📖 Referências

- [Documentação oficial do Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Spring Initializr](https://start.spring.io/)
