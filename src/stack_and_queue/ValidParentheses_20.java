package stack_and_queue;

import java.util.Stack;

public class ValidParentheses_20 {

    public static void main(String[] args) {
        Solution20 sol = new Solution20();
    }
}

class Solution20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c== '{') {
                stack.push(c);
            } else {
                if(stack.empty()) return false;
                if(c == ')' && stack.peek() != '(') return false;
                if(c == ']' && stack.peek() != '[') return false;
                if(c == '}' && stack.peek() != '{') return false;
                stack.pop();
            }
        }

        if(!stack.empty()) return false;
        return true;
    }
}
