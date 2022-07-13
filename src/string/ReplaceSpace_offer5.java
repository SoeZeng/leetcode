package string;

import java.util.Scanner;

public class ReplaceSpace_offer5 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = sol.replaceSpace(in.nextLine());
            System.out.println(s);

        }
    }

    static class Solution {
        /**
         * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
         *
         * @param s
         * @return
         */
        public String replaceSpace(String s) {

            /**
             * 使用一个新的对象，复制 str，复制的过程对其判断，是空格则替换，否则直接复制，类似于数组复制
             */
//            char[] chars = s.toCharArray();
//            StringBuilder str = new StringBuilder();
//            for(char c : chars) {
//                if(c == ' ') {
//                    str.append("%20");
//                } else {
//                    str.append(String.valueOf(c));
//                }
//            }
//
//            return str.toString();

            /**
             * 双指针法
             */
            char[] chars = s.toCharArray();
            StringBuilder str = new StringBuilder();

            for(char c : chars) {
                if(c == ' ') {
                    str.append("  ");
                }
            }

            if(str.length() == 0) return s;

            int left = s.length() - 1; // 左指针，指向原字符串最后一个位置
            s += str.toString();
            int right = s.length() - 1; // 右指针，指向扩充后的字符串最后一个位置
            chars = s.toCharArray();
            while(left >= 0) {
                if(chars[left] == ' ') {
                    chars[right--] = '0';
                    chars[right--] = '2';
                    chars[right--] = '%';
                } else {
                    chars[right--] = chars[left];
                }
                left--;
            }

            return new String(chars);

        }
    }
}
