
package tallercolasimpresion;

import java.util.Scanner;


public class TallerColasImpresion {

    public static void main(String[] args) {

        SistemaImpresion sistema = new SistemaImpresion();

        int opcion;

        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
       
                
        while (!cerrar) {

            System.out.println("\n |--------------------------------------|");
            System.out.println(" |               *MINUTECH*             |");
            System.out.println(" |-------------------|------------------|");
            System.out.println(" | 1.Cargar trabajos |4.Salir           |");
            System.out.println(" | 2.Imprimir 1      |5.---------       |");
            System.out.println(" | 3.Imprimir 2      |6.-----           |");
            System.out.println(" |-------------------|------------------|");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    sistema.cargarTrabajos();
                break;

                case 2: // imprimir 1
                    sistema.impresoraUno();
                break;

                case 3: // imprimir 2
                    sistema.impresoraDos();
                break;

                case 4: // salir
                    cerrar = true;
                break;
    
            }

        }

    }
}
