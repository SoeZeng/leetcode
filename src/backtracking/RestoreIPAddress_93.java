package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress_93 {

    public static void main(String[] args) {

    }
}

class Solution93 {
    List<String> ans = new ArrayList<>();
    StringBuilder tempStr = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        backTracing(s, 0, 0);
        return ans;
    }

//    public void backTracing(String s, int startIndex, int pointNum) {
//
//        if(pointNum == 3) {
//            if(isValid(s, startIndex, s.length())) {
//                ans.add(s);
//            }
//            return;
//        }
//
//        for(int i = startIndex; i < startIndex + 3 && i < s.length() - (3 - pointNum); i++) {
//            if(isValid(s, startIndex, i + 1)) {
//                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
//                backTracing(s, i + 2, pointNum + 1);
//                s = s.substring(0, i + 1) + s.substring(i + 2);
//            } else {
//                break;
//            }
//        }
//
//    }

    public void backTracing(String s, int startIndex, int num) {

        if(startIndex == s.length() && num == 4) {
            ans.add(tempStr.toString());
            return;
        }

        if(startIndex == s.length() || num == 4) {
            return;
        }

        for(int i = startIndex; i < s.length() && i < startIndex + 3 && Integer.parseInt(s.substring(startIndex, i + 1)) >= 0 && Integer.parseInt(s.substring(startIndex, i + 1)) <= 255; i++) {
            if(i + 1 - startIndex > 1 && s.charAt(startIndex) - '0' == 0) continue;

            tempStr.append(s.substring(startIndex, i + 1));
            if(num < 3) tempStr.append(".");

            backTracing(s, i + 1, num + 1);

            tempStr.delete(startIndex + num, i + num + 2);

        }
    }

    public boolean isValid(String s, int start, int end) {
        if(end <= start) return false;

        if(s.charAt(start) == '0' && end > start + 1) return false;

        int num = 0;
        for(int i = start; i < end; i++) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9') return false;

            num = num * 10 + s.charAt(i) - '0';
            if(num > 255) return false;
        }

        return true;

    }


}
