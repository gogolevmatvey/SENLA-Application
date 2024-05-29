package task3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");

        HashMap<String, Integer> wordAndVowelCount = new HashMap<String, Integer>();
        for (String word : words) {
            int vowelCount = countVowels(word);
            wordAndVowelCount.put(word, vowelCount);
        }

        ArrayList<String> sortedWords = new ArrayList<String>(wordAndVowelCount.keySet());
        sortedWords.sort(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return wordAndVowelCount.get(word2) - wordAndVowelCount.get(word1);
            }
        });

        for (String word : sortedWords) {
            System.out.println(capitalizeFirstVowel(word) + " " + wordAndVowelCount.get(word));
        }
    }

    private static int countVowels(String word) {
        int count = 0;
        for (char character : word.toCharArray()){
            if (isVowel(character))
                count++;
        }
        return count;
    }

    private static boolean isVowel(char character) {
        return "ёуеыаоэяиюЁУЕЫАОЭЯИЮ".indexOf(character) != -1;
    }

    private static String capitalizeFirstVowel(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i))) {
                return word.substring(0, i) + Character.toUpperCase(word.charAt(i)) + word.substring(i + 1);
            }
        }
        return word;
    }
}
