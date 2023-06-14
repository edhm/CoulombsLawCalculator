/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.edhm.calculadoraleycoulomb;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * @author edhuerta
 * @email ed.huerta.m@gmail.com
 *
 * This tool allows us to perform calculations related to Coulomb's Law, which
 * describe the electrostatic interaction between two electric charges.
 */
public class CalculadoraLeyCoulomb extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemLeyCoulomb;
    private JMenuItem menuItemCalcularFuerza;
    private JMenuItem menuItemCalcularCampoElectrico;
    private JMenuItem menuItemCalcularPotencialElectrico;
    private JMenuItem menuItemCalcularDiferenciaDePotencialElectrico;
    private JMenuItem menuItemTeamFour;
    private JPanel panelTeamFour;
    private JPanel panelLeyCoulomb;
    private JPanel panelCalcularFuerza;
    private JPanel panelCalcularCampoElectrico;
    private JPanel panelCalcularPotencialElectrico;
    private JPanel panelCalcularDiferenciaDePotencialElectrico;
//  
    private JButton buttonTeamFour;
    private JLabel labelEdhm;
// Componenetes para CalcularFuerza
    private JTextField textFieldCarga1;
    private JTextField textFieldCarga2;
    private JTextField textFieldDistancia;
    private JButton buttonCalcularFuerza;
    private JLabel labelResultadoFuerza;
// Componenetes para CampoEléctrico
    private JTextField textFieldCarga;
    private JTextField textFieldFuerza;
    private JButton buttonCalcularCampoElectrico;
    private JLabel labelResultadoCampoElectrico;
// Componenetes para Potencialelectrico
    private JTextField textFieldCargaprueba;
    private JTextField textFieldCargaPuntual;
    private JTextField textFieldDistanciaCarga;
    private JButton buttonCalcularPotencialElectrico;
    private JLabel labelResultadoPotencialElectrico;
// Componenetes para DiferenciaPotencialelectrico
    private JTextField textFieldCargapruebaDP;
    private JTextField textFieldDistanciaUno;
    private JTextField textFieldDistanciaDos;
    private JButton buttonCalcularDiferenciaPotencialElectrico;
    private JLabel labelResultadoDiferenciaPotencialElectrico;
    public static double k = (1 / (4 * Math.PI * 8.85 * Math.pow(10, -12)));

    public CalculadoraLeyCoulomb() {
        // Configurar la ventana principal
        setTitle("Calculadora Ley de Coulomb");
        setSize(900, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Crear el menú
        menuBar = new JMenuBar();
        menu = new JMenu("Menú");
        menuItemLeyCoulomb = new JMenuItem("Ley de Colulomb");
        menuItemTeamFour = new JMenuItem("TeamFour");
        menuItemCalcularFuerza = new JMenuItem("Calcular Fuerza");
        menuItemCalcularCampoElectrico = new JMenuItem("Calcular Campo Eléctrico");
        menuItemCalcularPotencialElectrico = new JMenuItem("Calcular Potencial Eléctrico");
        menuItemCalcularDiferenciaDePotencialElectrico = new JMenuItem("Calcular La Diferencia de Potencial Eléctrico");

        // Agregar los elementos del menú
        menu.add(menuItemLeyCoulomb);
        menu.add(menuItemTeamFour);
        menu.add(menuItemCalcularFuerza);
        menu.add(menuItemCalcularCampoElectrico);
        menu.add(menuItemCalcularPotencialElectrico);
        menu.add(menuItemCalcularDiferenciaDePotencialElectrico);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Agregar el ActionListener a los elementos del menú
        menuItemLeyCoulomb.addActionListener(this);
        menuItemTeamFour.addActionListener(this);
        menuItemCalcularFuerza.addActionListener(this);
        menuItemCalcularCampoElectrico.addActionListener(this);
        menuItemCalcularPotencialElectrico.addActionListener(this);
        menuItemCalcularDiferenciaDePotencialElectrico.addActionListener(this);

        // Crear los paneles para cada opción del menú
        panelLeyCoulomb = new JPanel();
        panelTeamFour = new JPanel();
        panelCalcularFuerza = new JPanel();
        panelCalcularCampoElectrico = new JPanel();
        panelCalcularPotencialElectrico = new JPanel();
        panelCalcularDiferenciaDePotencialElectrico = new JPanel();

        // Configurar los componentes de cada panel
        // Panel Ley de Coulomb
        JLabel labelLeyCoulomb = new JLabel("Calculadora Ley de Coulomb");
        panelLeyCoulomb.add(labelLeyCoulomb);

        // Panel TeamFour
        panelTeamFour.setLayout(new BoxLayout(panelTeamFour, BoxLayout.Y_AXIS));
        labelEdhm = new JLabel();

        buttonTeamFour = new JButton("¿ Desea Conocerme ?");
        panelTeamFour.add(labelEdhm);

        panelTeamFour.add(buttonTeamFour);
        // Agregar el ActionListener al botón conocer Integrantes
        buttonTeamFour.addActionListener(this);

        // Panel Calcular Fuerza
        JLabel labelCarga1 = new JLabel("Primera Carga :");
        textFieldCarga1 = new JTextField(10);
        JLabel labelCarga2 = new JLabel("Segunda Carga:");
        textFieldCarga2 = new JTextField(10);
        JLabel labelDistancia = new JLabel("Distancia:");
        textFieldDistancia = new JTextField(10);
        buttonCalcularFuerza = new JButton("Calcular Fuerza");
        labelResultadoFuerza = new JLabel();

        panelCalcularFuerza.add(labelCarga1);
        panelCalcularFuerza.add(textFieldCarga1);
        panelCalcularFuerza.add(labelCarga2);
        panelCalcularFuerza.add(textFieldCarga2);
        panelCalcularFuerza.add(labelDistancia);
        panelCalcularFuerza.add(textFieldDistancia);
        panelCalcularFuerza.add(buttonCalcularFuerza);
        panelCalcularFuerza.add(labelResultadoFuerza);
        // Agregar el ActionListener al botón Calcular Fuerza
        buttonCalcularFuerza.addActionListener(this);

        // Panel Calcular Campo Eléctrico
        JLabel labelCarga = new JLabel("Carga:");
        textFieldCarga = new JTextField(10);
        JLabel labelFuerza = new JLabel("Fuerza:");
        textFieldFuerza = new JTextField(10);
        buttonCalcularCampoElectrico = new JButton("Calcular Campo Eléctrico");
        labelResultadoCampoElectrico = new JLabel();

        panelCalcularCampoElectrico.add(labelCarga);
        panelCalcularCampoElectrico.add(textFieldCarga);
        panelCalcularCampoElectrico.add(labelFuerza);
        panelCalcularCampoElectrico.add(textFieldFuerza);
        panelCalcularCampoElectrico.add(buttonCalcularCampoElectrico);
        panelCalcularCampoElectrico.add(labelResultadoCampoElectrico);
        // Agregar el ActionListener al botón Calcular Campo Eléctrico
        buttonCalcularCampoElectrico.addActionListener(this);

        // Panel Calcular Potencial Electrico
        JLabel labelCargaprueba = new JLabel("Carga prueba :");
        textFieldCargaprueba = new JTextField(10);
        JLabel labelCargaPuntual = new JLabel("Carga Puntual:");
        textFieldCargaPuntual = new JTextField(10);
        JLabel labelDistanciaCarga = new JLabel("Distancia:");
        textFieldDistanciaCarga = new JTextField(10);
        buttonCalcularPotencialElectrico = new JButton("Calcular Potencial Eléctrico");
        labelResultadoPotencialElectrico = new JLabel();

        panelCalcularPotencialElectrico.add(labelCargaprueba);
        panelCalcularPotencialElectrico.add(textFieldCargaprueba);
        panelCalcularPotencialElectrico.add(labelCargaPuntual);
        panelCalcularPotencialElectrico.add(textFieldCargaPuntual);
        panelCalcularPotencialElectrico.add(labelDistanciaCarga);
        panelCalcularPotencialElectrico.add(textFieldDistanciaCarga);
        panelCalcularPotencialElectrico.add(buttonCalcularPotencialElectrico);
        panelCalcularPotencialElectrico.add(labelResultadoPotencialElectrico);
        // Agregar el ActionListener al botón Calcular Fuerza
        buttonCalcularPotencialElectrico.addActionListener(this);

        // Panel Calcular Diferencial de Potencial Electrico
        JLabel labelCargapruebaDP = new JLabel("Carga de prueba :");
        textFieldCargapruebaDP = new JTextField(10);
        JLabel labelDistanciaUno = new JLabel("Distancia Uno:");
        textFieldDistanciaUno = new JTextField(10);
        JLabel labelDistanciaDos = new JLabel("Distancia Dos:");
        textFieldDistanciaDos = new JTextField(10);
        buttonCalcularDiferenciaPotencialElectrico = new JButton("Calcular Diferencia de Potencial");
        labelResultadoDiferenciaPotencialElectrico = new JLabel();

        panelCalcularDiferenciaDePotencialElectrico.add(labelCargapruebaDP);
        panelCalcularDiferenciaDePotencialElectrico.add(textFieldCargapruebaDP);
        panelCalcularDiferenciaDePotencialElectrico.add(labelDistanciaUno);
        panelCalcularDiferenciaDePotencialElectrico.add(textFieldDistanciaUno);
        panelCalcularDiferenciaDePotencialElectrico.add(labelDistanciaDos);
        panelCalcularDiferenciaDePotencialElectrico.add(textFieldDistanciaDos);             //
        panelCalcularDiferenciaDePotencialElectrico.add(buttonCalcularDiferenciaPotencialElectrico);
        panelCalcularDiferenciaDePotencialElectrico.add(labelResultadoDiferenciaPotencialElectrico);
        // Agregar el ActionListener al botón Calcular Fuerza
        buttonCalcularDiferenciaPotencialElectrico.addActionListener(this);

        // Agregar los paneles a la ventana
        add(panelLeyCoulomb);
        add(panelTeamFour);
        add(panelCalcularFuerza);
        add(panelCalcularCampoElectrico);
        add(panelCalcularPotencialElectrico);
        add(panelCalcularDiferenciaDePotencialElectrico);

        // Inicialmente, se muestra solo el panel de Ley de Coulomb
        mostrarPanel(panelLeyCoulomb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemLeyCoulomb) {
            mostrarPanel(panelLeyCoulomb);
        } else if (e.getSource() == menuItemTeamFour) {
            mostrarPanel(panelTeamFour);
        } else if (e.getSource() == menuItemCalcularFuerza) {
            mostrarPanel(panelCalcularFuerza);
        } else if (e.getSource() == menuItemCalcularCampoElectrico) {
            mostrarPanel(panelCalcularCampoElectrico);
        } else if (e.getSource() == menuItemCalcularPotencialElectrico) {
            mostrarPanel(panelCalcularPotencialElectrico);
        } else if (e.getSource() == menuItemCalcularDiferenciaDePotencialElectrico) {
            mostrarPanel(panelCalcularDiferenciaDePotencialElectrico);      //
        } else if (e.getSource() == buttonTeamFour) {
            viewTeamFour();//
        } else if (e.getSource() == buttonCalcularFuerza) {
            calcularFuerza();
        } else if (e.getSource() == buttonCalcularCampoElectrico) {
            calcularCampoElectrico();
        } else if (e.getSource() == buttonCalcularPotencialElectrico) {
            calcularPotencialElectrico();
        } else if (e.getSource() == buttonCalcularDiferenciaPotencialElectrico) {
            calcularDiferenciaPotencialElectrico();
        }
    }

    //menu.add(menuItemCalcularPotencialElectrico);
    private void mostrarPanel(JPanel panel) {
        // Ocultar todos los paneles
        panelLeyCoulomb.setVisible(false);
        panelTeamFour.setVisible(false);
        panelCalcularFuerza.setVisible(false);
        panelCalcularCampoElectrico.setVisible(false);
        panelCalcularPotencialElectrico.setVisible(false);
        panelCalcularDiferenciaDePotencialElectrico.setVisible(false);

        // Mostrar el panel seleccionado
        panel.setVisible(true);
    }

    private void viewTeamFour() {
        {
            labelEdhm.setText("Edgar Huerta Mendoza");

        }

    }

    private void calcularFuerza() {
        String inputCarga1 = textFieldCarga1.getText();
        String inputCarga2 = textFieldCarga2.getText();
        String inputDistancia = textFieldDistancia.getText();

        // Verificar si los campos están vacíos
        if (inputCarga1.isEmpty() || inputCarga2.isEmpty() || inputDistancia.isEmpty()) {
            labelResultadoFuerza.setText("Por favor, ingresa valores en los campos de entrada.");
        } else {
            try {
                // Convertir los valores ingresados a números
                double carga1 = Double.parseDouble(inputCarga1);
                double carga2 = Double.parseDouble(inputCarga2);
                double distancia = Double.parseDouble(inputDistancia);

                // Calcular la fuerza
                double fuerza = k * ((carga1 * carga2) / Math.pow(distancia, 2));

                // Mostrar el resultado
                labelResultadoFuerza.setText("La fuerza es: " + fuerza);
            } catch (NumberFormatException ex) {
                labelResultadoFuerza.setText("Por favor, ingresa valores numéricos válidos.");
            }
        }
    }

    private void calcularCampoElectrico() {
        String inputCarga = textFieldCarga.getText();
        String inputFuerza = textFieldFuerza.getText();

        // Verificar si los campos están vacíos
        if (inputCarga.isEmpty() || inputFuerza.isEmpty()) {
            labelResultadoCampoElectrico.setText("Por favor, ingresa valores en los campos de entrada.");
        } else {
            try {
                // Convertir los valores ingresados a números
                double carga = Double.parseDouble(inputCarga);
                double fuerza = Double.parseDouble(inputFuerza);

                // Calcular el campo eléctrico
                double campoElectrico = fuerza / carga;

                // Mostrar el resultado
                labelResultadoCampoElectrico.setText("El campo eléctrico es: " + campoElectrico);
            } catch (NumberFormatException ex) {
                labelResultadoCampoElectrico.setText("Por favor, ingresa valores numéricos válidos.");
            }
        }
    }

    private void calcularPotencialElectrico() {
        String inputCargaprueba = textFieldCargaprueba.getText();
        String inputCargaPuntual = textFieldCargaPuntual.getText();
        String inputDistanciaCarga = textFieldDistanciaCarga.getText();

        // Verificar si los campos están vacíos
        if (inputCargaprueba.isEmpty() || inputCargaPuntual.isEmpty() || inputDistanciaCarga.isEmpty()) {
            labelResultadoPotencialElectrico.setText("Por favor, ingresa valores en los campos de entrada.");
        } else {
            try {
                // Convertir los valores ingresados a números
                double cargaprueba = Double.parseDouble(inputCargaprueba);
                double cargaPuntual = Double.parseDouble(inputCargaPuntual);
                double distanciaCarga = Double.parseDouble(inputDistanciaCarga);

                // Calcular la fuerza
                double potelectrico = k * (cargaprueba * cargaPuntual) / (distanciaCarga);

                // Mostrar el resultado
                labelResultadoPotencialElectrico.setText("El potencial eléctrico es: " + potelectrico);
            } catch (NumberFormatException ex) {
                labelResultadoPotencialElectrico.setText("Por favor, ingresa valores numéricos válidos.");
            }
        }
    }

    private void calcularDiferenciaPotencialElectrico() {
        String inputCargapruebaDP = textFieldCargapruebaDP.getText();
        String inputDistanciaUno = textFieldDistanciaUno.getText();
        String inputDistanciaDos = textFieldDistanciaDos.getText();
        //String inputDistanciaCarga = textFieldDistanciaCarga.getText();

        // Verificar si los campos están vacíos
        if (inputCargapruebaDP.isEmpty() || inputDistanciaUno.isEmpty() || inputDistanciaDos.isEmpty()) {
            labelResultadoDiferenciaPotencialElectrico.setText("Por favor, ingresa valores en los campos de entrada.");
        } else {
            try {
                // Convertir los valores ingresados a números
                double cargapruebaDP = Double.parseDouble(inputCargapruebaDP);
                double distanciaUno = Double.parseDouble(inputDistanciaUno);
                double distanciaDos = Double.parseDouble(inputDistanciaDos);

                // Calcular la fuerza
                double difPotElectrico = k * (cargapruebaDP) * ((1 / distanciaUno) - (1 / distanciaDos));

                // Mostrar el resultado
                labelResultadoPotencialElectrico.setText("El potencial eléctrico es: " + difPotElectrico);
            } catch (NumberFormatException ex) {
                labelResultadoPotencialElectrico.setText("Por favor, ingresa valores numéricos válidos.");
            }
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            CalculadoraLeyCoulomb calculadora = new CalculadoraLeyCoulomb();
            calculadora.setVisible(true);
        });
    }
}
