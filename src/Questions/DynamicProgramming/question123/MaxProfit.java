package Questions.DynamicProgramming.question123;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int k = 2;
        if (k >= days / 2) {
            int maxProfix = 0;
            for (int day = 1; day < days; day++) {
                if (prices[day] > prices[day - 1]) {
                    maxProfix += prices[day] - prices[day - 1];
                }
            }
            return maxProfix;
        }
        int[][] maxProfix = new int[k + 1][days];
        for (int transaction = 1; transaction <= k; transaction++) {
            int localMax = maxProfix[transaction - 1][0] - prices[0];
            for (int day = 1; day < days; day++) {
                maxProfix[transaction][day] = Math.max(maxProfix[transaction][day - 1], prices[day] + localMax);
                localMax = Math.max(localMax, maxProfix[transaction - 1][day] - prices[day]);
            }
        }
        return maxProfix[k][days - 1];
    }
}
