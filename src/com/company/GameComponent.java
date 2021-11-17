package com.company;

import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
//import sun.audio.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GameComponent extends JComponent implements MouseListener {//this class will implement the MouseListener because we will check if the user clicked a certain coordinate on the component.
    public BufferedImage backgroundImage; //we name three images: one for the background image, one for the blackjack logo that will be located in the center, and for the chip.
    public BufferedImage logo;
    public BufferedImage chip;
    private ArrayList<Card> dealerHand; //as usual, we have to card arraylists which will serve as hands: one for the dealer and for the player.
    private ArrayList<Card> playerHand;
    private int dealerScore; //we have two integers: one for dealer's score and the other for player's score.
    private int playerScore;
    public boolean faceDown = true; //this boolean value will tell the program if we have the card facedown or faceup.
    public static boolean betMade = false; //this boolean will tell the program if the player entered the bet.
    private int currentBalance; //this integer will store the value for the current Balance of the player.
    public static int currentBet; //this integer will store the value for the current bet.

    public GameComponent(ArrayList<Card> dH, ArrayList<Card> pH) { //this will be the constructor for this class which will accept two hands as a parameter.
        dealerHand = dH; //we initalize the instant fields.
        playerHand = pH;
        dealerScore = 0; //the scores start as 0.
        playerScore = 0;
        currentBalance = Registration.balance;
        addMouseListener(this);//we add MouseListener to the component.
    }
    public int getCurrentBalance() {
        return currentBalance;
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //we first cast Graphics g to Graphics2D g2 in order to use a more powerful brush.

        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\Hacking\\untitled3\\images\\backss.jpg")); //we read a file which is the png image of a poker table for our background image.
            chip = ImageIO.read(new File("C:\\Users\\Hacking\\untitled3\\images\\chip.png")); //we read a file which is the png image of a poker chip for the chip on the poker table.
        }
        catch(IOException e) {}

        g2.drawImage(backgroundImage, 0, 0, null); //we draw these images to the component.
        g2.drawImage(logo, 510, 200, null);
        g2.drawImage(chip, 50, 300, null);
        g2.setColor(Color.WHITE); //we set the colors.
        g2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
//        g2.drawString("DEALER", 515, 50);
//        g2.drawString("PLAYER", 515, 380);
        g2.drawString("CASINO WON: ", 50, 100);
        g2.drawString(Integer.toString(dealerScore), 300, 100);
        g2.drawString(Registration.nickname+"'s"+" WON: ", 50, 150);
        g2.drawString(Integer.toString(playerScore), 300, 150);
        g2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        g2.drawString("Для початку раунду, натисніть на фішку", 50, 250);
        g2.drawString("У вас буде можливість вибрати ставку!.", 50, 270);
        g2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g2.drawString("Ваш баланс: " + currentBalance, 50, 570);
        Calendar cal = Calendar.getInstance();          // Kaplun advised to use Calendar module!
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");    // get the date
        g2.drawString(sdf.format(cal.getTime()), 1020, 20);

        try { // card object draws images chopped off a spritesheet image from a 2D-array.
            for (int i = 0; i < dealerHand.size(); i++) {//we go through dealer's hand
                if (i == 0) { //if it is the first card,
                    if(faceDown) { //we check if will be facedown or not.
                        dealerHand.get(i).printCard(g2, true, true, i);
                        //we then draw each individual card.
                    }
                    else {
                        dealerHand.get(i).printCard(g2, true, false, i);
                        //if it is not face down, we write the 3rd parameter as false and then draw each individual card in the hand again.
                    }
                }
                else {
                    dealerHand.get(i).printCard(g2, true, false, i);
                    //if it is not the first card, we write the 3rd parameter as false and then draw each individual card in the hand again.
                }
            }
        }
        catch (IOException e) {}
        try {
            for (int i = 0; i < playerHand.size(); i++) {
                //we do the same thing for the user hand with a foor loop again: we go through each of the cards in user's hand.
                playerHand.get(i).printCard(g2, false, false, i);
                //we then draw each of the card on the component(screen). Extra information about parameters can be found in the Card class.
            }
        }
        catch (IOException e) {}
    }

    public void refresh(int cB, int uS, int dS, boolean fD) {
        //this refresh method will refresh the GameComponent when it is called.
        currentBalance = cB;
        playerScore = uS;
        dealerScore = dS;
        faceDown = fD;
        this.repaint();
    }

    public void mousePressed(MouseEvent e) {//in this void method, we will control mouse events of the user.
        int mouseX = e.getX(); //get the x and y coordinates of the user's mouse's current position.
        int mouseY = e.getY();

        if(mouseX>= 50 && mouseX<=200 && mouseY>=300 && mouseY<=450) {// do something if the x and y coordinates fall on top of the image.
            betMade = true; //if the user clicks on the chip image, then the bet is made.
            String[] options = new String[] {"1", "5", "10", "25", "100"};
            int response = JOptionPane.showOptionDialog(null, "Please enter your betting amount!", "BETTING", // dialog
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if(response == 0) {//if the user selects the first response, he selected the bet as 1.
                currentBet = 1;
                currentBalance -= 1;
            }
            else if(response == 1) {
                currentBet = 5;
                currentBalance -= 5;
            }
            else if(response == 2) {
                currentBet = 10;
                currentBalance -= 10;
            }
            else if(response == 3) {
                currentBet = 25;
                currentBalance -= 25;
            }
            else if(response == 4) {
                currentBet = 100;
                currentBalance -= 100;
            }
            else {// default value =1 , if nothins is selected
                currentBet = 1;
                currentBalance -= 1;
                System.out.println("Ви не вибрали ніяку ставку, отже граємо на 1 гривню!.");
            }
            System.out.println("Ви зробили свою ставку: " + currentBet + "." + " Якщо ви переможете, ваш поточний баланс буде:" + currentBet*2 +
                    "Якщо диллер переможе, ваш поточний баланс буде: " + currentBet + ".");
            //playChipsSettle(); // как запустить музыку????
            MAIN.newGame.startGame();
        }

    }
    //Обрабатываем события так как это класс главный и эти методы должны быть в нём описаны(инкапсуляция)
    public void mouseExited(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
    }


//    public static void playChipsSettle() {//this is a static method that plays a wav file when it is called.
//        try{
//            InputStream in = new FileInputStream("sounds/chipsSettle.wav"); //we first read the wav file.
//            AudioStream audio = new AudioStream(in); //then store it as an audio stream.
//
//            AudioPlayer.player.start(audio); //then, we basically 'play' this sound through AudioPlayer.
//        }
//        catch(IOException e) {}
//    }
}