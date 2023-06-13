package com.example.Actividad2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Actividad2.Entity.Empleado;
import com.example.Actividad2.Service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        return empleadoService.saveEmpleado(empleado);
    }

    @GetMapping
    public List<Empleado> listarEmpleados(){
        return empleadoService.getEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado buscarEmpleadoById(@PathVariable int id){
        return empleadoService.getEmpleadoById(id);
    }

    
    @GetMapping("/email/{email}")
    public Empleado buscarEmpleadoByEmail(@PathVariable String email){
        return (Empleado) empleadoService.getEmpleadoByEmail(email);
    }


    /*
    @GetMapping("/search/{nombre}")
    public Empleado buscarEmpleadoById(@PathVariable String nombre){
        return empleadoService.(nombre);
    }
     */

    @PutMapping
    public Empleado updateEmpleado(@RequestBody Empleado empleado){
        return empleadoService.updateEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public String deleteEmpleado(@PathVariable int id){
        return empleadoService.deleteEmpleado(id);
    }

}
