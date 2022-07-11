package hash_table;

import java.util.HashMap;
import java.util.Map;

public class FourSum_454 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
         *
         * 0 <= i, j, k, l < n
         * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
         *
         * @param nums1
         * @param nums2
         * @param nums3
         * @param nums4
         * @return
         */
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int n = nums1.length;
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int temp = nums1[i] + nums2[j];
                    if(!map.containsKey(temp)) map.put(temp,1);
                    else map.put(temp, map.get(temp) + 1);
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int temp = -(nums3[i] + nums4[j]);
                    if(map.containsKey(temp)) {
                        ans += map.get(temp);
                    }
                }
            }

            return ans;
        }
    }
}
