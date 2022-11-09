package greedy_algorithm;

import java.util.Arrays;

public class AssignCookies_445 {
    public static void main(String[] args) {
        Solution445 sol = new Solution445();
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,2};
        int res = sol.findContentChildren(g, s);
        System.out.println(res);
    }
}


class Solution445 {

    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     *
     * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]。
     * 如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * @param g 对每个孩子 i，都有一个胃口值 g[i]
     * @param s 每块饼干 j，都有一个尺寸 s[j]
     * @return 可满足的孩子个数的最大值
     */
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int num = 0;

        // 优先考虑饼干，小饼干先喂饱小胃口
        // for(int size : s) {
        //     if(num == g.length) {
        //         break;
        //     }

        //     if(size >= g[num]) {
        //         num++;
        //     }
        // }

        // 优先考虑胃口，大饼干先喂饱大胃口
        int j = s.length - 1;
        for(int i = g.length - 1; i >= 0; i--) {
            if(num == s.length) break;

            if(g[i] <= s[j]) {
                j--;
                num++;
            }
        }


        return num;
    }
}
