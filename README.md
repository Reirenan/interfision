# Sistema para a Clínica de Fisioterapia Interfision


Este é um sistema backend desenvolvido para gerenciar os processos administrativos da clínica de fisioterapia *Interfision*. Ele inclui funcionalidades como gerenciamento de pacientes, profissionais, consultas e especialidades.

---

## Índice
1. [Funcionalidades](#funcionalidades)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Configuração do Ambiente](#configuração-do-ambiente)
    - [Pré-requisitos](#pré-requisitos)
    - [Configuração do Banco de Dados](#configuração-do-banco-de-dados)
4. [Como Executar](#como-executar)
5. [Contribuição](#contribuição)
6. [Autor e Licença](#autor-e-licença)

---

## Funcionalidades

- **Pacientes**: Cadastro, atualização e associação com responsáveis.
- **Profissionais**: Registro de profissionais e suas especialidades.
- **Consultas**: Agendamento, cancelamento e registro de preços e status.
- **Especialidades**: Cadastro e gerenciamento das especialidades oferecidas.
- **Relatórios**: Histórico de atendimentos.

---

## Tecnologias Utilizadas

- **Java 21** com Spring Boot 3.2.2
- **Banco de Dados MySQL**
- **Flyway** para controle de versões do banco de dados
- **Spring Data JPA** e **Hibernate** para integração com o banco

---

## Configuração do Ambiente

### Pré-requisitos

- Java 21 ou superior
- Maven
- MySQL

### Configuração do Banco de Dados

1. Crie um banco de dados chamado `interfision`.
2. Configure as credenciais no arquivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/interfision
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=none
   spring.flyway.enabled=true
   ```

---

## Como Executar

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/Reirenan/interfision.git
   cd interfision
   ```

2. **Compile e Execute o Projeto**:
   ```bash
   mvn spring-boot:run
   ```

3. Acesse o sistema através de `http://localhost:8080` no navegador.

---

## Contribuição

Contribuições são bem-vindas! Para contribuir, siga os passos abaixo:

1. Realize um fork deste repositório.
2. Crie uma nova branch:
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
3. Commit suas alterações:
   ```bash
   git commit -m "Adiciona nova funcionalidade"
   ```
4. Envie para o repositório remoto:
   ```bash
   git push origin feature/nova-funcionalidade
   ```
5. Abra um Pull Request.

---

## Autor e Licença

**Autor**: Renan, Valéria e João Mateus
**Licença**: MIT
