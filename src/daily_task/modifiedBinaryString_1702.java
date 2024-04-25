package daily_task;

/**
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 *
 * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 * 比方说， "00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 * 比方说， "00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
 */
public class modifiedBinaryString_1702 {
}

/**
 * 用操作二，将非前缀的1推到末尾。
 * 11110∗∗∗∗∗∗ → 111100…011111
 * 用操作一，把中间连续的0替换为1，末尾留个0
 * 000…0 → 111…10
 */
class Solution1702 {
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        int idx = binary.indexOf('0');

        if(idx < 0) return binary;

        int cnt = 0; // 统计第一个0之后1的个数
        for (int i = idx + 1; i < n; i++) {
            cnt += binary.charAt(i) - '0';
        }

        return "1".repeat(n - 1 - cnt) + "0" + "1".repeat(cnt);
    }
}