/*
 * This code is written by John Trapp and Brendan Bellows
 * for the express purpose to be used in CSCI476 at Montana State University
 * Spring 2016. Please do not use elsewhere.
 */
package csci476_lab2;

import com.sun.media.sound.JavaSoundAudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author John Trapp and Brendan Bellows
 */
public class CSCI476_Lab2 {

    public static ArrayList<Password> hashList;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic
        hashList = new ArrayList<>();

        importHashValues();

        //decodeAll();
        printResults();
    }

    private static void importHashValues() {

        ////////////////////////////////////////////////////////////////////////
        //Gets the file with the hashes
        Scanner scanner = null;
        File file = null;
        final JFileChooser fc = new JFileChooser();
        JavaSoundAudioClip failSong = null;
        JavaSoundAudioClip fanfare = null;

        try {  //Try catch for loading song
            failSong = new JavaSoundAudioClip(new FileInputStream(new File("fail.wav")));
            fanfare = new JavaSoundAudioClip(new FileInputStream(new File("fanfare.wav")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The audio sound could not be loaded! "
                    + "Please put \"fail.wav\" or \"fanfare.mp3\" back where it came from.\nError: " + e,
                    null, JOptionPane.ERROR_MESSAGE);
        }

        //Loads in the file
        while (file == null) {
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

    private static void decodeAll() {
        Dictionary dictionary = new Dictionary();
        if (dictionary.importDictionary() == false) {
            System.out.println("Dictionary import failed. :(");
            System.exit(1);
        }

        //start timer
        //decode hash value
        //stop timer, add info, and repeat for all hash values
        //@todo code to decode the arrayList hashList
    }

    private static void printResults() {  //Prints everything out according to lab requirements
        for (Password hashList1 : hashList) {
            System.out.println(hashList1.toString());
        }
    }
}
