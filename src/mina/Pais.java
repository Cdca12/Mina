package mina;

import java.util.*;

import utils.*;

/**
 *
 * @author Carlos Contreras
 */
public class Pais extends Thread {

    public ToneladaPlata[] toneladaPlata;
    public int numeroPeticiones;
    public char type;
    public Integer tonsPerContinent;
    public int[] tonsPerType;

    private volatile static int contEurope;
    private volatile static int contAsia;
    private static Semaforo semTons = new Semaforo(1);
    // public int toneladasTipo1, toneladasTipo2, toneladasTipo3;

    public Pais(ToneladaPlata[] toneladaPlata, Integer tonsPerContinent, char type) {
        this.toneladaPlata = toneladaPlata;
        this.tonsPerContinent = tonsPerContinent;
        tonsPerType = new int[3];
        this.type = type;
    }

    @Override
    public void run() {
        ToneladaPlata currentTon;
        Vector<ToneladaPlata> ownTons = new Vector<ToneladaPlata>();
        int tipoPeticion, cantidadPeticion;
        //while (toneladasDisponibles()) {
            tipoPeticion = Rutinas.nextInt(1, 3);
            cantidadPeticion = Rutinas.nextInt(1, 3);
            //for (int i = 0; i < cantidadPeticion; i++) {

                for (int j = 0; j < toneladaPlata.length; j++) {
                    //System.out.println(getName()+" Europa: "+contEurope+" Asia: "+contAsia);
                    if(!toneladasDisponibles()){
                        System.out.println(getName()+"here");
                        break;
                    }
                    
                    currentTon = toneladaPlata[j];
                    //System.out.println(currentTon.estaAsignada);                    
                    if (currentTon.tipo != tipoPeticion) {
                        continue;
                    }
                    currentTon.semaforo.Espera();
                    if (currentTon.estaAsignada) {
                        //System.out.println(1);
                        currentTon.semaforo.Libera();
                        continue;
                    }
                    currentTon.estaAsignada = true;
                    currentTon.semaforo.Libera();

                    //System.out.println(3);    
                    if (this.type == 'E') {
                        semTons.Espera();
                        contEurope += cantidadPeticion;
                        semTons.Libera();
                    } else {
                        semTons.Espera();
                        contAsia += cantidadPeticion;
                        semTons.Libera();
                    }
                    ownTons.add(currentTon);
                    if(ownTons.size() == cantidadPeticion)
                        break;

                }
            //}

        //}
        System.out.println(this.getName() +"\tTipo: "+type+"\tPeticion: "+cantidadPeticion+"\tObtenidos: "+ ownTons.size()+"\ttipo Peticion: "+tipoPeticion);
    }

    public boolean toneladasDisponibles() {
        if (type == 'E') {
           semTons.Espera();
           boolean result = contEurope < this.tonsPerContinent;
           semTons.Libera();
           return result;
        }
        semTons.Espera();
        boolean result = contAsia < this.tonsPerContinent;
        semTons.Libera();
        return result;
    }
    

}
