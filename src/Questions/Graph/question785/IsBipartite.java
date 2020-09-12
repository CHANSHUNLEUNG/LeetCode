package Questions.Graph.question785;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int index = 0; index < graph.length; index++) {
            if (colors[index] == -1 & !isBipartite(graph, colors, index, 0)) {
                return false;
            }
        }

        return true;
    }

    private boolean isBipartite(int[][] graph, int[] colors, int index, int currentColor) {
//        visited
        if(colors[index] != -1){
            return colors[index] == currentColor;
        }

//        not visited
        colors[index] = currentColor;
        for (int nextNode : graph[index]) {
            if(!isBipartite(graph,colors,nextNode,1-currentColor)){
                return false;
            }
        }
        return true;
    }


}
