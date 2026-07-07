
package ui;

import database.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import ui.Dashboard;

public class BookingHistory extends JFrame {
    String loggedInUser;

    JPanel panel;

   public BookingHistory(String userName){

loggedInUser = userName;

        setTitle("Booking History");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(null);

        //================ SIDEBAR =================

JPanel sidebar = new JPanel();

sidebar.setBounds(0,0,260,900);

sidebar.setBackground(
new Color(2,18,71));

sidebar.setLayout(null);

add(sidebar);



//================ LOGO =================

JLabel logo =
new JLabel("AirBooker");

logo.setBounds(20,40,220,50);

logo.setForeground(Color.WHITE);

logo.setFont(
new Font("Arial",
Font.BOLD,32));

sidebar.add(logo);



//================ DASHBOARD BUTTON =================

JButton dashboardBtn =
new JButton("Dashboard");

dashboardBtn.setBounds(25,150,200,50);

dashboardBtn.setBackground(
new Color(15,23,75));

dashboardBtn.setForeground(Color.WHITE);

dashboardBtn.setFont(
new Font("Arial",
Font.BOLD,20));

dashboardBtn.setFocusPainted(false);

sidebar.add(dashboardBtn);



dashboardBtn.addActionListener(e -> {

    dispose();

    new Dashboard(loggedInUser);

});




        getContentPane().setBackground(
                new Color(245,247,250));



        JLabel title =
        new JLabel("Booking History");

        title.setBounds(650,40,500,50);

        title.setFont(
        new Font("Arial",
        Font.BOLD,32));

        add(title);
        JLabel nameLabel =
new JLabel(loggedInUser);

nameLabel.setBounds(1250,40,250,40);

nameLabel.setFont(
new Font("Arial",
Font.BOLD,26));

add(nameLabel);

     



        panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(Color.WHITE);



        JScrollPane scrollPane =
        new JScrollPane(panel);

        scrollPane.setHorizontalScrollBarPolicy(
ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

scrollPane.setVerticalScrollBarPolicy(
ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);



       scrollPane.setBounds(300,130,1200,700);

        add(scrollPane);



        loadBookings();

        setVisible(true);
    }



    public void loadBookings(){

        try{

            Connection con =
            DBConnection.getConnection();

            String query =
            "SELECT * FROM bookings " +
            "ORDER BY id DESC";

            PreparedStatement pst =
            con.prepareStatement(query);

            ResultSet rs =
            pst.executeQuery();

            int y = 20;

            while(rs.next()){

                JPanel card =
                new JPanel();

               card.setBounds(20,y,1100,100);

                card.setLayout(null);

                card.setBackground(Color.WHITE);

                card.setBorder(
                BorderFactory.createLineBorder(
                new Color(220,220,220)));



                JLabel airline =
                new JLabel(
                rs.getString("airline"));

                airline.setBounds(20,20,200,50);

                airline.setFont(
                new Font("Arial",
                Font.BOLD,28));

                card.add(airline);



                JLabel route =
                new JLabel(

                rs.getString("from_city")
                + " → " +

                rs.getString("to_city"));

                route.setBounds(200,20,420,50);

                route.setFont(
                new Font("Arial",
                Font.PLAIN,24));

                card.add(route);



                JLabel timing =
                new JLabel(

                rs.getString("departure_time")

                + " - " +

                rs.getString("arrival_time"));

                timing.setBounds(600,20,220,50);

                timing.setFont(
                new Font("Arial",
                Font.BOLD,24));

                card.add(timing);



                JLabel price =
                new JLabel(

                "₹ " +
                rs.getString("price"));

                price.setBounds(800,20,150,50);

                price.setForeground(
                new Color(37,99,235));

                price.setFont(
                new Font("Arial",
                Font.BOLD,24));

                card.add(price);





                panel.add(card);

                y += 110;
            }



panel.setPreferredSize(
new Dimension(1450,y+50));



            panel.repaint();

            panel.revalidate();
        }

        catch(Exception e){

            e.printStackTrace();
        }
    }
}