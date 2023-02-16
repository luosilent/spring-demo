package com;

/**
 * 给定一个 int 类型的数组，表示一只股票最近 N天的价格。假设你每次买卖只能一股，可以买卖多次，但是手里最多只能持有一股。
 * 请写一个函数，计算你所能获取的最大利润。
 * 例如，一只股票最近 N 天的价格为 int[]{1,4,2,3,}那么你所能获取的最大利润为4
 * @author luo
 * @date 2023/2/9 13:57
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1,4,2,3,5,1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }


}
