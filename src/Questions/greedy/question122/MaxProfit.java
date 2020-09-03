package Questions.greedy.question122;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int min = prices[0], maxProfit = 0;
        for(int price : prices){
            if(price < min){
                min = price;
            }
            if(price > min){
                maxProfit += price - min;
                min = price;
            }
        }
        return maxProfit;
    }
}
