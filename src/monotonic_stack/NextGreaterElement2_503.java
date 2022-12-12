package monotonic_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class NextGreaterElement2_503 {

    public static void main(String[] args) {
        Solution503 sol = new Solution503();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr1 = str.split(",");
            int[] nums = new int[arr1.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr1[i]);
            }
            int[] ans = sol.nextGreaterElements(nums);
            System.out.print("[");
            for (int i = 0; i < ans.length - 1; i++) {
                System.out.print(ans[i] + ",");
            }
            System.out.println(ans[ans.length - 1] + "]");
        }
    }
}

class Solution503 {

    /**
     * 定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），
     * 返回 nums 中每个元素的 下一个更大元素 。
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

//            for(int i = 1; i < nums.length; i++) {
//                while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
//                    ans[stack.peek()] = nums[i];
//                    stack.pop();
//                }
//                stack.push(i);
//            }
//            for(int i = 0; i < nums.length - 1; i++) {
//                while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
//                    ans[stack.peek()] = nums[i];
//                    stack.pop();
//                }
//                stack.push(i);
//            }
        for(int i = 1; i < nums.length * 2; i++) {
            while(!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                ans[stack.peek()] = nums[i % nums.length];
                stack.pop();
            }
            stack.push(i % nums.length);
        }

        return ans;
    }
}
