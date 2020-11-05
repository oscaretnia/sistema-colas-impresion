/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercolasimpresion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Lector {

    public ArrayList run(String dir) {

        String bfRead;
       
        ArrayList<String> temporal = new ArrayList<>();

        try {

            BufferedReader buff = new BufferedReader(new FileReader(dir));

            while ((bfRead = buff.readLine()) != null) {

                String[] datoLinea = bfRead.split(";");

                for (String dato : datoLinea) { // recorremos uno a uno los datos 

                    temporal.add(dato);
                }
            }
        } catch (Exception e) {

            System.err.println("No se encontro archivo !!");
        }

        return temporal;

    }

}
