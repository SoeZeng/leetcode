package greedy_algorithm;

import java.util.Arrays;

public class AssignCookies_445 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,2};
        int res = sol.findContentChildren(g, s);
        System.out.println(res);
    }
}


class Solution {
    // 优先考虑饼干，小饼干先喂饱小胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for(int size : s) {
            if(index == g.length) {
                break;
            }
            if(size >= g[index]) {
                index++;
            }
        }
        return index;
    }
}
