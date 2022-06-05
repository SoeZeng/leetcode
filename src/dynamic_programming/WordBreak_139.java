package dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordBreak_139 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String str = in.nextLine();
            String[] arr = str.split(",");
            List<String> wordDict = new ArrayList<>();
            for(String st : arr) {
                wordDict.add(st);
            }
            boolean ans = sol.wordBreak(s, wordDict);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
         *
         * @param s
         * @param wordDict
         * @return
         */
        public boolean wordBreak(String s, List<String> wordDict) {

            /**
             * 方法一：回溯
             */
            boolean[] memory = new boolean[s.length()];
            for (int i = 0; i < memory.length; i++) {
                memory[i] = true;
            }
            return backTracing(s, wordDict, memory, 0);


            /**
             * 方法二 ：动规
             */
//            // dp[i]表示字符串长度为i时是否能被字典中的单词覆盖
//            int[] dp = new int[s.length() + 1];
//
//            // 初始化
//            dp[0] = 1;
//
//            // 遍历顺序：先遍历背包，再遍历物品。因为必须要保证字符串是被顺序覆盖的
//            for(int j = 0; j <= s.length(); j++) {
//                for(int i = 0; i < wordDict.size(); i++) {
//                    String str = wordDict.get(i);
//                    int len = str.length();
//                    if(j >= len && dp[j - len] == 1 && str.equals(s.substring(j - len,j))) {
//                        dp[j] = 1;
//                    }
//                }
//            }
//            return dp[s.length()] == 1 ? true : false;
        }

        public boolean backTracing(String s, List<String> wordDict, boolean[] memory, int startIndex) {
            if (startIndex >= s.length()) {
                return true;
            }

            if(!memory[startIndex]) return memory[startIndex];
            for(int i = startIndex + 1; i <= s.length(); i++) {
                String str = s.substring(startIndex, i);
                if(wordDict.contains(str) && backTracing(s, wordDict, memory, i)) {
                    return true;
                }
            }

            memory[startIndex] = false; // 记录以startIndex开始的子串是不可以被拆分的

            return false;
        }
    }
}
