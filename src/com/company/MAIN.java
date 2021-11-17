package com.company;
import javax.sound.sampled.*;
import javax.swing.JFrame;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;

/*

План на консультацию
1) Спросить у Каплун за многопоточность, я то её реализовал , но вопрос как она работает в плане ядер
2) Добавить регистрацию к программе, и там где сам класс Game сделать так, чтобы выводилось на
экран имя игрока при выиграше,проиграше
3) Спросить за анимацию раздачи карт (рассказать за стак оверфлоу и как они парсятся с файла) похвастаться :)
4) Возможно добавить отключение звука , показать А.В проект
5) Показать курсовую
6) Попросить помощи сделать красивое главное меню , подобрать цвет

 */


public class MAIN {

    public static JFrame menuFrame = new JFrame(); // basic options like 'Play' and 'Exit'.
    public static JFrame gameFrame = new JFrame(); // game will be played.

    private static int playerScore = 0;
    private static int dealerScore = 0;
    public static int currentBalance = 1000;

       //

    public static Game newGame = new Game(gameFrame); //we initialize a 'Game' in order to control, start, and calculate the blackjack game.

    Registration reg = new Registration();
    private static boolean isFirstTime = true; // value will check if the game is newly started

    public static enum STATE{
        //This enum represents the state of the game which is either menu or game.
        // While it is menu, we will show the user the menu. While it is game, we will show the user the game.
        MENU,
        GAME
    };

    public static STATE currentState = STATE.MENU; //the first state is the MENU state.


    public static void main(String[] args) throws InterruptedException {
        if(currentState == STATE.MENU) {
            openMenu(); //we open the menu by a static method.
            Registration registration = new Registration();
            Sound.playSound("C:\\Users\\Hacking\\untitled3\\sounds\\mihail-krug_-_vladimirskiy-central.wav");

            // Начинает играть михаил круг когда кликается кнопка старта
        }
    }

    public static void openMenu() { //this method literally opens the menu.
        menuFrame.setTitle("BLACKJACK!"); //we set the frame title to 'BLACKJACK!'
        menuFrame.setSize(1130, 665);
        menuFrame.setLocationRelativeTo(null); //we position the frame to the center.
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setResizable(false); //we make it impossible for the user to resize the frame.
        OptionsComponent beginningComponent = new OptionsComponent();
        //we initialize an OptionsComponent which is the JComponent that contains the properties (buttons, titles, etc.) of the menu.
        menuFrame.add(beginningComponent); //We add this component to the frame.
        menuFrame.setVisible(true); //we make the frame visible.
    }

    public static Thread gameRefreshThread = new Thread () {
        //this first thread (each thread must have a run method) serves to continuously [since we put true inside the while loop, it will continue forever.] refresh the component.
        public void run () {
            while(true){
                newGame.atmosphereComponent.refresh(currentBalance, playerScore, dealerScore-1, newGame.faceDown); //this line calls the refresh method of the GameComponent atmosphere component which is declared inside the Game class. This method updates the score and balance values.
                //the reason why we put the parameter dealerscore-1 is because dealerscore starts as 1 in our game.
            }
        }
    };

    public static Thread gameCheckThread = new Thread () { //the second thread continually[while(true)] checks the game for a round over situation.
        public void run () {
            while(true) {
                if (isFirstTime||newGame.roundOver) {//if this is the first t me the game is started or the round is over (which was thanks to the checkHand method in Game),
                    System.out.println("Lets refresh the game!");
                    if (newGame.dealerWon){//if dealer won the game,
                        dealerScore++; //we add one to the score of dealer.
                        currentBalance-= GameComponent.currentBet; //we also subtract the bet from the current balance.
                    }
                    else {//if dealer didn't win, then the user won.
                        playerScore++; //we add one to the score of player.
                        currentBalance+= GameComponent.currentBet*2; //we add two times the bet to the current balance.
                    }
                    gameFrame.getContentPane().removeAll(); //we remove everything from the frame.
                    newGame = new Game(gameFrame); //we initialize a new game on the same frame.
                    newGame.formGame(); //we set the atmosphere of the game(which is everything except the cards.)
                    isFirstTime = false;
                    //once this thread worked, the game can't be opening for the first time (because it already did before this thread executed) after this so we set this boolean value to false.
                }
            }
        }
    };
}