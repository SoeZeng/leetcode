package daily_task;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 */
public class NextGreaterElement2_503 {

}

/**
 * 可以遍历一次数组，如果元素是单调递减的（则他们的「下一个更大元素」相同），我们就把这些元素保存，直到找到一个较大的元素；把该较大元素逐一跟保存了的元素比较，
 * 如果该元素更大，那么它就是前面元素的「下一个更大元素」  --> 单调递减栈
 *
 */
class Solution503{
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < n * 2; i++) {
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % n];
                stack.pop();
            }
            stack.push(i % n);
        }

        return res;
    }
}
