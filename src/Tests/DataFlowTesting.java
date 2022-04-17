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
    void gcdT1() {
        // below test method is to test public BigInteger gcd(BigInteger y)

        // test case t1: (xval = -8, yval = -12)

        BigInteger x = new BigInteger("-8");
        BigInteger y = new BigInteger("-12" );

        assertEquals(new BigInteger("4"),x.gcd(y));
    }

    @Test
    void gcdT2() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t1: (xval = 1, yval = 0)
        BigInteger x = new BigInteger("1");
        BigInteger y = new BigInteger("0");

        assertEquals(new BigInteger("1"), x.gcd(y));

    }

    @Test
    void gcdT3() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t1: (xval = -2, yval = 0)
        BigInteger x = new BigInteger("-2");
        BigInteger y = new BigInteger("0");

        assertEquals(new BigInteger("2"), x.gcd(y));

    }
    
    @Test
    void gcdT4() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t4: (xval = 3, yval = -9)
        BigInteger x = new BigInteger("-3");
        BigInteger y = new BigInteger("-9");

        assertEquals(new BigInteger("3"), x.gcd(y));

    }

    @Test
    void gcdT5() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t5: (xval = Integer.MIN_VALUE, yval = 0)
        
        BigInteger x = new BigInteger("-21474836481");
        BigInteger y = new BigInteger("0");

        assertEquals(new BigInteger("21474836481"), x.gcd(y));

    }

    @Test
    void gcdT6() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t6: (xval = 100, yval = 0)

        BigInteger x = new BigInteger("100");
        BigInteger y = new BigInteger("0");

        assertEquals(new BigInteger("100"), x.gcd(y));

    }

    @Test
    void gcdT7() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t7: (xval = 2386, yval = 21474836481F)

        BigInteger x = new BigInteger("2386");
        BigInteger y = new BigInteger("21474836481F", 16);

        System.out.println(y);
        assertEquals(new BigInteger("1"), x.gcd(y));

    }

}
