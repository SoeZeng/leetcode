public class PalindromeNumber_9 {
    public static void main(String[] args) {

    }
}

class Solution9 {
    /**
     *
     * @param x 整数 x
     * @return 是否是回文数，若是返回true
     */
    public boolean isPalindrome(int x) {

        // 转换成字符串
//        String s = x + "";
//        char[] chars = s.toCharArray();
//
//        for(int i = 0, j = chars.length - 1; i < j; i++, j--) {
//            if(chars[i] != chars[j]) return false;
//        }

//        return true;


        if(x < 0) return false;

        int y = 0;
        int rem = 0; // 余数
        int quo = x; // 商
        while(quo != 0) {
            rem = quo % 10;
            y = y * 10 + rem;
            quo /= 10;
        }

        return x == y;

    }
}
