/*
 * This code is written by John Trapp and Brendan Bellows
 * for the express purpose to be used in CSCI476 at Montana State University
 * Spring 2016. Please do not use elsewhere.
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

        decodeAll();
        
        printResults();
    }

    private static void importHashValues() {
        //@todo code to import the hash values into hashList
    }

    private static void decodeAll() {
        Dictionary dictionary = new Dictionary();
        if (dictionary.importDictionary() == false){
            System.out.println("Dictionary import failed. :(");
            System.exit(1);
        }
        
        //start timer
        
        //decode hash value
        
        //stop timer, add info, and repeat for all hash values
        
        //@todo code to decode the arrayList hashList
    }

    private static void printResults() {
        //@todo prints all of the necessary info to fufill lab requirements
    }
}
