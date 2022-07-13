package string;

public class ReverseString_541 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
         *
         * 如果剩余字符少于 k 个，则将剩余字符全部反转。
         * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
         *
         * @param s
         * @param k
         * @return
         */
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            // int start = 0;
            // while(start + 2 * k - 1< chars.length) {
            //     reverse(chars,start,start+k-1);
            //     start += 2 * k;
            // }
            // reverse(chars,start,end);
            for(int i = 0; i < chars.length; i += 2 * k){
                int start = i;
                //这里是判断尾数够不够k个来取决end指针的位置
                int end = Math.min(chars.length - 1, start + k - 1);
                //用异或运算反转
                reverse(chars, start, end);
            }

            return new String(chars);
        }

        public void reverse(char[] s, int start, int end) {
//            if(end >= s.length) end = s.length - 1;

            while(start < end) {
                s[start] ^= s[end];
                s[end] ^= s[start];
                s[start] ^= s[end];
                start++;
                end--;
            }
        }
    }
}
