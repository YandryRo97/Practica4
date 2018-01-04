/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Estadio;
import vista.VentanaEstadio;

/**
 *
 * @author USUARIO
 */
public class EventoEstadio implements ActionListener {

    private VentanaEstadio ventanaEstadio;

    public EventoEstadio(VentanaEstadio ventanaEstadio) {
        this.ventanaEstadio = ventanaEstadio;
    }

    public VentanaEstadio getVentanaEstadio() {
        return ventanaEstadio;
    }

    public void setVentanaEstadio(VentanaEstadio ventanaEstadio) {
        this.ventanaEstadio = ventanaEstadio;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            if (ae.getSource().equals(this.ventanaEstadio.getBoton())) {
                Long id = Long.parseLong(this.ventanaEstadio.getTxtList().get(0).getText());
                String nombre = this.ventanaEstadio.getTxtList().get(1).getText();
                String ciudad = this.ventanaEstadio.getTxtList().get(2).getText();
                Long capacidad = Long.parseLong(this.ventanaEstadio.getTxtList().get(3).getText());

                for (Estadio es : this.ventanaEstadio.getGestionDato().leerEstadio()) {
                    if (nombre.equals(es.getNombre())) {
                        throw new ExcepcionDatoRepetido("Nombre repetido");
                    }
                }
                Estadio e = new Estadio(id, nombre, ciudad, capacidad);
                
                try {
                    this.ventanaEstadio.getGestionDato().persistirEstadio(e);
                } catch (Exception ex) {
                    Logger.getLogger(EventoEstadio.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this.ventanaEstadio, "Guardado");
                
                //AQUI VA EL METODO PERSIST PAIS DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
                
                //AQUI VA EL METODO LEER PAIS DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
                
            }

            Object[][] datosEstadio = this.ventanaEstadio.cargaDatosTabla(this.ventanaEstadio.getGestionDato().leerEstadio().size(), 4);
            this.ventanaEstadio.setDatos(datosEstadio);
            this.ventanaEstadio.getModeloTabla().setDataVector(this.ventanaEstadio.getDatos(), this.ventanaEstadio.getEncabezado());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.ventanaEstadio, "Mal ingreso de datos");

        } catch (ExcepcionDatoRepetido ex) {
            JOptionPane.showMessageDialog(this.ventanaEstadio, "Cargo repetido");
        }

    }

}

