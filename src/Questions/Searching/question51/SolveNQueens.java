package Questions.Searching.question51;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        String initString = "";
        for (int index = 0; index < n; index++) {
            initString += ".";
        }
        List<String> initSolution = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            initSolution.add(initString);
        }

        backTracking(0, 0, n, initSolution, result);
        return result;
    }

    private void backTracking(int start, int currentNumber, int n, List<String> currentSolution,
                              List<List<String>> result) {
        if (currentNumber == n) {
            result.add(new ArrayList<>(currentSolution));
            return;
        }
        for (int index = start; index < n; index++) {
            for (int count = 0; count < n; count++) {
                if (!isValid(index, count, n, currentSolution)) {
                    continue;
                }
                String backup = currentSolution.get(index);
                String newString = backup.substring(0, count) + "Q" + backup.substring(count + 1, n);
                currentSolution.set(index, newString);
                backTracking(index + 1, currentNumber + 1, n, currentSolution, result);
                currentSolution.set(index, backup);
            }
        }

    }

    public boolean isValid(int x, int y, int n, List<String> currentResult) {
        if (currentResult.get(x).contains("Q")) {
            return false;
        }
        for (int index = 0; index < currentResult.size(); index++) {
            if (currentResult.get(index).charAt(y) == 'Q') {
                return false;
            }
        }
        int checkX = x - 1;
        int checkY = y + 1;
        while (checkX >= 0 && checkY < n) {
            if (currentResult.get(checkX).charAt(checkY) == 'Q') {
                return false;
            }
            checkX--;
            checkY++;
        }
        checkX = x - 1;
        checkY = y - 1;
        while (checkX >= 0 && checkY >= 0) {
            if (currentResult.get(checkX).charAt(checkY) == 'Q') {
                return false;
            }
            checkX--;
            checkY--;

        }
        return true;
    }
}
