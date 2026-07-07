package ui;

import database.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MyTickets extends JFrame {

    String loggedInUser;

    JPanel panel;

   public MyTickets(String userName){

loggedInUser = userName;

        setTitle("My Tickets");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(null);

        getContentPane().setBackground(
                new Color(245,247,250));



        //================ SIDEBAR =================

        JPanel sidebar = new JPanel();

        sidebar.setBounds(0,0,280,900);

        sidebar.setBackground(
                new Color(0,15,70));

        sidebar.setLayout(null);

        add(sidebar);



        JLabel logo =
        new JLabel("AirBooker");

        logo.setBounds(30,40,220,50);

        logo.setForeground(Color.WHITE);

        logo.setFont(
        new Font("Arial",
        Font.BOLD,34));

        sidebar.add(logo);



        JButton dashboardBtn =
        new JButton("Dashboard");

        dashboardBtn.setBounds(25,160,220,55);

        dashboardBtn.setBackground(
        new Color(15,25,90));

        dashboardBtn.setForeground(Color.WHITE);

        dashboardBtn.setFont(
        new Font("Arial",
        Font.BOLD,18));

        dashboardBtn.setFocusPainted(false);

        sidebar.add(dashboardBtn);



        dashboardBtn.addActionListener(e -> {

            dispose();

           new Dashboard(loggedInUser);

        });



        //================ TITLE =================

        JLabel title =
        new JLabel("My Tickets");

        title.setBounds(650,40,400,50);

        title.setFont(
        new Font("Arial",
        Font.BOLD,40));

        add(title);

        JLabel nameLabel =
new JLabel(loggedInUser);

nameLabel.setBounds(1230,40,250,40);

nameLabel.setFont(
new Font("Arial",
Font.BOLD,26));

add(nameLabel);



        //================ MAIN PANEL =================

        panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(Color.WHITE);



        JScrollPane scrollPane =
        new JScrollPane(panel);

        scrollPane.setHorizontalScrollBarPolicy(
ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

scrollPane.setVerticalScrollBarPolicy(
ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);



        scrollPane.setBounds(320,130,1180,700);

        add(scrollPane);



        loadTickets();

        setVisible(true);
    }



    public void loadTickets(){

        try{

            Connection con =
            DBConnection.getConnection();

            String query =
"SELECT * FROM bookings " +
"WHERE status='Active' " +
"ORDER BY id DESC";

            PreparedStatement pst =
            con.prepareStatement(query);

            ResultSet rs =
            pst.executeQuery();

            int y = 20;

            while(rs.next()){

                JPanel card =
                new JPanel();

                card.setBounds(20,y,1120,110);

                card.setLayout(null);

                card.setBackground(Color.WHITE);

                card.setBorder(
                BorderFactory.createLineBorder(
                new Color(220,220,220)));



                //================ AIRLINE =================

                JLabel airline =
                new JLabel(
                rs.getString("airline"));

                airline.setBounds(25,30,180,40);

                airline.setFont(
                new Font("Arial",
                Font.BOLD,32));

                card.add(airline);



                //================ ROUTE =================

                JLabel route =
                new JLabel(

                rs.getString("from_city")

                + " → " +

                rs.getString("to_city"));

                route.setBounds(260,35,350,35);

                route.setFont(
                new Font("Arial",
                Font.PLAIN,28));

                card.add(route);



                //================ TIME =================

                JLabel timing =
                new JLabel(

                rs.getString("departure_time")

                + " - " +

                rs.getString("arrival_time"));

                timing.setBounds(650,35,220,35);

                timing.setFont(
                new Font("Arial",
                Font.BOLD,28));

                card.add(timing);



                //================ PRICE =================

                JLabel price =
                new JLabel(

                "₹ " +

                rs.getString("price"));

                price.setBounds(930,35,180,35);

                price.setForeground(
                new Color(37,99,235));

                price.setFont(
                new Font("Arial",
                Font.BOLD,30));

                card.add(price);



                panel.add(card);

                y += 130;
            }



            panel.setPreferredSize(
            new Dimension(1100,y+50));



            panel.repaint();

            panel.revalidate();
        }

        catch(Exception e){

            e.printStackTrace();
        }
    }
}