package hash_table;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String[] arr1 = s1.split(",");
            String[] arr2 = s2.split(",");
            int[] nums1 = new int[arr1.length];
            int[] nums2 = new int[arr2.length];
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = Integer.parseInt(arr1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                nums2[i] = Integer.parseInt(arr2[i]);
            }
            int[] res = sol.intersection(nums1, nums2);
        }
    }

    static class Solution {

        /**
         * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            // List<Integer> list = new ArrayList<>();
            Set<Integer> temp = new HashSet<>();
            Set<Integer> set = new HashSet<>();

            for(int num : nums1) {
                temp.add(num);
            }

            for(int num : nums2) {
                if(temp.contains(num)) set.add(num);
            }

            int[] ans = new int[set.size()];
            int index = 0;
            for(int num : set) {
                ans[index++] = num;
            }

            return ans;

        }
    }
}
