package com.EjercicioAyudantia.ISoft.new_usecase.controller;

import java.util.HashMap;

import com.EjercicioAyudantia.ISoft.new_usecase.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.EjercicioAyudantia.ISoft.new_usecase.Classes.Task;

@RestController
public class TaskController {
    private HashMap<Long, Task> tareas;
    private final TaskService taskService = new TaskService();

    @PatchMapping("/task/{id}/complete")
    private ResponseEntity<Task> completeTask(@PathVariable("id") Long id){
        if (tareas.containsKey(id)) {
            taskService.completeTask(tareas.get(id));
            return new ResponseEntity<>(tareas.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
