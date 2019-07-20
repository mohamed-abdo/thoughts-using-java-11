package utils.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import utils.streams.UtilsFunctions;
import utils.streams.UtilsFunctionsImpl;

import java.math.BigDecimal;

@SpringBootTest(classes = {UtilsFunctionsImpl.class})
@ExtendWith(SpringExtension.class)
class UtilsFunctionsImplTest {

    @Autowired
    private UtilsFunctions utilsFunctions;

    @Test
    void getFirstNonRepeatedChar() {
        var input = "abcde";
        var expected = 'a';
        Assertions.assertEquals(expected, utilsFunctions.getFirstNonRepeatedChar(input));
    }

    @Test
    void getFirstNonRepeatedChar_2() {
        var input = "mohamed abdo";
        var expected = 'h';
        Assertions.assertEquals(expected, utilsFunctions.getFirstNonRepeatedChar(input));
    }

    @Test
    void getFirstNonRepeatedChar_NullInput() {
        Assertions.assertThrows(NullPointerException.class, () -> utilsFunctions.getFirstNonRepeatedChar(null));
    }

    @Test
    void getFirstNonRepeatedChar_emptyInput() {
        var input = "";
        var expected = IllegalArgumentException.class;
        Assertions.assertThrows(expected, () -> utilsFunctions.getFirstNonRepeatedChar(input));
    }

    @Test
    void getFirstNonRepeatedChar_noMatch() {
        var input = "abcabc";
        var expected = IllegalArgumentException.class;
        Assertions.assertThrows(expected, () -> utilsFunctions.getFirstNonRepeatedChar(input));
    }

    @Test
    void isRotatedString() {
        var first = "name";
        var second = "enam";
        Assertions.assertTrue(utilsFunctions.isStringsRotated(first, second));
    }

    @Test
    void isRotatedString_NullInput() {
        Assertions.assertThrows(NullPointerException.class, () -> utilsFunctions.isStringsRotated(null, null));
    }

    @Test
    void isRotatedString_2() {
        var first = "name";
        var second = "mena";
        Assertions.assertTrue(utilsFunctions.isStringsRotated(first, second));
    }

    @Test
    void isRotatedString_invalid() {
        var first = "name";
        var second = "eman";
        Assertions.assertFalse(utilsFunctions.isStringsRotated(first, second));
    }

    @Test
    void isRotatedString_invalid_2() {
        var first = "name";
        var second = "name2";
        Assertions.assertFalse(utilsFunctions.isStringsRotated(first, second));
    }

    @Test
    void sampleOf_map_flatMap_reduce() {
        var strNums = "1.1,2.5,3.1,4.9,5.9,6.0";
        var strNums2 = "9.2,2.5,3.1,3.9,5.9,4.0";
        Assertions.assertTrue(utilsFunctions.sampleOf_map_flatMap_reduce(strNums, strNums2)
                .compareTo(BigDecimal.valueOf(52.1)) == 0);
    }
}