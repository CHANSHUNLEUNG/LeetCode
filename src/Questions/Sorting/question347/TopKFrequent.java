package Questions.Sorting.question347;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> frequency.get(a) - frequency.get(b));
//        for (int num : frequency.keySet()) {
//            priorityQueue.add(num);
//            if (priorityQueue.size() > k) {
//                priorityQueue.remove();
//            }
//        }
//        int[] answer = new int[k];
//        for (int index = 0; index < k; index++) {
//            answer[index] = priorityQueue.remove();
//        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer,Integer> entry : frequency.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] answer = new int[k];
        for(int index=0; index<k; index++){
            answer[index] = pq.poll().getKey();
        }
        return answer;
    }

    public static void main(String[] argv) {
    }

}
