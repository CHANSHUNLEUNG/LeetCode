package Questions.tree.question208;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    //    private char val;
//    private List<Trie> nextList;
//    private boolean end;
//
//    public Trie() {
//        this.nextList = new ArrayList<>();
//        end = false;
//    }
//
//    public void insert(String word) {
//        Trie current = this;
//        for (char character : word.toCharArray()) {
//            boolean found = false;
//            for (Trie next : current.nextList) {
//                if (next.val == character) {
//                    current = next;
//                    found = true;
//                    break;
//                }
//            }
//            if (found) {
//                continue;
//            }
//            Trie next = new Trie();
//            next.val = character;
//            current.nextList.add(next);
//            current = next;
//        }
//        current.end = true;
//    }
//
//    public boolean search(String word) {
//        Trie current = this;
//        int count = 0;
//        for (char character : word.toCharArray()) {
//            for (Trie next : current.nextList) {
//                if (next.val == character) {
//                    current = next;
//                    count++;
//                    break;
//                }
//            }
//        }
//        if (count == word.length() && current.end) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean startsWith(String prefix) {
//        Trie current = this;
//        int count = 0;
//        for (char character : prefix.toCharArray()) {
//            for (Trie next : current.nextList) {
//                if (next.val == character) {
//                    current = next;
//                    count++;
//                    break;
//                }
//            }
//        }
//        if (count == prefix.length()) {
//            return true;
//        }
//        return false;
//    }
    private class Node {
        Node[] node = new Node[26];
        boolean isLeaf;
    }

    private Node node = new Node();

    public Trie() {

    }

    public void insert(String word) {
        insert(word, node);
    }

    private void insert(String word, Node node) {
        if (node == null) {
            return;
        }
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.node[index] == null) {
            node.node[index] = new Node();
        }
        insert(word.substring(1), node.node[index]);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }

    public boolean search(String word) {
        return search(word, this.node);
    }

    private boolean search(String word, Node node) {
        if (node == null) {
            return false;
        }
        if (word.length() == 0) {
            return node.isLeaf;
        }
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), node.node[index]);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, this.node);
    }

    private boolean startsWith(String prefix, Node node) {
        if (node == null) {
            return false;
        }
        if (prefix.length() == 0) {
            return true;
        }
        int index = indexForChar(prefix.charAt(0));
        return startsWith(prefix.substring(1), node.node[index]);
    }
}
