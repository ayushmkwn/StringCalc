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
}
