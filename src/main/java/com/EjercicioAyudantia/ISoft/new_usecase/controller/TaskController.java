package com.EjercicioAyudantia.ISoft.new_usecase.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EjercicioAyudantia.ISoft.new_usecase.Classes.Task;
import com.EjercicioAyudantia.ISoft.new_usecase.DTO.TaskDTO;
import com.EjercicioAyudantia.ISoft.new_usecase.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;
    private HashMap<Long, Task> tareas;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO dto){        

        Task task = taskService.createTask(
            tareas.keySet().stream().max(Long::compareTo).get() + 1,
            dto
        );

        tareas.put(task.getId(), task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    
}
