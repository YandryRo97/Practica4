/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoEquipo;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Equipo;
import modelo.Grupo;
import modelo.Pais;
import modelo.Torneo;

/**
 *
 * @author USUARIO
 */
public class VentanaEquipo extends JInternalFrame {
    
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private JButton boton;
    private JButton boton2;
    private JPanel panelGuardar;
    private JPanel panelInicial;
    private JPanel panelVer;
    private GestionDato gestionDato;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private JComboBox combo1;
    private JComboBox combo2;
    private JComboBox combo3;
    
    public VentanaEquipo(GestionDato gestionDato){
        super("Registro Equipo", true, true, true, true);
        this.setSize(560, 300);
        this.gestionDato = gestionDato;
        this.iniciaComponente();
        this.setVisible(true);
    }
    
    public void iniciaComponente(){
        
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Id"));
        this.etiList.add(new JLabel("Numero Jugadores"));
        this.etiList.add(new JLabel("Pais"));
        this.etiList.add(new JLabel("Torneo"));
        this.etiList.add(new JLabel("Grupo"));
        
        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField(5));
        this.txtList.add(new JTextField(7));
        
        this.boton= new JButton("Guardar");
        
   
        this.boton.addActionListener(new EventoEquipo(this));
    
        this.encabezado = new Object[5];
        this.encabezado[0]="Id";
        this.encabezado[1]="Numero Jugadores";
        this.encabezado[2]="Pais";
        this.encabezado[3]="Torneo";
        this.encabezado[4]="Grupo";
       
        this.datos = cargaDatosTabla(this.gestionDato.leerEquipo().size(),5);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        LayoutManager disenio = new GridLayout(6, 2);
        LayoutManager disenio2 = new GridLayout(2, 1);
        this.panelVer= new JPanel(new BorderLayout());
	this.panelGuardar = new JPanel(disenio);
	this.panelInicial = new JPanel(disenio2);
        
        this.panelGuardar.add(this.etiList.get(0));
        this.panelGuardar.add(this.txtList.get(0));
        this.panelGuardar.add(this.etiList.get(1));
        this.panelGuardar.add(this.txtList.get(1));
        
        this.panelGuardar.add(this.etiList.get(2));
        this.combo1=new JComboBox();
        this.cargarCombo1();
        this.panelGuardar.add(this.combo1);
        
        this.panelGuardar.add(this.etiList.get(3));
        this.combo2=new JComboBox();
        this.cargarCombo2();
        this.panelGuardar.add(this.combo2);
        
        this.panelGuardar.add(this.etiList.get(4));
        this.combo3=new JComboBox();
        this.cargarCombo3();
        this.panelGuardar.add(this.combo3);
       
	this.panelVer.add(this.scroll, BorderLayout.CENTER);
	this.panelGuardar.add(this.boton);
	this.panelInicial.add(this.panelGuardar);
	this.panelInicial.add(this.panelVer);
        this.panelVer.add(this.scroll, BorderLayout.CENTER);
        this.add(panelInicial);
    }
    
    public Object[][]cargaDatosTabla(int h,int w)
    {
        Object[][]retorno=new Object[h][w];
        int i=0;
        for(Equipo c:this.gestionDato.leerEquipo())
        {
           retorno[i][0]=c.getId();
           retorno[i][1]=c.getNumJugadores();
           retorno[i][2]=c.getPais().getNombre();
           retorno[i][3]=c.getTorneo().getEstadio().getNombre();
           retorno[i][4]=c.getGrupo().getNombre();
           i++;
        }
        
        return retorno;
           
    }
    public void cargarCombo1(){
        this.combo1.removeAllItems();
        for(Pais p: this.gestionDato.leerPais())
        {
            this.combo1.addItem(p.getNombre());
        }
    }
    
    public void cargarCombo2(){
        this.combo2.removeAllItems();
        for(Torneo t: this.gestionDato.leerTorneo())
        {
            this.combo2.addItem(t.getEstadio().getNombre());
        }
    }


    public void cargarCombo3()
    {
       this.combo3.removeAllItems();
       for(Grupo g: this.gestionDato.leerGrupo())
       {
           this.combo3.addItem(g.getNombre());
       }
    }

    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public void setBoton2(JButton boton2) {
        this.boton2 = boton2;
    }

    public JPanel getPanelGuardar() {
        return panelGuardar;
    }

    public void setPanelGuardar(JPanel panelGuardar) {
        this.panelGuardar = panelGuardar;
    }

    public JPanel getPanelInicial() {
        return panelInicial;
    }

    public void setPanelInicial(JPanel panelInicial) {
        this.panelInicial = panelInicial;
    }

    public JPanel getPanelVer() {
        return panelVer;
    }

    public void setPanelVer(JPanel panelVer) {
        this.panelVer = panelVer;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JComboBox getCombo1() {
        return combo1;
    }

    public void setCombo1(JComboBox combo1) {
        this.combo1 = combo1;
    }

    public JComboBox getCombo2() {
        return combo2;
    }

    public void setCombo2(JComboBox combo2) {
        this.combo2 = combo2;
    }

    public JComboBox getCombo3() {
        return combo3;
    }

    public void setCombo3(JComboBox combo3) {
        this.combo3 = combo3;
    }
    
}
