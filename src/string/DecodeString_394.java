package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString_394 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String decodeString(String s) {

        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();

        int tempNum = 0;
        StringBuilder tempStr = new StringBuilder();

        // '['：数字和临时字符串都入栈
        // ']'：若数字栈非空，栈顶元素出栈，循环拼接当前临时字符串；若字符串栈非空，栈顶元素出栈与当前临时字符串拼接
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                tempNum = tempNum * 10 + (c - '0');
            } else if(c >= 'a' && c <= 'z') {
                tempStr.append(c);
            } else if(c == '[') {
                strs.push(tempStr.toString());
                tempStr = new StringBuilder();
                nums.push(tempNum);
                tempNum = 0;
            } else {
                int n = !nums.empty() ? nums.pop() : 1;
                String str = tempStr.toString();
                for(int i = 1; i < n; i++) {
                    tempStr.append(str);
                }
                str = tempStr.toString();
                if(!strs.empty()) tempStr = new StringBuilder(strs.pop());
                tempStr.append(str);
            }
        }

        return tempStr.toString();
    }
}
