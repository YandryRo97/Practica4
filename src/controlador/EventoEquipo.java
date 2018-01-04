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
import modelo.Equipo;
import modelo.Grupo;
import modelo.Pais;
import modelo.Torneo;
import vista.VentanaEquipo;

/**
 *
 * @author USUARIO
 */
public class EventoEquipo implements ActionListener 
{
    private VentanaEquipo ventanaEquipo;
    private GestionDato gD;

    public EventoEquipo(VentanaEquipo ventanaEquipo) {
        this.ventanaEquipo = ventanaEquipo;
        this.gD = gD;
    }

    public VentanaEquipo getVentanaEquipo() {
        return ventanaEquipo;
    }

    public void setVentanaEquipo(VentanaEquipo ventanaEquipo) {
        this.ventanaEquipo = ventanaEquipo;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
    
    public void actionPerformed(ActionEvent e) 
    
    {
       
       try
       {
           if (e.getSource().equals(this.ventanaEquipo.getBoton()))
           {
           
                Long id= Long.parseLong(this.ventanaEquipo.getTxtList().get(0).getText());
                
                int numJug= Integer.parseInt(this.ventanaEquipo.getTxtList().get(1).getText());
               
                String pais=this.ventanaEquipo.getCombo1().getSelectedItem().toString();
                
                String estTorneo=this.ventanaEquipo.getCombo2().getSelectedItem().toString();
                
                String grupo=this.ventanaEquipo.getCombo3().getSelectedItem().toString();
                
                for (Equipo eq:this.ventanaEquipo.getGestionDato().leerEquipo()) 
                {
                    if ((id == eq.getId())&& (pais.equals(eq.getPais().getNombre())) && (estTorneo.equals(eq.getTorneo().getEstadio()))&& (estTorneo.equals(eq.getGrupo().getNombre())))
                    {
                        throw new ExcepcionDatoRepetido("Cargo repetido");
                    }
                }
          
           
                for(Pais p:this.ventanaEquipo.getGestionDato().leerPais())
                {
               
                    if(pais.equals(p.getNombre()))
                    {
                  
                        for(Torneo t:this.ventanaEquipo.getGestionDato().leerTorneo())
                        {
                            if(estTorneo.equals(t.getEstadio().getNombre()))
                            {
                                for(Grupo g:this.ventanaEquipo.getGestionDato().leerGrupo())
                                {
                                    if(grupo.equals(g.getNombre()))
                                    {
                                        Equipo equipo=new Equipo(id,numJug,p,t,g);
                                        
                                        JOptionPane.showMessageDialog(this.ventanaEquipo,"Guardado");
                                        try {
                                            this.ventanaEquipo.getGestionDato().persistirEquipo(equipo);
                                            
                                            
                                            //AQUI VA EL METODO PERSIST EQUIPO DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
                                            
                                            //AQUI VA EL METODO LEE EQUIPO DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
                                        } catch (Exception ex) {
                                            Logger.getLogger(EventoEquipo.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        
                                        for(Equipo eq:this.ventanaEquipo.getGestionDato().leerEquipo())
                                        {
                                            this.ventanaEquipo.getGestionDato().leerEquipo();
                                        }
                                 
                                    }
                                }
                            }
                        }
                    }
                    
                   
                }
               
           }
           
           Object[][]datosEquipo=this.ventanaEquipo.cargaDatosTabla(this.ventanaEquipo.getGestionDato().leerEquipo().size(),5);
           this.ventanaEquipo.setDatos(datosEquipo);
           this.ventanaEquipo.getModeloTabla().setDataVector(this.ventanaEquipo.getDatos(), this.ventanaEquipo.getEncabezado());
       
       } catch (NumberFormatException ex) 
       {
         JOptionPane.showMessageDialog(this.ventanaEquipo, "Mal ingreso de datos");
       } catch (ExcepcionDatoRepetido ex) 
        {
            JOptionPane.showMessageDialog(this.ventanaEquipo, "Cargo repetido");
        }
    }
}

