package knownAlgorithms;

import java.util.HashMap;

public class sortedCharactersFrequenciesProblem {

    public static void main(String[] args) {
        String message = "hello world";
        ASCIIMethod(message);
        System.out.println("==========================");
        hashMethod(message);

    }

    public static void ASCIIMethod(String message) {
        int[] freq = new int[127];

        for (int i = 0; i < message.length(); i++) {
            int currentCode = message.charAt(i);
            freq[currentCode]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                char c = (char) i;
                System.out.print(c + " ");
                System.out.println(freq[i]);
            }

        }

    }

    public static void hashMethod(String message) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
        }
        for (char c : freqMap.keySet()) {
            System.out.print(c + " ");
            System.out.println(freqMap.get(c));
        }

    }

}
