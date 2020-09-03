package Questions.Searching.question279;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumSquares {
    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        int result = 0;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0, 0));
        int[] visited = new int[n + 1];
        while (!queue.isEmpty() || result < n) {
            result++;
            int iterationSize = queue.size();
            for (int index = 0; index < iterationSize; index++) {
                List<Integer> current = queue.poll();
                for (int edge = 1; edge <= sqrt; edge++) {
                    if (safeAddQueue(queue, edge, current, visited, n) == n) {
                        return result;
                    }
                }
            }
        }
        return -1;
    }

    private int safeAddQueue(Queue<List<Integer>> queue, int edge, List<Integer> current, int[] visited, int n) {
        int number = current.get(0), depth = current.get(1);
        int next = number + edge * edge;
        if (next <= n && visited[next] == 0) {
            queue.add(Arrays.asList(next, depth + 1));
            visited[next] = 1;
        }
        return next;
    }
    public static void main(String[] argv){
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(12));
    }
}
