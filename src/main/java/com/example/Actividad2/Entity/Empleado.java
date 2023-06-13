package com.example.Actividad2.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    private int id;

    private String nombre;

    private String apellido;

    private int edad;

    private int sueldo;

    private String email;

    private int anos_experiencia;

    private int telefono;

}
