import java.util.*;
import java.lang.*;

public class WordBreakProblem {
    public static void main(String[] args) {
        String[] entries = new String[]{"i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango"};
        Trie trie = new Trie();
        List<String> entry = new ArrayList<>(Arrays.asList(entries[1].split("")));
        reverseArray(entry);
//        for (String value: entry) {
//            System.out.println(value);
//
//        }

        addWord(trie, entry);
        System.out.println(trie);
//        System.out.println(trie);
//        List<String> anotherEntry = new ArrayList<>(Arrays.asList(entries[1].split("")));
//        reverseArray(anotherEntry);

//        showTrie(trie, anotherEntry);
    }

    private static void showTrie(Trie trie, List<String> anotherEntry) {
        if (anotherEntry.size() > 0) {
            String keyForSearch = anotherEntry.remove(anotherEntry.size() - 1);
            Trie nextTrie = trie.currentEntries.get(keyForSearch);
            System.out.println(nextTrie.letter);
            showTrie(nextTrie, anotherEntry);
        } else {
            System.out.println(trie.isWord);
        }
    }

    private static void reverseArray(List<String> entry) {
        boolean running = true;
        int index = 0, endIndex = (entry.size() - 1);
//        System.out.println(endIndex);

        while (running) {
            if (index >= endIndex) {
                running = false;
                continue;
            }

            String temp = entry.get(index);
            entry.set(index, entry.get(endIndex));
            entry.set(endIndex, temp);

            index++;
            endIndex--;
        }
    }

    private static void addWord(Trie trie, List<String> entry) {
        if (entry.size() > 0) {
            String keyForSearch = entry.remove(entry.size() - 1);
            Trie nextTrie;
//            System.out.println(keyForSearch);
            if (!trie.currentEntries.containsKey(keyForSearch)) {
                nextTrie = new Trie();
                nextTrie.letter = keyForSearch;
//                System.out.println(nextTrie.letter);
                trie.currentEntries.put(keyForSearch, nextTrie);
            } else {
                nextTrie = trie.currentEntries.get(keyForSearch);
            }
            addWord(nextTrie, entry);
        } else {
            trie.isWord = true;
        }
    }
}

class Trie {
    public Map<String, Trie> currentEntries;
    public boolean isWord = false;
    public String letter = "";
    Trie() {
        this.currentEntries = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Trie{" +
                "isWord=" + isWord +
                ", letter='" + letter + '\'' + "\n" +
                ", currentEntries=" + currentEntries +
                '}';
    }
}