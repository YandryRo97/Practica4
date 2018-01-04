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
public class Equipo implements Serializable 
{
    @Id
    private Long id;
    private int numJugadores;
    private Pais pais;
    private Torneo torneo;
    private Grupo grupo;

    public Equipo() {
    }

    public Equipo(Long id, int numJugadores, Pais pais, Torneo torneo, Grupo grupo) {
        this.id = id;
        this.numJugadores = numJugadores;
        this.pais = pais;
        this.torneo = torneo;
        this.grupo = grupo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
   

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    
}

