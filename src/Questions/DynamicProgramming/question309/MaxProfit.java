package Questions.DynamicProgramming.question309;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int cool = 0;
        int rest = 0;
        for (int day = 1; day <= prices.length; day++) {
            int price = prices[day - 1];
            int prevHold = hold;
            hold = Math.max(prevHold, rest - price);
            rest = Math.max(rest, cool);
            cool = prevHold + price;
        }
        return Math.max(rest, cool);
    }
}
