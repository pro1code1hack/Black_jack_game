package com.company;

import javax.swing.*;
import java.awt.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Task
        extends JFrame {
    // Components of the Form
    private Container c;
    private JLabel description;
    private JLabel title;

    public  Task()
    {
        setTitle("Task");
        setBounds(300, 90, 1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);
        c = getContentPane();
        c.setLayout(null);

        JFrame rules = new JFrame();
        rules.setBounds(100, 200, 800, 800);
        rules.setTitle("Rules");
        rules.setVisible(true);
        rules.add(new JLabel(new ImageIcon("C:\\Users\\Hacking\\untitled3\\images\\task.jpg")));
        rules.pack();


    }
}
