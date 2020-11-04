package Questions.Tecent.back2018;

import java.io.BufferedInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int count = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
        for (int index = 0; index < count; index++) {
            priorityQueue.offer(scanner.nextInt());
        }
        long answer = 0;
        boolean niu = true;
        while(!priorityQueue.isEmpty()){
            if(niu){
                answer += priorityQueue.poll();
                niu = false;
            }else{
                answer -= priorityQueue.poll();
                niu = true;
            }
        }
        System.out.println(answer);
    }
}
