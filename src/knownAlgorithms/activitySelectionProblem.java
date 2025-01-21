package knownAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class activitySelectionProblem {

    public static void main(String[] args) {
        int[] start = {9, 10, 11, 12, 13, 15};
        int[] end = {11, 11, 12, 14, 15, 16};

        System.err.println(activitySelection(start, end));

    }

    static public ArrayList<Integer> activitySelection(int[] start, int[] end) {
        ArrayList<Integer> res = new ArrayList<>();

        if (start.length == end.length) {
            Arrays.sort(end);
            int i = 1;
            int j = 0;

            for (; i < start.length; i++) {
                if (start[i] >= end[j]) {
                    res.add(i);
                    j = i;
                }
            }

        }
        return res;
    }

}
