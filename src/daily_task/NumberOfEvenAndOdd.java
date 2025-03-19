package daily_task;

/**
 * 给你一个 正 整数 n 。
 * 用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。
 * 用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。
 * 请注意，在数字的二进制表示中，位下标的顺序 从右到左。
 * 返回整数数组 answer ，其中 answer = [even, odd] 。
 */
public class NumberOfEvenAndOdd {

}

class Solution2595 {

    public int[] evenOddBit(int n) {

//        int even = 0;
//        int odd = 0;
//
//        int idx = 0;
//        while(n > 0) {
//            if(n % 2 == 1) {
//                if(idx % 2 == 0) even++;
//                else odd++;
//            }
//            n /= 2;
//            idx++;
//        }
//
//        return new int[]{even, odd};


        int[] ans = new int[2];
        for (int i = 0; n > 0; n >>= 1) {
            ans[i] += n & 1;
            i ^= 1; // 切换奇偶
        }
        return ans;

    }

}