package extra;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersByTheNumerOf1Bits_1356 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
         *
         * 如果存在多个数字二进制中1的数目相同，则必须将它们按照数值大小升序排列。
         *
         * 请你返回排序后的数组。
         *
         * @param arr 待排序数组
         * @return 排序后的数组
         */
        public int[] sortByBits(int[] arr) {
            return Arrays.stream(arr).boxed()
                    .sorted(new Comparator<Integer>(){
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            int cnt1 = cntInt(o1);
                            int cnt2 = cntInt(o2);
                            return (cnt1 == cnt2) ? Integer.compare(o1, o2) : Integer.compare(cnt1, cnt2);
                        }
                    })
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        public int cntInt(int num) {
            // int cnt = 0;
            // while(num > 0) {
            //     if(num % 2 == 1) cnt++;
            //     num = num / 2;
            // }

            // return cnt;
            int count = 0;
            while(num > 0) {
                num = num & (num - 1);
                count ++;
            }

            return count;
        }
    }
}
