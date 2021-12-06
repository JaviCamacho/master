/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Javi
 */
public class Login extends JFrame {

    private final JLabel bkg, tittle, user, pass;
    private final JTextField userField, passField;
    private final JButton acceptBtn;
    private final ActionListener entrar;

    public Login() {
        bkg = new JLabel();
        tittle = new JLabel("Administrador");
        user = new JLabel("Usuario:");
        pass = new JLabel("Contraseña:");
        userField = new JTextField("");
        passField = new JPasswordField("");
        acceptBtn = new JButton("Aceptar");
        entrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (userField.getText().equals("Javi") && passField.getText().equals("1234")) {
                    Interfaz mpu = new Interfaz();
                    Evidencia.interfaz = mpu;
                    getMe().dispose();
                } else {
                    System.out.println("no yeii :C");
                    JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos");
                    userField.setText("");
                    passField.setText("");
                }
            }
        };

        setTitle("Login");
        setSize(800, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        bkg.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Assets/fondo.png")).getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH)));
        bkg.setLocation(0, 0);
        bkg.setSize(800, 500);
        bkg.setVisible(true);

        tittle.setLocation(537, 25);
        tittle.setSize(250, 60);
        tittle.setFont(new Font("Courier New", 1, 25));
        tittle.setVisible(true);

        user.setLocation(505, 100);
        user.setSize(250, 25);
        user.setFont(new Font("Courier New", 1, 14));
        user.setVisible(true);

        userField.setLocation(595, 100);
        userField.setSize(150, 25);
        userField.setFont(new Font("Courier New", 1, 14));
        userField.setVisible(true);

        pass.setLocation(505, 150);
        pass.setSize(250, 25);
        pass.setFont(new Font("Courier New", 1, 14));
        pass.setVisible(true);

        passField.setLocation(595, 150);
        passField.setSize(150, 25);
        passField.setFont(new Font("Courier New", 1, 14));
        passField.addActionListener(entrar);
        passField.setVisible(true);

        acceptBtn.setLocation(535, 300);
        acceptBtn.setSize(200, 25);
        acceptBtn.setFont(new Font("System", 1, 14));
        acceptBtn.addActionListener(entrar);
        acceptBtn.setVisible(true);

        add(user);
        add(tittle);
        add(pass);
        add(userField);
        add(passField);
        add(acceptBtn);
        add(bkg);
        setVisible(true);
    }

    public Login getMe(){
        return this;
    }
    
}
