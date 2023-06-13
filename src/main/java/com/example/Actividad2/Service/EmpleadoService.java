package com.example.Actividad2.Service;

import com.example.Actividad2.Entity.Empleado;
import com.example.Actividad2.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado saveEmpleado (Empleado empleado){return empleadoRepository.save(empleado);}

    public List<Empleado> getEmpleados(){return empleadoRepository.getAllEmpleados();}

    public Empleado getEmpleadoById(int id){
        return empleadoRepository.findById(id);
    }
    /*
    public Empleado search(String nombre){
        return empleadoRepository.search(nombre);
    }
    */

    public List<Empleado> getEmpleadoByEmail(String email){return empleadoRepository.findByEmail(email);}
    public String deleteEmpleado(int id){
        empleadoRepository.delete(id);
        return "Empleado eliminado" + id;
    }

    public Empleado updateEmpleado(Empleado empleado){return empleadoRepository.update(empleado);}


}
