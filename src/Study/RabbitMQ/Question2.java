package Study.RabbitMQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2 {
    public static void main(String[] argv) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int D = Integer.parseInt(info[1]);
        int[] position = new int[N];
        String[] stringPosition = bf.readLine().split(" ");
        for (int index = 0; index < stringPosition.length; index++) {
            position[index] = Integer.parseInt(stringPosition[index]);
        }
        System.out.println(solve(N, D, position));
        bf.close();
    }

    private static long solve(int n, int d, int[] position) {
        int count = 0;
        for(int first=0; first<position.length;first++){
            for(int second=first+1; second<position.length; second++){
                if(position[second] - position[first] <=d){
                    for(int third=second+1; third<position.length; third++){
                        if(position[third] - position[first] <= d){
                            count++;
                            count%=99997867;
                        }
                    }
                }
            }
        }
        return count;
    }
}
