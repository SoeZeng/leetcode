package daily_task;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 *
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 *
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 */
public class BaseballGame_682 {

}

class Solution682 {
    public int calPoints(String[] operations) {
        // 栈
//        Stack<Integer> nums = new Stack<>();
//        for(String operation : operations) {
//            char c = operation.charAt(0);
//            if(c == '+') {
//                int y = nums.pop();
//                int x = nums.peek();
//                nums.push(y);
//                nums.push(x + y);
//            } else if(c == 'D') {
//                nums.push(nums.peek() * 2);
//            } else if(c == 'C') {
//                nums.pop();
//            } else {
//                nums.push(Integer.parseInt(operation));
//            }
//        }
//
//        int sum = 0;
//        while(!nums.isEmpty()) {
//            sum += nums.pop();
//        }
//
//        return sum;

        // 列表
        List<Integer> nums = new ArrayList<>();

        for(String operation : operations) {
            switch (operation.charAt(0)) {
                case 'C':
                    nums.remove(nums.size() - 1);
                    break;
                case 'D':
                    nums.add(nums.get(nums.size() - 1) * 2);
                    break;
                case '+':
                    nums.add(nums.get(nums.size() - 1) + nums.get(nums.size() - 2));
                    break;
                default:
                    nums.add(Integer.parseInt(operation));
            }

        }

        int sum = 0;
        for(int x : nums) {
            sum += x;
        }

        return sum;
    }
}
