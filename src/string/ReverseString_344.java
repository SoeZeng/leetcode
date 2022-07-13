package string;

public class ReverseString_344 {

    public static void main(String[] args) {

    }

    static class Solution {
        /**
         * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
         *
         * @param s
         */
        public void reverseString(char[] s) {

            for(int i = 0, j = s.length - 1; i < j; i++, j--) {
                char c = s[i];
                s[i] = s[j];
                s[j] = c;
            }

//            int l = 0;
//            int r = s.length - 1;
//            while (l < r) {
//                s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
//                s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
//                s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
//                l++;
//                r--;
//            }
        }
    }
}
