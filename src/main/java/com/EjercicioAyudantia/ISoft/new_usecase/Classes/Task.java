package com.EjercicioAyudantia.ISoft.new_usecase.Classes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String titulo;
    private String prioridad;
    private String fechaLimite;
    private boolean completada;
}
