package extra.greedy;

import java.util.Scanner;

public class Dota2Senate_649 {

    public static void main(String[] args) {
        Solution649 sol = new Solution649();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String senate = in.nextLine();
            String ans = sol.predictPartyVictory(senate);
            System.out.println(ans);
        }
    }
}

class Solution649 {

    /**
     * Dota2 的世界里有两个阵营：Radiant(天辉)和Dire(夜魇)
     *
     * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。
     * 在每一轮中，每一位参议员都可以行使两项权利中的一项：
     *
     * 禁止一名参议员的权利：
     *
     * 参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
     *
     * 宣布胜利：
     *
     * 如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
     *
     * 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了Radiant（天辉）和Dire（夜魇）。
     * 然后，如果有 n 个参议员，给定字符串的大小将是n。
     *
     * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
     *
     * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。
     * 输出应该是Radiant或Dire。
     *
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        // R = true表示本轮循环结束后，字符串里依然有R;D同理
        boolean R = true, D = true;
        char[] chars = senate.toCharArray();
        // 当flag大于0时，R在D前出现，R可以消灭D。当flag小于0时，D在R前出现，D可以消灭R
        int flag = 0;

        while(R && D) {
            R = false;
            D = false;
            for(int i = 0; i < chars.length; i++) {
                if(chars[i] == 'R') {
                    if(flag < 0) chars[i] = '0'; // R被消灭
                    else R = true;
                    flag++;
                } else if(chars[i] == 'D') {
                    if(flag > 0) chars[i] = '0';
                    else D = true;
                    flag--;
                }
            }
        }

        return R == true ? "Radiant" : "Dire";
    }
}
