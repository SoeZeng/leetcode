package extra.array;

import java.util.*;

public class UniqueNumberOfOccurrences_1207 {

    public static void main(String[] args) {
        Solution1207 sol = new Solution1207();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] strs = s.split(",");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            boolean res = sol.uniqueOccurrences(arr);
            System.out.println(res);
        }
    }
}

class Solution1207 {

    /**
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     *
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
//            List<Integer> list = new ArrayList<>();
//            Arrays.sort(arr);
//            int cnt = 1;
//            for(int i = 0; i < arr.length - 1; i++) {
//                if(arr[i] == arr[i + 1]) cnt++;
//                else {
//                    if(list.contains(cnt)) return false;
//                    list.add(cnt);
//                    if(i == arr.length - 2 && list.contains(1)) return false;
//                    cnt = 1;
//                }
//            }

        int[] count = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++; // 防止负数作为下标
        }
        boolean[] flag = new boolean[1001]; // 标记相同频率是否重复出现
        for (int i = 0; i <= 2000; i++) {
            if (count[i] > 0) {
                if (flag[count[i]] == false) {
                    flag[count[i]] = true;
                } else {
                    return false;
                }
            }
        }
//            for(int i = 0; i < counts.length; i++) {
//                if(counts[i] == 0) continue;
//
//                if(flags[counts[i]]) return false;
//
//                flags[counts[i]] = true;
//            }



        return true;
    }
}
