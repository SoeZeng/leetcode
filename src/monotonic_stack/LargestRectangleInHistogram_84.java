package monotonic_stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class LargestRectangleInHistogram_84 {

    public static void main(String[] args) {
        Solution84 sol = new Solution84();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] height = new int[arr.length];
            for (int i = 0; i < height.length; i++) {
                height[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.largestRectangleArea(height);
            System.out.println(ans);
        }
    }
}


class Solution84 {
    public int largestRectangleArea(int[] heights) {

        int ans = 0;


        /**
         * 双指针法：超时
         */
        for(int i = 0; i < heights.length; i++) {
            int left = i;
            for(; left >= 0; left--) {
                if(heights[left] < heights[i]) break;
            }

            int right = i;
            for(; right < heights.length; right++) {
                if(heights[right] < heights[i]) break;
            }

            int area = heights[i] * (right - left - 1);
            if(ans < area) ans = area;
        }


        /**
         * 动态规划
         */
        int[] leftIndex = new int[heights.length];
        int[] rightIndex = new int[heights.length];

        // 记录每个柱子 左边第一个小于该柱子的下标
        leftIndex[0] = -1;
        for(int i = 1; i < heights.length; i++) {
            int index = i - 1;
            while(index >= 0 && heights[i] <= heights[index]) {
                index = leftIndex[index];
            }
            leftIndex[i] = index;
        }

        // 记录每个柱子 右边第一个大于该柱子的下标
        rightIndex[heights.length - 1] = heights.length;
        for(int i = heights.length - 2; i >= 0; i--) {
            int index = i + 1;
            while(index < heights.length && heights[i] <= heights[index]) {
                index = rightIndex[index];
            }
            rightIndex[i] = index;
        }

        for(int i = 0; i < heights.length; i++) {
            int area = heights[i] * (rightIndex[i] - leftIndex[i] - 1);
            if(ans < area) ans = area;
        }

        /**
         * 单调栈
         */
        int[] newHeights = new int[heights.length + 2]; // 数组扩容
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for(int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        Deque<Integer> stack = new LinkedList<>();
        int res = newHeights[0];
        stack.push(0);

        for(int i = 1; i < newHeights.length; i++) {
            while(newHeights[i] < newHeights[stack.peek()]) {
                int mid = stack.peek();
                stack.pop();
                if(!stack.isEmpty()) {
                    int h = newHeights[mid];
                    int w = i - stack.peek() - 1;
                    if(ans < h * w) ans = h * w;
                }
            }
            stack.push(i);
        }


        return ans;

    }
}
