package greedy_algorithm;

import java.util.Scanner;

public class JumpGameⅡ_45 {

    public static void main(String[] args) {
        Solution45 sol = new Solution45();
        Scanner in = new Scanner(System.in);

        // 数组输入方式一
//        while(in.hasNextInt()) {
//            int[] nums = new int[in.nextInt()];
//            for(int i = 0; i < nums.length; i++) {
//                nums[i] = in.nextInt();
//            }
//            int ans = sol.jump(nums);
//            System.out.println(ans);
//        }

        // 数组输入方式二
        while(in.hasNext()) {
            String str = in.nextLine().toString();
            String[] arr = str.split(",");
            int[] nums = new int[arr.length];
            for(int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.jump(nums);
            System.out.println(ans);
        }

    }
}

class Solution45 {
    public int jump(int[] nums) {

        if(nums.length == 1) return 0;

        int cur = 0; // 记录当前可达范围
        int next = 0; // 记录下一跳可达范围
        int ans = 0;
//            for(int i = 0; i < nums.length - 1; i++) {
//                // 更新下一跳的最大可覆盖范围
//                next = Math.max(nums[i] + i,next);
//                // 当到达当前可达范围的最大下标时，跳跃次数+1
//                if(i == cur) {
//                    cur = next;
//                    ans++;
//                }
//            }
        for(int i = 0; i < nums.length && cur < nums.length - 1; i++) {
            next = Math.max(next, i + nums[i]);
            if(i == cur) {
                cur = next;
                ans++;
            }
        }

        return ans;

    }
}
