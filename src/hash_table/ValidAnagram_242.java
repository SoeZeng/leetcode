package hash_table;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Scanner;

public class ValidAnagram_242 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String t = in.nextLine();
            boolean ans = sol.isAnagram(s, t);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
         *
         * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {

            if(s.length() != t.length()) return false;

            int[] words = new int[26];
            for(int i = 0; i < s.length(); i++) {
                words[s.charAt(i) - 'a']++;
                words[t.charAt(i) - 'a']--;
            }

            for(int i = 0; i < words.length; i++) {
                if(words[i] != 0) return false;
            }

            return true;
        }
    }
}
