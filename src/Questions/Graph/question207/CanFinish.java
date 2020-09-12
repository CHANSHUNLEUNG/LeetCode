package Questions.Graph.question207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            return true;
        }
        List<List<Integer>> prerequisitesMap = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int index = 0; index < numCourses; index++) {
            prerequisitesMap.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            List<Integer> current = prerequisitesMap.get(prerequisite[0]);
            current.add(prerequisite[1]);
        }
        for (int index = 0; index < numCourses; index++) {
            if (!dfs(index, prerequisitesMap, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int index, List<List<Integer>> prerequisitesMap, int[] visited) {
        if (visited[index] == 2) {
            return true;
        }
        if (visited[index] == 1) {
            return false;
        }
        visited[index] = 1;
        for (int prerequisit : prerequisitesMap.get(index)) {
            if (!dfs(prerequisit, prerequisitesMap, visited)) {
                return false;
            }
        }
        visited[index] = 2;
        return true;
    }

    public static void main(String[] argv) {
    }
}
