package greedy_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class NonOverlappingIntervals_435 {
    public static void main(String[] args) {
        Solution435 sol = new Solution435();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int len = Integer.parseInt(in.nextLine());
            int[][] intervals = new int[len][2];
            for (int i = 0; i < len; i++) {
                String str = in.nextLine();
                String[] arr = str.split(",");
                for (int j = 0; j < 2; j++) {
                    intervals[i][j] = Integer.parseInt(arr[j]);
                }
            }
            int res = sol.eraseOverlapIntervals(intervals);
            System.out.println(res);
        }
    }

}

class Solution435 {
    /**
     * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。
     * 返回 需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // Arrays.sort(intervals,(a,b) -> {
        //     return a[0] - b[0];
        // });

        // int[] preInterval = intervals[0];
        // int eraseNum = 0;
        // for(int i = 1; i < intervals.length; i++) {
        //     if(intervals[i][0] < preInterval[1]) {
        //         eraseNum++;
        //         if(intervals[i][1] < preInterval[1]) {
        //             preInterval = intervals[i];
        //         }
        //     } else {
        //         preInterval = intervals[i];
        //     }
        // }
        // return eraseNum;

//        Arrays.sort(intervals,(a, b) -> {
//            return a[0] - b[0];
//        });
//        int unoverlapIntervals = 1; // 记录非重叠区间个数
//        int maxLeftVal = intervals[intervals.length - 1][0]; // 记录左边界最大值
//        for(int i = intervals.length - 2; i >= 0; i--) {
//            if(intervals[i][1] <= maxLeftVal){
//                maxLeftVal = intervals[i][0];
//                unoverlapIntervals++;
//            }
//        }
//        return intervals.length - unoverlapIntervals;


        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int ans = 0;
        int minEnd = intervals[0][1]; // 记录当前非重叠区间的右边界
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] - minEnd < 0) { // 若当前区间左边界小于右边界，说明有重叠区间
                ans++;
                minEnd = Math.min(minEnd, intervals[i][1]); // 删除区间范围更大即右边界越大的区间，更新右边界
            } else {
                minEnd = intervals[i][1]; // 更新右边界
            }
        }

        return ans;
    }
}