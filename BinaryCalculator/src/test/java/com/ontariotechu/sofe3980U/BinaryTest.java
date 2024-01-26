package com.ontariotechu.sofe3980U;

import static org.junit.jupiter.api.Assertions.assertTrue; // Static import for assertTrue

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit test for Binary class.
 */
public class BinaryTest {
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor() {
        Binary binary = new Binary("1001001");
        assertTrue(binary.getValue().equals("1001001"));
    }

    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits() {
        Binary binary = new Binary("1001001211");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars() {
        Binary binary = new Binary("1001001A");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign() {
        Binary binary = new Binary("-1001001");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * T est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing() {
        Binary binary = new Binary("00001001");
        assertTrue(binary.getValue().equals("1001"));
    }

    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString() {
        Binary binary = new Binary("");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add() {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("10111"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first
     * argument is less than the second
     */
    @Test
    public void add2() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first
     * argument is greater than the second
     */
    @Test
    public void add3() {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test The add functions with two zeros
     */
    @Test
    public void add5() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }
    
    /**
     * Test The and functions with two binary numbers, the length of the first
     * argument is greater than the second
     */
    @DisplayName("Binary Multiply Test Cases 😎")
    @ParameterizedTest(name = "{0} | {1} = {2}")
    @CsvSource({
        // "first", "second", "expected"
        "11, 1010, 1011", 
        "101, 1010, 1111", 
        "0000, 1010, 1010",
    })
    public void or(String bin1, String bin2, String expected) {
        Binary result = Binary.or(
            new Binary(bin1), 
            new Binary(bin2)
        );
        assertTrue(
            result
                .getValue()
                .equals(expected)
        );
    }

    
    /**
     * Test The and functions with two binary numbers, the length of the first
     * argument is greater than the second
     */
    @DisplayName("Binary Multiply Test Cases 😎")
    @ParameterizedTest(name = "{0} & {1} = {2}")
    @CsvSource({
        // "first", "second", "expected"
        "11, 1010, 10", 
        "101, 1010, 0", 
        "1110, 1010, 1010",
    })
    public void and(String bin1, String bin2, String expected) {
        Binary result = Binary.and(
            new Binary(bin1), 
            new Binary(bin2)
        );
        assertTrue(
            result
                .getValue()
                .equals(expected)
        );
    }

    /**
     * Test The multiply functions with two binary numbers, the length of the first
     * argument is greater than the second
     */
    @DisplayName("Binary Multiply Test Cases 😎")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
        // "first", "second", "expected"
        "1010, 101, 110010", 
        "1101, 1011, 10001111", 
        "1010, 0101, 110010",
    })
    public void multiply(String bin1, String bin2, String expected) {
        Binary product = Binary.multiply(
            new Binary(bin1), 
            new Binary(bin2)
        );
        assertTrue(
            product
                .getValue()
                .equals(expected)
        );
    }
}
