/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Oldřich
 */
public class Hodiny implements Runnable {

    private JLabel timeDisplay = new JLabel();

    private DateFormat timeFormat;
    private Thread timer;
    volatile boolean running;

    @Override
    public void run() {
        while (running) {
            timeDisplay.setText(timeFormat.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hodiny.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        timer = null;
    }

}
