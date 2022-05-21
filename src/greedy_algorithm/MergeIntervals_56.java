package greedy_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals_56 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int len = Integer.parseInt(in.nextLine());
            int[][] intervals = new int[len][];
            for(int i = 0; i < len; i++) {
                String s = in.nextLine();
                String[] arr = s.split(",");
                intervals[i] = new int[arr.length];
                for(int j = 0; j < arr.length; j++) {
                    intervals[i][j] = Integer.parseInt(arr[j]);
                }
            }
            int[][] ans = sol.merge(intervals);
            System.out.print("[");
            for (int i = 0; i < ans.length; i++) {
                System.out.print("[" + ans[i][0] + "," + ans[i][1] + "]");
                if(i < ans.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    static class Solution {
        /**
         * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
         * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
         *
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals,(a, b) -> {
                return a[0] - b[0];
            });
            List<int[]> list = new ArrayList<>();
            list.add(intervals[0]);
            for(int i = 1; i < intervals.length; i++) {
                int[] temp = list.get(list.size() - 1);
                if(intervals[i][0] <= temp[1]) {
                    // list.remove(list.size() - 1);
                    temp[1] = Math.max(temp[1],intervals[i][1]);
                    // list.add(intervals[i]);
                } else {
                    list.add(intervals[i]);
                }
            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
