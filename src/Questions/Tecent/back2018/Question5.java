package Questions.Tecent.back2018;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int machine = scanner.nextInt();
        int task = scanner.nextInt();
        int machines[][] = new int[machine][2];
        int tasks[][] = new int[task][2];
        for (int index = 0; index < machine; index++) {
            machines[index][0] = scanner.nextInt();
            machines[index][1] = scanner.nextInt();
        }
        for (int index = 0; index < task; index++) {
            tasks[index][0] = scanner.nextInt();
            tasks[index][1] = scanner.nextInt();
        }
        Arrays.sort(machines, (x, y) -> x[0] == y[0] ? y[1] - x[1] : y[0] - x[0]);
        Arrays.sort(tasks, (x, y) -> x[0] == y[0] ? y[1] - x[1] : y[0] - x[0]);
        int machineIndex = 0;
        int grade[] = new int[101];
        int count = 0;
        int total = 0;
        for (int index = 0; index < task; index++) {
            while (machineIndex < machine && machines[machineIndex][0] >= tasks[index][0]) {
                grade[machines[machineIndex++][1]]++;
            }
            for (int currentGrade = tasks[index][1]; currentGrade <= 100; currentGrade++) {
                if (grade[currentGrade] > 0) {
                    grade[currentGrade]--;
                    count++;
                    total += 200 * tasks[index][0] + 3 * tasks[index][1];
                    break;
                }
            }
        }
        System.out.println(count + " " + total);
    }
}
