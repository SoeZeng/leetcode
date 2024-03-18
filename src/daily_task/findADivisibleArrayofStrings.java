package daily_task;

/**
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 *      如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 *      否则，div[i] = 0
 * 返回 word 的可整除数组。
 **/

public class findADivisibleArrayofStrings {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] dev = new int[n];
        long temp = 0;
        for (int i = 0; i < n; i++) {
            // int temp = Integer.parseInt(word.substring(0, i + 1));
            // long temp = Long.parseLong(word.substring(0, i + 1));

            // 注意数据溢出！！！将数字每次都对m取余数，取余数后再加数位不改变取余结果的
            temp = (temp * 10 + word.charAt(i) - '0') % m;
            dev[i] = temp % m == 0 ? 1 : 0;

        }
        return dev;
    }
}
