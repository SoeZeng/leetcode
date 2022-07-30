package stack_and_queue;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {

    public static void main(String[] args) {

    }
}

class Solution150 {

    /**
     * 根据 逆波兰表示法，求表达式的值。
     * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            if("+".equals(tokens[i])) {
                stack.push(stack.pop() + stack.pop());
            } else if("-".equals(tokens[i])) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if("*".equals(tokens[i])) {
                stack.push(stack.pop() * stack.pop());
            } else if("/".equals(tokens[i])) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
