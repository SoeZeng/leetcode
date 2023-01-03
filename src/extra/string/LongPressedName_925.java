package extra.string;

import java.util.Scanner;

public class LongPressedName_925 {

    public static void main(String[] args) {

        Solution925 sol = new Solution925();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String name = in.nextLine();
            String typed = in.nextLine();
            boolean ans = sol.isLongPressedName(name, typed);
            System.out.println(ans);
        }
    }
}

class Solution925 {

    /**
     * 你的朋友正在使用键盘输入他的名字name。偶尔，在键入字符c时，按键可能会被长按，而字符可能被输入 1 次或多次。
     *
     * 你将会检查键盘输入的字符typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回True
     *
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {

        if(typed.length() < name.length()) return false;

        char[] typedChars = typed.toCharArray();
        int index = 0;

        for(char c : name.toCharArray()) {
            // 第一位就不匹配
            if(index == 0 && c != typedChars[index]) return false;

            // 跨越重复项
            while(index < typedChars.length && c != typedChars[index] && typedChars[index] == typedChars[index - 1]) {
                index++;
            }
            // 跨越重复项后依然不匹配
            if(index >= typedChars.length || c != typedChars[index]) return false;
            else index++;
        }

        // typed没有匹配完
        while(index < typedChars.length) {
            if(typedChars[index] != typedChars[index - 1]) return false;
            index++;
        }

        return true;


//        if(name.charAt(0) != typed.charAt(0)) return false;
//
//        int k = 1;
//
//        for(int i = 1; i < typed.length(); i++) {
//            if(k < name.length() && typed.charAt(i) == name.charAt(k)) {
//                k++;
//            } else if(typed.charAt(i) != typed.charAt(i - 1)){
//                return false;
//            }
//        }
//
//        return k == name.length();
    }
}
