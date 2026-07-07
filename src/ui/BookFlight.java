package ui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import database.DBConnection;



public class BookFlight extends JFrame {
        String loggedInUser;

JComboBox fromBox;
JComboBox toBox;

JComboBox departBox;
JComboBox returnBox;
JComboBox classBox;
JComboBox passengerBox;

JCheckBox indigo;
JCheckBox airindia;
JCheckBox vistara;
JCheckBox spicejet;

JPanel flightsPanel;

   
public BookFlight(String userName){

loggedInUser = userName;

    //====================== Frame Setting ====================
    setTitle("AirBooker - Book Flight");

setSize(1500,900);

setLocationRelativeTo(null);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setLayout(null);

getContentPane().setBackground(
        new Color(245,247,250));

//====================== lefts sidebar ================================

JPanel sidebar = new JPanel();

sidebar.setBounds(0,0,240,900);

sidebar.setBackground(new Color(4,18,52));

sidebar.setLayout(null);

add(sidebar);

// ================================ logo ====================================

JLabel logo = new JLabel("AirBooker");

logo.setBounds(25,35,200,50);

logo.setFont(new Font("Arial",Font.BOLD,32));

logo.setForeground(Color.WHITE);

sidebar.add(logo);


//================ Dashboard Button =================

JButton dashboardBtn =
        createSidebarButton("Dashboard",120);

sidebar.add(dashboardBtn);


dashboardBtn.addActionListener(e -> {

    dispose();

    new Dashboard(loggedInUser);
});



//====================== top bar ===========================================
JPanel topBar = new JPanel();

topBar.setBounds(240,0,1260,80);

topBar.setBackground(Color.WHITE);

topBar.setLayout(null);

add(topBar);

//=================================== sreach bar =================================
JTextField searchField =
        new JTextField();

searchField.setBounds(
        80,20,650,40);

searchField.setFont(
        new Font("Arial",
                Font.PLAIN,18));

searchField.setText(
        " Search flights, destinations...");

topBar.add(searchField);


// ============================user label ======================================
JLabel userLabel =
new JLabel(loggedInUser);

userLabel.setBounds(
        1080,20,200,40);

userLabel.setFont(
        new Font("Arial",
                Font.BOLD,22));

topBar.add(userLabel);

//================================= page title ====================================

JLabel title =
        new JLabel("Book Flight");

title.setBounds(
        260,90,300,30);

title.setFont(
        new Font("Arial",
                Font.BOLD,28));

title.setForeground(
        new Color(10,20,60));

add(title);

JLabel subtitle =
        new JLabel(
                "Search and book your next flight");

subtitle.setBounds(
        260,130,500,30);

subtitle.setFont(
        new Font("Arial",
                Font.PLAIN,20));

subtitle.setForeground(Color.GRAY);

add(subtitle);


//==================== SEARCH PANEL ====================

JPanel searchPanel = new JPanel();

searchPanel.setBounds(240, 170, 1220, 120);

searchPanel.setBackground(Color.WHITE);

searchPanel.setLayout(null);

searchPanel.setBorder(
        BorderFactory.createLineBorder(
                new Color(230,230,230)));

add(searchPanel);



//==================== FROM ====================

JLabel fromLabel = new JLabel("From");

fromLabel.setBounds(25,15,100,20);

fromLabel.setFont(
        new Font("Arial",Font.BOLD,14));

searchPanel.add(fromLabel);


String fromCities[] = {
    "New Delhi (DEL)",
    "Mumbai (BOM)",
    "Kolkata (CCU)",
    "Bangalore (BLR)"
};

fromBox =
        new JComboBox(fromCities);

fromBox.setBounds(25,45,150,40);

fromBox.setFont(
        new Font("Arial",Font.PLAIN,16));

searchPanel.add(fromBox);




//==================== TO ====================

JLabel toLabel = new JLabel("To");

toLabel.setBounds(230,15,100,20);

toLabel.setFont(
        new Font("Arial",Font.BOLD,14));

searchPanel.add(toLabel);


String toCities[] = {
    "Mumbai (BOM)",
    "New Delhi (DEL)",
    "Hyderabad (HYD)",
    "Chennai (MAA)"
};

toBox =
        new JComboBox(toCities);

toBox.setBounds(200,45,150,40);

toBox.setFont(
        new Font("Arial",Font.PLAIN,16));

searchPanel.add(toBox);




//==================== DEPARTURE ====================

JLabel departLabel =
        new JLabel("Departure");

departLabel.setBounds(435,15,100,20);

departLabel.setFont(
        new Font("Arial",Font.BOLD,14));

searchPanel.add(departLabel);


String departDates[] = {
    "25 May 2025",
    "26 May 2025",
    "27 May 2025"
};

departBox =
        new JComboBox(departDates);

departBox.setBounds(375,45,140,40);

departBox.setFont(
        new Font("Arial",Font.PLAIN,16));

searchPanel.add(departBox);




//==================== RETURN ====================

JLabel returnLabel =
        new JLabel("Return");

returnLabel.setBounds(610,15,100,20);

returnLabel.setFont(
        new Font("Arial",Font.BOLD,14));

searchPanel.add(returnLabel);


String returnDates[] = {
    "28 May 2025",
    "29 May 2025",
    "30 May 2025"
};

returnBox =
        new JComboBox(returnDates);

returnBox.setBounds(545,45,140,40);

returnBox.setFont(
        new Font("Arial",Font.PLAIN,16));

searchPanel.add(returnBox);




//==================== CLASS ====================

JLabel classLabel =
        new JLabel("Class");

classLabel.setBounds(785,15,100,20);

classLabel.setFont(
        new Font("Arial",Font.BOLD,14));

searchPanel.add(classLabel);


String classType[] = {
    "Economy",
    "Business",
    "First Class"
};

classBox =
        new JComboBox(classType);

classBox.setBounds(715,45,130,40);

classBox.setFont(
        new Font("Arial",Font.PLAIN,16));

searchPanel.add(classBox);




//==================== PASSENGERS ====================

JLabel passengerLabel =
        new JLabel("Passengers");

passengerLabel.setBounds(960,15,100,20);

passengerLabel.setFont(
        new Font("Arial",Font.BOLD,14));

searchPanel.add(passengerLabel);


String passengers[] = {
    "1 Adult",
    "2 Adults",
    "3 Adults",
    "4 Adults"
};

passengerBox =
        new JComboBox(passengers);

passengerBox.setBounds(875,45,130,40);

passengerBox.setFont(
        new Font("Arial",Font.PLAIN,16));

searchPanel.add(passengerBox);




//==================== SEARCH BUTTON ====================

JButton searchBtn =
        new JButton("Search Flights");

searchBtn.setBounds(1030,45,160,40);

searchBtn.setFont(
        new Font("Arial",Font.BOLD,20));

searchBtn.setBackground(
        new Color(37,99,235));

searchBtn.setForeground(Color.WHITE);

searchBtn.setFocusPainted(false);

searchBtn.setBorderPainted(false);

searchBtn.setCursor(
        new Cursor(Cursor.HAND_CURSOR));

searchPanel.add(searchBtn);




//================ SEARCH BUTTON ACTION =================

searchBtn.addActionListener(e -> {

    loadFlights();

});




//==============================filter panel =================================
JPanel filterPanel =
        new JPanel();

filterPanel.setBounds(
        250,360,220,500);

filterPanel.setBackground(Color.WHITE);

filterPanel.setLayout(null);

add(filterPanel);

JLabel filterTitle =
        new JLabel("Filter Flights");

filterTitle.setBounds(
        20,20,180,30);

filterTitle.setFont(
        new Font("Arial",
                Font.BOLD,24));

filterPanel.add(filterTitle);


//==================== Flights Panel ====================

flightsPanel = new JPanel();

flightsPanel.setBounds(500,360,900,500);

flightsPanel.setBackground(
        new Color(245,247,250));

flightsPanel.setLayout(null);

add(flightsPanel);





//============================filter checkbox ===============================

indigo =
        new JCheckBox("IndiGo");

indigo.setBounds(
        20,80,150,30);

filterPanel.add(indigo);

airindia =
        new JCheckBox("Air India");

airindia.setBounds(
        20,120,150,30);

filterPanel.add(airindia);

vistara =
        new JCheckBox("Vistara");

vistara.setBounds(
        20,160,150,30);

filterPanel.add(vistara);

spicejet =
        new JCheckBox("SpiceJet");

spicejet.setBounds(
        20,200,150,30);

filterPanel.add(spicejet);







    setVisible(true);

    }

    //================ LOAD FLIGHTS ====================

public void loadFlights(){

    flightsPanel.removeAll();

    String source =
            fromBox.getSelectedItem().toString();

    String destination =
            toBox.getSelectedItem().toString();

     String departure =
        departBox.getSelectedItem().toString();

String returnDate =
        returnBox.getSelectedItem().toString();

String flightClass =
        classBox.getSelectedItem().toString();

String passengers =
        passengerBox.getSelectedItem().toString();

    int y = 20;

    try{

        Connection con =
                DBConnection.getConnection();


        String query =
                "SELECT * FROM flights " +
                "WHERE from_city=? " +
                "AND to_city=? " +
                "AND departure_date=? " +
                "AND return_date=? " +
                "AND class_type=? " +
                "AND passengers=?";

        //================ AIRLINE FILTER =================

if(indigo.isSelected()){

    query += " AND airline='IndiGo'";
}

if(airindia.isSelected()){

    query += " AND airline='Air India'";
}

if(vistara.isSelected()){

    query += " AND airline='Vistara'";
}

if(spicejet.isSelected()){

    query += " AND airline='SpiceJet'";
}



PreparedStatement pst =
                con.prepareStatement(query);

       pst.setString(1, source);

        pst.setString(2, destination);

        pst.setString(3, departure);

        pst.setString(4, returnDate);

        pst.setString(5, flightClass);

        pst.setString(6, passengers);

        ResultSet rs = pst.executeQuery();


       boolean found = false;

while(rs.next()){

    found = true;

    JPanel card =
            createFlightCard(

                    rs.getString("airline"),

                    rs.getString("departure_time")
                    + " - " +
                    rs.getString("arrival_time"),

                    "₹ " + rs.getString("price"),

                    y
            );

    flightsPanel.add(card);

    y += 130;
}


if(!found){

    JOptionPane.showMessageDialog(
            null,
            "No Flights Found");
}

        flightsPanel.repaint();

        flightsPanel.revalidate();

    }

    catch(Exception e){

        JOptionPane.showMessageDialog(
                null,
                e);
    }
}






    //======================== filter card method =======================
public JPanel createFlightCard(
        String airline,
        String time,
        String price,
        int y){

    JPanel card = new JPanel();

    card.setBounds(20,y,760,100);

    card.setBackground(Color.WHITE);

    card.setLayout(null);

    card.setBorder(
            BorderFactory.createLineBorder(
                    new Color(230,230,230)));

    JLabel airlineLabel =
            new JLabel(airline);

    airlineLabel.setBounds(
            20,20,150,30);

    airlineLabel.setFont(
            new Font("Arial",
                    Font.BOLD,24));

    card.add(airlineLabel);

    JLabel timeLabel =
            new JLabel(time);

    timeLabel.setBounds(
            250,20,250,30);

    timeLabel.setFont(
            new Font("Arial",
                    Font.BOLD,28));

    card.add(timeLabel);

    JLabel priceLabel =
            new JLabel(price);

    priceLabel.setBounds(
        500,20,180,30);

    priceLabel.setForeground(
            new Color(37,99,235));

    priceLabel.setFont(
            new Font("Arial",
                    Font.BOLD,30));

    card.add(priceLabel);

    JButton bookBtn =
            new JButton("Book Now");

   bookBtn.setBounds(
        630,25,110,40);

    bookBtn.setBackground(
            new Color(37,99,235));

    bookBtn.setForeground(Color.WHITE);

    bookBtn.setFocusPainted(false);

    card.add(bookBtn);

bookBtn.addActionListener(e -> {

    try{

        Connection con =
        DBConnection.getConnection();

        String query =
"INSERT INTO bookings " +
"(airline, from_city, to_city, departure_time, arrival_time, price, status) " +
"VALUES (?,?,?,?,?,?,?)";



        PreparedStatement pst =
        con.prepareStatement(query);



        pst.setString(1, airline);

        pst.setString(2,
        fromBox.getSelectedItem().toString());

        pst.setString(3,
        toBox.getSelectedItem().toString());



        pst.setString(4,
        time.split("-")[0].trim());

        pst.setString(5,
        time.split("-")[1].trim());



        pst.setString(6,
        price.replace("₹","").trim());

        pst.setString(7, "Active");



        pst.executeUpdate();



        JOptionPane.showMessageDialog(
        null,
        "Booking Successful");



       

    }

    catch(Exception ex){

        ex.printStackTrace();
    }
});





    return card;

}


    // =========================== sidebar button ==================================
public JButton createSidebarButton(
        String text,int y){

    JButton btn = new JButton(text);

    btn.setBounds(20,y,190,50);

    btn.setFont(
            new Font("Arial",
                    Font.BOLD,20));

    btn.setBackground(
            new Color(15,25,70));

    btn.setForeground(Color.WHITE);

    btn.setFocusPainted(false);

    btn.setBorderPainted(false);

    btn.setCursor(
            new Cursor(Cursor.HAND_CURSOR));

    return btn;
}


}