/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author USUARIO
 */
@Entity
public class Pais implements Serializable 
{
    @Id
    private Long id;
    private String nombre;
    private String nacionalidad;
    private Long numHabitantes;

    public Pais() {
    }

    public Pais(Long id, String nombre, String nacionalidad, Long numHabitantes) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.numHabitantes = numHabitantes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Long getNumHabitantes() {
        return numHabitantes;
    }

    public void setNumHabitantes(Long numHabitantes) {
        this.numHabitantes = numHabitantes;
    }

}
