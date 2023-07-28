//Code Implementation:
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Wordcounter {
    private static final String[] COMMON_WORDS = {
            "the", "and", "a", "an", "in", "on", "at", "of", "to", "for", "with", "is", "it"
            // Add more common words if needed
    };

    public static void main(String[] args) {
        String text = readInputText();
        if (text != null) {
            int totalWords = countWords(text);
            int uniqueWords = countUniqueWords(text);
            Map<String, Integer> wordFrequency = calculateWordFrequency(text);

            System.out.println("Total number of words: " + totalWords);
            System.out.println("Number of unique words: " + uniqueWords);
            System.out.println("Word frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    private static String readInputText() {
        System.out.println("Enter the text or provide a file path to count the words:");
        try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
            String input = br.readLine().trim();
            if (input.isEmpty()) {
                System.out.println("Empty input. Please provide some text or a file path.");
                return null;
            }

            if (input.endsWith(".txt")) {
                return readTextFromFile(input);
            } else {
                return input;
            }
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
            return null;
        }
    }

    private static String readTextFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+|\\p{Punct}");
        return words.length;
    }

    private static int countUniqueWords(String text) {
        String[] words = text.split("\\s+|\\p{Punct}");
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            if (!isCommonWord(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequency.size();
    }

    private static boolean isCommonWord(String word) {
        for (String commonWord : COMMON_WORDS) {
            if (word.equalsIgnoreCase(commonWord)) {
                return true;
            }
        }
        return false;
    }

    private static Map<String, Integer> calculateWordFrequency(String text) {
        String[] words = text.split("\\s+|\\p{Punct}");
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            if (!isCommonWord(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequency;
    }
}
