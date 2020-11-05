/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercolasimpresion;


public class Trabajo {
    
    private final String dependencia;
    private final String tipo;
    

    public Trabajo(String dependencia, String tipo) {
        this.dependencia = dependencia;
        this.tipo = tipo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public String getTipo() {
        if ("1".equals(tipo)) return "Sencillo";
        if ("2".equals(tipo)) return "Informe";
        if ("3".equals(tipo)) return "Catalogo";
        return tipo;
    }   
    
    public int getTiempo() {
        if (esSencillo()) return 1;
        if (esInforme()) return 3;
        if (esCatalogo()) return 5;
        
        return 0;
    }
    
    public boolean esSencillo() {
        return getTipo().equalsIgnoreCase("Sencillo");
    }
    
    public boolean esInforme() {
        return getTipo().equalsIgnoreCase("Informe");
    }
    
    public boolean esCatalogo() {
        return getTipo().equalsIgnoreCase("Catalogo");
    }
    
    public boolean esAdmon() {
        return dependencia.equalsIgnoreCase("ADMON");
    }
    
    public boolean esGerencia() {
        return dependencia.equalsIgnoreCase("GERENCIA");
    }
    
    public boolean esMercadeo() {
        return dependencia.equalsIgnoreCase("MERCADEO");
    }
    
    public boolean esProduccion() {
        return dependencia.equalsIgnoreCase("PRODUCCION");
    }
}
