package Questions.Searching.question127;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int[] visited = new int[wordList.size()];
        int result = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int iterationSize = queue.size();
            result++;
            for (int index = 0; index < iterationSize; index++) {
                String currentString = queue.poll();
                for (int wordIndex = 0; wordIndex < wordList.size(); wordIndex++) {
                    String word = wordList.get(wordIndex);
                    if (visited[wordIndex] == 0 && canTransform(currentString, word)) {
                        if (word.equals(endWord)) {
                            return result;
                        }
                        queue.offer(word);
                        visited[wordIndex] = 1;
                    }
                }

            }
        }

        return 0;
    }

    public boolean canTransform(String beginWord, String endWord) {
        int diffCount = 0;
        for (int index = 0; index < beginWord.length(); index++) {
            if (beginWord.charAt(index) != endWord.charAt(index)) {
                diffCount++;
            }
        }
        return diffCount == 1 ? true : false;
    }

}
