// Função para adicionar uma nova tarefa
function addTask(description) {
    // Envia uma requisição POST para o endpoint /addTask com a descrição da tarefa
    $.post("/addTask", { description: description }, function () {
        // Recarrega a página após a adição da tarefa
        window.location.reload();
    });
}

// Função para excluir uma tarefa
function deleteTask(taskId) {
    // Envia uma requisição GET para o endpoint /deleteTask/{taskId}
    $.get("/deleteTask/" + taskId, function () {
        // Recarrega a página após a exclusão da tarefa
        window.location.reload();
    });
}

// Função para atualizar o status de conclusão de uma tarefa
function updateTask(taskId, completed) {
    // Envia uma requisição POST para o endpoint /updateTask/{taskId}/{completed}
    $.post("/updateTask/" + taskId + "/" + completed, function () {
        // Recarrega a página após a atualização da tarefa
        window.location.reload();
    });
}
