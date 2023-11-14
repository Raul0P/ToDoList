package com.fag.ToDoList.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fag.ToDoList.model.Task;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {

    private final List<Task> taskList = new ArrayList<>();
    private Task newTask = new Task(); 

    @GetMapping
    public String getTaskList(Model model) {
        model.addAttribute("tasks", taskList);
        model.addAttribute("newTask", newTask);
        return "task-list";
    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute Task task) {
        task.setId((long) (taskList.size() + 1));
        taskList.add(task);
        newTask = new Task(); 
        return "redirect:/";
    }

    @GetMapping("/deleteTask/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        taskList.removeIf(task -> task.getId().equals(taskId));
        return "redirect:/";
    }

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

    private Task findTaskById(Long taskId) {
        return taskList.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElse(null);
    }
}
