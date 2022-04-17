package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * 
 * Task 3: White-box Testing: Data Flow Testing (18 marks) Consider the
 * following two methods in BigInteger class (their source code is shown in
 * Appendix):
 *      public BigInteger gcd(BigInteger y) 
 *      private static int compareTo(BigInteger x, BigInteger y)  (Note that this is a private method, you can test it through the public method public int compareTo(BigInteger val), which only calls this method)
 * 
 * For each method: 
 * 1) Identify all the definition-use pairs (du-pairs) (5 marks) 
 * 2) Design test cases to achieve All-Defs coverage (4 marks) 
 * 3) Design test cases to achieve All-Uses coverage (6 marks) 
 * 4) Write and execute the test cases in JUnit. (3 marks)
 * 
 * 
 */
public class DataFlowTesting {
    @Test
    void gcdTest() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        
        BigInteger x = new BigInteger("1");
        BigInteger y = new BigInteger("1" );
        BigInteger result = x.add(y);

        assertEquals(2,x.gcd);



    }
}
