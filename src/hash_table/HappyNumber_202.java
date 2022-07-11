package hash_table;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyNumber_202 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            boolean ans = sol.isHappy(n);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 编写一个算法来判断一个数 n 是不是快乐数。
         *
         * 「快乐数」定义为：
         *
         * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
         * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
         * 如果这个过程 结果为 1，那么这个数就是快乐数。
         * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
         *
         * @param n
         * @return
         */
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            int val = n;

            while(true) {
                if(val == 1) return true;
                if(set.contains(val)) return false;
                set.add(val);
                int temp = val;
                val = 0;
                while(temp > 0) {
                    val += (temp % 10) * (temp % 10);
                    temp = temp / 10;
                }
            }

        }
    }
}
