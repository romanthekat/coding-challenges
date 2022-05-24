package net.romangaranin.leetcode.top.easy;

import net.romangaranin.leetcode.Helper;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 */
public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        var s = new Solution();
        Helper.test(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
        Helper.test(s.maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
        Helper.test(s.maxProfit(new int[]{5, 3, 5, 2, 6}), 4);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            var topProfit = 0;

            var bestBuy = prices[0];
            for (int i = 1; i < prices.length; i++) {
                var price = prices[i];
                var possibleProfit = price - bestBuy;

                if (possibleProfit > topProfit) {
                    topProfit = possibleProfit;
                }

                if (price < bestBuy) {
                    bestBuy = price;
                }
            }

            return topProfit;
        }
    }

}
