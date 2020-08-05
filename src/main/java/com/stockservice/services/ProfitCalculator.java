package com.stockservice.services;

public class ProfitCalculator implements ICalculator {

    @Override
    public int getMaxProfit(int[] stockPrices) throws IllegalArgumentException  {

        if(stockPrices == null || stockPrices.length < 2) {
            throw new IllegalArgumentException ("There must be more than one stock price!");
        }

        int bestBuyingPrice = stockPrices[0];
        int currentMaxProfit = stockPrices[1] - bestBuyingPrice;

        for(int i = 1; i < stockPrices.length - 1; i++) {
            if(stockPrices[i] < bestBuyingPrice)
            {
                bestBuyingPrice = stockPrices[i];
            }

            int priceDifference = stockPrices[i+1] - bestBuyingPrice;

            if(priceDifference > currentMaxProfit)
            {
                currentMaxProfit = priceDifference;
            }
        }

        return currentMaxProfit;
    }
}
