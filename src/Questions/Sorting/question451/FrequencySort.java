package Questions.Sorting.question451;

import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            frequencyMap.put(s.charAt(index), frequencyMap.getOrDefault(s.charAt(index), 0) + 1);
        }
        List<ArrayList<Character>> bucket = new ArrayList<ArrayList<Character>>();
        for(int i=0;i< s.length()+1;i++){
            bucket.add(new ArrayList<Character>());
        }
        for (char character : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(character);
            bucket.get(frequency).add(character);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = bucket.size() - 1; i >= 0; i--) {
            if (bucket.get(i) == null) {
                continue;
            }
            for (char character : bucket.get(i)) {
                for (int times = 0; times < i; times++) {
                    stringBuilder.append(character);
                }
            }

        }
        return stringBuilder.toString();
    }
    public static void main(String[] argv){
        int[] test = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(Arrays.binarySearch(test,3));
    }
}
