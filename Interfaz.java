/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Javi
 */
public class Interfaz extends JFrame {

    private static Database database;
    public static Menu menu;
    public static JPanel nuevoPaciente, nuevoDoctor, nuevaCita;
    public static ArrayList<String> doctores, pacientes;

    public Interfaz() {
        database = new Database();
        doctores = new ArrayList<>();
        pacientes = new ArrayList<>();
        menu = new Menu();
        nuevoDoctor = new Doctor();
        nuevoPaciente = new Paciente();
        nuevaCita = new Cita();

        database.fillDatabase();

        setTitle("Administrador");
        setSize(800, 530);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        menu.setSize(800, 500);
        menu.setLocation(0, 0);
        menu.setVisible(true);

        nuevoPaciente.setSize(800, 500);
        nuevoPaciente.setLocation(0, 0);
        nuevoPaciente.setVisible(false);

        nuevoDoctor.setSize(800, 500);
        nuevoDoctor.setLocation(0, 0);
        nuevoDoctor.setVisible(false);

        nuevaCita.setSize(800, 500);
        nuevaCita.setLocation(0, 0);
        nuevaCita.setVisible(false);

        add(menu);
        add(nuevoPaciente);
        add(nuevoDoctor);
        add(nuevaCita);
        setVisible(true);
    }

    public static Database getDatabase(){
        return database;
    }

}
