/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import modelo.Equipo;
import modelo.Estadio;
import modelo.Grupo;
import modelo.Jugador;
import modelo.Pais;
import modelo.Torneo;
import vista.VentanaPrincipal;

/**
 *
 * @author USUARIO
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    List<Equipo> Eq = new ArrayList<Equipo>();
    List<Pais> Pa = new ArrayList<Pais>();
    List<Torneo> To = new ArrayList<Torneo>();
    List<Grupo> G = new ArrayList<Grupo>();
    List<Estadio> E = new ArrayList<Estadio>();
    List<Jugador> J = new ArrayList<Jugador>();
    
    Pais p=new Pais(Long.parseLong("131"),"Ecuador","Ecuatoriana",Long.parseLong("140000"));
    Estadio est=new Estadio(Long.parseLong("198"),"Atahualpa","Quito",Long.parseLong("500000"));
    Torneo tor=new Torneo(Long.parseLong("151"),"14/Dic/2018",est);
    Grupo gr=new Grupo(Long.parseLong("161"),"Grupo A",4);
    Equipo e=new Equipo(Long.parseLong("171"),25,p,tor,gr);
    Jugador ju=new Jugador(Long.parseLong("181"),"Alex","Aguinaga",p,e);
        
    GestionDato gd=new GestionDato(Eq,Pa,To,E,G,J);
    
    gd.persistirPais(p);
    gd.persistirEquipo(e);
    gd.persistirGrupo(gr);
    gd.persistirJugador(ju);
    gd.persistirEstadio(est);
    gd.persistirTorneo(tor);
        
    VentanaPrincipal v = new VentanaPrincipal("Archivos Binarios",gd);
        v.setVisible(true);
    }
    
    
}
