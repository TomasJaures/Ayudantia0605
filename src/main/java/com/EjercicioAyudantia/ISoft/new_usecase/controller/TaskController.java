package com.EjercicioAyudantia.ISoft.new_usecase.controller;

import java.util.ArrayList;
import java.util.List;

import com.EjercicioAyudantia.ISoft.new_usecase.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EjercicioAyudantia.ISoft.new_usecase.Classes.Task;
import com.EjercicioAyudantia.ISoft.new_usecase.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }
    @GetMapping
    public List<Task> list(@RequestParam(required = false) String prioridad,
                           @RequestParam(required = false) String titulo,
                           @RequestParam(required = false) String fechaLimite) {
        return service.findAll(prioridad, titulo, fechaLimite);
    }
}
