package monotonic_stack;

import java.util.Scanner;

public class TrappingRainWater_42 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] height = new int[arr.length];
            for (int i = 0; i < height.length; i++) {
                height[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.trap(height);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水.
         *
         * @param height
         * @return
         */
        // public int trap(int[] height) {
        //     // 单调栈
        //     Deque<Integer> stack = new LinkedList<>();
        //     int ans = 0;
        //     stack.push(0);

        //     for(int i = 1; i < height.length; i++) {
        //         while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
        //             int mid = stack.peek();
        //             stack.pop();
        //             if(!stack.isEmpty()) {
        //                 int h = Math.min(height[stack.peek()], height[i]) - height[mid];
        //                 int w = i - stack.peek() - 1;
        //                 ans += h * w;
        //             }

        //         }
        //         stack.push(i);
        //     }

        //     return ans;
        // }

        // public int trap(int[] height) {
        //     // 双指针
        //     int ans = 0;

        //     for(int i = 1; i < height.length - 1; i++) {
        //         int left = height[i];
        //         int right = height[i];
        //         for(int l = i - 1; l >= 0; l--) {
        //             left = Math.max(left,height[l]);
        //         }
        //         for(int r = i + 1; r < height.length; r++) {
        //             right = Math.max(right,height[r]);
        //         }
        //         int h = Math.min(left, right) - height[i];
        //         if(h > 0) ans += h;
        //     }

        //     return ans;

        // }

        public int trap(int[] height) {
            // 动规
            int[] maxLeft = new int[height.length];
            int[] maxRight = new int[height.length];
            int ans = 0;

            // 记录每个柱子左边柱子的最大高度
            maxLeft[0] = height[0];
            for(int i = 1; i < height.length; i++) {
                maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
            }

            // 记录每个柱子右边柱子的最大高度
            maxRight[height.length - 1] = height[height.length - 1];
            for(int i = height.length - 2; i >= 0; i--) {
                maxRight[i] = Math.max(height[i], maxRight[i + 1]);
            }

            for(int i = 1; i < height.length - 1; i++) {
                int h = Math.min(maxLeft[i],maxRight[i]) - height[i];
                if(h > 0) ans += h;
            }

            return ans;
        }
    }
}
