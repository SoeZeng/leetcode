package daily_task;

/**
 * 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
 *
 * 该整数是 num 的一个长度为 3 的 子字符串 。
 * 该整数由唯一一个数字重复 3 次组成。
 * 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
 *
 * 注意：
 *
 * 子字符串 是字符串中的一个连续字符序列。
 * num 或优质整数中可能存在 前导零 。
 */
public class largest3SameDIgitNumberInString_2264 {

}

class Solution2264 {
    public String largestGoodInteger(String num) {
        String ans = "";

        // 十次遍历
//        for (char c = '9'; c >= '0'; c--) {
//            String s = String.valueOf(c).repeat(3);
//            if(num.contains(s)) return s;
//        }
//        return "";

        // 一次遍历
//        for (int i = 0; i < num.length() - 2; i++) {
//            if(num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
//                if(ans.equals("") || ans.charAt(0) - num.charAt(i) < 0) ans = num.substring(i, i + 3);
//            }
//        }
//        return ans;

        /**
         * 字符'0'和整数0的区别：
         * 字符型变量用于存储一个单一字符，在C语言中用char表示，其中每个字符变量都会占用1个字节（8位二进制数）。
         * 整型int在内存中占用空间为四个字节（32位二进制数）。
         * 字符'0'：charc='0'，它的ASCII码实际上是48，内存中存放表示：00110000。
         * 整数0内存中表示为00000000000000000000000000000000，虽然都是0，但是跟上面字符'\0'存储占用长度是不一样的。
         */
        char max = 0;
        for (int i = 0; i < num.length() - 2; i++) {
            char c = num.charAt(i);
            if(c > max && c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                max = c;
            }
        }

        return max > 0 ? String.valueOf(max).repeat(3) : "";
    }
}
