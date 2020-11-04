package Questions.DynamicProgramming.question1130;

import java.util.*;

public class MctFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int product = 0;
        ArrayList<Integer> element = new ArrayList<>();
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            element.add(arr[i]);
        }
        while (n > 2) {
            int min = element.indexOf(Collections.min(element));
            if (0 < min && min < element.size() - 1)
                product = Math.min(element.get(min) * element.get(min - 1), element.get(min) * element.get(min + 1));
            else if (min == 0)
                product = element.get(min) * element.get(min + 1);
            else
                product = element.get(min) * element.get(min - 1);
            sum += product;
            element.remove(min);
            n--;
        }
        return sum + (element.get(0) * element.get(1));
    }
    public int checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            cnt++;
            System.out.println(i);
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        for(int num : nums){
            System.out.println(num);
        }
        return cnt ;
    }
    public String reverseVowels(String S){
        //Check edge cases
        if(S == null || S.length() == 0){
            return "";
        }


        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int start = 0, end = S.length()-1;
        String startString = "";
        String endString = "";
        while(start <= end){
            char startChar = S.charAt(start);
            char endChar = S.charAt(end);
            if(!set.contains(startChar)){
                start++;
                startString+=startChar;
            }
            if(!set.contains(endChar)){
                end--;
                endString = "" + endChar + endString;
            }
            if(set.contains(startChar) && set.contains(endChar)){
                startString += endChar;
                endString = "" + startChar + endString;
                start++;
                end--;
            }
        }
        return  startString+endString;
    }
    public static void main(String[] argv){
        int[] nums = new int[]{5,4,3,2,1};
        Map<Integer,Integer> test = new HashMap<>();
        for(int num : nums){
            test.put(num,num);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> test.get(a) - test.get(b));
        System.out.println(pq.peek());
    }
}
