package Questions.greedy.question121;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int minPrice = prices[0], maxProfit = 0;
        for(int price : prices){
            if(price - minPrice > maxProfit){
                maxProfit = price - minPrice;
            }
            if(price < minPrice){
                minPrice = price;
            }
        }
        return maxProfit;
    }
}
