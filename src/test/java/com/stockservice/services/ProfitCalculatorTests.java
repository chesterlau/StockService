package com.stockservice.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProfitCalculatorTests {

    @ParameterizedTest
    @DisplayName("Should calculate max profit correctly")
    @MethodSource("getMaxProfitValidTestData")
    void getMaxProfit_Returns_Max_Profit_Correctly(int[] stockPrices, int expectedMaxProfit) {

        //Arrange
        ICalculator calculator = new ProfitCalculator();

        //Act
        int result = calculator.getMaxProfit(stockPrices);

        //Assert
        assertEquals(expectedMaxProfit, result);

    }

    @ParameterizedTest
    @DisplayName("Should throw illegal argument exception when invalid stock prices provided")
    @MethodSource("getMaxProfitInvalidTestData")
    void getMaxProfit_Throws_IllegalArgumentException(int[] stockPrices) {

        //Arrange
        ICalculator calculator = new ProfitCalculator();

        //Assert
        assertThrows(IllegalArgumentException.class, ()-> {
            calculator.getMaxProfit(stockPrices);
        });

    }

    private static Stream<Arguments> getMaxProfitValidTestData() {
        return Stream.of(
            Arguments.of(new int[] { 10, 7, 5, 8, 11, 9 }, 6),
            Arguments.of(new int[] { 2, 3, 1, 13, 8, 3, 5 }, 12),
            Arguments.of(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }, -1)
        );
    }

    private static Stream<int[]> getMaxProfitInvalidTestData() {
        return Stream.of(
            null,
            new int[] { },
            new int[] { 1 }
        );
    }

}
