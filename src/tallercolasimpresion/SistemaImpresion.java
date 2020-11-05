/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercolasimpresion;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sophy
 */
public class SistemaImpresion {

    private final String FILE = "C:\\Users\\oscaretnia\\Desktop\\TallerColasImpresion\\src\\Taller.txt";

    //Gerencia y Admon
    Impresora impr1 = new Impresora();

    //Mercadeo y Produccion solo permite dos  trabajos maximo
    Impresora impr2 = new Impresora();

    //Cola auxiliar
    Cola aux = new Cola();

    public void cargarTrabajos() {
        Lector lector = new Lector();
        List<String> bufferRead = lector.run(FILE);
        List<Trabajo> datos = new ArrayList<>();

        for (int i = 0; i < bufferRead.size(); i++) {

            datos.add(new Trabajo(bufferRead.get(i), bufferRead.get(i + 1)));
            i++;
        }

        for (Trabajo trabajo : datos) {
            agregarTrabajo(trabajo);
        }

    }

    public void impresoraUno() {

        while (!impr1.estaVacia()) {

            if (impr1.obtener() != null) {
                imprimir(impr1.obtener());
                impr1.terminarTrabajo();
            } else {
                System.out.println("Impresora uno ha terminado");
            }
            
            if (impr1.obtenerTamanio() == 2) {

                if (aux.obtener() != null) {
                    agregarTrabajo(aux.obtener());
                    aux.desencolar();
                }
            }

        }

    }

    public void impresoraDos() {

        while (!impr2.estaVacia()) {

            if (impr2.obtener() != null) {
                imprimir(impr2.obtener());
                impr2.terminarTrabajo();
            } else {
                System.out.println("Impresora uno ha terminado");
            }

            if (impr2.obtenerTamanio() < 2) {

                if (aux.obtener() != null) {
                    agregarTrabajo(aux.obtener());
                    aux.desencolar();
                }
            }

        }

    }

    private void agregarTrabajo(Trabajo trabajo) {
        if (trabajo.esAdmon() || trabajo.esGerencia()) {

            ///si tiene más de 5 minutos  debe analizarse  en cuál de las impresorastardará menos tiempo y enviarse a dicha impresora.   
            if (impr1.obtenerTiempo() > 5) {

                if (impr1.obtenerTiempo() == impr2.obtenerTiempo()) { // si la cola es igual debe enviar a la impresora por defecto

                    agregarImpresoraUno(trabajo);

                } else if (impr1.obtenerTiempo() > impr2.obtenerTiempo()) { // si es mayor la cola de 1 debe enviarse a 2

                    if (impr2.obtenerTamanio() >= 2) {

                        agregarColaAuxiliar(trabajo);

                    } else {

                        agregarImpresoraDos(trabajo);

                    }

                } else {

                    agregarImpresoraUno(trabajo);

                }

            } else {
                agregarImpresoraUno(trabajo);
            }

        }

        if (trabajo.esProduccion() || trabajo.esMercadeo()) {

            if (impr2.obtenerTamanio() >= 2) {

                agregarColaAuxiliar(trabajo);

            } else {

                agregarImpresoraDos(trabajo);
            }

        }
    }

    private void imprimir(Trabajo trabajo) {
        try {
            System.out.println("|------------------------------------|");
            System.out.println("Imprimiendo : " + trabajo.getDependencia() + " - " + trabajo.getTipo());
            Thread.sleep(trabajo.getTiempo() * 1000);
            System.out.println("Impresion terminada : " + trabajo.getDependencia() + " - " + trabajo.getTipo());
        } catch (InterruptedException ex) {
            Logger.getLogger(SistemaImpresion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarImpresoraUno(Trabajo trabajo) {
        impr1.agregarTrabajo(trabajo);
        System.out.println(trabajo.getDependencia() + " " + trabajo.getTipo() + " se envio a la impresora 1 ");
    }

    private void agregarImpresoraDos(Trabajo trabajo) {
        impr2.agregarTrabajo(trabajo);
        System.out.println(trabajo.getDependencia() + " " + trabajo.getTipo() + " se envio a la impresora 2 ");
    }

    private void agregarColaAuxiliar(Trabajo trabajo) {
        aux.encolar(trabajo);
        System.out.println(trabajo.getDependencia() + " " + trabajo.getTipo() + "  se envio a la cola auxiliar");
    }

}
