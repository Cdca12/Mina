package mina;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import utils.Semaforo;

/**
 *
 * @author Carlos Contreras
 */
public class ToneladaPlata extends JPanel {
    public int tipo;
    public Semaforo semaforo;
    public boolean estaAsignada;
    
    public ToneladaPlata(int tipo) {
        this.tipo = tipo;
        this.semaforo = new Semaforo(1);
        this.estaAsignada = false;
        setBorder(BorderFactory.createRaisedBevelBorder());
        switch (tipo) {
            case 1: // Tipo 1: Regular
                setBackground(Color.RED);
                break;
            case 2: // Tipo 2: Buena
                setBackground(Color.ORANGE);
                break;
            case 3: // Tipo 3: Excelente
                setBackground(Color.GREEN);
                break;
        }
        
    }
}
