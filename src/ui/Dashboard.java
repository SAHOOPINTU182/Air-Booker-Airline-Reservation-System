package ui;

import javax.swing.*;

import database.DBConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ui.BookFlight;

public class Dashboard extends JFrame implements ActionListener {

    JPanel sidebarPanel;
    JTextField searchField;
    JPanel resultPanel;

    JComboBox<String> fromField;
JComboBox<String> toField;
JComboBox<String> departField;
JComboBox<String> returnField;
JComboBox<String> classBox;

    boolean showAllFlights = false;
   

    JLabel logoLabel;
    JLabel welcomeLabel;
    JLabel profileImage;

    JButton dashboardBtn;
    JButton bookFlightBtn;
    JButton myTicketsBtn;
    JButton cancelTicketBtn;
    JButton historyBtn;
    JButton logoutBtn;
    JButton profileBtn;

    String loggedInUser;

public Dashboard(String userName){

loggedInUser = userName;

        setTitle("AirBooker Dashboard");
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // ================= SIDEBAR =================

        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(null);
        sidebarPanel.setBounds(0, 0, 250, 900);
        sidebarPanel.setBackground(new Color(5, 15, 45));

        // Logo
        logoLabel = new JLabel("AirBooker");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 32));
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setBounds(30, 30, 220, 40);
        sidebarPanel.add(logoLabel);

        // Buttons
        dashboardBtn = createSidebarButton("Dashboard", 120);
        bookFlightBtn = createSidebarButton("Book Flight", 190);
        myTicketsBtn = createSidebarButton("My Tickets", 260);
        cancelTicketBtn = createSidebarButton("Cancel Ticket", 330);
        historyBtn = createSidebarButton("Booking History", 400);
       // profileBtn = createSidebarButton("Profile", 470);
        logoutBtn = createSidebarButton("Logout", 740);

        sidebarPanel.add(dashboardBtn);
        sidebarPanel.add(bookFlightBtn);
        sidebarPanel.add(myTicketsBtn);
        sidebarPanel.add(cancelTicketBtn);
        sidebarPanel.add(historyBtn);
        //sidebarPanel.add(profileBtn);
        sidebarPanel.add(logoutBtn);





        add(sidebarPanel);


    //===================== Action listner ==============================
dashboardBtn.addActionListener(this);

bookFlightBtn.addActionListener(this);

myTicketsBtn.addActionListener(this);

cancelTicketBtn.addActionListener(this);

historyBtn.addActionListener(this);
//profileBtn.addActionListener(this);

logoutBtn.addActionListener(this);




    //===================== TOP BAR ===============================

JPanel topBar = new JPanel();
topBar.setBounds(250, 0, 1250, 70);
topBar.setBackground(Color.WHITE);
topBar.setLayout(null);

add(topBar);


// SEARCH FIELD
searchField =
new JTextField(" Search flights, destinations...");
searchField.setBounds(35, 15, 530, 40);
searchField.setFont(new Font("Arial", Font.PLAIN, 16));

topBar.add(searchField);


//================ USER NAME =================

JLabel userLabel =
new JLabel(loggedInUser);

userLabel.setBounds(960,18,220,30);

userLabel.setHorizontalAlignment(
SwingConstants.RIGHT);

userLabel.setFont(
new Font("Arial",
Font.BOLD,18));

topBar.add(userLabel);



//================ PROFILE IMAGE =================

profileImage = new JLabel();

profileImage.setBounds(1200,12,45,45);
profileImage.setOpaque(true);

profileImage.setBackground(Color.WHITE);

profileImage.setBorder(
BorderFactory.createLineBorder(
new Color(220,220,220),2));

profileImage.setCursor(
new Cursor(Cursor.HAND_CURSOR));

topBar.add(profileImage);





//========== Welcome Bar ==================================
 welcomeLabel =
new JLabel(
"Welcome back, " + loggedInUser + "!");

welcomeLabel.setBounds(290,85,450,35);

welcomeLabel.setFont(
new Font("Arial", Font.BOLD, 24));
welcomeLabel.setForeground(new Color(15,23,63));

add(welcomeLabel);

//========================= Subtitle ================================ 
JLabel subLabel =new JLabel("Manage your flights and bookings.");

subLabel.setBounds(295,115,400,25);

subLabel.setFont(
new Font("Arial", Font.PLAIN, 14));
subLabel.setForeground(Color.GRAY);

add(subLabel);


//===================== Cards =============================
createCard("Total Bookings","12",290,150);
createCard("Upcoming Trips","2",500,150);
createCard("Total Spent","₹ 48,650",710,150);
createCard("Loyalty Points","1,250",920,150);



//=========================Search Panel ===============================
JPanel searchPanel =new JPanel();
searchPanel.setBounds(290,280,1150,110);
searchPanel.setBackground(new Color(8,20,60));
searchPanel.setLayout(null);
add(searchPanel);





// =========================== Sreach Title  =============================

JLabel searchTitle =new JLabel("Search Flights");
searchTitle.setBounds(25,10,220,25);
searchTitle.setForeground(Color.WHITE);
searchTitle.setFont(new Font("Arial", Font.BOLD, 20));
searchPanel.add(searchTitle);

//==============form field ====================================
String fromCities[] = {

"New Delhi (DEL)",
"Mumbai (BOM)",
"Kolkata (CCU)",
"Bangalore (BLR)"
};

fromField =
new JComboBox<>(fromCities);

fromField.setBounds(30,50,160,45);

searchPanel.add(fromField);

//========================== To field =============================

String toCities[] = {

"Mumbai (BOM)",
"New Delhi (DEL)",
"Hyderabad (HYD)",
"Chennai (MAA)"
};

toField =
new JComboBox<>(toCities);

toField.setBounds(220,50,160,45);

searchPanel.add(toField);


//=================Depart field ===============================

String departDates[] = {

"25 May 2025",
"26 May 2025",
"27 May 2025"
};

departField =
new JComboBox<>(departDates);

departField.setBounds(410,50,160,45);

searchPanel.add(departField);


//======================Return field ===============================================

String returnDates[] = {

"28 May 2025",
"29 May 2025",
"30 May 2025"
};

returnField =
new JComboBox<>(returnDates);

returnField.setBounds(600,50,160,45);

searchPanel.add(returnField);


//=====================Class Dropdown =====================

String classes[] ={"Economy", "Business"};
classBox =
new JComboBox<>(classes);
classBox.setBounds(790,50,160,45);
searchPanel.add(classBox);


//================ RESULT PANEL =================

resultPanel = new JPanel();

resultPanel.setLayout(null);

resultPanel.setBackground(Color.WHITE);

resultPanel.setPreferredSize(
new Dimension(1130,1600));



//================ SCROLL PANE =================

JScrollPane scrollPane =
new JScrollPane(resultPanel);

scrollPane.setBounds(290,400,1150,320);

scrollPane.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

scrollPane.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

scrollPane.setBorder(
BorderFactory.createLineBorder(
new Color(220,220,220),1));

add(scrollPane);

//================ AUTO SCROLL =================

Timer autoScrollTimer =
new Timer(60, null);

autoScrollTimer.addActionListener(e -> {

    JScrollBar verticalBar =
    scrollPane.getVerticalScrollBar();

    int currentValue =
    verticalBar.getValue();

    int maxValue =
    verticalBar.getMaximum()
    - verticalBar.getVisibleAmount();

    if(currentValue < maxValue){

        verticalBar.setValue(
        currentValue + 1);

    }

    else{

        verticalBar.setValue(0);
    }
});

autoScrollTimer.start();

//================ PANEL TITLE =================

JLabel recTitle =
new JLabel("Recommended Flights");

recTitle.setBounds(20,15,300,30);

recTitle.setFont(
new Font("Arial",
Font.BOLD,24));

resultPanel.add(recTitle);



//================ VIEW ALL =================

JLabel viewAll =
new JLabel("View All Flights");

viewAll.setBounds(980,20,150,20);

viewAll.setForeground(
new Color(37,99,235));

resultPanel.add(viewAll);

viewAll.setCursor(
new Cursor(Cursor.HAND_CURSOR));

viewAll.addMouseListener(
new java.awt.event.MouseAdapter(){

@Override
public void mouseClicked(
java.awt.event.MouseEvent e){

showAllFlights = true;

loadAllFlights();
}
});

loadRecommendedFlights();







//======================== Search Button =================================
JButton searchButton = new JButton("Search Flights");
searchButton.setBounds(980,50,150,45);
searchButton.setBackground(new Color(37,99,235));
searchButton.setForeground(Color.WHITE);
searchButton.setOpaque(true);

searchButton.setBorderPainted(false);

searchButton.setFocusPainted(false);
searchPanel.add(searchButton);

searchButton.addActionListener(e -> {

    searchFlights();
});

//================ IMAGE CHOOSE =================

profileImage.addMouseListener(
new java.awt.event.MouseAdapter() {

    public void mouseClicked(
    java.awt.event.MouseEvent evt) {

        FileDialog dialog =
        new FileDialog(
        Dashboard.this,
        "Select Profile Picture",
        FileDialog.LOAD);

        dialog.setDirectory(
        System.getProperty("user.home")
        + "\\Pictures");

        dialog.setVisible(true);

        String fileName =
        dialog.getFile();

        if(fileName != null){

            String fullPath =
            dialog.getDirectory()
            + fileName;

            ImageIcon icon =
            new ImageIcon(fullPath);

            Image img =
            icon.getImage().getScaledInstance(

            45,
            45,
            Image.SCALE_SMOOTH

            );

            profileImage.setIcon(
            new ImageIcon(img));
        }
    }
});






 setVisible(true);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

@Override
public void actionPerformed(ActionEvent e) {

    if (e.getSource() == dashboardBtn) {

        JOptionPane.showMessageDialog(
                this,
                "Dashboard Opened");

    }

    else if (e.getSource() == bookFlightBtn) {

         dispose();

        new BookFlight(loggedInUser);
    }

    else if (e.getSource() == myTicketsBtn) {

         dispose();

               new MyTickets(loggedInUser);

    }

    else if (e.getSource() == cancelTicketBtn) {

        
             dispose();

                new CancelTicket(loggedInUser);

    }

   else if (e.getSource() == historyBtn) {

    dispose();

   new BookingHistory(loggedInUser);

}
else if (e.getSource() == profileBtn) {

    dispose();

    new ProfilePage(loggedInUser);
}

    else if (e.getSource() == logoutBtn) {

        int option = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to logout?",
                "Logout",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {

            dispose();

            new Login();
        }
    }
}



    // Sidebar Button Method
    public JButton createSidebarButton(String text, int y) {

        JButton btn = new JButton(text);

        btn.setBounds(20, y, 200, 50);

        btn.setFont(new Font("Arial", Font.BOLD, 18));

        btn.setBackground(new Color(15, 23, 63));

        btn.setForeground(Color.WHITE);

        btn.setFocusPainted(false);

        btn.setBorderPainted(false);

        return btn;
    }

    //====================== Card Method ======================
    public void createCard(String title,String value,int x,int y){
JPanel card = new JPanel();
card.setBounds(x, y, 190, 95);
card.setBackground(Color.WHITE);
card.setLayout(null);
card.setBorder(BorderFactory.createLineBorder(new Color(230,230,230),1));
JLabel titleLabel =new JLabel(title);
titleLabel.setBounds(20,15,200,25);
titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
JLabel valueLabel =new JLabel(value);
valueLabel.setBounds(20,40,150,35);
valueLabel.setFont(new Font("Arial", Font.BOLD, 24));
valueLabel.setForeground(new Color(37,99,235));
card.add(titleLabel);
card.add(valueLabel);

    add(card);
}

public void searchFlights(){

    resultPanel.removeAll();

    int y = 70;

    try{

        Connection con =
                DBConnection.getConnection();

        String from =
                fromField.getSelectedItem().toString();

        String to =
                toField.getSelectedItem().toString();

        String depart =
                departField.getSelectedItem().toString();

        String ret =
                returnField.getSelectedItem().toString();

        String flightClass =
                classBox.getSelectedItem().toString();



        String query =
        "SELECT * FROM flights " +
        "WHERE from_city=? " +
        "AND to_city=? " +
        "AND departure_date=? " +
        "AND return_date=? " +
        "AND class_type=?";



        PreparedStatement pst =
                con.prepareStatement(query);

        pst.setString(1, from);

        pst.setString(2, to);

        pst.setString(3, depart);

        pst.setString(4, ret);

        pst.setString(5, flightClass);

        System.out.println(from);

System.out.println(to);

System.out.println(depart);

System.out.println(ret);

System.out.println(flightClass);



        ResultSet rs =
                pst.executeQuery();

        boolean found = false;



        JLabel title =
        new JLabel("Available Flights");

        title.setBounds(20,15,300,30);

        title.setFont(
        new Font("Arial",
        Font.BOLD,24));

        resultPanel.add(title);



        while(rs.next()){

            found = true;



            String statuses[] = {
            "Available",
            "Delayed",
            "Cancelled"
            };



            String randomStatus =
            statuses[
            (int)(Math.random()*3)
            ];



            JPanel card =
            createRecommendCard(

            rs.getString("airline"),

            "FL-" + rs.getInt("id"),

            rs.getString("departure_time"),

            rs.getString("arrival_time"),

            rs.getString("from_city")
            + " → " +
            rs.getString("to_city"),

            "2h 15m",

            "₹ " + rs.getString("price"),

            randomStatus,

            y
            );



            resultPanel.add(card);

            y += 60;
        }



        if(!found){

            JOptionPane.showMessageDialog(
                    null,
                    "No Flights Available");
        }



        resultPanel.repaint();

        resultPanel.revalidate();

    }

    catch(Exception e){

        e.printStackTrace();
    }
}

public JPanel createFlightResultCard(

        String airline,
        String route,
        String price,
        int y){

    JPanel card = new JPanel();

    card.setBounds(20,y,1000,70);

    card.setLayout(null);

    card.setBackground(Color.WHITE);

    card.setBorder(
            BorderFactory.createLineBorder(
                    new Color(230,230,230)));

    JLabel airlineLabel =
            new JLabel(airline);

    airlineLabel.setBounds(
            20,20,200,30);

    airlineLabel.setFont(
            new Font("Arial",
                    Font.BOLD,22));

    card.add(airlineLabel);

    JLabel routeLabel =
            new JLabel(route);

    routeLabel.setBounds(
            300,20,300,30);

    routeLabel.setFont(
            new Font("Arial",
                    Font.PLAIN,18));

    card.add(routeLabel);

    JLabel priceLabel =
            new JLabel(price);

    priceLabel.setBounds(
            700,20,150,30);

    priceLabel.setForeground(
            new Color(37,99,235));

    priceLabel.setFont(
            new Font("Arial",
                    Font.BOLD,24));

    card.add(priceLabel);

    JButton bookBtn =
            new JButton("Book Now");
            bookBtn.setBackground(
new Color(37,99,235));

bookBtn.setForeground(Color.WHITE);

bookBtn.setOpaque(true);

bookBtn.setBorderPainted(false);

bookBtn.setFocusPainted(false);

    bookBtn.setBounds(
            860,15,120,35);

    bookBtn.setBackground(
            new Color(37,99,235));

    bookBtn.setForeground(
            Color.WHITE);

    card.add(bookBtn);

    return card;
}

public JPanel createRecommendCard(

String airline,
String flightNo,
String departure,
String arrival,
String route,
String duration,
String price,
String status,
int y){

JPanel card = new JPanel();

card.setBounds(15,y,1110,70);
card.setLayout(null);

card.setBackground(Color.WHITE);

card.setBorder(
BorderFactory.createMatteBorder(
0,0,1,0,
new Color(230,230,230)));



//================ AIRLINE =================

JLabel airlineLabel =
new JLabel(airline);

airlineLabel.setBounds(20,10,120,25);

airlineLabel.setFont(
new Font("Arial",
Font.BOLD,18));

card.add(airlineLabel);



//================ FLIGHT NUMBER =================

JLabel flightLabel =
new JLabel(flightNo);

flightLabel.setBounds(20,28,100,15);

flightLabel.setForeground(Color.GRAY);

card.add(flightLabel);



//================ DEPARTURE =================

JLabel depLabel =
new JLabel(departure);

depLabel.setBounds(220,10,80,25);

depLabel.setFont(
new Font("Arial",
Font.BOLD,20));

card.add(depLabel);



//================ ARRIVAL =================

JLabel arrLabel =
new JLabel(arrival);

arrLabel.setBounds(400,10,80,25);

arrLabel.setFont(
new Font("Arial",
Font.BOLD,20));

card.add(arrLabel);



//================ ROUTE =================

JLabel routeLabel =
new JLabel(route);

routeLabel.setBounds(220,30,150,15);

routeLabel.setForeground(Color.GRAY);

card.add(routeLabel);



//================ DURATION =================

JLabel durationLabel =
new JLabel(duration);

durationLabel.setBounds(310,15,80,20);

durationLabel.setForeground(Color.GRAY);

card.add(durationLabel);



//================ PRICE =================

JLabel priceLabel =
new JLabel(price);

priceLabel.setBounds(620,12,150,25);

priceLabel.setFont(
new Font("Arial",
Font.BOLD,22));

priceLabel.setForeground(
new Color(37,99,235));

card.add(priceLabel);



//================ STATUS =================

JLabel statusLabel =
new JLabel(status);

statusLabel.setBounds(850,15,150,20);

statusLabel.setFont(
new Font("Arial",
Font.BOLD,16));

if(status.equals("Available")){

statusLabel.setForeground(
new Color(0,140,70));

}

else if(status.equals("Delayed")){

statusLabel.setForeground(
Color.ORANGE);

}

else{

statusLabel.setForeground(
Color.RED);
}

card.add(statusLabel);

//================ BOOK BUTTON =================

JButton bookBtn =
new JButton("Book Now");

bookBtn.setBounds(950,15,120,35);

bookBtn.setBackground(
new Color(37,99,235));

bookBtn.setForeground(Color.WHITE);

bookBtn.setOpaque(true);

bookBtn.setBorderPainted(false);

bookBtn.setFocusPainted(false);

bookBtn.setCursor(
new Cursor(Cursor.HAND_CURSOR));

card.add(bookBtn);

return card;
}


public void loadRecommendedFlights(){

resultPanel.removeAll();

resultPanel.repaint();

resultPanel.revalidate();

//================ TITLE =================

JLabel recTitle =
new JLabel("Recommended Flights");

recTitle.setBounds(20,15,300,30);

recTitle.setFont(
new Font("Arial",
Font.BOLD,24));

resultPanel.add(recTitle);



//================ VIEW ALL =================

JLabel viewAll =
new JLabel("View All Flights");

viewAll.setBounds(980,20,150,20);

viewAll.setForeground(
new Color(37,99,235));

viewAll.setCursor(
new Cursor(Cursor.HAND_CURSOR));

resultPanel.add(viewAll);



viewAll.addMouseListener(
new java.awt.event.MouseAdapter(){

@Override
public void mouseClicked(
java.awt.event.MouseEvent e){

showAllFlights = true;

loadAllFlights();
}
});




//================ DEFAULT 4 FLIGHTS =================

resultPanel.add(
createRecommendCard(
"IndiGo",
"6E 203",
"07:30",
"09:45",
"DEL → BOM",
"2h 15m",
"₹ 4,250",
"Available",
70
));



resultPanel.add(
createRecommendCard(
"Air India",
"AI 664",
"09:15",
"11:25",
"DEL → BOM",
"2h 10m",
"₹ 5,780",
"Delayed",
130
));



resultPanel.add(
createRecommendCard(
"SpiceJet",
"SG 812",
"12:45",
"15:05",
"DEL → BOM",
"2h 20m",
"₹ 3,890",
"Available",
190
));



resultPanel.add(
createRecommendCard(
"Vistara",
"UK 554",
"18:30",
"20:45",
"DEL → BOM",
"2h 15m",
"₹ 6,150",
"Cancelled",
250
));



resultPanel.repaint();

resultPanel.revalidate();
}


public void loadAllFlights(){

resultPanel.removeAll();


//================ TITLE =================

JLabel recTitle =
new JLabel("All Flights");

recTitle.setBounds(20,15,300,30);

recTitle.setFont(
new Font("Arial",
Font.BOLD,24));

resultPanel.add(recTitle);


int y = 70;


//================ MANY FLIGHTS =================

String flights[][] = {

{"IndiGo","6E 203","07:30","09:45","DEL → BOM","2h 15m","₹ 4,250","Available"},

{"Air India","AI 664","09:15","11:25","DEL → BOM","2h 10m","₹ 5,780","Delayed"},

{"SpiceJet","SG 812","12:45","15:05","DEL → BOM","2h 20m","₹ 3,890","Available"},

{"Vistara","UK 554","18:30","20:45","DEL → BOM","2h 15m","₹ 6,150","Cancelled"},

{"Akasa Air","QP 221","06:20","08:40","DEL → BLR","2h 20m","₹ 5,250","Available"},

{"Go First","GF 112","10:10","12:25","BOM → HYD","2h 15m","₹ 4,890","Delayed"},

{"AirAsia","I5 332","14:00","16:20","CCU → DEL","2h 20m","₹ 3,650","Available"},

{"IndiGo","6E 771","16:30","18:55","BLR → MAA","2h 25m","₹ 4,950","Available"},

{"Vistara","UK 998","19:10","21:35","DEL → GOI","2h 25m","₹ 6,850","Cancelled"},

{"SpiceJet","SG 543","22:00","00:15","BOM → DEL","2h 15m","₹ 4,450","Available"}

};



for(String flight[] : flights){

resultPanel.add(

createRecommendCard(

flight[0],
flight[1],
flight[2],
flight[3],
flight[4],
flight[5],
flight[6],
flight[7],
y
));

y += 60;
}


resultPanel.repaint();

resultPanel.revalidate();
}

    
}