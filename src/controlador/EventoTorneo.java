/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Estadio;
import modelo.Torneo;
import vista.VentanaTorneo;

/**
 *
 * @author USUARIO
 */
public class EventoTorneo implements ActionListener {

    private VentanaTorneo ventanaTorneo;

    public EventoTorneo(VentanaTorneo ventanaTorneo) {
        this.ventanaTorneo = ventanaTorneo;
    }

    public VentanaTorneo getVentanaTorneo() {
        return ventanaTorneo;
    }

    public void setVentanaTorneo(VentanaTorneo ventanaTorneo) {
        this.ventanaTorneo = ventanaTorneo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {

            if (ae.getSource().equals(this.ventanaTorneo.getBoton())) {

                Long id = Long.parseLong(this.ventanaTorneo.getTxtList().get(0).getText());
                String fecha = this.ventanaTorneo.getTxtList().get(1).getText();
                String estadio = this.ventanaTorneo.getCombo().getSelectedItem().toString();

                for (Torneo t : this.ventanaTorneo.getGestionDato().getTorneoList()) {

                    if ((id == t.getId()) && (estadio.equals(t.getEstadio().getNombre())) && (fecha.equals(t.getFechaIns()))) {
                        throw new ExcepcionDatoRepetido("Estadio repetido");

                    }

                }
                for (Estadio e : this.ventanaTorneo.getGestionDato().getEstadioList()) {
                    if (estadio.equals(e.getNombre())) {

                        Torneo to = new Torneo(id, fecha, e);
                        JOptionPane.showMessageDialog(this.ventanaTorneo, "Guardado");
                        ventanaTorneo.getGestionDato().getTorneoList().add(to);

                        //AQUI VA EL METODO PERSIST EQUIPO DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
                        this.ventanaTorneo.getGestionDato().persistirTorneo(to);
                        //AQUI VA EL METODO LEE EQUIPO DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
                        this.ventanaTorneo.getGestionDato().leerTorneo();
                    }

                }

            }
            Object[][] datosTorneo = this.ventanaTorneo.cargaDatosTabla(this.ventanaTorneo.getGestionDato().getTorneoList().size(), 3);
            this.ventanaTorneo.setDatos(datosTorneo);
            this.ventanaTorneo.getModeloTabla().setDataVector(this.ventanaTorneo.getDatos(), this.ventanaTorneo.getEncabezado());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.ventanaTorneo, "Mal ingreso de datos");
        } catch (ExcepcionDatoRepetido ex) {
            JOptionPane.showMessageDialog(this.ventanaTorneo, "Estadio repetido");
        }
    }

}

