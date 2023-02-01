package extra.simulate;

import java.util.Scanner;

public class RobotReturnToOrigin_657 {

    public static void main(String[] args) {
        Solution657 sol = new Solution657();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String moves = in.nextLine();
            boolean ans = sol.judgeCircle(moves);
            System.out.println(ans);
        }
    }
}

class Solution657 {

    /**
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在(0, 0) 处结束。
     *
     * 移动顺序由字符串moves表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有R（右），L（左），U（上）和 D（下）。
     *
     * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
     *
     *
     * @param moves 移动字符串
     * @return  是否能回到原点，true表示可以
     */
    public boolean judgeCircle(String moves) {
        int left = 0;
        int up = 0;

        for(char c : moves.toCharArray()) {
            switch (c) {
                case 'L':
                    left++;
                    break;
                case 'R':
                    left--;
                    break;
                case 'U':
                    up++;
                    break;
                case 'D':
                    up--;
            }
        }

        return left == 0 && up == 0;
    }
}
