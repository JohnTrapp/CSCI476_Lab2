/*
 * This code is written by John Trapp and Brendan Bellows
 * for the express purpose to be used in CSCI476 at Montana State University
 * Spring 2016. Please do not use elseware.
 */
package csci476_lab2;

import java.util.ArrayList;

/**
 *
 * @author John Trapp and Brendan Bellows
 */
public class CSCI476_Lab2 {

    public ArrayList<Password> hashList;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic
        importHashValues();

        //start timer
        decodeAll();

        //stop timer
        printResults();
    }

    private static void importHashValues() {
        //@todo code to import the hash values into hashList
    }

    private static void decodeAll() {
        //@todo code to decode the arrayList hashList
    }

    private static void printResults() {
        //@todo prints all of the necessary info to fufill lab requirements
    }
}
