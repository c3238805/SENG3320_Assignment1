package Tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StructuralTestingCompareTo {

    @Test
        //x.words && y.words == null, x.ival < y.ival
    void CompareTo_Test1()
    {
        BigInteger xValue = new BigInteger("12");
        BigInteger yValue = new BigInteger("13");

        assertEquals(-1,xValue.compareTo(yValue));
    }

    @Test
        //x.words && y.words == null, x.ival > y.ival
    void CompareTo_Test2()
    {
        BigInteger xValue = new BigInteger("13");
        BigInteger yValue = new BigInteger("12");

        assertEquals(1,xValue.compareTo(yValue));
    }

    @Test
        //x.words && y.words == null, x.ival = y.ival
    void CompareTo_Test3()
    {
        BigInteger xValue = new BigInteger("50");
        BigInteger yValue = new BigInteger("50");

        assertEquals(0,xValue.compareTo(yValue));
    }

    @Test
        //x.words || y.words != null, x_negative != y_negative, x_negative == true
    void CompareTo_Test4()
    {
        BigInteger xValue = new BigInteger("-20428423987");
        BigInteger yValue = new BigInteger("2000");

        assertEquals(-1,xValue.compareTo(yValue));
    }

    @Test
        //x.words || y.words != null, x_negative != y_negative, x_negative == false
    void CompareTo_Test5()
    {
        BigInteger xValue = new BigInteger("1897987979798");
        BigInteger yValue = new BigInteger("-31290");

        assertEquals(1,xValue.compareTo(yValue));
    }

    @Test
        //x.words || y.words != null, x_negative == false, x_negative == y_negative, x.words != null, y.words == null, x_len > y_len
    void CompareTo_Test6()
    {
        BigInteger xValue = new BigInteger("2923942394");
        BigInteger yValue = new BigInteger("20");

        assertEquals(1,xValue.compareTo(yValue));
    }

    @Test
        //x.words || y.words != null, x_negative == true, x_negative == y_negative, x.words != null, y.words == null, x_len > y_len
    void CompareTo_Test7()
    {
        BigInteger xValue = new BigInteger("-2923942394");
        BigInteger yValue = new BigInteger("-20");

        assertEquals(-1,xValue.compareTo(yValue));
    }
    @Test
        //x.words || y.words != null, x_negative == y_negative, x.words == null, y.words != null, x_len < y_len
    void CompareTo_Test8()
    {
        BigInteger xValue = new BigInteger("20");
        BigInteger yValue = new BigInteger("1897987979798");

        assertEquals(-1,xValue.compareTo(yValue));
    }
    @Test
    //x.words || y.words != null, x_negative == y_negative, x.words != null, y.words != null, x_len == y_len, xValue < yValue
    void CompareTo_Test9()
    {
        BigInteger xValue = new BigInteger("1897987979798");
        BigInteger yValue = new BigInteger("1897987979799");

        assertEquals(-1,xValue.compareTo(yValue));
    }

    @Test
        //x.words || y.words != null, x_negative == y_negative, x.words != null, y.words != null, x_len == y_len, xValue == yValue
    void CompareTo_Test10()
    {
        BigInteger xValue = new BigInteger("1897987979798");
        BigInteger yValue = new BigInteger("1897987979798");

        assertEquals(0,xValue.compareTo(yValue));
    }

    @Test
        //x.words || y.words != null, x_negative == y_negative, x.words != null, y.words != null, x_len == y_len, xValue > yValue
    void CompareTo_Test11()
    {
        BigInteger xValue = new BigInteger("1897987979799");
        BigInteger yValue = new BigInteger("1897987979798");
        
        assertEquals(1,xValue.compareTo(yValue));
    }

   }