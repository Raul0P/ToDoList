package com.fag.ToDoList.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fag.ToDoList.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador responsável por gerenciar operações relacionadas a tarefas na lista de afazeres.
 */
@Controller
@RequestMapping("/")
public class TaskController {

    // Lista que armazena as tarefas
    private final List<Task> taskList = new ArrayList<>();

    // Tarefa utilizada para criar uma nova tarefa
    private Task newTask = new Task(); 

    /**
     * Manipula requisições GET para a raiz ("/") e exibe a lista de tarefas.
     *
     * @param model O modelo usado para enviar dados para a view.
     * @return O nome da view a ser renderizada ("task-list").
     */
    @GetMapping
    public String getTaskList(Model model) {
        model.addAttribute("tasks", taskList);
        model.addAttribute("newTask", newTask);
        return "task-list";
    }

    /**
     * Manipula requisições POST para adicionar uma nova tarefa à lista.
     *
     * @param task A tarefa a ser adicionada, fornecida como parâmetro de formulário.
     * @return Um redirecionamento para a raiz ("/") após a adição da tarefa.
     */
    @PostMapping("/addTask")
    public String addTask(@ModelAttribute Task task) {
        task.setId((long) (taskList.size() + 1));
        taskList.add(task);
        newTask = new Task(); 
        return "redirect:/";
    }

    /**
     * Manipula requisições GET para excluir uma tarefa da lista.
     *
     * @param taskId O identificador único da tarefa a ser excluída, fornecido como parte da URL.
     * @return Um redirecionamento para a raiz ("/") após a exclusão da tarefa.
     */
    @GetMapping("/deleteTask/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        taskList.removeIf(task -> task.getId().equals(taskId));
        return "redirect:/";
    }

    /**
     * Manipula requisições POST para atualizar o status de conclusão de uma tarefa na lista.
     *
     * @param taskId     O identificador único da tarefa a ser atualizada, fornecido como parte da URL.
     * @param completed  O novo status de conclusão da tarefa, fornecido como parte da URL.
     * @return ResponseEntity indicando o resultado da atualização.
     */
    @PostMapping("/updateTask/{taskId}/{completed}")
    public ResponseEntity<Void> updateTask(@PathVariable Long taskId, @PathVariable Boolean completed) {
        Task task = findTaskById(taskId);

        if (task != null) {
            task.setCompleted(completed);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Localiza uma tarefa na lista pelo seu identificador único.
     *
     * @param taskId O identificador único da tarefa a ser localizada.
     * @return A tarefa correspondente, ou null se não encontrada.
     */
    private Task findTaskById(Long taskId) {
        return taskList.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElse(null);
    }
}
