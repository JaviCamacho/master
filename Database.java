/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Javi
 */
public class Database {

    private File file;
    private String doctores = "", pacientes = "", citas = "";
    public static int idDoctor = 0, idPaciente = 0;
    public static ArrayList<Pacientes> pacientesRegistro;

    public Database() {
        pacientesRegistro = new ArrayList<>();
        file = new File("database.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al crear la base de datos");
        }
    }

    public void fillDatabase() {
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            boolean bandera = true;
            int row = 0;
            while (bandera) {
                String cadena = br.readLine();
                row++;
                if (cadena != null) {
                    StringTokenizer stk = new StringTokenizer(cadena, ",");
                    switch (row) {
                        case 1:
                            while (stk.hasMoreTokens()) {
                                String id = stk.nextToken();
                                Database.idDoctor = Integer.parseInt(id);
                                String nombre = stk.nextToken();
                                String especialidad = stk.nextToken();
                                Evidencia.interfaz.doctores.add(nombre);
                                addDoctor(id + "," + nombre + "," + especialidad + ",");
                            }
                            break;
                        case 2:
                            while (stk.hasMoreTokens()) {
                                String id = stk.nextToken();
                                Database.idPaciente = Integer.parseInt(id);
                                String nombre = stk.nextToken();
                                Evidencia.interfaz.pacientes.add(nombre);
                                addPaciente(id + "," + nombre + ",");
                            }
                            break;
                        case 3:
                            while (stk.hasMoreTokens()) {
                                String id = stk.nextToken();
                                String fechaHora = stk.nextToken();
                                String motivo = stk.nextToken();
                                String nameDoctor = stk.nextToken();
                                String namePac = stk.nextToken();
                                pacientesRegistro.add(new Pacientes(id, fechaHora, motivo, nameDoctor, pacientes));
                                addCita(id + "," + fechaHora + "," + motivo + "," + nameDoctor + "," + namePac + ",");
                            }
                            break;
                    }
                } else {
                    br.close();
                    reader.close();
                    bandera = false;
                }
            }
        } catch (Exception e) {
        }
    }

    public void addDoctor(String doctor) {
        doctores = doctores.concat(doctor);
    }

    public void addPaciente(String paciente) {
        pacientes = pacientes.concat(paciente);
    }

    public void addCita(String cita) {
        citas = citas.concat(cita);
    }

    public void saveAll() {
        try {
            doctores = doctores.substring(0, doctores.length() - 1);
        } catch (Exception e) {
        }
        try {
            pacientes = pacientes.substring(0, pacientes.length() - 1);
        } catch (Exception e) {
        }
        try {
            citas = citas.substring(0, citas.length() - 1);
        } catch (Exception e) {
        }
        try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw)) {
            if (true) {
                PrintWriter pw2 = new PrintWriter(file);
                pw2.print("");
            }
            pw.println(doctores);
            pw.println(pacientes);
            pw.println(citas);
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
