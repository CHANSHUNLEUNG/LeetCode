package Study.RabbitMQ;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    private static class SolutionHolder {
        private static Solution solution = new Solution();
    }

    @Leo("aiyoubucuo")
    private static int leo = 10;

    public Solution getInstance() {
        return SolutionHolder.solution;
    }

    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }


    public static void main(String[] argv) throws ClassNotFoundException, IllegalAccessException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for(int index=0; index<10000; index++){
            stringBuilder.append("11111111111111111111111111111111111111111");
        }
        BigInteger bigInteger = new BigInteger(stringBuilder.toString());
        System.out.println(bigInteger);
    }

}
