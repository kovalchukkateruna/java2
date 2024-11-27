import java.util.*;

public class TextProcessor {

    public static void main(String[] args) {
        StringBuffer text = new StringBuffer(
            "This is a test test. Is this a a test? This is not a drill. This test is is important."
        );

        int result = findSentencesWithDuplicateWords(text);
        System.out.println(result);
    }

    public static int findSentencesWithDuplicateWords(StringBuffer text) {
        String[] sentences = text.toString().split("(?<=[.!?])");
        int count = 0;

        for (String sentence : sentences) {
            String cleanedSentence = sentence.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").trim();
            String[] words = cleanedSentence.split("\\s+");
            Set<String> uniqueWords = new HashSet<>();
            boolean hasDuplicates = false;

            for (String word : words) {
                if (!uniqueWords.add(word)) {
                    hasDuplicates = true;
                    break;
                }
            }

            if (hasDuplicates) {
                count++;
            }
        }

        return count;
    }
}
