package com.company;
import java.awt.*;

public class DRW extends Canvas {
    public void paint(Graphics gr){

        gr.setColor(Color.red);
        gr.setFont(new Font("Arial",Font.ITALIC + Font.BOLD,16));
        gr.draw3DRect(10,10,100,100,false);
        gr.setColor(Color.ORANGE);
        gr.drawLine(10,10,100,100);
        gr.setColor(Color.pink);
        gr.drawOval(10,125,100,100);
        gr.setColor(new Color(255,200,35));
        gr.setColor(new Color(0.5F,0.7F,0.3F));
        gr.setColor(new Color(0xFF0000));
        gr.drawString("Реалізувати гру Blackjack",120, 35);
    }
}