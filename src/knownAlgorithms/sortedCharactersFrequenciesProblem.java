package knownAlgorithms;

import java.util.HashMap;
import java.util.Map;

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

    public static int[][] sortWith2DArray(HashMap<Character, Integer> freqMap) {
        int[][] sort2DArray = new int[freqMap.size()][2];
        int i = 0;
        for (Map.Entry<Character, Integer> dataMap : freqMap.entrySet()) {
            sort2DArray[i][0] = dataMap.getKey();
            sort2DArray[i][1] = dataMap.getValue();
            i++;
        }
        return sort2DArray;
    }

    // marge Sort Algorithm
    public static int[][] sort(int[][] toSort2DArray, int start, int end) {
        if (end <= start) {
            return toSort2DArray;
        }
        int midPoint = (end + start) / 2;
        sort(toSort2DArray, start, midPoint);
        sort(toSort2DArray, midPoint + 1, end);
        marge(toSort2DArray, start, midPoint, end);
        return toSort2DArray;

    }

    public static void marge(int[][] toSort2DArray, int start, int midPoint, int end) {
        int i, j, k;
        int lengthOfLeftArray = midPoint - start + 1;
        int lengthOfRightArray = end - midPoint;
        int[][] LeftArray = new int[lengthOfLeftArray][2];
        int[][] RightArray = new int[lengthOfRightArray][2];
        for (i = 0; i < LeftArray.length; i++) {
            LeftArray[i][0] = toSort2DArray[start + i][0];
            LeftArray[i][1] = toSort2DArray[start + i][1];
        }
        for (j = 0; j < RightArray.length; j++) {
            RightArray[j][0] = toSort2DArray[midPoint + 1 + j][0];
            RightArray[j][1] = toSort2DArray[midPoint + 1 + j][1];
        }
        j = 0;
        i = 0;
        k = start;

        while (i < lengthOfLeftArray && i < lengthOfRightArray) {
            if (LeftArray[i][1] <= RightArray[j][1]) {
                toSort2DArray[k][0] = LeftArray[i][0];
                toSort2DArray[k][1] = LeftArray[i][1];
                i++;
            } else {
                toSort2DArray[k][0] = RightArray[j][0];
                toSort2DArray[k][1] = RightArray[j][1];
                j++;
            }
            k++;
        }

        while (i < lengthOfLeftArray) {

            toSort2DArray[k][0] = LeftArray[i][0];
            toSort2DArray[k][1] = LeftArray[i][1];
            i++;
            k++;
        }

        while (j < lengthOfRightArray) {
            toSort2DArray[k][0] = RightArray[j][0];
            toSort2DArray[k][1] = RightArray[j][1];
            j++;
            k++;
        }

    }

}
