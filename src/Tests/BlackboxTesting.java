package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
/**
 * Task 1: Blackbox Testing (21 marks) Consider the following three methods in
 * BigInteger class (their API specifications are shown in Appendix):
 *      public BigInteger(int signum,byte[] magnitude)
 *      public BigInteger(String val, int radix)
 *      public int compareTo(BigInteger val)
 * 
 * For each method: 
 * 1) Design test cases using the Equivalence Partitioning
 *    technique. State clearly the equivalence classes. Clearly specify which
 *    partitions/classes are being tested, the corresponding test inputs, and the
 *    expected outputs. (15 marks)
 * 
 * 2) Write and execute the test cases in JUnit. (6 marks)
 * 
 */
public class BlackboxTesting {
    /**
     * Brandon
     * equivalence partitions
     * signum (<-1,-1,0,1,>1)
     * byte array (empty array, all elements are zero, at least one non-zero element
     * optional: bring up in meeting (resulting integer is > Integer.MAX_VALUE)
     */
    @Test()     // Testing public BigInteger(int signum,byte[] magnitude)
    public void sign_magnitude_Test() throws NumberFormatException{
        int[] signumDictionary = new int[] {-2,-1,0,1,2};
        byte[][] magnitudeDictionary = new byte[][] {
            new byte[]{

            },
            new byte[]{
                0,0,0,0,0,0
            },
            new byte[]{
                1,0,0,0,0,0
            }
        };
        //BigInteger testBigInteger = BigInteger.ZERO;
        for (int signum : signumDictionary) {
            for (byte[] magnitude : magnitudeDictionary) {
                /**
                 * if signum is outside acceptable range number 
                 * format exception is thrown
                 */
                if (signum > 1 || signum < -1)
                assertThrows(NumberFormatException.class, new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        new BigInteger(signum, magnitude);
                    }
                });
                /**
                 * if byte array is empty or filled with zero values
                 * then the result is zero regardless of sign
                 */
                if (signum < 1 && signum > -1 && magnitude != magnitudeDictionary[2]) {
                    assertEquals(BigInteger.ZERO, new BigInteger(signum, magnitude));
                }
                //testBigInteger = new BigInteger(signum, magnitude);
                /**
                 * signum is zero and byte array contains a non-zero value
                 * a number format exception will be thrown 
                 */
                if (signum == 0 && magnitude == magnitudeDictionary[2]) {
                    assertThrows(NumberFormatException.class, new Executable() {
                        @Override
                        public void execute() throws Throwable {
                            new BigInteger(signum, magnitude);
                        }
                    });
                }
                /**
                 * signum of -1 provides a negative value
                 * and signum  of 1 provides a postive value
                 */

                //create a value with the appropiate magnitude
                //byte array acts as a number counting in base 256
                //hence multiple by 256 array length - 1 times
                BigInteger magnitudeValue = BigInteger.ONE;
                for (int i = 1; i < magnitudeDictionary[2].length; i++) {
                    magnitudeValue = magnitudeValue.multiply(new BigInteger("256"));
                }
                if (signum == -1 && magnitude == magnitudeDictionary[2]) {
                    //multiply by negative one to account for sign
                    assertEquals(magnitudeValue.multiply(new BigInteger("-1")), new BigInteger(signum, magnitude));
                }
                if (signum == 1 && magnitude == magnitudeDictionary[2]) {
                    assertEquals(magnitudeValue, new BigInteger(signum, magnitude));
                }
            }
        }        
    }

    /**
     * Brandon
     */
    @Test() // Testing public BigInteger(String val, int radix)
    public void string_radix_Test() throws NumberFormatException {

    }


    @Test() // Testing public int compareTo(BigInteger val)
    public void compareTo_Test() {

    }



}
