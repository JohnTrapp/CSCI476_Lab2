/*
 * This code is written by John Trapp and Brendan Bellows
 * for the express purpose to be used in CSCI476 at Montana State University
 * Spring 2016. Please do not use elsewhere.
 */
package csci476_lab2;

/**
 *
 * @author John Trapp and Brendan Bellows
 */
public class Password {

    private String hashValue = null, decodedPass = null;
    private double decodeTime = 0.0;

    public Password(String hashValueInput) {
        hashValue = hashValueInput;
    }

    public String getHashValue() {
        return hashValue;
    }

    public String getDecodedPass() {
        return decodedPass;
    }

    public double getDecodeTime() {
        return decodeTime;
    }

    public void setHashValue(String hashValueInput) {
        hashValue = hashValueInput;
    }

    public void setDecodedPass(String decodedPassInput) {
        decodedPass = decodedPassInput;
    }

    public void setDecodeTime(double decodeTimeInput) {
        decodeTime = decodeTimeInput;
    }

    @Override
    public String toString() {
        String output = "The password for hash value " + hashValue + " is "
                + decodedPass + ", it took the program " + decodeTime
                + " seconds to recover this password.";
        return output;
    }
}
