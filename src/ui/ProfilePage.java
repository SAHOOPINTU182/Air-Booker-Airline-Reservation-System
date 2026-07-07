package ui;

import database.DBConnection;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.io.File;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProfilePage extends JFrame {

    JLabel imageLabel;

    JTextField nameField;
    JTextField usernameField;
    JTextField emailField;

    JPasswordField passwordField;

    JButton updateBtn;
    JButton chooseImageBtn;
    JButton backBtn;

    String imagePath = "";

    String loggedInUser;

    public ProfilePage(String userName){

        loggedInUser = userName;

        setTitle("AirBooker - Profile");

        setSize(1200,750);

        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(
                new Color(245,247,250));



        //================ TITLE =================

        JLabel title =
        new JLabel("My Profile");

        title.setBounds(60,30,300,40);

        title.setFont(
        new Font("Arial",
        Font.BOLD,36));

        add(title);



        //================ PROFILE IMAGE =================

        imageLabel =
        new JLabel();

        imageLabel.setBounds(80,120,180,180);

        imageLabel.setOpaque(true);

        imageLabel.setBackground(Color.WHITE);

        imageLabel.setBorder(
        new LineBorder(
        new Color(220,220,220),
        2,
        true));

        add(imageLabel);



        //================ CHOOSE IMAGE =================

        chooseImageBtn =
        new JButton("Choose Image");

        chooseImageBtn.setBounds(90,330,160,40);

        chooseImageBtn.setBackground(
        new Color(37,99,235));

        chooseImageBtn.setForeground(Color.WHITE);

        add(chooseImageBtn);



        chooseImageBtn.addActionListener(e -> {

            JFileChooser chooser =
            new JFileChooser();

            int result =
            chooser.showOpenDialog(null);

            if(result == JFileChooser.APPROVE_OPTION){

                File file =
                chooser.getSelectedFile();

                imagePath =
                file.getAbsolutePath();

                ImageIcon icon =
                new ImageIcon(imagePath);

                Image img =
                icon.getImage().getScaledInstance(
                180,
                180,
                Image.SCALE_SMOOTH);

                imageLabel.setIcon(
                new ImageIcon(img));
            }
        });




        //================ NAME =================

        JLabel nameLabel =
        new JLabel("Full Name");

        nameLabel.setBounds(400,140,150,30);

        nameLabel.setFont(
        new Font("Arial",
        Font.BOLD,20));

        add(nameLabel);


        nameField =
        new JTextField();

        nameField.setBounds(550,140,350,45);

        add(nameField);




        //================ USERNAME =================

        JLabel userLabel =
        new JLabel("Username");

        userLabel.setBounds(400,220,150,30);

        userLabel.setFont(
        new Font("Arial",
        Font.BOLD,20));

        add(userLabel);


        usernameField =
        new JTextField();

        usernameField.setBounds(550,220,350,45);

        add(usernameField);




        //================ EMAIL =================

        JLabel emailLabel =
        new JLabel("Email");

        emailLabel.setBounds(400,300,150,30);

        emailLabel.setFont(
        new Font("Arial",
        Font.BOLD,20));

        add(emailLabel);


        emailField =
        new JTextField();

        emailField.setBounds(550,300,350,45);

        add(emailField);




        //================ PASSWORD =================

        JLabel passLabel =
        new JLabel("Password");

        passLabel.setBounds(400,380,150,30);

        passLabel.setFont(
        new Font("Arial",
        Font.BOLD,20));

        add(passLabel);


        passwordField =
        new JPasswordField();

        passwordField.setBounds(550,380,350,45);

        add(passwordField);




        //================ UPDATE BUTTON =================

        updateBtn =
        new JButton("Update Profile");

        updateBtn.setBounds(550,470,180,45);

        updateBtn.setBackground(
        new Color(34,197,94));

        updateBtn.setForeground(Color.WHITE);

        updateBtn.setFont(
        new Font("Arial",
        Font.BOLD,18));

        add(updateBtn);




        //================ BACK BUTTON =================

        backBtn =
        new JButton("Back");

        backBtn.setBounds(750,470,150,45);

        backBtn.setBackground(
        new Color(239,68,68));

        backBtn.setForeground(Color.WHITE);

        backBtn.setFont(
        new Font("Arial",
        Font.BOLD,18));

        add(backBtn);




        //================ UPDATE ACTION =================

        updateBtn.addActionListener(e -> {

            try{

                Connection con =
                DBConnection.getConnection();

                String query =
                "UPDATE users SET fullname=?, username=?, email=?, password=? WHERE username=?";

                PreparedStatement pst =
                con.prepareStatement(query);

                pst.setString(1,
                nameField.getText());

                pst.setString(2,
                usernameField.getText());

                pst.setString(3,
                emailField.getText());

                pst.setString(4,
                String.valueOf(
                passwordField.getPassword()));

                pst.setString(5,
                loggedInUser);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(
                null,
                "Profile Updated Successfully");

            }

            catch(Exception ex){

                ex.printStackTrace();
            }
        });




        //================ BACK ACTION =================

        backBtn.addActionListener(e -> {

            dispose();

            new Dashboard(loggedInUser);
        });




        setVisible(true);
    }
}