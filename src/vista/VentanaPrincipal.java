/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoPrincipal;
import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author USUARIO
 */
public class VentanaPrincipal extends JFrame{
    
    private JMenuBar menuPrincipal;
    private JDesktopPane escritorio;
    private JMenu menu1;
    private List<JMenuItem> menuItemList;
    private GestionDato gD;
    
    public VentanaPrincipal(String titulo, GestionDato gD) {
        this.setTitle(titulo);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(3);
        this.gD = gD;
        this.iniciaComponente();
    }
    
    public void iniciaComponente(){
        this.menuPrincipal = new JMenuBar();
        this.escritorio = new JDesktopPane();
        
        this.menu1 = new JMenu("Crear");
        
        this.menuItemList = new ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Estadio"));
        this.menuItemList.add(new JMenuItem("Torneo"));
        this.menuItemList.add(new JMenuItem("Equipo"));
        this.menuItemList.add(new JMenuItem("Grupo"));
        this.menuItemList.add(new JMenuItem("Pais"));
        this.menuItemList.add(new JMenuItem("Jugador"));
        
        this.setContentPane(this.escritorio);
        this.setJMenuBar(menuPrincipal);

        this.menuPrincipal.add(this.menu1);
        
        this.menu1.add(this.menuItemList.get(0));
        this.menu1.add(this.menuItemList.get(1));
        this.menu1.add(this.menuItemList.get(2));
        this.menu1.add(this.menuItemList.get(3));
        this.menu1.add(this.menuItemList.get(4));
        this.menu1.add(this.menuItemList.get(5));
                 
        this.menuItemList.get(0).addActionListener(new EventoPrincipal(this));
        this.menuItemList.get(1).addActionListener(new EventoPrincipal(this));
        this.menuItemList.get(2).addActionListener(new EventoPrincipal(this));
        this.menuItemList.get(3).addActionListener(new EventoPrincipal(this));
        this.menuItemList.get(4).addActionListener(new EventoPrincipal(this));
        this.menuItemList.get(5).addActionListener(new EventoPrincipal(this));
        
        
    }

    public JMenuBar getMenuPrincipal() {
        return menuPrincipal;
    }

    public void setMenuPrincipal(JMenuBar menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenu getMenu1() {
        return menu1;
    }

    public void setMenu1(JMenu menu1) {
        this.menu1 = menu1;
    }

    public List<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
    
    

}
