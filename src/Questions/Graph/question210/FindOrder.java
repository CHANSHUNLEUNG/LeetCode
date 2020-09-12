package Questions.Graph.question210;

import java.util.ArrayList;
import java.util.List;

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> prerequisitMap = new ArrayList<>();
        for (int index = 0; index < numCourses; index++) {
            prerequisitMap.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            List<Integer> current = prerequisitMap.get(prerequisite[0]);
            current.add(prerequisite[1]);
        }
        int[] visited = new int[numCourses];
        List<Integer> answerList = new ArrayList<>();
        for (int index = 0; index < numCourses; index++) {
            if (prerequisitMap.get(index).size() == 0) {
                answerList.add(index);
                visited[index] = 2;
            }
        }
        for (int index = 0; index < numCourses; index++) {
            if(!dfs(index,prerequisitMap,visited,answerList)){
                return new int[]{};
            }
        }
        int[] answer = new int[answerList.size()];
        for (int index = 0; index < answerList.size(); index++) {
            answer[index] = answerList.get(index);
        }
        return answer;
    }

    private boolean dfs(int index, List<List<Integer>> prerequisitMap, int[] visited, List<Integer> answerList) {
        if(visited[index] == 1){
            return false;
        }
        if(visited[index] == 2){
            return true;
        }
        visited[index] = 1;
        for(int nextIndex : prerequisitMap.get(index)){
            if(!dfs(nextIndex,prerequisitMap,visited,answerList)){
                return false;
            }
        }
        visited[index] = 2;
        answerList.add(index);
        return true;
    }
}
