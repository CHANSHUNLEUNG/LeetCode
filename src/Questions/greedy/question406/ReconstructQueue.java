package Questions.greedy.question406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }
        Arrays.sort(people, (first, second) -> {
            return (first[0] == second[0]) ? first[1] - second[1] : second[0] - first[0];
        });
        List<int[]> result = new ArrayList<>();
        for(int[] person : people){
            result.add(person[1],person);
        }
        return result.toArray(new int[result.size()][]);
    }

}
