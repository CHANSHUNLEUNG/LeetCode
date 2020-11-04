package Questions.ByteDance.Back20183;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Question2 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char board[][] = new char[n][m];
        boolean visited[][] = new boolean[n][m];
        int personX = -1, personY = -1, boxX = -1, boxY = -1, targetX = -1, targetY = -1;

        for (int index = 0; index < n; index++) {
            String line = scanner.next();
            board[index] = line.toCharArray();
            if (line.contains("S")) {
                personX = index;
                personY = line.indexOf("S");
//                System.out.println("personX:" + personX + ",personY:" + personY);
            }
            if (line.contains("0")) {
                boxX = index;
                boxY = line.indexOf("0");
//                System.out.println("boxX:" + boxX + ",boxY:" + boxY);
            }
            if (line.contains("E")) {
                targetX = index;
                targetY = line.indexOf("E");
//                System.out.println("targetX:" + targetX + ",targetY:" + targetY);
            }
        }

//        boolean personVisited[][] = new boolean[board.length][board[0].length];
//        System.out.println(getSteps(board, personVisited, personX, personY, boxX, boxY, 0, 0));
//        System.out.println(getSteps(board, personVisited, personX, personY, boxX, boxY, 1, 0));
//        System.out.println(getSteps(board, personVisited, personX, personY, boxX, boxY, 2, 0));
//        System.out.println(getSteps(board, personVisited, personX, personY, boxX, boxY, 3, 0));

        backTracking(board, visited, personX, personY, boxX, boxY, targetX, targetY, 0);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }

    private static void backTracking(char[][] board, boolean[][] visited, int personX, int personY,
                                     int boxX, int boxY, int targetX, int targetY, int currentStep) {
        if (boxX == targetX && boxY == targetY) {
//            System.out.println("============================================");
            min = Math.min(min, currentStep);
            return;
        }
        if (currentStep >= min || visited[boxX][boxY]) {
            return;
        }
        visited[boxX][boxY] = true;
        //up=0, down = 1, left = 2, right = 3
        boolean personVisited[][] = new boolean[board.length][board[0].length];
        int moveUp = getSteps(board, personVisited, personX, personY, boxX, boxY, 0, 0);
        int moveDown = getSteps(board, personVisited, personX, personY, boxX, boxY, 1, 0);
        int moveLeft = getSteps(board, personVisited, personX, personY, boxX, boxY, 2, 0);
        int moveRight = getSteps(board, personVisited, personX, personY, boxX, boxY, 3, 0);
//        System.out.println("moveUp:"+moveUp);
//        System.out.println("moveDown:"+moveDown);
//        System.out.println("moveLeft:"+moveLeft);
//        System.out.println("moveRight:"+moveRight);
//        System.out.println();
        if (moveUp != Integer.MAX_VALUE) {
//            System.out.println("move up, personX: " + personX + ",personY: " + personY + ",boxX: " + boxX
//                    + ",boxY:" + boxY);
            char temp = board[boxX - 1][boxY];
            board[boxX][boxY] = '.';
            board[boxX - 1][boxY] = '0';
//            for(int index=0; index<board.length;index++) System.out.println(board[index]);
            backTracking(board, visited, boxX, boxY, boxX - 1, boxY,
                    targetX, targetY, currentStep + moveUp + 1);
            board[boxX][boxY] = '0';
            board[boxX - 1][boxY] = temp;
        }
        if (moveDown != Integer.MAX_VALUE) {
//            System.out.println("move down, personX: " + personX + ",personY: " + personY + ",boxX: " + boxX
//                    + ",boxY:" + boxY);
            char temp = board[boxX + 1][boxY];
            board[boxX][boxY] = '.';
            board[boxX + 1][boxY] = '0';
//            for(int index=0; index<board.length;index++) System.out.println(board[index]);
            backTracking(board, visited, boxX, boxY, boxX + 1, boxY,
                    targetX, targetY, currentStep + moveDown + 1);
            board[boxX][boxY] = '0';
            board[boxX + 1][boxY] = temp;
        }
        if (moveLeft != Integer.MAX_VALUE) {
//            System.out.println("move left, personX: " + personX + ",personY: " + personY + ",boxX: " + boxX
//                    + ",boxY:" + boxY);
            char temp = board[boxX][boxY - 1];
            board[boxX][boxY] = '.';
            board[boxX][boxY - 1] = '0';
//            for(int index=0; index<board.length;index++) System.out.println(board[index]);
            backTracking(board, visited, boxX, boxY, boxX, boxY - 1,
                    targetX, targetY, currentStep + moveLeft + 1);
            board[boxX][boxY] = '0';
            board[boxX][boxY - 1] = temp;
        }
        if (moveRight != Integer.MAX_VALUE) {
//            System.out.println("move right, personX: " + personX + ",personY: " + personY + ",boxX: " + boxX
//                    + ",boxY:" + boxY);
            char temp = board[boxX][boxY + 1];
            board[boxX][boxY] = '.';
            board[boxX][boxY + 1] = '0';
//            for(int index=0; index<board.length;index++) System.out.println(board[index]);
            backTracking(board, visited, boxX, boxY, boxX, boxY + 1,
                    targetX, targetY, currentStep + moveRight + 1);
            board[boxX][boxY] = '0';
            board[boxX][boxY + 1] = temp;
        }
        visited[boxX][boxY] = false;

    }

    private static int getSteps(char[][] board, boolean[][] personVisited, int personX, int personY,
                                int boxX, int boxY, int direction, int step) {

        if (personVisited[personX][personY]) {
//            System.out.println("personX: "+personX+",personY: "+personY +", visited");
            return Integer.MAX_VALUE;
        }
        //以推上为例 1.箱子下边是#或越界 2.箱子上边是#或越界 3.人物不可达箱子下边
        if (direction == 0 || direction == 1) {
            if (boxX + 1 >= board.length || board[boxX + 1][boxY] == '#'
                    || boxX - 1 < 0 || board[boxX - 1][boxY] == '#') {
                return Integer.MAX_VALUE;
            }
        }
        if (direction == 2 || direction == 3) {
            if (boxY + 1 >= board[0].length || board[boxX][boxY + 1] == '#'
                    || boxY - 1 < 0 || board[boxX][boxY - 1] == '#') {
                return Integer.MAX_VALUE;
            }
        }
//        System.out.println("personX: " + personX + ",personY: " + personY);

        //到达目的地
        if (direction == 0 && personX == boxX + 1 && personY == boxY) {
//            System.out.println(step);
            return step;
        }
        if (direction == 1 && personX == boxX - 1 && personY == boxY) {
//            System.out.println(step);
            return step;
        }
        if (direction == 2 && personX == boxX && personY == boxY + 1) {
//            System.out.println(step);
            return step;
        }
        if (direction == 3 && personX == boxX && personY == boxY - 1) {
//            System.out.println(step);
            return step;
        }
        personVisited[personX][personY] = true;
        int min = Integer.MAX_VALUE;
        //上下左右移动
        if (personX - 1 >= 0 && board[personX - 1][personY] != '#' && board[personX - 1][personY] != '0') {
            min = Math.min(min, getSteps(board, personVisited,
                    personX - 1, personY, boxX, boxY, direction, step + 1));
        }
        if (personX + 1 < board.length && board[personX + 1][personY] != '#' && board[personX + 1][personY] != '0') {
            min = Math.min(min, getSteps(board, personVisited,
                    personX + 1, personY, boxX, boxY, direction, step + 1));
        }
        if (personY - 1 >= 0 && board[personX][personY - 1] != '#' && board[personX][personY - 1] != '0') {
            min = Math.min(min, getSteps(board, personVisited,
                    personX, personY - 1, boxX, boxY, direction, step + 1));
        }
        if (personY + 1 < board[0].length && board[personX][personY + 1] != '#' && board[personX][personY + 1] != '0') {
            min = Math.min(min, getSteps(board, personVisited,
                    personX, personY + 1, boxX, boxY, direction, step + 1));
        }
        personVisited[personX][personY] = false;


        return min;
    }
}
