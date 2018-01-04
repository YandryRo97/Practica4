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
public class Torneo implements Serializable {
    @Id
    private Long id;
    private String fechaIns;
    private Estadio estadio;

    public Torneo() {
    }

    public Torneo(Long id, String fechaIns, Estadio estadio) {
        this.id = id;
        this.fechaIns = fechaIns;
        this.estadio = estadio;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(String fechaIns) {
        this.fechaIns = fechaIns;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

}
