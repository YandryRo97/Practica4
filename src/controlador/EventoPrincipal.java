/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaEquipo;
import vista.VentanaEstadio;
import vista.VentanaGrupo;
import vista.VentanaJugador;
import vista.VentanaPais;
import vista.VentanaPrincipal;
import vista.VentanaTorneo;

/**
 *
 * @author USUARIO
 */
public class EventoPrincipal implements ActionListener{
    
     private VentanaPrincipal ventana;
    private GestionDato gD;

    public EventoPrincipal(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }
    
    public VentanaPrincipal getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         
        if (e.getSource().equals(this.ventana.getMenuItemList().get(3))) {
            VentanaGrupo vG = new VentanaGrupo(this.ventana.getgD());
            vG.setVisible(true);
            this.ventana.getEscritorio().add(vG);
        }
        
        if (e.getSource().equals(this.ventana.getMenuItemList().get(5))) {
            VentanaJugador vJ = new VentanaJugador(this.ventana.getgD());
            vJ.setVisible(true);
            this.ventana.getEscritorio().add(vJ);
        }

        if (e.getSource().equals(this.ventana.getMenuItemList().get(2))) {
            VentanaEquipo vE = new VentanaEquipo(this.ventana.getgD());
            vE.setVisible(true);
            this.ventana.getEscritorio().add(vE);
        }
        
        if (e.getSource().equals(this.ventana.getMenuItemList().get(4))) {
            VentanaPais vP = new VentanaPais(this.ventana.getgD());
            vP.setVisible(true);
             this.ventana.getEscritorio().add(vP);
           
        }
         if (e.getSource().equals(this.ventana.getMenuItemList().get(0))) {
            VentanaEstadio vP = new VentanaEstadio(this.ventana.getgD());
            vP.setVisible(true);
             this.ventana.getEscritorio().add(vP);

        }
          if (e.getSource().equals(this.ventana.getMenuItemList().get(1))) {
            VentanaTorneo vP = new VentanaTorneo(this.ventana.getgD());
            vP.setVisible(true);
             this.ventana.getEscritorio().add(vP);
          }
        
    }
    
}
