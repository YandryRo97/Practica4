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
public class Jugador implements Serializable 
{
   @Id
    private Long id;
    private String nombre;
    private String apellido;
    private Pais pais;
    private Equipo equipo;

    public Jugador() {
    }

    public Jugador(Long id, String nombre, String apellido, Pais pais, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.equipo = equipo;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

   
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    
}
