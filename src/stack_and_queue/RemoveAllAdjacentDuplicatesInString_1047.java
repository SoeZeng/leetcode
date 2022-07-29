package stack_and_queue;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_1047 {

    public static void main(String[] args) {
        Solution1047 sol = new Solution1047();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String ans = sol.removeDuplicates(s);
            System.out.println(ans);
        }
    }
}

class Solution1047 {

    /**
     * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     *
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
//        Stack<Character> stack = new Stack<>();
//
//        for(char c : s.toCharArray()) {
//            if(!stack.empty() && stack.peek() == c) {
//                stack.pop();
//            } else {
//                stack.push(c);
//            }
//        }
//
//        s = "";
//        while(!stack.empty()) {
//            s = stack.pop() + s;
//        }
//
//        return s;

//        // 使用Deque作为堆栈
//        ArrayDeque<Character> deq = new ArrayDeque<>();
//
//        for(char c : s.toCharArray()) {
//            if(!deq.isEmpty() && deq.peek() == c) {
//                deq.pop();
//            } else {
//                deq.push(c);
//            }
//        }
//
//        String str = "";
//        while(!deq.isEmpty()) {
//            str = deq.pop() + str;
//        }
//
//        return str;



//        // 使用字符串作为堆
//        StringBuilder strb = new StringBuilder();
//
//        int top = -1;
//        for(char c : s.toCharArray()) {
//            // int len = strb.length();
//            if(top >= 0 && strb.charAt(top) == c) {
//                strb.deleteCharAt(top);
//                top--;
//            } else {
//                strb.append(String.valueOf(c));
//                top++;
//            }
//        }
//
//        return strb.toString();


        // 双指针
        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;

        while(fast < s.length()) {
            chars[slow] = chars[fast];
            if(slow > 0 && chars[slow] == chars[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }

        return new String(chars,0,slow);

    }
}
