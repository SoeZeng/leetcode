package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SplitPalindrome_131 {

    public static void main(String[] args) {

    }
}

class Solution131 {
    List<List<String>> ans = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * @param s 字符串
     * @return s所有可能的分割方案
     */
    public List<List<String>> partition(String s) {
        backTracing(s, 0);
        return ans;
    }

    public void backTracing(String s, int startIndex) {
        if(startIndex >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex + 1;i <= s.length(); i++) {
            String subStr = s.substring(startIndex,i);
            if(isPalindrome(subStr)) {
                path.add(subStr);
                backTracing(s, i);
                path.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s) {

        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
