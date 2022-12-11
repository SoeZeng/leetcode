package monotonic_stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DailyTemperature_739 {

    public static void main(String[] args) {
        Solution739 sol = new Solution739();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr = str.split(",");
            int[] temperatures = new int[arr.length];
            for (int i = 0; i < temperatures.length; i++) {
                temperatures[i] = Integer.parseInt(arr[i]);
            }
            int[] ans = sol.dailyTemperatures(temperatures);
            System.out.print("[");
            for (int i = 0; i < ans.length - 1; i++) {
                System.out.print(ans[i] + ",");
            }
            System.out.println(ans[ans.length - 1] + "]");
        }
    }
}

class Solution739 {

    /**
     * 给定一个整数数组temperatures，表示每天的温度，
     * 返回一个数组answer，其中answer[i]是指在第 i 天之后，才会有更高的温度。
     * 如果气温在这之后都不会升高，请在该位置用0 来代替。
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        // 暴力
//             for(int i = 0; i < n; i++) {
//                 for(int j = i + 1; j < n; j++) {
//                     if(temperatures[j] > temperatures[i]) {
//                         answer[i] = j - i;
//                         break;
//                     }
//                 }
//             }
//
//             return answer;

        /**
         * 如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的更大的元素就是 当前遍历的元素，
         * 所以弹出 栈顶元素，并记录
         * 如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         * 否则的话，可以直接入栈。
         * 注意，单调栈里 加入的元素是 下标。
         */
//            Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return answer;

    }
}
