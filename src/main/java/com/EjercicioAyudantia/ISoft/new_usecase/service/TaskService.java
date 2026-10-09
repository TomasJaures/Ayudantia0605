package com.EjercicioAyudantia.ISoft.new_usecase.service;

import org.springframework.stereotype.Service;

import com.EjercicioAyudantia.ISoft.new_usecase.Classes.Task;
import com.EjercicioAyudantia.ISoft.new_usecase.DTO.TaskDTO;

@Service 
public class TaskService {

    public Task createTask(Long id, TaskDTO dto){;
        Task tarea = new Task(
            id,
            dto.getTitulo(),
            dto.getPrioridad(),
            dto.getFechaLimite(),
            false
        );
        return tarea;
    }
}
