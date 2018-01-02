/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Grupo;
import vista.VentanaGrupo;

/**
 *
 * @author USUARIO
 */
public class EventoGrupo  implements ActionListener{
    
    private VentanaGrupo ventanaGrupo;
    private GestionDato gD;

    public EventoGrupo(VentanaGrupo ventanaGrupo) {
        this.ventanaGrupo = ventanaGrupo;
    }

    public VentanaGrupo getVentanaGrupo() {
        return ventanaGrupo;
    }

    public void setVentanaGrupo(VentanaGrupo ventanaGrupo) {
        this.ventanaGrupo = ventanaGrupo;
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
           if (e.getSource().equals(this.ventanaGrupo.getBoton()))
           {
                Long id= Long.parseLong(this.ventanaGrupo.getTxtList().get(0).getText());
                String  n= this.ventanaGrupo.getTxtList().get(1).getText();
                int numEqui = Integer.parseInt(this.ventanaGrupo.getTxtList().get(2).getText());
               
                for (Grupo gr:this.ventanaGrupo.getGestionDato().getGrupoList()) 
                {
                    if ((id == gr.getId())&& (n == gr.getNombre()) && (numEqui== gr.getNumeroEqui()))
                    {
                        throw new ExcepcionDatoRepetido("Cargo repetido");
                    }
                }
                Grupo grupo = new Grupo(id,n,numEqui);
                JOptionPane.showMessageDialog(this.ventanaGrupo,"Guardado");
                ventanaGrupo.getGestionDato().getGrupoList().add(grupo);
              
                //AQUI VA EL METODO PERSIST EQUIPO DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
                this.ventanaGrupo.getGestionDato().persistirGrupo(grupo);
                //AQUI VA EL METODO LEE EQUIPO DE GESTION DATO QUE ANIADE LOS DATOS A LA TABLA DE LA BASE DE DATOS
                this.ventanaGrupo.getGestionDato().leerGrupo();
           }
           
           Object[][]datos = this.ventanaGrupo.cargaDatosTabla(this.ventanaGrupo.getGestionDato().getGrupoList().size(),3);
           this.ventanaGrupo.setDatos(datos);
           this.ventanaGrupo.getModeloTabla().setDataVector(this.ventanaGrupo.getDatos(), this.ventanaGrupo.getEncabezado());
         
       
       } catch (NumberFormatException ex) 
       {
         JOptionPane.showMessageDialog(this.ventanaGrupo, "Mal ingreso de datos");
       } catch (ExcepcionDatoRepetido ex) 
        {
            JOptionPane.showMessageDialog(this.ventanaGrupo, "Cargo repetido");
        }
        
    }
    
}

