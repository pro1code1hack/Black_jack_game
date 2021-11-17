// Java program to implement
// a Simple Registration Form
// using Java Swing
package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.util.GregorianCalendar;

// Конструктор що створює на основі поточну дату -

class Registration
        extends JFrame
        implements ActionListener {

    public static String nickname;
    public static int balance;
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JRadioButton one_hund;
    private JRadioButton two_hund;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel prefs;
    private JTextArea tpref;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private JLabel password;
    private JTextField tpassword;
    private ButtonGroup bets;
    private JLabel lbets;
    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };


    public Registration()
    {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Nickname");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(100, 150);
        c.add(password);                    // mno

        JPasswordField tpassword = new JPasswordField(12);
        tpassword.setEchoChar('*');
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(190, 20);
        tpassword.setLocation(200, 150);
        c.add(tpassword);


        lbets = new JLabel("Bets");
        lbets.setFont(new Font("Arial", Font.PLAIN, 20));
        lbets.setSize(100, 20);
        lbets.setLocation(100, 200);
        c.add(lbets);

        one_hund = new JRadioButton("100$");
        one_hund.setFont(new Font("Arial", Font.PLAIN, 15));
        one_hund.setSelected(true);
        one_hund.setSize(75, 20);
        one_hund.setLocation(200, 200);
        c.add(one_hund);

        two_hund = new JRadioButton("200$");
        two_hund.setFont(new Font("Arial", Font.PLAIN, 15));
        two_hund.setSelected(false);
        two_hund.setSize(80, 20);
        two_hund.setLocation(275, 200);
        c.add(two_hund);

        bets = new ButtonGroup();
        bets.add(one_hund);
        bets.add(two_hund);

        dob = new JLabel("DOB");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 250);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 250);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 250);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 250);
        c.add(year);

        prefs = new JLabel("Pref-ces");
        prefs.setFont(new Font("Arial", Font.PLAIN, 20));
        prefs.setSize(100, 20);
        prefs.setLocation(100, 300);
        c.add(prefs);

        tpref = new JTextArea();
        tpref.setFont(new Font("Arial", Font.PLAIN, 15));
        tpref.setSize(200, 75);
        tpref.setLocation(200, 300);
        tpref.setLineWrap(true);
        c.add(tpref);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea("Завдання: Реалізувати гру blackjack (21)");
        tout.setFont(new Font("Comic Sans", Font.PLAIN, 18));
        tout.setSize(350, 400);
        tout.setLocation(500, 95);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        nickname = tname.getText();
        LocalDate current_date = LocalDate.now();
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String data1;
                String data
                        = "Name : "
                        + tname.getText() + "\n";
                if (one_hund.isSelected()) {
                    balance = 1000;
                    data1 = "Bets : You decided to play on one 1000 dollars,get ready!"
                            + '\n';
                }
                else
                {
                    balance = 2000;
                    data1 = "Bets : You decided to play on 2000 dollars,get ready!"
                            + '\n';
                    System.out.println(balance);
                }
                Date d1 = new Date();
                String result = (String)year.getSelectedItem();
                //System.out.println(result);
                int res_year = Integer.parseInt(result.trim());
                if (2021-res_year < 18)
                {System.out.println("Vhod restricted");
                    JOptionPane.showMessageDialog(c, "Вам заборонено грати в наше казино! Підростайте!"); //we print out the message by getting our current balance from the Tester class.
                    System.exit(1);

                }
                    // вывести диалоговое окно
                else {
                String data2
                        = "DOB : "
                        + (String)date.getSelectedItem()
                        + "/" + (String)month.getSelectedItem()
                        + "/" + (String)year.getSelectedItem()
                        + "\n";

                //

                String data3 = "Entrance to the casino is allowed: " + tpref.getText();
                String resss = data + data1 + data2 + data3;
                tout.setText(resss);
                tout.setEditable(false);
                res.setText("Registration Successfully..");
                }
                try(FileWriter writer = new FileWriter("notes3.txt", false))
                {
                    // запись всей строки
                    String text = String.valueOf(nickname);
                    writer.write(text);
                    writer.flush();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
//                dispose();
//               try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException interruptedException) {
//                    interruptedException.printStackTrace();
//                }
//                dispose();

            }
            else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }

        }

        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tpref.setText(def);
            //tpassword.setText("");
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
           // date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            resadd.setText(def);
        }
    }
}


