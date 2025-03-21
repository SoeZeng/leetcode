package daily_task;

/**
 * 给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的字典序最小的字符串
 *
 * 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
 */
public class SmallestString_3216 {

}

class Solution_3216{
    public String getSmallestString(String s) {
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length - 1; i++) {
            char a = chars[i];
            char b = chars[i + 1];
            if((a > b) && (a % 2 == b % 2)) {
                chars[i] = b;
                chars[i + 1] = a;
                break;
            }
        }

        return new String(chars);
    }
}
