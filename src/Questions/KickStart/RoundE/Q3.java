package Questions.KickStart.RoundE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q3 {
    public static void main(String[] argv) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testNumber = Integer.parseInt(bf.readLine());
        for (int index = 1; index <= testNumber; index++) {
            int number = Integer.parseInt(bf.readLine());
            List<List<Integer>> toys = new ArrayList<>();
            for (int count = 0; count < number; count++) {
                String[] edge = bf.readLine().split(" ");
                List<Integer> edgeInt = new ArrayList<>(Arrays.asList(Integer.parseInt(edge[0]), Integer.parseInt(edge[1])));
                toys.add(edgeInt);
            }
            String answer = solve(toys);
            System.out.println("Case #" + index + ": " + answer);
        }
    }

    private static String solve(List<List<Integer>> toys) {
        int total = 0;
        boolean []remove = new boolean[toys.size()];

        for(List<Integer> toy : toys){
            total+=toy.get(0);
        }
        int bestRemoveCount = 0;
        int removeCount = 0;
        int longest = 0;
        int tempLongest = total;
        while(hasBad(toys, remove,total)){
            for(int index=0; index<toys.size(); index++){
                if(total - toys.get(index).get(0) < toys.get(index).get(1)){
                    if(tempLongest > longest){
                        bestRemoveCount = removeCount;
                        longest = tempLongest;
                    }
                    tempLongest -= toys.get(index).get(0);
                    removeCount++;
                }
            }
        }
        boolean allRemoved = true;
        for(boolean removed : remove){
            if(!removed){
                allRemoved = false;
                break;
            }
        }
        return allRemoved ? bestRemoveCount + " " + longest : removeCount + " INDEFINITELY";
    }

    private static boolean hasBad(List<List<Integer>> toys, boolean[] remove, int currentTotal) {
        for(int index=0; index<toys.size(); index++){
            if(currentTotal - toys.get(index).get(0) < toys.get(index).get(1)){
                return true;
            }
        }
        return false;
    }

}
