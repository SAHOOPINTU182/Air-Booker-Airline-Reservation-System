package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel subtitleLabel;

    JLabel emailLabel;
    JLabel passwordLabel;

    JTextField emailField;
    JPasswordField passwordField;

    JButton loginButton;
    JButton registerButton;

    JPanel panel;

    public Login() {

        setTitle("AirBooker - Login");
        setSize(1250, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Main Panel
        panel = new JPanel();
        panel.setLayout(null);

        // Background Color
        panel.setBackground(new Color(245,247,250));

        // ================  pannel add =======================
        JPanel leftPanel = new JPanel();

    leftPanel.setBounds(0, 0, 430, 750);

    leftPanel.setBackground(new Color(0,51,153));

    leftPanel.setLayout(null);

    panel.add(leftPanel);


    //=================== plane image ===============================
    ImageIcon planeIcon =
        new ImageIcon("src/images/plane.png");

Image planeImage =
        planeIcon.getImage().getScaledInstance(
                300,
                180,
                Image.SCALE_SMOOTH);

JLabel planeLabel =
        new JLabel(new ImageIcon(planeImage));

planeLabel.setBounds(40, 120, 300, 180);

leftPanel.add(planeLabel);


   // ========================= city image ===========================
                ImageIcon cityIcon =
        new ImageIcon("src/images/city.png");

Image cityImage =
        cityIcon.getImage().getScaledInstance(
                430,
                160,
                Image.SCALE_SMOOTH);

JLabel cityLabel =
        new JLabel(new ImageIcon(cityImage));

cityLabel.setBounds(0, 560, 430, 160);

leftPanel.add(cityLabel);


//============================ Airbooker logo ===================

JLabel logoLabel = new JLabel("AirBooker");

logoLabel.setBounds(35, 250, 400, 70);

logoLabel.setFont(
        new Font("Arial", Font.BOLD, 60));

logoLabel.setForeground(Color.WHITE);

leftPanel.add(logoLabel);


//============================= welcome title ==========================


JLabel welcomeLabel =
new JLabel("Welcome Back!");

welcomeLabel.setBounds(650, 90, 500, 60);

welcomeLabel.setFont(
new Font("Arial", Font.BOLD, 52));

welcomeLabel.setForeground(
new Color(15,23,63));

panel.add(welcomeLabel);


//===============  small text ========================================
JLabel smallText =
new JLabel(
"Please login to your account");

smallText.setBounds(650, 155, 500, 30);

smallText.setFont(
new Font("Arial", Font.PLAIN, 24));

smallText.setForeground(Color.GRAY);

panel.add(smallText);



//================================= Email lable + field ===========================
emailLabel = new JLabel("Email");

emailLabel.setFont(
new Font("Arial", Font.BOLD, 22));

emailLabel.setBounds(520, 300, 180, 40);

panel.add(emailLabel);


emailField = new JTextField();

emailField.setBounds(720, 300, 430, 50);

emailField.setFont(
new Font("Arial", Font.PLAIN, 18));

emailField.setBorder(
new LineBorder(
new Color(220,220,220),
2,
true));

panel.add(emailField);

//===============================password field ============================

passwordLabel = new JLabel("Password");

passwordLabel.setFont(
new Font("Arial", Font.BOLD, 22));

passwordLabel.setBounds(520, 420, 180, 40);

panel.add(passwordLabel);


passwordField = new JPasswordField();

passwordField.setBounds(720, 420, 430, 50);

passwordField.setFont(
new Font("Arial", Font.PLAIN, 18));

passwordField.setBorder(
new LineBorder(
new Color(220,220,220),
2,
true));

panel.add(passwordField);


//================================= login button ==========================
loginButton = new JButton("Login");

loginButton.setBounds(970, 540, 180, 50);



loginButton.setBackground(new Color(34,197,94));


loginButton.setForeground(Color.WHITE);

loginButton.setFont(
new Font("Arial", Font.BOLD, 22));

loginButton.setFocusPainted(false);

loginButton.setBorderPainted(false);
loginButton.addActionListener(this);
panel.add(loginButton);

//========================= register ======================
registerButton = new JButton("Register");
registerButton.setBounds(720, 540, 180, 50);


registerButton.setBackground(
    new Color(37,99,235));


registerButton.setForeground(Color.WHITE);

registerButton.setFont(
new Font("Arial", Font.BOLD, 22));

registerButton.setFocusPainted(false);

registerButton.setBorderPainted(false);
registerButton.addActionListener(this);

panel.add(registerButton);






        add(panel);

        setVisible(true);
    }
@Override
public void actionPerformed(ActionEvent e) {

    // Register Button
    if (e.getSource() == registerButton) {

        dispose();

        new Register();
    }

    // Login Button
    else if (e.getSource() == loginButton) {

        String email =
        emailField.getText();

        String password =
        String.valueOf(
        passwordField.getPassword());

        try {

            Connection conn =
            DBConnection.getConnection();

            String query =
            "SELECT * FROM users " +
            "WHERE email=? AND password=?";

            PreparedStatement pst =
            conn.prepareStatement(query);

            pst.setString(1, email);

            pst.setString(2, password);

            ResultSet rs =
pst.executeQuery();

if (rs.next()) {

    System.out.println("LOGIN SUCCESS");

    JOptionPane.showMessageDialog(
    this,
    "Login Successful");

    String userName =
    rs.getString("fullname");
    dispose();

    new Dashboard(userName);
}

            

            else {

                JOptionPane.showMessageDialog(
                this,
                "Invalid Email or Password");
            }

        }

        catch (Exception ex) {

            ex.printStackTrace();
        }
    }

}

}



