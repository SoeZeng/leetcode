package extra;

public class NumbersSmallerThanTheCurrentNumber_1365 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
         *
         * @param nums
         * @return
         */
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] ans = new int[nums.length];

            /**
             * 暴力解法：时间复杂度 o(n)
             */
            for(int i = 0; i < nums.length; i++) {
                for(int j = 0; j < nums.length; j++) {
                    if(nums[j] < nums[i]) ans[i]++;
                }
            }

            /**
             * 桶思想：
             * 定义一排桶 int arr[101] , 其中 arr[i] 里存放数字 n 出现的次数
             * 遍历 nums，初始化桶数组 arr
             * 累加处理桶数组arr ， 使得 arr[i] 表示比 i 小的数字的个数
             * 最后遍历 nums ，取出对应桶里的结果即可。
             */
            int[] arr = new int[101];

            for(int num : nums) {
                arr[num]++;
            }

            int cnt = 0;
            for(int i = 0; i <= 100; i++) {
                int temp = arr[i];
                arr[i] = cnt;
                cnt += temp;
            }

            for(int i = 0; i < nums.length; i++) {
                ans[i] = arr[nums[i]];
            }

            return ans;
        }
    }
}
