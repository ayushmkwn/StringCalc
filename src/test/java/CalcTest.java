import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CalcTest {
    Calc calc;

    @Before
    public void init() {
        calc = new Calc();
    }

    @Test
    public void isEmptyCheck() {
        assertEquals(0,calc.add(""));
    }

    @Test
    public void isSingleValue() {
        assertEquals(1,calc.add("1"));
    }

    @Test
    public void sumofTwoValue() {
        assertEquals(10,calc.add("5,5"));
    }

    @Test
    public void sumofMultipleValue() {
        assertEquals(15,calc.add("1,2,8,4"));
    }

    @Test
    public void sumofMultipleValueNewLine() {
        assertEquals(50,calc.add("20\n10\n19,1"));
    }

    @Test
    public void allNewLine() {
        assertEquals(0,calc.add("\n\n\n\n"));
    }

    @Test
    public void diffDelimiters() {
        assertEquals(3,calc.add("//;\n1;2"));
    }

    @Test
    public void negativeNumberTest() {
        try {
            calc.add("5,-10,15,-20,30");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers are not allowed: -10,-20",e.getMessage());
        }
    }

    @Test
    public void negativeNumberTestSingle() {
        try {
            calc.add("-5");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers are not allowed: -5",e.getMessage());
        }
    }

    @Test
    public void greaterThanThousandIgnored() {
        assertEquals(100,calc.add("10,50,1010,40"));
    }

    @Test
    public void greaterThanThousandIgnoredSingleValue() {
        assertEquals(0,calc.add("1500"));
    }

    @Test
    public void anyLengthOfDelimiter() {
        assertEquals(6,calc.add("//[xxx]\n1xxx2xxx3"));
    }

    @Test
    public void multipleDelimiters() {
        assertEquals(6,calc.add("//[;][,]\n1;2,3"));
    }

    @Test
    public void multipleDelimitersofAnyLength() {
        assertEquals(6,calc.add("//[**][,][;]\n1**2,3"));
    }
}
