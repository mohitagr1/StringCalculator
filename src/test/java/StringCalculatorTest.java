import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void shouldReturnZeroOnEmptyString(){
        Assertions.assertEquals(0,StringCalculator.add(""));
    }

    @Test
    void shouldReturnNumberForOneNumber(){
        Assertions.assertEquals(4,StringCalculator.add("4"));
    }

    @Test
    void shouldReturnSumForTwoNumber(){
        Assertions.assertEquals(7,StringCalculator.add("2,5"));
    }

    @Test
    void shouldReturnSumForMultipleNumbers(){
        Assertions.assertEquals(18,StringCalculator.add("2,5,7,4"));
    }

}