package Questions.DynamicProgramming.question714;

public class MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int hold = Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices) {
            int prevHold = hold;
            hold = Math.max(prevHold, sell - price - fee);
            sell = Math.max(sell, prevHold + price);
        }
        return sell;
    }
}
