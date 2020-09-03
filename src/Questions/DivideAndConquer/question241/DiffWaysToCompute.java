package Questions.DivideAndConquer.question241;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == '-' || input.charAt(index) == '+' || input.charAt(index) == '*') {
                List<Integer> leftSolutions = diffWaysToCompute(input.substring(0, index));
                List<Integer> rightSolutions = diffWaysToCompute(input.substring(index + 1, input.length()));
                for (int leftSolution : leftSolutions) {
                    for (int rightSolution : rightSolutions) {
                        if (input.charAt(index) == '-') {
                            result.add(leftSolution - rightSolution);
                        } else if (input.charAt(index) == '+') {
                            result.add(leftSolution + rightSolution);
                        } else {
                            result.add(leftSolution * rightSolution);
                        }
                    }
                }

            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
