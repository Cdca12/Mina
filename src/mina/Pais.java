package mina;

import utils.Rutinas;
import utils.Semaforo;

/**
 *
 * @author Carlos Contreras
 */
public class Pais extends Thread {

    public ToneladaPlata[] toneladaPlata;
    public int numeroPeticiones;
    public int toneladasTipo1, toneladasTipo2, toneladasTipo3;

    public Pais(ToneladaPlata[] toneladaPlata) {
        this.toneladaPlata = toneladaPlata;
    }

    @Override
    public void run() {
        int tipoPeticion, cantidadPeticion;
        while (toneladasDisponibles()) {
            tipoPeticion = Rutinas.nextInt(1, 3);
            cantidadPeticion = Rutinas.nextInt(1, 3);
            numeroPeticiones+= cantidadPeticion;
            for (int i = 0; i < cantidadPeticion; i++) {
//                toneladaPlata[i]
            }
        }
    }
    
    public boolean toneladasDisponibles() {
        for (ToneladaPlata toneladaPlata : toneladaPlata) {
            if (!toneladaPlata.estaAsignada) {
                return true;
            }
        }
        return false;
    }
}
