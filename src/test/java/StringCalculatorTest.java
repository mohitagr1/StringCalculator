import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void shouldReturnZeroOnEmptyString(){
        Assertions.assertEquals(0,stringCalculator.add(""));
    }

    @Test
    void shouldReturnNumberForOneNumber(){
        Assertions.assertEquals(4,stringCalculator.add("4"));
    }

    @Test
    void shouldReturnSumForTwoNumber(){
        Assertions.assertEquals(7,stringCalculator.add("2,5"));
    }

    @Test
    void shouldReturnSumForMultipleNumbers(){
        Assertions.assertEquals(18,stringCalculator.add("2,5,7,4"));
    }

    @Test
    void shouldReturnSumOfNumbersSplitByCommaAndNewLine(){
        Assertions.assertEquals(6,stringCalculator.add("1\n2,3"));
    }

    @Test
    void shouldReturnSumOfNumbersSplitByCustomDelimiter(){
        Assertions.assertEquals(12,stringCalculator.add("//;\n1;4;7"));
    }

    @Test
    void shouldReturnNumberOfTimesAddInvoked(){
        Assertions.assertEquals(1, stringCalculator.getCalledCount());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbers(){
        Assertions.assertThrows(RuntimeException.class,() -> stringCalculator.add("1,-2,3,-4"),"negatives not allowed : -2 -4");
    }

    @Test
    void shouldIgnoreNumberGreaterThan1000(){
        Assertions.assertEquals(3, stringCalculator.add("1,1100,2"));
    }

}