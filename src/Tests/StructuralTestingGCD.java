import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StructuralTestingGCD {

    @Test
    void GCDTest1()
    {
        BigInteger xValue = new BigInteger("0");
        BigInteger yValue = new BigInteger("0");

        BigInteger expectedResult = new BigInteger("0");

        assertEquals(expectedResult,xValue.gcd(yValue));
    }

    @Test
    void GCDTest2()
    {
        BigInteger xValue = new BigInteger("-1");
        BigInteger yValue = new BigInteger("-1");

        BigInteger expectedResult = new BigInteger("1");

        assertEquals(expectedResult,xValue.gcd(yValue));
    }

    @Test
    void GCDTest3()
    {
        BigInteger xValue = new BigInteger("1");
        BigInteger yValue = new BigInteger(String.valueOf(Integer.MIN_VALUE));

        BigInteger expectedResult = new BigInteger("1");

        assertEquals(expectedResult,xValue.gcd(yValue));
    }

    @Test
    void GCDTest4()
    {
        BigInteger xValue = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        BigInteger yValue = new BigInteger("0");

        BigInteger expectedResult = new BigInteger("2147483648");

        assertEquals(expectedResult,xValue.gcd(yValue));
    }

    @Test
    void GCDTest5()
    {
        BigInteger xValue = new BigInteger("948464564845641654444444");
        BigInteger yValue = new BigInteger("56465165555");

        BigInteger expectedResult = new BigInteger("1");

        assertEquals(expectedResult, xValue.gcd(yValue));
    }

    @Test
    void GCDTest6()
    {
        BigInteger xValue = new BigInteger("1");
        BigInteger yValue = new BigInteger("1");

        BigInteger expectedResult = new BigInteger("1");

        assertEquals(expectedResult, xValue.gcd(yValue));
    }

    @Test
    void GCDTest7()
    {
        BigInteger xValue = new BigInteger("1");
        BigInteger yValue = new BigInteger("948464564845641654444444");

        BigInteger expectedResult = new BigInteger("1");

        assertEquals(expectedResult, xValue.gcd(yValue));
    }

    @Test
    void GCDTest8()
    {
        BigInteger xValue = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        BigInteger yValue = new BigInteger(String.valueOf(Integer.MIN_VALUE));

        BigInteger expectedResult = new BigInteger("2147483648");

        assertEquals(expectedResult, xValue.gcd(yValue));
    }

    @Test
    void GCDTest9()
    {
        BigInteger xValue = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        BigInteger yValue = new BigInteger("9484645648456416544444445");

        BigInteger expectedResult = new BigInteger("1");

        assertEquals(expectedResult, xValue.gcd(yValue));
    }
}