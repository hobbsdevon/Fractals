/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;


/**
 *
 * @author devonhobbs
 */
public class Simple extends JFrame {
    public static final int SIMPLE_WIDTH = 512;
    public static final int SIMPLE_HEIGHT = 512;
    public static final String SIMPLE_TITLE = "Simple";
    
    public Simple(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SIMPLE_WIDTH, SIMPLE_HEIGHT);
        this.setTitle(SIMPLE_TITLE);
        
        Container pane = this.getContentPane();
        
        SimpleBitMap panel = new SimpleBitMap();
        pane.add(panel);
        
        this.setVisible(true);
    } //Simple()
    
    public static void main(String[] args){
        Simple simple = new Simple();
    } //main(String[])
    
    
} //Simple
