package ui;

import javax.swing.*;
import java.awt.*;
import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.border.*;
import java.sql.ResultSet;
import java.awt.geom.RoundRectangle2D;

public class Register extends JFrame implements ActionListener 
{

    JLabel titleLabel;
    JLabel subtitleLabel;
    JLabel alreadyAccountLabel;
    JLabel loginTextLabel;

    JLabel fullNameLabel;
    JLabel usernameLabel;
    JLabel emailLabel;
    JLabel passwordLabel;

    JTextField fullNameField;
    JTextField usernameField;
    JTextField emailField;

    JPasswordField passwordField;

    JButton registerButton;
    JButton loginButton;
    JButton clearButton;

    JPanel panel;

    public Register() {

        setTitle("AirBooker - Register");
        setSize(1250, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Main Panel
        panel = new JPanel();
        panel.setLayout(null);

        //================ LEFT PANEL =================

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 430, 750);
        leftPanel.setBackground(new Color(0,51,153));
        leftPanel.setLayout(null);
        panel.add(leftPanel);

        //================= Plane Image ===========================
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

        //==================== city image ============================
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



        // Professional Dark Background
        panel.setBackground(new Color(245,247,250));

        // Title
        JLabel logoLabel = new JLabel("AirBooker");
        logoLabel.setBounds(35, 250, 400, 70);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 60));
        logoLabel.setForeground(Color.WHITE);
        leftPanel.add(logoLabel);
        
        // Subtitle
        JLabel logoSub =new JLabel("");
        logoSub.setBounds(40, 325, 400, 35);
        logoSub.setForeground(Color.WHITE);
        logoSub.setFont(new Font("Arial", Font.PLAIN, 24));
        leftPanel.add(logoSub);


        //Right title
       
        JLabel welcomeLabel =
        new JLabel("Welcome Back!");

        welcomeLabel.setBounds(620, 70, 500, 60);

        welcomeLabel.setFont(
        new Font("Arial", Font.BOLD, 52));

        welcomeLabel.setForeground(
        new Color(15,23,63));

        panel.add(welcomeLabel);
        
        //small text 
        
        JLabel smallText =
        new JLabel(
        "Please login or create a new account");

        smallText.setBounds(620, 135, 500, 30);

        smallText.setFont(
        new Font("Arial", Font.PLAIN, 24));

        smallText.setForeground(Color.GRAY);

        panel.add(smallText);


//====================== LABEL COLOR ======================

Color labelColor = new Color(40,40,40);

//====================== FULL NAME ======================

fullNameLabel = new JLabel("Full Name");

fullNameLabel.setFont(
        new Font("Arial", Font.BOLD, 22));

fullNameLabel.setForeground(labelColor);

fullNameLabel.setBounds(500, 230, 180, 40);

panel.add(fullNameLabel);


fullNameField = new JTextField();

fullNameField.setBounds(700, 230, 430, 50);

fullNameField.setFont(
        new Font("Arial", Font.PLAIN, 18));

fullNameField.setBackground(Color.WHITE);

fullNameField.setForeground(Color.BLACK);

fullNameField.setCaretColor(Color.BLACK);

fullNameField.setBorder(
        new LineBorder(
                new Color(220,220,220),
                2,
                true));

panel.add(fullNameField);


//====================== USERNAME ======================

usernameLabel = new JLabel("Username");

usernameLabel.setFont(
        new Font("Arial", Font.BOLD, 22));

usernameLabel.setForeground(labelColor);

usernameLabel.setBounds(500, 320, 180, 40);

panel.add(usernameLabel);


usernameField = new JTextField();

usernameField.setBounds(700, 320, 430, 50);

usernameField.setFont(
        new Font("Arial", Font.PLAIN, 18));

usernameField.setBackground(Color.WHITE);

usernameField.setForeground(Color.BLACK);

usernameField.setCaretColor(Color.BLACK);

usernameField.setBorder(
        new LineBorder(
                new Color(220,220,220),
                2,
                true));

panel.add(usernameField);


//====================== EMAIL ======================

emailLabel = new JLabel("Email");

emailLabel.setFont(
        new Font("Arial", Font.BOLD, 22));

emailLabel.setForeground(labelColor);

emailLabel.setBounds(500, 410, 180, 40);

panel.add(emailLabel);


emailField = new JTextField();

emailField.setBounds(700, 410, 430, 50);

emailField.setFont(
        new Font("Arial", Font.PLAIN, 18));

emailField.setBackground(Color.WHITE);

emailField.setForeground(Color.BLACK);

emailField.setCaretColor(Color.BLACK);

emailField.setBorder(
        new LineBorder(
                new Color(220,220,220),
                2,
                true));

panel.add(emailField);


//====================== PASSWORD ======================

passwordLabel = new JLabel("Password");

passwordLabel.setFont(
        new Font("Arial", Font.BOLD, 22));

passwordLabel.setForeground(labelColor);

passwordLabel.setBounds(500, 500, 180, 40);

panel.add(passwordLabel);


passwordField = new JPasswordField();

passwordField.setBounds(700, 500, 430, 50);

passwordField.setFont(
        new Font("Arial", Font.PLAIN, 18));

passwordField.setBackground(Color.WHITE);

passwordField.setForeground(Color.BLACK);

passwordField.setCaretColor(Color.BLACK);

passwordField.setBorder(
        new LineBorder(
                new Color(220,220,220),
                2,
                true));

panel.add(passwordField);



       //====================== REGISTER BUTTON ======================

registerButton = new JButton("Regisater");

registerButton.setBounds(930, 590, 170, 50);


registerButton.setFont(
        new Font("Arial", Font.BOLD, 22));

registerButton.setBackground(new Color(34,197,94));

registerButton.setForeground(Color.WHITE);

registerButton.setFocusPainted(false);

registerButton.setBorderPainted(false);

registerButton.setCursor(
        new Cursor(Cursor.HAND_CURSOR));

registerButton.addActionListener(this);

panel.add(registerButton);


//====================== CLEAR BUTTON ======================

clearButton = new JButton("Clear");

clearButton.setBounds(730, 590, 170, 50);
clearButton.setFont(
        new Font("Arial", Font.BOLD, 22));

clearButton.setBackground(new Color(37,99,235));

clearButton.setForeground(Color.WHITE);

clearButton.setFocusPainted(false);

clearButton.setBorderPainted(false);

clearButton.setCursor(
        new Cursor(Cursor.HAND_CURSOR));

clearButton.addActionListener(this);

panel.add(clearButton);
        

//====================== LOGIN TEXT ======================

alreadyAccountLabel =
new JLabel("Already have an account?");

alreadyAccountLabel.setFont(
        new Font("Arial", Font.PLAIN, 18));

alreadyAccountLabel.setForeground(Color.GRAY);

alreadyAccountLabel.setBounds(760, 660, 230, 30);

panel.add(alreadyAccountLabel);


//====================== LOGIN LINK ======================

loginTextLabel = new JLabel("Login");

loginTextLabel.setFont(
        new Font("Arial", Font.BOLD, 18));

loginTextLabel.setForeground(
        new Color(37,99,235));

loginTextLabel.setCursor(
        new Cursor(Cursor.HAND_CURSOR));
loginTextLabel.setBounds(995, 660, 80, 30);

panel.add(loginTextLabel);


loginTextLabel.addMouseListener(
    new java.awt.event.MouseAdapter() {

        @Override
        public void mouseClicked(
                java.awt.event.MouseEvent evt) {

            dispose();

            new Login();
        }
    });

add(panel);

setVisible(true);
    
}

@Override
public void actionPerformed(ActionEvent e) {

    // ================= REGISTER =================

    if (e.getSource() == registerButton) {

        String fullname = fullNameField.getText();

        String username = usernameField.getText();

        String email = emailField.getText();
        
        
        // Email Validation

        String emailPattern ="^[A-Za-z0-9+_.-]+@(.+)$";

            if (!Pattern.matches(emailPattern, email)) {

                JOptionPane.showMessageDialog(this,
            "Invalid Email Format",
            "Email Error",
                JOptionPane.ERROR_MESSAGE);

                return;
            }

        String password =
                String.valueOf(passwordField.getPassword());

        try {

            Connection conn =
                    DBConnection.getConnection();

            //================ CHECK EMAIL =================

String checkQuery =
"SELECT * FROM users WHERE email=?";

PreparedStatement checkPst =
conn.prepareStatement(checkQuery);

checkPst.setString(1, email);

ResultSet rs =
checkPst.executeQuery();

if(rs.next()){

    JOptionPane.showMessageDialog(
            this,
            "User already exists with this email!");

    return;
}

//================ INSERT USER =================

String query =
"INSERT INTO users(fullname, username, email, password) VALUES (?, ?, ?, ?)";

PreparedStatement pst =
conn.prepareStatement(query);

pst.setString(1, fullname);

pst.setString(2, username);

pst.setString(3, email);

pst.setString(4, password);

int rows = pst.executeUpdate();

           if (rows > 0) {

                JOptionPane.showMessageDialog(this,
            "Registered Successfully");

            dispose();

            new Login();

        }else {

                JOptionPane.showMessageDialog(this,
                        "Registration Failed");
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    // ================= CLEAR =================

    if (e.getSource() == clearButton) {

        fullNameField.setText("");

        usernameField.setText("");

        emailField.setText("");

        passwordField.setText("");

        JOptionPane.showMessageDialog(this,
                "All Fields Cleared");
    }

  

    
}

}
