package string;

public class ReverseWordsInAString_151 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
         *
         * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
         *
         * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
         *
         * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
         * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
         *
         * @param s
         * @return
         */
        public String reverseWords(String s) {
//            String[] strs = s.split(" "); // " hello world " --> ["","","hello","world"] why?
//
//
//            StringBuilder strb = new StringBuilder();
//            for(int i = 0; i < strs.length; i++) {
//                if(strs[i].length() == 0) continue;
//
//                strb.append(reverse(strs[i]));
//                if(i < strs.length - 1) strb.append(" ");
//            }
//
//            return reverse(strb.toString());

            /**
             * 不使用Java内置方法实现
             * <p>
             * 1.去除首尾以及中间多余空格
             * 2.反转整个字符串
             * 3.反转各个单词
             */
            // 移除多余空格
            StringBuilder strb = removeSpace(s);

            // 翻转字符串
            reverseString(strb, 0, strb.length() - 1);

            // 翻转单词
            reverseWord(strb);

            return strb.toString();

        }

        public StringBuilder removeSpace(String s) {
            char[] chars = s.toCharArray();
            StringBuilder str = new StringBuilder();
            int start = 0;
            int end = chars.length - 1;

            while(chars[start] == ' ') start++;
            while(chars[end] == ' ') end--;

            for(int i = start; i <= end; i++) {
                if(i > 0 && chars[i] == ' ' && chars[i] == chars[i - 1]) {
                    continue;
                } else {
                    str.append(String.valueOf(chars[i]));
                }
            }

            return str;
        }

        public void reverseString(StringBuilder str, int start, int end) {
            while(start < end) {
                char temp = str.charAt(start);
                str.setCharAt(start,str.charAt(end));
                str.setCharAt(end, temp);
                start++;
                end--;
            }
        }

        public void reverseWord(StringBuilder str) {
            int start = 0;
            int end = 1;

            while(end < str.length()) {
                if(str.charAt(end) == ' ') {
                    reverseString(str,start,end - 1);
                    start = end + 1;
                }
                end++;
            }
            reverseString(str, start, end - 1);
        }

        public String reverse(String s) {
            char[] chars = s.toCharArray();
            int start = 0;
            int end = chars.length - 1;
            while(start < end) {
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];
                start++;
                end--;
            }
            return new String(chars);
        }
    }
}
