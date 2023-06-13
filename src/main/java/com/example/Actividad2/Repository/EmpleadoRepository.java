package com.example.Actividad2.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Actividad2.Entity.Empleado;
import org.springframework.stereotype.Repository;

@Repository
public class EmpleadoRepository {
    private List<Empleado> empleados = new ArrayList<>();
    //Listar empleados
    public List<Empleado> getAllEmpleados(){
        return empleados;
    }
    //Buscar un empleado
    public Empleado findById(int id){
        for(int i = 0; i < empleados.size(); i++){
            if(empleados.get(i).getId() == id) {
                return empleados.get(i);
            }
        }
        return null;
    }
    //Para buscar un empleado
    public List<Empleado> search (String nombre){
        return empleados.stream()
                .filter(x -> x.getNombre().startsWith(nombre))
                .collect(Collectors.toList());
    }

    public List<Empleado> findByEmail (String email){
        return empleados.stream()
                .filter(e -> e.getEmail().startsWith(email))
                .collect(Collectors.toList());
    }


    //Guardar un empleado
    public Empleado save(Empleado p){
        Empleado empleado = new Empleado();
        empleado.setId(p.getId());
        empleado.setNombre(p.getNombre());
        empleado.setApellido(p.getApellido());
        empleado.setEdad(p.getEdad());
        empleado.setSueldo(p.getSueldo());
        empleado.setEmail(p.getEmail());
        empleado.setAnos_experiencia(p.getAnos_experiencia());
        empleado.setTelefono(p.getTelefono());

        empleados.add(empleado);
        return empleado;
    }
    //Eliminar un empleado
    public String delete(Integer id){
        empleados.removeIf( x -> x.getId() == id);
        return null;
    }
    //Actualizar un empleado
    public Empleado update(Empleado empleado){
        int idPos = 0;
        int id = 0;
        for (int i = 0; i < empleados.size(); i++){
            if(empleados.get(i).getId() == (empleado.getId())){
                id = (int) empleado.getId();
                idPos = i;
                break;
            }
        }
        Empleado empleado1 = new Empleado();
        empleado1.setId(id);
        empleado.setNombre(empleado.getNombre());
        empleado.setApellido(empleado.getApellido());
        empleado.setEdad(empleado.getEdad());
        empleado.setSueldo(empleado.getSueldo());
        empleado.setEmail(empleado.getEmail());
        empleado.setAnos_experiencia(empleado.getAnos_experiencia());
        empleado.setTelefono(empleado.getTelefono());
        empleados.set(idPos, empleado);
        return empleado1;
    }
}
