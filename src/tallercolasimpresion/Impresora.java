/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercolasimpresion;

/**
 *
 * @author Sophy
 */
public class Impresora {
    
    private final Cola cola;
    
    public Impresora() {
        cola = new Cola();
    }
    
    public void agregarTrabajo(Trabajo trabajo) {
        cola.encolar(trabajo);
    }
    
    public void terminarTrabajo() {
        cola.desencolar();
    }
    
    public int obtenerTiempo() {
        int tiempo = 0;
        for (Trabajo trabajo: cola.lista()) {
            tiempo += trabajo.getTiempo();
        }
        return tiempo;
    }

    int obtenerTamanio() {
        return cola.obtenerTamanio();
    }

    boolean estaVacia() {
        return cola.estaVacia();
    }
    
    public Trabajo obtener() {
        return cola.obtener();
    }
    
    
}
