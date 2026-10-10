package com.EjercicioAyudantia.ISoft.new_usecase.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.EjercicioAyudantia.ISoft.new_usecase.service.TaskService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.EjercicioAyudantia.ISoft.new_usecase.Classes.Task;
import com.EjercicioAyudantia.ISoft.new_usecase.DTO.TaskDTO;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private HashMap<Long, Task> tareas = new HashMap<>();

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO dto){        

        Task task = taskService.createTask(
            tareas.keySet().stream().max(Long::compareTo).orElse(0L) + 1,
            dto
        );

        tareas.put(task.getId(), task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    
    
    @GetMapping
    public List<Task> list(@RequestParam(required = false) String prioridad,
                           @RequestParam(required = false) String titulo,
                           @RequestParam(required = false) String fechaLimite) {
        return taskService.findAll(prioridad, titulo, fechaLimite,tareas);
    }

    @PatchMapping("/{id}/complete")
    private ResponseEntity<Task> completeTask(@PathVariable("id") Long id){
        if (tareas.containsKey(id)) {
            taskService.completeTask(tareas.get(id));
            return new ResponseEntity<>(tareas.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
