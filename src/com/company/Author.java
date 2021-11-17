package com.company;
import javax.swing.*;
import java.awt.*;

public class Author extends JFrame {
    Author(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Author");
        this.setLayout(new BorderLayout());
        //this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Hacking\\untitled3\\images\\rules.jpg")));
        this.setLayout(new FlowLayout());
        this.setBounds(500,100,600,350);
       //this.paint_oval(Graphics gr);
        this.setResizable(true);

//        //this.setBounds(5);
//        this.setVisible(true);
//        this.setResizable(false);


    }
    //Author
//    public void paint_oval(Graphics gr){
//
//     ;
//    }

        public void paint (Graphics gr)
        {
            Image im = Toolkit.getDefaultToolkit().getImage("images\\m_f.jpg");
            gr.drawImage(im,0,0,250,300,this);


            gr.setColor(Color.ORANGE);
            gr.setFont(new Font("Arial",Font.ITALIC + Font.BOLD,24));
            gr.drawString("Дремлюга Є.С",300, 50);
            gr.drawString("1БС-20Б.",300, 70);
            gr.setFont(new Font("Arial",Font.ITALIC + Font.BOLD,22));
            gr.drawString("Спеціальність Кібербезпека" ,250, 105);
            gr.drawString("Telegram: @proguitarist",250, 140);
           // gr.setColor(Color.getHSBColor(255, 255, 255));
            gr.setColor(Color.cyan);
            gr.setFont(new Font("Arial",Font.ITALIC + Font.BOLD,16));
            gr.draw3DRect(300,200,100,100,false);
            gr.setColor(Color.ORANGE);
            //gr.drawLine(600,300,100,100);
            gr.setColor(Color.pink);
            gr.drawOval(300,200,100,100);
            gr.setColor(new Color(255,200,35));
            gr.setColor(new Color(0.5F,0.7F,0.3F));
            gr.setColor(new Color(0xFF0000));
        }
}
