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

        // test case t1: (x = BigInteger(Integer.toString(-8)), y = BigInteger(Integer.toString(-12)))
        // x= -8 , y = -12
        // words == null , xval != 0 ,  y.words == null && xval !=Integer.MIN_VALUE && yval !=Integer.MIN_VALUE
        // xval < 0 , yval < 0
        BigInteger x = new BigInteger(Integer.toString(-8));
        BigInteger y = new BigInteger(Integer.toString(-12));

        assertEquals(new BigInteger(Integer.toString(4)),x.gcd(y));
    }

    @Test
    void gcdT2() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t2: (x = BigInteger(Integer.toString(8), y = BigInteger(Integer.toString(12)))
        // x= 8 , y = 12
        // words == null , xval != 0 ,y.words == null && xval !=Integer.MIN_VALUE && yval!=Integer.MIN_VALUE
        // xval >= 0 , yval >= 0 
        
        BigInteger x = new BigInteger(Integer.toString(8));
        BigInteger y = new BigInteger(Integer.toString(12));

        assertEquals(new BigInteger(Integer.toString(4)), x.gcd(y));

    }

    @Test
    void gcdT3() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t3: (x = BigInteger(Integer.toString(-5)), y = BigInteger(Integer.toString(25)))
        // x = -5, y = 25
        // words == null ,xval != 0,  y.words == null && xval !=Integer.MIN_VALUE &&yval!=Integer.MIN_VALUE
        // xval < 0 , yval >= 0 


        BigInteger x = new BigInteger(Integer.toString(-5));
        BigInteger y = new BigInteger(Integer.toString(25));

        assertEquals(new BigInteger(Integer.toString(5)), x.gcd(y));

    }
    
    @Test
    void gcdT4() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t4: (x = BigInteger(Integer.toString(3)), y = BigInteger(Integer.toString(-9)))
        // x = 3, y = -9
        // words == null ,xval != 0, y.words == null && xval !=Integer.MIN_VALUE&&yval!=Integer.MIN_VALUE
        // xval >= 0 , yval < 0

        BigInteger x = new BigInteger(Integer.toString(3));
        BigInteger y = new BigInteger(Integer.toString(-9));

        assertEquals(new BigInteger(Integer.toString(3)), x.gcd(y));

    }

    @Test
    void gcdT5() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t5: (x = BigInteger(Integer.toString(24), y = BigInteger(Integer.toString(-2147483648)))
        // x = 24, y = -2147483648
        // words == null ,xval != 0, !(y.words == null && xval!=Integer.MIN_VALUE&&yval!=Integer.MIN_VALUE)
        // y.words == null , yval !=0 

        BigInteger x = new BigInteger(Integer.toString(24));
        BigInteger y = new BigInteger(Integer.toString(-2147483648));


        assertEquals(new BigInteger(Integer.toString(8)), x.gcd(y));

    }

    @Test
    void gcdT6() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t6: (x = 0, y = 100)

        // words == null , xval == 0

        BigInteger x = new BigInteger(Integer.toString(0));
        BigInteger y = new BigInteger(Integer.toString(100));

        assertEquals(new BigInteger(Integer.toString(100)), x.gcd(y));

    }

    @Test
    void gcdT7() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t7: (x = -2147483648, y =0)
        // words == null ,xval != 0, !(y.words == null && xval!=Integer.MIN_VALUE&&yval!=Integer.MIN_VALUE)
        // y.words == null , yval ==0

        BigInteger x = new BigInteger(Integer.toString(-2147483648));
        BigInteger y = new BigInteger(Integer.toString(0));

        assertEquals(new BigInteger("2147483648"), x.gcd(y));

    }

    @Test
    void gcdT8() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t8: (x = BigInteger("100000000F", 16), y =BigInteger(Integer.toString(23)))
        // x= 68719476751 , y =23
        // words != null 
        // y.words == null , yval !=0

        BigInteger x = new BigInteger("100000000F", 16);       // x= 68719476751
        BigInteger y = new BigInteger(Integer.toString(23));        

        assertEquals(new BigInteger(Integer.toString(23)), x.gcd(y));

    }

    @Test
    void gcdT9() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t9: (x = BigInteger("A200000000", 16), y = BigInteger("21474836481F", 16) )
        // x= 695784701952  ,  y =36590037911583
        // words != null
        // y.words != null 

        BigInteger x = new BigInteger("A200000000", 16);        // x= 695784701952
        BigInteger y = new BigInteger("21474836481F", 16);      // y =36590037911583

        assertEquals(new BigInteger(Integer.toString(3)), x.gcd(y));

    }

    @Test
    void gcdT10() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t10: (x = BigInteger("F200000000", 16), yval =0)
        // x= 1039382085632 , y =0
        // words != null
        // y.words == null , yval == 0 

        BigInteger x = new BigInteger("F200000000", 16);        // x = 1039382085632
        BigInteger y = new BigInteger(Integer.toString(0));

        assertEquals(new BigInteger("1039382085632"), x.gcd(y));

    }

    @Test
    void gcdT11() {
        // this test method is to test public BigInteger gcd(BigInteger y)

        // test case t11: (x = BigInteger(Integer.toString(100)), y =BigInteger("21474836481F", 16))
        // x= 11583 , y =36590037911583
        // words == null , xval != 0, !(y.words == null && xval!=Integer.MIN_VALUE&&yval!=Integer.MIN_VALUE)
        // y.words != null 


        BigInteger x = new BigInteger(Integer.toString(11583));     // x= 11583
        BigInteger y = new BigInteger("36590037911583");        // y =36590037911583

        assertEquals(new BigInteger(Integer.toString(39)), x.gcd(y));

    }

    

}
