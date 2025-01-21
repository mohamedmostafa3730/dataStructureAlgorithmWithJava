package knownAlgorithms;

import java.util.Arrays;
import java.util.HashMap;

public class validAnagramProblem {

//    Url of problem on leedCode.com => https://leetcode.com/problems/valid-anagram/
    public static void main(String[] args) {
        String nOne = "anagram";
        String nTwo = "nagaram";
        System.err.println(isAnagramByHashMap(nOne, nTwo));
    }

//  bySort => time( O(n log ⁡n) + O(m log ⁡m)) , memory(O(1) || O(n + m))
//                        the memory complicity depending on the sorting algorithm
    public static boolean isAnagramBySort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }
    
    
//  byHashMap => time(O(n+m)), memory(O(1))
//   the memory complicity => since we have at most 26 different characters
    public static boolean isAnagramByHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
    
}
