package greedy_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfArrowsToBurstBalloons_452 {
    public static void main(String[] args) {
        Solution452 sol = new Solution452();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int len = Integer.parseInt(in.nextLine());
            int[][] points = new int[len][2];
            for (int i = 0; i < len; i++) {
                String str = in.nextLine();
                String[] arr = str.split(",");
                for (int j = 0; j < 2; j++) {
                    points[i][j] = Integer.parseInt(arr[j]);
                }
            }
            int minArrowShots = sol.findMinArrowShots(points);
            System.out.println(minArrowShots);
        }
    }

}

class Solution452 {
    /**
     * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组points，
     * 其中points[i] = [xstart, xend]表示水平直径在xstart和xend之间的气球。你不知道气球的确切 y 坐标。
     *
     * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
     * 且满足 xstart≤ x ≤ xend，则该气球会被 引爆。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
     *
     * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数。
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a, b) -> {
            // if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int arrowShots = 1;
        int minEnd = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] - minEnd > 0) {
                arrowShots++;
                minEnd = points[i][1];
            }
            minEnd = Math.min(minEnd,points[i][1]);
        }
        return arrowShots;

        // 根据气球直径的开始坐标从小到大排序
        // 使用Integer内置比较方法，不会溢出
//        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
//
//        int count = 1;  // points 不为空至少需要一支箭
//        for (int i = 1; i < points.length; i++) {
//            if (points[i][0] > points[i - 1][1]) {  // 气球i和气球i-1不挨着，注意这里不是>=
//                count++; // 需要一支箭
//            } else {  // 气球i和气球i-1挨着
//                points[i][1] = Math.min(points[i][1], points[i - 1][1]); // 更新重叠气球最小右边界
//            }
//        }
//        return count;
    }
}
