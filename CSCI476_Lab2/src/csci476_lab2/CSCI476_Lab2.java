/*
 * This code is written by John Trapp and Brendan Bellows
 * for the express purpose to be used in CSCI476 at Montana State University
 * Spring 2016. Please do not use elsewhere.
 */
package csci476_lab2;

import com.sun.media.sound.JavaSoundAudioClip;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author John Trapp and Brendan Bellows
 */
public class CSCI476_Lab2 extends JPanel {

    public JTextArea textArea;
    public JButton importHash, importDictionary, start;
    public static ArrayList<Password> hashList;

    public CSCI476_Lab2() {
        //Where the GUI is loaded
        GridBagLayout gridBag = new GridBagLayout(); //Oh GridBag, how I hate/love you...
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridBag);

        textArea = new JTextArea(20, 30);  //The new output area
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setTabSize(3);
        textArea.setEditable(false);

        start = new JButton("Start");  //The start button
        start.setEnabled(false);
        start.addActionListener(new startListener());

        importDictionary = new JButton("Import Dictionary");  //The import dictionary button
        importDictionary.setEnabled(false);
        importDictionary.addActionListener(new dictionaryListener());

        importHash = new JButton("Import Hash Values");  //The import hash values button
        importHash.addActionListener(new hashListener());

        c.gridx = 0;  //GridBag constraints. Ugg...
        c.gridy = 0;  //Top-left please!
        c.ipady = 5;  //Some Nice padding.
        c.insets = new Insets(0, 0, 5, 5);  //Add some padding (Top,left,bottom,right)
        add(importHash, c);

        c.gridx = 1;  //Go over one spot
        c.gridy = 0;  //Stay in the same row
        add(importDictionary, c);

        c.gridx = 2;  //Go over another spot
        c.gridy = 0;  //Stay in the same row
        c.insets = new Insets(0, 0, 5, 0);  //Change padding
        add(start, c);

        c.gridx = 0;  //Go back to the first spot
        c.gridy = 1;  //Go down one row
        c.gridwidth = 3;  //Strech that out all the way!
        c.insets = new Insets(0, 0, 0, 0);
        add(scrollPane, c);

        //This has to be here for some reason. Don't worry about it.
        hashList = new ArrayList<>();
    }

    private static void importHashValues() {

        ////////////////////////////////////////////////////////////////////////
        //Gets the file with the hashes
        Scanner scanner = null;
        File file = null;
        final JFileChooser fc = new JFileChooser();
        JavaSoundAudioClip failSong = null;  //Goof-around code.
        JavaSoundAudioClip fanfare = null;

        try {  //Try catch for loading song
            failSong = new JavaSoundAudioClip(new FileInputStream(new File("fail.wav")));
            fanfare = new JavaSoundAudioClip(new FileInputStream(new File("fanfare.wav")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The audio sound could not be loaded! "
                    + "Please put \"fail.wav\" or \"fanfare.mp3\" back where it came from.\nError: " + e,
                    null, JOptionPane.ERROR_MESSAGE);
        }

        while (file == null) {  //Loads in the file
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
            } else {
                failSong.play();
                JOptionPane.showMessageDialog(null, "You didn't choose a file!"
                        + "\n*Sad trombone music*\n", null, JOptionPane.ERROR_MESSAGE);
            }
        }
        
        try {  //Try catch for the file
            scanner = new Scanner(file);
            fanfare.play();
            JOptionPane.showMessageDialog(null, "File load successful!");
        } catch (Exception e) {
            failSong.play();
            JOptionPane.showMessageDialog(null, "The scanner for importHashValues()"
                    + " could not find the file.\nError: " + e, null, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        ////////////////////////////////////////////////////////////////////////

        while (scanner.hasNext()) {  //Imports the hash values into the arrayList
            hashList.add(new Password(scanner.nextLine()));
        }
    }

    private static void decodeAll() {  //Decodes the hash values
        for (Password hashList1 : hashList) {
            long startTime = System.currentTimeMillis();  //Start timing

            //decode happens here
            //hashList1.setDecodedPass();
            long endTime = System.currentTimeMillis();  //Stop timing
            long totalTime = (endTime - startTime) / 1000;  //Figure that out in seconds
            hashList1.setDecodeTime(totalTime);  //Set the decode time
        }
    }

    private void printResults() {  //Prints everything out according to lab requirements
        for (Password hashList1 : hashList) {
            textArea.append(hashList1.toString() + "\n");
        }
    }

    private class startListener implements ActionListener {

        public startListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            decodeAll();
            printResults();
        }
    }

    private class dictionaryListener implements ActionListener {

        public dictionaryListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Dictionary dictionary = new Dictionary();
            if (dictionary.importDictionary() == false) {  //checks to see if the import worked
                textArea.append("Dictionary import failed. :(\n");
            } else {
                start.setEnabled(true);
                importDictionary.setEnabled(false);  //To avoid breakage
            }
        }
    }

    private class hashListener implements ActionListener {

        public hashListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            importHashValues();
            
            importDictionary.setEnabled(true);     
            importHash.setEnabled(false);
        }
    }
}
