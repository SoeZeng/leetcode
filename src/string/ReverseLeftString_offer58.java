package string;

public class ReverseLeftString_offer58 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         *
         * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
         *
         * @param s
         * @param n
         * @return
         */
        public String reverseLeftWords(String s, int n) {

            char[] chars = s.toCharArray();

            // 局部翻转
            reverse(chars,0,n - 1);
            reverse(chars,n,chars.length - 1);

            // 整体翻转
            reverse(chars,0,chars.length - 1);

            return new String(chars);
        }

        public void reverse(char[] s, int start, int end) {
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
