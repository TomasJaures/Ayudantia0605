package com.EjercicioAyudantia.ISoft.new_usecase.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private String titulo;
    private String prioridad;
    private String fechaLimite;
}
