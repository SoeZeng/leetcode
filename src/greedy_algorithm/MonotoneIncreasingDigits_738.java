package greedy_algorithm;

import java.util.Scanner;

public class MonotoneIncreasingDigits_738 {

    public static void main(String[] args) {
        Solution738 sol = new Solution738();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int ans = sol.monotoneIncreasingDigits(n);
            System.out.println(ans);
        }
    }

}

class Solution738 {
    /**
     * 当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。
     *
     * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
//            if(n / 10 == 0) return n;
//            int cur = n % 10;
//            int k = 0;
//            int ans = 0;
//
//            n = n / 10;
//            while(n > 0) {
//                int pre = n % 10;
//                if(cur < pre) {
//                    ans = (int) Math.pow(10,k+1) - 1;
//                    cur = pre - 1;
//                } else {
//                    ans += (int)cur * Math.pow(10,k);
//                    cur = pre;
//                }
//                n = n / 10;
//                k++;
//            }
//            ans += (int)cur * Math.pow(10,k);
//            return ans;

        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();

        // 若是从前向后遍历，遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]减一，但此时如果strNum[i - 1]减一了，可能又小于strNum[i - 2]
        // 例如， 332 -> 329，此时2又小于3了，需要重新定位第一个峰值
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i+1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));


    }
}
