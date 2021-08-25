import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CalcTest {
    Calc calc;

    @Before
    public void init() {
        calc = new Calc();
    }

    @Test
    public void isEmptyCheck() {
        Assert.assertEquals(0,calc.add(""));
    }

    @Test
    public void isSingleValue() {
        Assert.assertEquals(1,calc.add("1"));
    }

    @Test
    public void sumofTwoValue() {
        Assert.assertEquals(10,calc.add("5,5"));
    }

    @Test
    public void sumofMultipleValue() {
        Assert.assertEquals(15,calc.add("1,2,8,4"));
    }

    @Test
    public void sumofMultipleValueNewLine() {
        Assert.assertEquals(50,calc.add("20\n10\n19,1"));
    }

    @Test
    public void allNewLine() {
        Assert.assertEquals(0,calc.add("\n\n\n\n"));
    }

    @Test
    public void diffDelimiters() {
        Assert.assertEquals(3,calc.add("//;\n1;2"));
    }

    @Test
    public void negativeNumberTest() {
        try {
            calc.add("5,-10,15,-20,30");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Negative not allowed: -10,-20",e.getMessage());
        }
    }

    @Test
    public void negativeNumberTestSingle() {
        try {
            calc.add("-5");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Negative not allowed: -5",e.getMessage());
        }
    }

    @Test
    public void greaterThanThousandIgnored() {
        Assert.assertEquals(100,calc.add("10,50,1010,40"));
    }

    @Test
    public void greaterThanThousandIgnoredSingleValue() {
        Assert.assertEquals(0,calc.add("1500"));
    }
}
