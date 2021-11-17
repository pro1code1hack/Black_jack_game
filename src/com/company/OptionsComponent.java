package com.company;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
//import sun.audio.*;

public class OptionsComponent extends JComponent implements ActionListener{

    private JButton btnPlay = new JButton("Грати"); //we initialize 4 buttons for the menu component, which will open up first in our game.
    private JButton btnExit = new JButton("Вихід");
    private JButton btnAuthor = new JButton("ME");
    private JButton btnTask = new JButton("TASK");
    private static BufferedImage backgroundImage; //we initialize an image which will serve as the background image.

    public OptionsComponent() { //in the default constructor of this class,
        btnPlay.addActionListener(this); //we add action listeners to all buttons to control what will happen when the user clicks them.
        btnExit.addActionListener(this);
        btnAuthor.addActionListener(this);
        btnTask.addActionListener(this);
    }

    public void paintComponent(Graphics g) {//we will decorate the component with this method.

        Graphics2D g2 = (Graphics2D) g; //we first cast Graphics g to Graphics2D g2 in order to use a more powerful brush.

        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\Hacking\\untitled3\\images\\back.jpg")); //we read a file which is the png image of a poker table for our background image.
        }
        catch(IOException e) {}

        g2.drawImage(backgroundImage, 0, 0, null); //we draw the background image to the component.

        g2.setFont(new Font("Comic Sans MS", Font.BOLD, 100)); //In these codes, we will add the title of our game and its font and color.
        g2.setColor(new Color(26, 165, 255));
        g2.drawString("BLACKJACK!", 290, 260);
        g2.setColor(new Color(196, 160, 59, 255));    // Посоветоваться с Каплун
        g2.setFont(new Font("Arial", Font.BOLD, 30));
        g2.drawString("Вас вітає 'Казино у Єгора'! Бажаєте зіграти?", 220, 580 ); //Here, we add a small description to the component.
        btnPlay.setBounds(500, 300, 150, 80); //we set the bounds of the buttons.
        btnExit.setBounds(500, 400, 150, 80);
        btnAuthor.setBounds(80, 75, 150, 80);
        btnTask.setBounds(900, 75, 150, 80);

        btnPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 40)); //we set the fonts of writings on the buttons.
        btnExit.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        btnAuthor.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        btnTask.setFont(new Font("Comic Sans MS", Font.BOLD, 35));

        super.add(btnPlay); //super refers to the JComponent. Thus, with these codes, we add the four buttons to the component.
        super.add(btnExit);
        super.add(btnAuthor);
        super.add(btnTask);
    }

    public void actionPerformed(ActionEvent e) {//we will control the button actions here.
        JButton selectedButton = (JButton)e.getSource();//we will assign the clicked button which created an action event to the JButton selectedButton. It is the selected button.

        if(selectedButton == btnExit) { //if the selected button is the exit button (btnExit), we will exit the game.
            System.exit(0); //this line is to exit the program.
        }
        else if(selectedButton == btnPlay) {//if the selected button is the play button (btnPlay), we start the game.
            MAIN.currentState = MAIN.STATE.GAME; //
            // we equalize the current state to STATE.GAME where STATE was the enum declared in the Tester class.
            // Because we will no longer be in the menu, we will jump to the game.
            MAIN.menuFrame.dispose(); //we first get rid of the menu frame and the components it has.
            MAIN.gameRefreshThread.start(); //then, simultaneously, we start our two threads and these run at the same time.
            MAIN.gameCheckThread.start();
        }
        else if(selectedButton == btnAuthor) {
                    Author author = new Author();
                    //JOptionPane.INFORMATION_MESSAGE);
        }
        else if(selectedButton == btnTask) {
            Task task = new Task();     // get the class with a picture of Task
            DRW drw = new DRW();
        }
    }
}