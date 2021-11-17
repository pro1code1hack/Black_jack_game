package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ranks extends JFrame
{
    public Ranks()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("Правила");
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Hacking\\untitled3\\images\\rules.jpg")));
        setLayout(new FlowLayout());
        setSize(786,392);
    }
} 