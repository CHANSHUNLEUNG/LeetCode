package Questions.ByteDance.Algor2018;

import java.io.BufferedInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int pm = scanner.nextInt();
        int programmer = scanner.nextInt();
        int idea = scanner.nextInt();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> x[1] != y[1] ? x[1] - y[1]
                : x[2] != y[2] ? y[2] - x[2] : x[3] != y[3] ? x[3] - y[3] : x[0] - y[0]);
        for (int index = 0; index < idea; index++) {
            int current[] = new int[5];
            current[0] = scanner.nextInt(); // 序列
            current[1] = scanner.nextInt(); // 提出时间
            current[2] = scanner.nextInt(); // 优先等级
            current[3] = scanner.nextInt(); // 所需时间
            current[4] = index;
            priorityQueue.offer(current);
        }
        int[] programmers = new int[programmer];
        int answer[] = new int[idea];
        int time = 1;
        PriorityQueue<int[]> nonFinish = new PriorityQueue<>((x, y) -> x[1] != y[1] ? x[1] - y[1]
                : x[3] != y[3] ? x[3] - y[3] : x[0] - y[0]);
        while (!priorityQueue.isEmpty() || !nonFinish.isEmpty()) {
            for (int index = 0; index < pm; index++) {
                if (!priorityQueue.isEmpty() && priorityQueue.peek()[1] <= time) {
                    nonFinish.offer(priorityQueue.poll());
                }
            }
            if(nonFinish.isEmpty()){
                time++;
                continue;
            }
            for(int index=0; index<programmer; index++){
                if(programmers[index] == 0){
                    int current[] = nonFinish.poll();
                    programmers[index] = current[3];
                    answer[current[4]] = time +current[3];
                }
            }

            for (int find = 0; find < programmer; find++) {
                if (programmers[find] != 0) {
                    programmers[find]--;
                }
            }
            time++;
        }
        for (int index = 0; index < answer.length; index++) {
            System.out.println(answer[index]);
        }

    }
}
