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
public class Grupo implements Serializable 
{
    @Id
    private Long id;
    private String nombre;
    private int numeroEqui;

    public Grupo() {
    }

    public Grupo(Long id, String nombre, int numeroEqui) {
        this.id = id;
        this.nombre = nombre;
        this.numeroEqui = numeroEqui;
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

    public int getNumeroEqui() {
        return numeroEqui;
    }

    public void setNumeroEqui(int numeroEqui) {
        this.numeroEqui = numeroEqui;
    }

   
}

