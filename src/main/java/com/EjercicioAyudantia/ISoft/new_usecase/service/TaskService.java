package com.EjercicioAyudantia.ISoft.new_usecase.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.EjercicioAyudantia.ISoft.new_usecase.Classes.Task;

@Service
public class TaskService {
    private final Map<Long, Task> tareas = new ConcurrentHashMap<>();

    public List<Task> findAll(String prioridad, String titulo, String fechaLimite) {
        return tareas.values().stream()
                .filter(t -> prioridad == null || t.getPrioridad().equalsIgnoreCase(prioridad))
                .filter(t -> titulo == null || t.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .filter(t -> fechaLimite == null || fechaLimite.equals(t.getFechaLimite()))
                .sorted(Comparator.comparing(Task::getId))
                .toList();
    }
}