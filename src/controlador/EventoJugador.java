/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Pais;
import vista.VentanaJugador;

/**
 *
 * @author USUARIO
 */
public class EventoJugador implements ActionListener{
    
    private VentanaJugador ventana;
    private GestionDato gD;

    public EventoJugador(VentanaJugador ventana) {
        this.ventana = ventana;
    }

    public VentanaJugador getVentana() {
        return ventana;
    }

    public void setVentana(VentanaJugador ventana) {
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
        
         
       try
       {
           if (e.getSource().equals(this.ventana.getBoton()))
           {
           
                Long id= Long.parseLong(this.ventana.getTxtList().get(0).getText());
                
                String nombre=this.ventana.getTxtList().get(1).getText();
                
                String apellido=this.ventana.getTxtList().get(2).getText();
               
                String pais=this.ventana.getCombo1().getSelectedItem().toString();
                
                String equipo=this.ventana.getCombo2().getSelectedItem().toString();
               
                for (Jugador j:this.ventana.getGestionDato().getJugadorList()) 
                {
                    if ((id == j.getId())&& (nombre == j.getNombre())&& (apellido == j.getApellido()) && (pais.equals(j.getPais().getNombre())) && (equipo.equals(j.getEquipo().getTorneo().getEstadio().getNombre())))
                    {
                        throw new ExcepcionDatoRepetido("Cargo repetido");
                    }
                }
          
           
                for(Pais p:this.ventana.getGestionDato().getPaisList())
                {
               
                    if(pais.equals(p.getNombre()))
                    {
                  
                        for(Equipo equi:this.ventana.getGestionDato().getEquipoList())
                        {
                            if(equipo.equals(equi.getTorneo().getEstadio().getNombre()))
                            {
                                
                                        Jugador juga = new Jugador(id,nombre,apellido,p,equi);
                                        JOptionPane.showMessageDialog(this.ventana,"Guardado");
                                        ventana.getGestionDato().getJugadorList().add(juga);
                                        
                                        //AQUI VA EL METODO PERSIST EQUIPO DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
                                        this.ventana.getGestionDato().persistirJugador(juga);
                                        //AQUI VA EL METODO LEE EQUIPO DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
                                        this.ventana.getGestionDato().leerJugador();
                                    }
                                }
                            }
                        }
                    }
         
           Object[][]datos=this.ventana.cargaDatosTabla(this.ventana.getGestionDato().getJugadorList().size(),5);
           this.ventana.setDatos(datos);
           this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos() , this.ventana.getEncabezado());
       
       } catch (NumberFormatException ex) 
       {
         JOptionPane.showMessageDialog(this.ventana, "Mal ingreso de datos");
       } catch (ExcepcionDatoRepetido ex) 
        {
            JOptionPane.showMessageDialog(this.ventana, "Cargo repetido");
        }
    }
 
}
