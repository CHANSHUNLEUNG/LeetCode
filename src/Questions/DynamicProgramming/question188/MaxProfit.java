package Questions.DynamicProgramming.question188;

public class MaxProfit {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
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
            int maxRemaining = -prices[0];
            for (int day = 1; day < days; day++) {
                maxProfix[transaction][day] = Math.max(maxProfix[transaction][day-1], maxRemaining + prices[day]);
                maxRemaining = Math.max(maxRemaining,maxProfix[transaction-1][day] - prices[day]);
            }
        }
        return maxProfix[k][days - 1];
    }
}
