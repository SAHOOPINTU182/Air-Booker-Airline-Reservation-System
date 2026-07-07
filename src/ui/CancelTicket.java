package ui;

import database.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class CancelTicket extends JFrame {

    String loggedInUser;

    JPanel panel;

   public CancelTicket(String userName){

loggedInUser = userName;

        setTitle("Cancel Ticket");

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
        new JLabel("Cancel Ticket");

        title.setBounds(620,40,400,50);

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



                int bookingId =
                rs.getInt("id");



                //================ AIRLINE =================

                JLabel airline =
                new JLabel(
                rs.getString("airline"));

                airline.setBounds(25,30,180,40);

                airline.setFont(
                new Font("Arial",
                Font.BOLD,30));

                card.add(airline);



                //================ ROUTE =================

                JLabel route =
                new JLabel(

                rs.getString("from_city")

                + " → " +

                rs.getString("to_city"));

                route.setBounds(220,35,350,35);

                route.setFont(
                new Font("Arial",
                Font.PLAIN,24));

                card.add(route);



                //================ TIME =================

                JLabel timing =
                new JLabel(

                rs.getString("departure_time")

                + " - " +

                rs.getString("arrival_time"));

                timing.setBounds(550,35,220,35);

                timing.setFont(
                new Font("Arial",
                Font.BOLD,24));

                card.add(timing);



                //================ PRICE =================

                JLabel price =
                new JLabel(

                "₹ " +

                rs.getString("price"));

                price.setBounds(770,35,150,35);

                price.setForeground(
                new Color(37,99,235));

                price.setFont(
                new Font("Arial",
                Font.BOLD,24));

                card.add(price);



                //================ CANCEL BUTTON =================

                JButton cancelBtn =
                new JButton("Cancel");

                cancelBtn.setBounds(920,30,120,45);

                cancelBtn.setBackground(Color.RED);

                cancelBtn.setForeground(Color.WHITE);

                cancelBtn.setFont(
                new Font("Arial",
                Font.BOLD,18));

                cancelBtn.setFocusPainted(false);

                card.add(cancelBtn);



                cancelBtn.addActionListener(e -> {

                    try{

                        Connection deleteCon =
                        DBConnection.getConnection();

                        String deleteQuery =
                        "UPDATE bookings " +
                        "SET status='Cancelled' " +
                        "WHERE id=?";

                        PreparedStatement pstDelete =
                        deleteCon.prepareStatement(deleteQuery);

                        pstDelete.setInt(1, bookingId);

                        pstDelete.executeUpdate();



                        JOptionPane.showMessageDialog(
                        null,
                        "Ticket Cancelled Successfully");



                        panel.remove(card);



                        Component[] components =
                        panel.getComponents();

                        int newY = 20;

                        for(Component comp : components){

                            comp.setBounds(
                            20,
                            newY,
                            1120,
                            110);

                            newY += 130;
                        }



                        panel.setPreferredSize(
                        new Dimension(1100,newY+50));



                        panel.repaint();

                        panel.revalidate();
                    }

                    catch(Exception ex){

                        ex.printStackTrace();
                    }
                });



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