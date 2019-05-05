package mina;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.Rutinas;

/**
 *
 * @author Carlos Contreras
 */
public class Mina extends JFrame implements ActionListener {

    private int rangoInferior, rangoSuperior, numeroTipo1, numeroTipo2, numeroTipo3, toneladasEuropa, toneladasAsia;
    private JPanel minaPlata;
    private ToneladaPlata[] toneladasPlata;
    private int numeroToneladas, numeroPaisesEuropa, numeroPaisesAsia;
    private JButton btnIniciar, btnReiniciar, btnSalir;
    private JLabel lbNumeroToneladas, lbToneladasTipo1, lbToneladasTipo2, lbToneladasTipo3,
            lbLogoEuropa, lbLogoAsia, lbEuropa, lbAsia, lbNumeroPaisesEuropa, lbNumeroPaisesAsia,
            lbToneladasEuropa, lbToneladasAsia;

    public Mina() {
        initComponents();
        addListeners();
        setVisible(true);
    }

    public void initComponents() {
        setTitle("Mina");
        setLayout(null);
        setSize(800, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(false);
        setLocationRelativeTo(null);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(1180, 30, 140, 30);
        add(btnIniciar);

        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setBounds(btnIniciar.getX(), btnIniciar.getY() + btnIniciar.getHeight() + 5, 140, 30);
        add(btnReiniciar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(btnIniciar.getX(), btnReiniciar.getY() + btnReiniciar.getHeight() + 5, 140, 30);
        add(btnSalir);

        minaPlata = new JPanel();
//        minaPlata.setBounds(10, 10, 1150, 670);
        minaPlata.setBounds(10, 10, 1150, 650);
        generarMina();
        add(minaPlata);

        lbNumeroToneladas = new JLabel("Número de toneladas: " + numeroToneladas);
        lbNumeroToneladas.setBounds(20, 675, 200, 10);
        add(lbNumeroToneladas);

        lbToneladasTipo1 = new JLabel("Toneladas Tipo 1: " + numeroTipo1);
        lbToneladasTipo1.setBounds(lbNumeroToneladas.getX() + lbNumeroToneladas.getWidth() + 5, 675, 200, 10);
        add(lbToneladasTipo1);

        lbToneladasTipo2 = new JLabel("Toneladas Tipo 2: " + numeroTipo2);
        lbToneladasTipo2.setBounds(lbToneladasTipo1.getX() + lbToneladasTipo1.getWidth() + 5, 675, 200, 10);
        add(lbToneladasTipo2);

        lbToneladasTipo3 = new JLabel("Toneladas Tipo 3: " + numeroTipo3);
        lbToneladasTipo3.setBounds(lbToneladasTipo2.getX() + lbToneladasTipo2.getWidth() + 5, 675, 200, 10);
        add(lbToneladasTipo3);

        lbLogoEuropa = new JLabel(Rutinas.AjustarImagen("./src/images/Europa.png", 100, 100));
        lbLogoEuropa.setBounds(1200, 200, 100, 100);
        add(lbLogoEuropa);

        lbLogoAsia = new JLabel(Rutinas.AjustarImagen("./src/images/Asia.png", 100, 100));
        lbLogoAsia.setBounds(1200, 420, 100, 100);
        add(lbLogoAsia);

        generarPaises();

        lbEuropa = new JLabel("Europa");
        lbEuropa.setBounds(1230, 135, 100, 100);
        add(lbEuropa);

        lbNumeroPaisesEuropa = new JLabel("Número países: " + numeroPaisesEuropa);
        lbNumeroPaisesEuropa.setBounds(1195, 270, 150, 100);
        add(lbNumeroPaisesEuropa);
        
        lbAsia = new JLabel("Asia");
        lbAsia.setBounds(1230, 355, 100, 100);
        add(lbAsia);

        lbNumeroPaisesAsia = new JLabel("Número países: " + numeroPaisesAsia);
        lbNumeroPaisesAsia.setBounds(1195, 490, 150, 100);
        add(lbNumeroPaisesAsia);
        
        lbToneladasEuropa = new JLabel("Toneladas: " + toneladasEuropa);
        lbToneladasEuropa.setBounds(1195, 290, 150, 100);
        add(lbToneladasEuropa);
        
        lbToneladasAsia = new JLabel("Toneladas: " + toneladasAsia);
        lbToneladasAsia.setBounds(1195, 510, 150, 100);
        add(lbToneladasAsia);

    }

    public void generarPaises() {
        numeroPaisesEuropa = Rutinas.nextInt(10, 30);
        numeroPaisesAsia = Rutinas.nextInt(5, 7);
        toneladasEuropa = (int) (numeroToneladas * 0.50);
        toneladasAsia = (int) (numeroToneladas * 0.50);
    }

    public void addListeners() {
        btnIniciar.addActionListener(this);
        btnReiniciar.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    public void generarMina() {
        rangoInferior = 100;
        rangoSuperior = 300;
        numeroToneladas = Rutinas.nextInt(rangoInferior, rangoSuperior);
//        numeroToneladas = 100; // TEST:

        // Generar
        int raizCuadrada = (int) Math.sqrt(numeroToneladas);
        minaPlata.setLayout(new GridLayout(raizCuadrada, raizCuadrada));

        // Generar toneladas por cada categoría
        numeroTipo1 = (int) (numeroToneladas * 0.30);
        numeroTipo2 = (int) (numeroToneladas * 0.60);
        numeroTipo3 = numeroToneladas - (numeroTipo1 + numeroTipo2);

        // Generar toneladas de plata totales
        toneladasPlata = new ToneladaPlata[numeroToneladas];
        for (int i = 0; i < numeroToneladas; i++) {
            for (int j = 0; j < numeroTipo1; toneladasPlata[i] = new ToneladaPlata(1), i++, j++);
            for (int j = 0; j < numeroTipo2; toneladasPlata[i] = new ToneladaPlata(2), i++, j++);
            for (int j = 0; j < numeroTipo3; toneladasPlata[i] = new ToneladaPlata(3), i++, j++);
        }
        Collections.shuffle(Arrays.asList(toneladasPlata));
        for (int i = 0; i < numeroToneladas; minaPlata.add(toneladasPlata[i]), i++);
    }

    public void actualizarTexto() {
        lbNumeroToneladas.setText("Número de toneladas: " + numeroToneladas);
        lbToneladasTipo1.setText("Toneladas Tipo 1: " + numeroTipo1);
        lbToneladasTipo2.setText("Toneladas Tipo 2: " + numeroTipo2);
        lbToneladasTipo3.setText("Toneladas Tipo 3: " + numeroTipo3);
        lbNumeroPaisesEuropa.setText("Número de países: " + numeroPaisesEuropa);
        lbNumeroPaisesAsia.setText("Número de países: " + numeroPaisesAsia);
        lbToneladasEuropa.setText("Toneladas: " + toneladasEuropa);
        lbToneladasAsia.setText("Toneladas: " + toneladasAsia);
    }
    
    public void asignarToneladas() {
        // Crear Paises
        Pais[] paisesEuropa = new Pais[numeroPaisesEuropa];
        Pais[] paisesAsia = new Pais[numeroPaisesAsia];
        for (int i = 0; i < numeroPaisesEuropa; paisesEuropa[i] = new Pais(toneladasPlata,toneladasEuropa,'E'), i++);
        for (int i = 0; i < numeroPaisesAsia; paisesAsia[i] = new Pais(toneladasPlata,toneladasAsia,'A'), i++);
            
        // Iniciar hilo Paises
        for (int i = 0; i < numeroPaisesEuropa; paisesEuropa[i].start(), i++);
        for (int i = 0; i < numeroPaisesAsia; paisesAsia[i].start(), i++);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnIniciar) {
            asignarToneladas();
            return;
        }
        if (evt.getSource() == btnReiniciar) {
            minaPlata.removeAll();
            generarMina();
            minaPlata.updateUI();
            generarPaises();
            actualizarTexto();
            return;
        }
        if (evt.getSource() == btnSalir) {
            System.exit(NORMAL);
            return;
        }
    }

}
