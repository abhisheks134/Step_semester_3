package week_2.assignment_problems;

import java.util.*;

public class StopWordFilteredWordFrequency
{
    static void printFilteredWordFrequency(String feedback)
    {
        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split into words
        String[] words = feedback.split("\\s+");

        // Stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        // HashMap for frequency
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words)
        {
            boolean isStopWord = false;

            // Check whether word is a stop word
            for (String stopWord : stopWords)
            {
                if (word.equals(stopWord))
                {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord)
            {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        // Sort entries by frequency in descending order
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        // Print result
        for (Map.Entry<String, Integer> entry : list)
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}