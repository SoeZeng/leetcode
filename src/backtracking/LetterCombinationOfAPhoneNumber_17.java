package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationOfAPhoneNumber_17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String digits = in.nextLine();
            Solution17 sol = new Solution17();
            List<String> ans = sol.letterCombinations(digits);
        }
    }
}

class Solution17 {

    String[] numStrings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();
    StringBuilder strb = new StringBuilder();

    /**
     *
     * @param digits 仅包含数字2-9的字符串
     * @return 它能表示的字母组合 （数字与字母的映射与电话按键相同）
     */
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return ans;

        backTracing(digits,0);
        return ans;
    }

    public void backTracing(String digits, int index) {
        if(index == digits.length()) {
            ans.add(strb.toString());
            return;
        }

        String numString = numStrings[digits.charAt(index) - '0'];
        for(int i = 0; i < numString.length(); i++) {
            strb.append(numString.charAt(i));
            backTracing(digits, index + 1);
            strb.deleteCharAt(strb.length() - 1);
        }
    }
}
