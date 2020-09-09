package Questions.Math.question238;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        Arrays.fill(products, 1);
        int left = 1;
        for (int index = 1; index < nums.length; index++) {
            left *= nums[index - 1];
            products[index] = left;
        }
        int right = 1;
        for (int index = nums.length - 2; index >= 0; index--) {
            right *= nums[index + 1];
            products[index] *= right;
        }
        return products;
    }
}
