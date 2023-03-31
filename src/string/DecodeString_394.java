package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString_394 {
    public static void main(String[] args) {

    }
}

class Solution {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
     * 注意 k 保证为正整数。
     *
     * @param s 字符串
     * @return 解码后的字符串
     */
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
