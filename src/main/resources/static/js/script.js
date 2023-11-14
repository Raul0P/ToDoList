function addTask(description) {
    $.post("/addTask", { description: description }, function () {
        window.location.reload();
    });
}

function deleteTask(taskId) {
    $.get("/deleteTask/" + taskId, function () {
        window.location.reload();
    });
}

function updateTask(taskId, completed) {
    $.post("/updateTask/" + taskId + "/" + completed, function () {
        window.location.reload();
    });
}
