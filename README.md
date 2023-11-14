# To-Do List Web Application

Esta aplicação web permite ao usuário gerenciar suas tarefas em uma lista de afazeres (To-Do List).

## Funcionalidades

- Adicionar uma nova tarefa à lista.
- Marcar uma tarefa como concluída.
- Excluir uma tarefa da lista.
- Visualizar a data de vencimento de cada tarefa.

## Tecnologias Utilizadas

- Spring Boot (Java) para o back-end.
- Thymeleaf para a camada de visualização.
- HTML, CSS e JavaScript para a interface do usuário.

## Instruções de Uso

1. Clone o repositório.
2. Execute a aplicação Spring Boot.
3. Abra o navegador e acesse http://localhost:8080/tasks.

## Detalhes Técnicos

### Modelagem da Tarefa

A classe `Task` representa uma tarefa e possui os seguintes atributos:

- `id`: Identificador único da tarefa.
- `description`: Descrição da tarefa.
- `completed`: Indica se a tarefa está concluída.
- `dueDate`: Data de vencimento da tarefa.

### Controlador

O `TaskController` gerencia as solicitações relacionadas às tarefas.

- Mapeamento para exibir a lista de tarefas: `/tasks`.
- Mapeamento para adicionar uma nova tarefa: `/tasks/add`.

### Front-End (Thymeleaf + HTML + CSS + JavaScript)

- Lista de tarefas exibida em uma tabela.
- Formulário para adicionar uma nova tarefa.
- Caixas de seleção para marcar tarefas como concluídas.
- Botão para excluir tarefas.

