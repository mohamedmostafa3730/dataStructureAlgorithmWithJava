package knownAlgorithms;

public class sortedCharactersFrequenciesProblem {

    public static void main(String[] args) {
        String message = "hello world";
        ASCIIMethod(message);

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

}
