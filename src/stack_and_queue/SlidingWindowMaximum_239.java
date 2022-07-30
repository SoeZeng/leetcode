package stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum_239 {

    public static void main(String[] args) {
        Solution239 sol = new Solution239();
    }
}

class Solution239 {

    /**
     * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。
     * 滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        // 用Deque来实现单调队列，队列中元素从大到小（对头 -> 队尾）
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for(int i = 0; i < nums.length; i++) {
            // 队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // 既然是单调，就要保证每次放进去的数字要比末尾的都小，否则也弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if(i >= k - 1) {
                res[index++] = nums[deque.peek()];
            }
        }

        return res;
    }
}
