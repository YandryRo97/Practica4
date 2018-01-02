/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoEstadio;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Estadio;

/**
 *
 * @author USUARIO
 */
public class VentanaEstadio extends JInternalFrame{
    
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

    public VentanaEstadio(GestionDato gestionDato) {
        super("Registro Estadio", true, true, true, true);
        this.setSize(500, 300);
        this.gestionDato = gestionDato;
        this.iniciaComponente();
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

    public void iniciaComponente() {
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Ingrese el id"));
        this.etiList.add(new JLabel("Ingrese el nombre"));
        this.etiList.add(new JLabel("Ingrese la ciudad"));
        this.etiList.add(new JLabel("Ingrese la capacidad"));

        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField(10));
        this.txtList.add(new JTextField(10));
        this.txtList.add(new JTextField(10));
        this.txtList.add(new JTextField(10));

        this.boton = new JButton("Guardar");
        this.boton2 = new JButton("Limpiar");
        
        this.boton.addActionListener(new EventoEstadio(this));
        this.boton2.addActionListener(new EventoEstadio(this));
        

        this.encabezado = new Object[4];
        this.encabezado[0] = "Id";
        this.encabezado[1] = "Nombre";
        this.encabezado[2] = "Ciudad";
        this.encabezado[3] = "Capacidad";

        this.datos = cargaDatosTabla(this.gestionDato.getEstadioList().size(), 4);
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        this.panelGuardar.add(this.etiList.get(0));
        this.panelGuardar.add(this.txtList.get(0));
        this.panelGuardar.add(this.etiList.get(1));
        this.panelGuardar.add(this.txtList.get(1));
        this.panelGuardar.add(this.etiList.get(2));
        this.panelGuardar.add(this.txtList.get(2));
        this.panelGuardar.add(this.etiList.get(3));
        this.panelGuardar.add(this.txtList.get(3));

        this.panelVer.add(this.scroll, BorderLayout.CENTER);
        this.panelGuardar.add(this.boton);
        this.panelInicial.add(this.panelGuardar);
        this.panelInicial.add(this.panelVer);
        this.panelVer.add(this.scroll, BorderLayout.CENTER);
        this.add(panelInicial);

    }

    public Object[][] cargaDatosTabla(int h, int w) {

        Object[][] retorno = new Object[h][w];
        int i = 0;
        for(Estadio es : this.gestionDato.getEstadioList()){
            
            retorno[i][0] = es.getId();
            retorno[i][1] = es.getNombre();
            retorno[i][2] = es.getCapacidad();
            retorno[i][3] = es.getCapacidad();
            
            i++;
        }
        return retorno;

    }
    
}
