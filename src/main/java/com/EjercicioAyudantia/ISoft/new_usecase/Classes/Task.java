package com.EjercicioAyudantia.ISoft.new_usecase.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String titulo;
    private String prioridad;
    private String fechaLimite;
    private boolean completada;
}
