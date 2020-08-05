package com.stockservice;

import com.stockservice.services.ICalculator;
import com.stockservice.services.ProfitCalculator;

public class Main {

    public static void main(String[] args) {

        int[] stockPrices = {10, 7, 5, 8, 11, 9};
        ICalculator calculator = new ProfitCalculator();

        int maxProfit = calculator.getMaxProfit(stockPrices);
        System.out.println(maxProfit);

    }
}
