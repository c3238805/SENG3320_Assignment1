package Tests;

import org.junit.jupiter.api.Test;
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
    @Test()     // Testing public BigInteger(int signum,byte[] magnitude)
    public void sign_magnitude_Test() throws NumberFormatException{
        

        
    }  
    
    @Test() // Testing public BigInteger(String val, int radix)
    public void string_radix_Test() throws NumberFormatException {

    }


    @Test() // Testing public int compareTo(BigInteger val)
    public void compareTo_Test() {

    }



}
