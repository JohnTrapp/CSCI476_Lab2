/*
 * This code is written by John Trapp and Brendan Bellows
 * for the express purpose to be used in CSCI476 at Montana State University
 * Spring 2016. Please do not use elsewhere.
 */
package csci476_lab2;

import javax.swing.JFrame;
import java.awt.Image;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author john.trapp
 */
public class Driver {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 2: Dictionary Attack");
        frame.setLocation(200, 200);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CSCI476_Lab2());
        frame.setVisible(true);
        //frame.pack();
    }
}
