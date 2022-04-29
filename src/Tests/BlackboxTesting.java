package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
     * String postive and negitave value indicators (string has '+' on front, string has '-' on front, string has neither on front)
     * String contain illegal characters (contains illegal character, does not contain illegal character)
     * String contains alpha numeric character above the radix (base) (for example if radix = 16, String cannot contain 'g's but may contain 'f's))
     */
    @Test() // Testing public BigInteger(String val, int radix)
    public void string_radix_Test() throws NumberFormatException {
        //construct a list of strings with possible combinations of their corresponding partitions
        List<String> valueLib = new ArrayList<>();
        String[] startingSymbols = {"+","-",""};
        String[] illegalSymbols = {"$",""};
        //values of different base
        String[] valuesOfDifferentBases = {"1010111000000000000000","235487390257093487500987","qp429nuv8oseeruiot943zynbnlunrht984"};
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

        //construct an array of integers of integers for boundary cases
        int[] radixLib = {1,2,10,36,37};

        //execute assertions
        for (int radix : radixLib) {
            for (String value : valueLib) {
                //whether radix is in range
                boolean radixInRange = radix > 1 && radix < 37;

                //whether special chars are present
                boolean specialCharacterPresent = Pattern.compile("[@&#$]").matcher(value).find();

                //whether or not the string starts with a sign
                boolean startsWithSign = Pattern.compile("[+-]").matcher(value).find();

                //regex for checking if alpahnumerics are larger than the radix allows
                String[] alphaNumerics = {
                        "0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f",
                        "g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v",
                        "w","x","y","z"
                };
                //[^anycharacters] => if there are any chars other than these in the matcher returns true
                String regex = "[^";
                for (int i = 0; i < radix; i++) {
                    if (i == 36)
                        break;
                    regex += alphaNumerics[i];
                }
                regex += "]";

                //whether or not the strings alphanumerics exceed the radix
                boolean stringMatchesRadix = true;
                if(startsWithSign){
                    if (Pattern.compile(regex).matcher(value.substring(1)
                                    .replace("@", "")
                                    .replace("&", "")
                                    .replace("#", "")
                                    .replace("$", ""))
                            .find()) {
                        stringMatchesRadix = false;
                    }
                } else {
                    if (Pattern.compile(regex).matcher(value
                                    .replace("@", "")
                                    .replace("&", "")
                                    .replace("#", "")
                                    .replace("$", ""))
                            .find()) {
                        stringMatchesRadix = false;
                    }
                }


                //tests


                //test for radix out of bounds
                if (!radixInRange) {
                    assertThrows(NumberFormatException.class, new Executable() {
                        @Override
                        public void execute() throws Throwable {
                            new BigInteger(value, radix);
                        }
                    });
                }


                //test special characters throw exception
                if (
                        radixInRange
                                && specialCharacterPresent
                                && stringMatchesRadix
                ) {
                    //a spec char with chars not exceeding radix
                    assertThrows(NumberFormatException.class, new Executable() {
                        @Override
                        public void execute() throws Throwable {
                            new BigInteger(value, radix);
                        }
                    });
                }


                //alphanumerics of the value exceed the base defined by radix
                //ensure no special chars are not in the middle of the value
                if (
                        radixInRange
                                && !specialCharacterPresent
                                && !stringMatchesRadix
                ) {
                    // no spec chars chars exceed radix
                    assertThrows(NumberFormatException.class, new Executable() {
                        @Override
                        public void execute() throws Throwable {
                            new BigInteger(value, radix);
                        }
                    });
                }


                //test the result of the values prepended with '+', '-' and ''
                if (
                        radixInRange
                                && !specialCharacterPresent
                                && stringMatchesRadix
                ) {
                    //no spec char chars,chars do not exceed radix
                        /*
                        use substring and multiply by neg one to evaluate that
                        the prepended symbol appropriately affects the resulting bigInteger
                        */
                    if(Pattern.compile("[+]").matcher(value).find()){
                        //+
                        try {
                            assertEquals(new BigInteger(value.substring(1), radix), new BigInteger(value, radix));
                        } catch (Exception e) {
                            //printed out anyway
                            //e.printStackTrace();
                        }

                    } else if(Pattern.compile("[-]").matcher(value).find()){
                        //-
                        assertEquals(new BigInteger(value.substring(1),radix).multiply(new BigInteger("-1")), new BigInteger(value,radix));
                    } else {
                        //no + or -
                        //equals the same as a prepended '+'
                        assertEquals(new BigInteger("+" + value,radix), new BigInteger(value,radix));
                        //equal the negative of a prepended '-'
                        assertEquals(new BigInteger("-" + value,radix), new BigInteger(value,radix).multiply(new BigInteger("-1")));
                        //should there be another way to test this partition here
                    }
                }
            }
        }
    }

    /**
     * Austin
     * public CompareTo(BigInteger val)
     * equivalence partitions
     *  BigInteger < val (output expected = -1)
     *  BigInteger == val (output expected = 0)
     *  BigInteger > val (output expected = 1)
     */
    @Test() // Testing public int compareTo(BigInteger val)
    public void compareTo_Test() {

        //Testing x < y
        BigInteger xValue = new BigInteger("100");
        BigInteger yValue = new BigInteger("1000");

        assertEquals(-1,xValue.compareTo(yValue));

        xValue = new BigInteger("-100");
        yValue = new BigInteger("1000");

        assertEquals(-1,xValue.compareTo(yValue));

        xValue = new BigInteger("-1000");
        yValue = new BigInteger("-100");

        assertEquals(-1,xValue.compareTo(yValue));

        xValue = new BigInteger("0");
        yValue = new BigInteger("1");

        assertEquals(-1,xValue.compareTo(yValue));

        xValue = new BigInteger("-1");
        yValue = new BigInteger("0");

        assertEquals(-1,xValue.compareTo(yValue));

        xValue = new BigInteger("11328409283409823143513413247869678880980419280912412345243598747239467094586703945");
        yValue = new BigInteger("12490832435987205730517057198325709132141241242144213241414141414141123414123421444");

        assertEquals(-1,xValue.compareTo(yValue));

        xValue = new BigInteger("-1132840928340982314351341324786967888098041928091246466423457678465313535578797876");
        yValue = new BigInteger("12490832435987205730517057198325709132141241242144243563456345634564364363463456335");

        assertEquals(-1,xValue.compareTo(yValue));

        xValue = new BigInteger("-1332840928340982314351341324786967888098041928091242345523523452345234523452345234");
        yValue = new BigInteger("-1249083243598720573051705719832570913214124124214422345234523453252345324525235534");

        assertEquals(-1,xValue.compareTo(yValue));


        // testing x = y
        xValue = new BigInteger("100");
        yValue = new BigInteger("100");

        assertEquals(0,xValue.compareTo(yValue));

        xValue = new BigInteger("-100");
        yValue = new BigInteger("-100");

        assertEquals(0,xValue.compareTo(yValue));

        xValue = new BigInteger("+100");
        yValue = new BigInteger("+100");

        assertEquals(0,xValue.compareTo(yValue));

        xValue = new BigInteger("0");
        yValue = new BigInteger("0");

        assertEquals(0,xValue.compareTo(yValue));

        xValue = new BigInteger("+0");
        yValue = new BigInteger("+0");

        assertEquals(0,xValue.compareTo(yValue));

        xValue = new BigInteger("-0");
        yValue = new BigInteger("-0");

        assertEquals(0,xValue.compareTo(yValue));
        xValue = new BigInteger("0");
        yValue = new BigInteger("-0");

        assertEquals(0,xValue.compareTo(yValue));
        xValue = new BigInteger("-0");
        yValue = new BigInteger("0");

        assertEquals(0,xValue.compareTo(yValue));

        xValue = new BigInteger("138946198734618239764978163429813267498126479821364981634812357234985723498674231487341981273409173587643826598243513752439850243759");
        yValue = new BigInteger("138946198734618239764978163429813267498126479821364981634812357234985723498674231487341981273409173587643826598243513752439850243759");

        assertEquals(0,xValue.compareTo(yValue));


        // testing x > y
        xValue = new BigInteger("1000");
        yValue = new BigInteger("100");

        assertEquals(1,xValue.compareTo(yValue));

        xValue = new BigInteger("-100");
        yValue = new BigInteger("-1000");

        assertEquals(1,xValue.compareTo(yValue));

        xValue = new BigInteger("1000");
        yValue = new BigInteger("-100");

        assertEquals(1,xValue.compareTo(yValue));


        xValue = new BigInteger("133284092834098231435134132478696788809804192809124");
        yValue = new BigInteger("124908324359872057305170571983257091321412412421442");

        assertEquals(1,xValue.compareTo(yValue));

        xValue = new BigInteger("113284092834098231435134132478696788809804192809124");
        yValue = new BigInteger("-124908324359872057305170571983257091321412412421442");

        assertEquals(1,xValue.compareTo(yValue));

        xValue = new BigInteger("-113284092834098231435134132478696788809804192809124");
        yValue = new BigInteger("-124908324359872057305170571983257091321412412421442");

        assertEquals(1,xValue.compareTo(yValue));

        xValue = new BigInteger("1");
        yValue = new BigInteger("0");

        assertEquals(1,xValue.compareTo(yValue));

        xValue = new BigInteger("0");
        yValue = new BigInteger("-1");

        assertEquals(1,xValue.compareTo(yValue));

    }
}






