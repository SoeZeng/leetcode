package daily_task;

/**
 * 给你一个下标从 0 开始的字符串 s ，该字符串由用户输入。按键变更的定义是：使用与上次使用的按键不同的键。例如 s = "ab" 表示按键变更一次，而 s = "bBBb" 不存在按键变更。
 *
 * 返回用户输入过程中按键变更的次数。
 *
 * 注意：shift 或 caps lock 等修饰键不计入按键变更，也就是说，如果用户先输入字母 'a' 然后输入字母 'A' ，不算作按键变更。
 *
 *
 */
public class numberOfChangingKeys_3019 {

}

class Solution3019 {
    public int countKeyChanges(String s) {
        int ans = 0;

        /**
         * 对于同一字母的大写和小写，ASCII 值的二进制的低 5 位是相同的，所以只需统计 s[i−1]&31 != s[i]&31 的个数。
         *
         * 其中 &31 表示取二进制的低 5 位。
         */
        for (int i = 0; i < s.length() - 1; i++) {
            // if(s.charAt(i) != s.charAt(i + 1) && Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) ans++;
            if((s.charAt(i) & 31) != (s.charAt(i +1) & 31)) ans++;
        }

        return ans;
    }
}
