import java.util.*;
import java.lang.*;

public class LongestWord {
    private static String longestWord(String sentence) {
        if (!sentence.equals(null)) {
            if (!sentence.equals("")) {
                Map<Character, Integer> validCharacters = new HashMap<>();
                final int asciiCharactersLength = 255;
                for (int index = 0; index < asciiCharactersLength; index++) {
                    if (((index >= 'a') && (index <= 'z')) ||
                            ((index >= 'A') && (index <= 'Z'))) {
                        validCharacters.put((char) index, index);
                    }
                }

                ObjectPlaceHolder longestWord = new ObjectPlaceHolder(), currentWord = new ObjectPlaceHolder();
                char[] sentenceCharArray = sentence.toCharArray();
                for (char character: sentenceCharArray) {
                    if(validCharacters.containsKey(character)) {
                        currentWord.word += character;
                        currentWord.length += 1;
                    } else {
                        checkForLongestWord(currentWord, longestWord);
                        currentWord.word = "";
                        currentWord.length = 0;
                    }
                }
                checkForLongestWord(currentWord, longestWord);

                return longestWord.word;
            }
        }
        return sentence;
    }

    private static void checkForLongestWord(ObjectPlaceHolder currentWord, ObjectPlaceHolder longestWord) {
        if (currentWord.length > longestWord.length) {
            longestWord.word = currentWord.word;
            longestWord.length = currentWord.length;
        }
    }

    public static void main (String[] args) {
        final String sentence = "hello&&wor((ld**sucker";
        final String sentence2 = "";
        System.out.println(longestWord(sentence));
        System.out.println(longestWord(sentence2));
    }
}

class ObjectPlaceHolder {
    public String word = "";
    public Integer length = 0;
}
