/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Pais;
import vista.VentanaPais;

/**
 *
 * @author USUARIO
 */
public class EventoPais implements ActionListener{
    
    private VentanaPais ventanaPais;

    public EventoPais(VentanaPais ventanaPais) {
        this.ventanaPais = ventanaPais;
    }

    public VentanaPais getVentanaPais() {
        return ventanaPais;
    }

    public void setVentanaPais(VentanaPais ventanaPais) {
        this.ventanaPais = ventanaPais;
    }

    
    @Override
   public void actionPerformed(ActionEvent e) 
    {
       try{
           if (e.getSource().equals(this.ventanaPais.getBoton()))
           {
               Long id=Long.parseLong(this.ventanaPais.getTxtList().get(0).getText());
               
               String nombre=this.ventanaPais.getTxtList().get(1).getText();
              
               String nacionalidad=this.ventanaPais.getTxtList().get(2).getText();
               
               Long numHab=Long.parseLong(this.ventanaPais.getTxtList().get(3).getText());
               
                for (Pais p:this.ventanaPais.getGestionDato().getPaisList()) 
                {
                    if (nombre.equals(p.getNombre()))
                    {
                        throw new ExcepcionDatoRepetido("Cargo repetido");
                    }
                }
             
              
               Pais pa=new Pais(id,nombre,nacionalidad,numHab);
               ventanaPais.getGestionDato().getPaisList().add(pa);
               JOptionPane.showMessageDialog(this.ventanaPais,"Guardado");
               
               //AQUI VA EL METODO PERSIST PAIS DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
               this.ventanaPais.getGestionDato().persistirPais(pa);
               //AQUI VA EL METODO LEER PAIS DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
               this.ventanaPais.getGestionDato().leerPais();
                         
                                
            }
        
       
        Object[][]datosPais=this.ventanaPais.cargaDatosTabla(this.ventanaPais.getGestionDato().getPaisList().size(),4);
        this.ventanaPais.setDatos(datosPais);
        this.ventanaPais.getModeloTabla().setDataVector(this.ventanaPais.getDatos(), this.ventanaPais.getEncabezado());
       
       } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(this.ventanaPais, "Mal ingreso de datos");
       
        }
       catch (ExcepcionDatoRepetido ex) 
        {
            JOptionPane.showMessageDialog(this.ventanaPais, "Cargo repetido");
        }
    }
}

    
