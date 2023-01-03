package extra.string;

import java.util.Arrays;

public class BackspaceStringCompare_844 {

    public static void main(String[] args) {

    }
}


class Solution844 {

    /**
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 退格后s和t是否相等
     */
    public boolean backspaceCompare(String s, String t) {
        char[] charsArrayOfS = removeBackSpace(s);
        char[] charsArrayOfT = removeBackSpace(t);

        if(charsArrayOfS.length != charsArrayOfT.length) return false;

        for(int i = 0; i < charsArrayOfS.length; i++) {
            if(charsArrayOfS[i] != charsArrayOfT[i]) return false;
        }

        return true;
    }

    public char[] removeBackSpace(String s) {
        char[] chars = s.toCharArray();
        int k = 0;

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != '#') {
                chars[k] = chars[i];
                k++;
            } else if(k > 0){
                k--;
            }
        }

        return Arrays.copyOf(chars, k);
    }
}

