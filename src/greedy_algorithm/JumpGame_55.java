package greedy_algorithm;

public class JumpGame_55 {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] nums = new int[]{3,0,8,2,0,0,1};
        int[] nums = new int[]{3,2,1,0,4};
        boolean result = sol.canJump(nums);
        System.out.println(result);
    }

    static class Solution {
        /**
         * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 .
         * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
         * 判断你是否能够到达最后一个下标。
         *
         * @param nums
         * @return
         */
        public boolean canJump(int[] nums) {
            int cover = 0;  // cover表示可达范围
            for(int i = 0; i <= cover; i++) {
                cover = Math.max(i+nums[i],cover);
                if(cover >= nums.length - 1) return true;
            }
            return false;
        }

        public boolean canJump1(int[] nums) {
            int next = nums[0]; // 记录下一跳的位置

            while(next < nums.length - 1) {
                // 如果下一跳位置的值等于0，表示无法再前进，需要回退
                if(nums[next] == 0) {
                    int temp = next;
                    while(next > 0 && next + nums[next] <= temp) {
                        next--;
                    }
                    if(next == 0) {
                        return false;
                    }
                }
                next += nums[next];
            }

            return true;
        }
    }
}
