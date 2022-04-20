package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataFlowTesting_compareTo {
    
    @Test
    void compareTo_test1() {
        // below test method is to test static int compareTo(BigInteger x, BigInteger y)

        
        BigInteger x = new BigInteger("2147483649");
        BigInteger y = new BigInteger("2147483648");

        assertEquals(1, x.compareTo(y));
    }

    @Test
    void compareTo_test2() {
        // below test method is to test static int compareTo(BigInteger x, BigInteger y)

        BigInteger x = new BigInteger("-2147483649");
        BigInteger y = new BigInteger("2147483648");

        assertEquals(-1, x.compareTo(y));
    }

    @Test
    void compareTo_test3() {
        // below test method is to test static int compareTo(BigInteger x, BigInteger y)

        BigInteger x = new BigInteger("88888");
        BigInteger y = new BigInteger("2147483648");

        assertEquals(-1, x.compareTo(y));
    }

    @Test
    void compareTo_test4() {
        // below test method is to test static int compareTo(BigInteger x, BigInteger y)

        BigInteger x = new BigInteger("2147483648");
        BigInteger y = new BigInteger("2147483648");

        assertEquals(0, x.compareTo(y));
    }
    
}
