/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author USUARIO
 */
class ExcepcionDatoRepetido extends Exception{
    
    public ExcepcionDatoRepetido(String datoRepetido) {
        super(datoRepetido);
        
    }
}
