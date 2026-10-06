package com.EjercicioAyudantia.ISoft.new_usecase.service;

import com.EjercicioAyudantia.ISoft.new_usecase.Classes.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TaskService {
    public void completeTask(Task task) {
        task.setCompletada(true);
    }
}
