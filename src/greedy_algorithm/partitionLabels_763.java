package greedy_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class partitionLabels_763 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            List<Integer> res = sol.partitionLabels(s);
            System.out.println(res.toString());

        }
    }

    static class Solution {
        /**
         * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
         * 返回一个表示每个字符串片段的长度的列表。
         *
         * @param s
         * @return
         */
        public List<Integer> partitionLabels(String s) {
//            List<Integer> res = new ArrayList<>();
//            char[] chars = s.toCharArray();
//            int start = 0;
//            while(start < chars.length) {
//                int end = s.lastIndexOf(String.valueOf(chars[start]));
//                for(int i = start + 1; i < end; i++) {
//                    end = Math.max(end,s.lastIndexOf(String.valueOf(chars[i])));
//                }
//                res.add(end - start + 1);
//                start = end + 1;
//            }
//            return res;

            List<Integer> res = new ArrayList<>();
            char[] chars = s.toCharArray();
            int[] hash = new int[26]; // 记录每一个字符出现的最后位置
            for(int i = 0; i < chars.length; i++) {
                hash[chars[i] - 'a'] = i;
            }
            int left = 0;
            int right = 0;
            for(int i = 0; i < chars.length; i++) {
                right = Math.max(right,hash[chars[i] - 'a']);
                if(i == right) {
                    res.add(right - left + 1);
                    left = right + 1;
                }
            }
            return res;
        }
    }
}
