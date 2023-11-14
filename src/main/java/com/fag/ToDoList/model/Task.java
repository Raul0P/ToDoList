package com.fag.ToDoList.model;

public class Task {
    private Long id;
    private String description;
    private boolean completed;
    

    public Task(){
        
    }

    public String getDescription() {
        return description;
    }
    public Long getId() {
        return id;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }
}