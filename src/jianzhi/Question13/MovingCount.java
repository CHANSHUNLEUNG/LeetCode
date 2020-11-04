package jianzhi.Question13;

import java.util.*;

public class MovingCount {
    private static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows == 0 || cols == 0 || threshold<=0){
            return 0;
        }
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<Integer>(Arrays.asList(0,0)));
        boolean visited[][] = new boolean[rows][cols];
        visited[0][0] = true;
        int count = 0;
        while(!queue.isEmpty()){
            int iterationSize = queue.size();
//            System.out.println(iterationSize);
            count+=iterationSize;
            for(int index=0; index<iterationSize; index++){
                ArrayList<Integer> arrayList = queue.poll();
                int x = arrayList.get(0);
                int y = arrayList.get(1);
                for(int[] direction:directions){
                    int nextX = x + direction[0];
                    int nextY = y + direction[1];
                    int xc = cal(nextX);
                    int yc = cal(nextY);
                    if(xc + yc <= threshold && nextX >=0 && nextX <rows && nextY>=0 && nextY<cols&&
                            !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
//                        System.out.println("nextX:"+nextX+"nextY:"+nextY);
                        queue.offer(new ArrayList<>(Arrays.asList(nextX, nextY)));
                    }
                }

            }
        }
        return count;
    }

    public int cal(int num){
        int ret = 0;
        while(num > 0){
            ret += num%10;
            num /= 10;
        }
        return ret;
    }
    public static void main(String[] argv){
        System.out.println(new MovingCount().movingCount(5,10,10));
    }
}
