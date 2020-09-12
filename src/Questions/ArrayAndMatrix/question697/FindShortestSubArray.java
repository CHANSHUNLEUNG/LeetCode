package Questions.ArrayAndMatrix.question697;

public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        int[] countForNumber = new int[50000];
        int max = 1;
        for (int num : nums) {
            countForNumber[num]++;
            max = Math.max(countForNumber[num], max);
        }
        int answer = Integer.MAX_VALUE;
        for (int index = 0; index < countForNumber.length; index++) {
            if (countForNumber[index] == max) {
                int start = 0, end = nums.length - 1;
                while (nums[start] != index) {
                    start++;
                }
                while (nums[end] != index) {
                    end--;
                }
                answer = Math.min(answer, end - start);
            }
        }
        return answer;
    }
}
