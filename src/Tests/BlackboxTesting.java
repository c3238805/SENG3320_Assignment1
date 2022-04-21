package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


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
     * public BigInteger(int signum, byte[] magnitude)
     * equivalence partitions
     * signum (<-1,-1,0,1,>1)
     * byte array (empty array, all elements are zero, at least one non-zero element
     * optional: bring up in meeting (resulting integer is > Integer.MAX_VALUE)
     */
    @Test()     // Testing public BigInteger(int signum,byte[] magnitude)
    public void sign_magnitude_Test() throws NumberFormatException{
        int[] signumLib = new int[] {-2,-1,0,1,2};
        byte[][] magnitudeLib = new byte[][] {
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
        for (int signum : signumLib) {
            for (byte[] magnitude : magnitudeLib) {
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
                if (signum <= 1 && signum >= -1 && magnitude != magnitudeLib[2]) {
                    assertEquals(BigInteger.ZERO, new BigInteger(signum, magnitude));
                }
                //testBigInteger = new BigInteger(signum, magnitude);
                /**
                 * signum is zero and byte array contains a non-zero value
                 * a number format exception will be thrown 
                 */
                if (signum == 0 && magnitude == magnitudeLib[2]) {
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
                for (int i = 1; i < magnitudeLib[2].length; i++) {
                    magnitudeValue = magnitudeValue.multiply(new BigInteger("256"));
                }
                if (signum == -1 && magnitude == magnitudeLib[2]) {
                    //multiply by negative one to account for sign
                    assertEquals(magnitudeValue.multiply(new BigInteger("-1")), new BigInteger(signum, magnitude));
                }
                if (signum == 1 && magnitude == magnitudeLib[2]) {
                    assertEquals(magnitudeValue, new BigInteger(signum, magnitude));
                }
            }
        }        
    }

    /**
     * Brandon
     * public BigInteger(String value, int radix)
     * equivalence partitions
     * radix range (< 2, inside acceptable range, > 36)
     * String postive and negitave value indicators (string has '+' on front, string has '+' on front, string has neither on front)
     * String contain illegal characters (contains illegal character, contains '+' or '-' not at front, does not contain illegal character)
     * String contains alpha numeric character above the radix (base) (for example if radix = 16, String cannot contain 'g's but may contain 'f's))
     */
    @Test() // Testing public BigInteger(String val, int radix)
    public void string_radix_Test() throws NumberFormatException {
        //construct a list of strings with possible combinations of their corresponding partitions
        List<String> valueLib = new ArrayList<>();
        String[] startingSymbols = {"+","-",""};
        String[] illegalSymbols = {"@","&","#","$",""};
        //values of different base
        String[] valuesOfDifferentBases = {"1010111000000000000000","235487390257093487500987","qp429nuv8oseeruiot9438ynbnlunrht984"};
        //construct every possible scenario of value
        for (String startingSymbol : startingSymbols) {
            for (String illegalSymbol : illegalSymbols) {
                for (String valuesOfDifferentBase : valuesOfDifferentBases) {
                    valueLib.add(
                        startingSymbol + valuesOfDifferentBase.substring(0, valuesOfDifferentBase.length() / 2)
                        + illegalSymbol + valuesOfDifferentBase.substring(valuesOfDifferentBase.length() / 2)
                        );
                }
            }
        }
        
        //construct a array of integers of integers for boundary cases
        int[] radixLib = {1,2,10,36,37};
        //execute assertions
        for (int radix : radixLib) {
            for (String value : valueLib) {

                //regex for checking if alpahnumerics are larger than the radix allows
                String[] alphaNumerics = {
                    "0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f",
                    "g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v",
                    "w","x","y","z"
                };
                //[^anycharacters] => if there are any chars other than these in the matcher returns true
                String regex = "[^";
                for (int i = 0; i < radix; i++) {
                    if (radix == 37)
                        break; 
                    regex += alphaNumerics[i];
                }
                regex += "]";


                //test for radix out of bounds
                if (radix < 2 || radix > 36) {
                    assertThrows(NumberFormatException.class, new Executable() {
                        @Override
                        public void execute() throws Throwable {
                            new BigInteger(value, radix);
                        }
                    });
                }

                //test special characters throw exception
                if (radix >= 2 && radix <= 36 && Pattern.compile("[@&#$]").matcher(value).find()) {
                    boolean flag = true;
                    if(Pattern.compile("[+-]").matcher(value).find()){
                        if (Pattern.compile(regex).matcher(value.substring(1)
                        .replace("@", "")
                        .replace("&", "")
                        .replace("#", "")
                        .replace("$", ""))
                        .find()) {
                            flag = false;
                        }
                    } else {
                        if (Pattern.compile(regex).matcher(value
                        .replace("@", "")
                        .replace("&", "")
                        .replace("#", "")
                        .replace("$", ""))
                        .find()) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        //a spec char with chars not exceeding radix 
                        assertThrows(NumberFormatException.class, new Executable() {
                            @Override
                            public void execute() throws Throwable {
                                new BigInteger(value, radix);
                            }
                        });
                    }
                }
                
                //alphanumerics of the value exceed the base defined by radix
                //ensure no special chars are not in the middle of the value
                if (radix >= 2 && radix <= 36 && !Pattern.compile("[@&#$]").matcher(value).find()) {
                    boolean flag = false;
                    if(Pattern.compile("[+-]").matcher(value).find()){
                        if (Pattern.compile(regex).matcher(value.substring(1)).find()) {
                            flag = true;
                        }
                    } else {
                        if (Pattern.compile(regex).matcher(value).find()) {
                            flag = true;
                        }
                    }
                    if (flag) {
                        // no spec chars chars exceed radix
                        assertThrows(NumberFormatException.class, new Executable() {
                            @Override
                            public void execute() throws Throwable {
                                new BigInteger(value, radix);
                            }
                        });
                    }
                    
                }


                //test the result of the values prepended with '+', '-' and ''
                if (radix >= 2 && radix <= 36 && !Pattern.compile("[@&#$]").matcher(value).find()) {
                    boolean flag = true;
                    if(Pattern.compile("[+-]").matcher(value).find()){
                        if (Pattern.compile(regex).matcher(value.substring(1)).find()) {
                            flag = false;
                        }
                    } else {
                        if (Pattern.compile(regex).matcher(value).find()) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        //no spec char chars do not exceed radix
                        /*
                        use substring and multiply by neg one to evaluate that
                        the prepended symbol appropriately affects the result
                        */
                        if(Pattern.compile("[+]").matcher(value).find()){
                            assertEquals(new BigInteger(value.substring(1),radix), new BigInteger(value,radix));
                        } else if(Pattern.compile("[-]").matcher(value).find()){
                            assertEquals(new BigInteger(value.substring(1),radix).multiply(new BigInteger("-1")), new BigInteger(value,radix));
                        } else {

                        }
                    }
                }
            }
        }
        //System.out.println(Pattern.compile("[^01]").matcher("+102").find());
        System.out.println(Pattern.compile("[+-]").matcher("10").find());
    }


    @Test() // Testing public int compareTo(BigInteger val)
    public void compareTo_Test() {

    }



}
