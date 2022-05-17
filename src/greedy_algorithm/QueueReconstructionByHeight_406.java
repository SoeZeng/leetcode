package greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class QueueReconstructionByHeight_406 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int len = Integer.parseInt(in.nextLine());
            int[][] people = new int[len][2];
            for (int i = 0; i < len; i++) {
                String s = in.nextLine();
                String[] arr = s.split(",");
                people[i][0] = Integer.parseInt(arr[0]);
                people[i][1] = Integer.parseInt(arr[1]);
            }
            int[][] ans = sol.reconstructQueue(people);
            System.out.print("[");
            for (int i = 0; i < len; i++) {
                System.out.print("[" + ans[i][0] + "," + ans[i][1] + "]");
                if(i < len - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
    static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people,(a, b) -> {
                if(a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];
            });

            LinkedList<int[]> que = new LinkedList<>();
            for(int[] p : people) {
                que.add(p[1],p);
            }

            return que.toArray(new int[people.length][]);
        }
    }
}
