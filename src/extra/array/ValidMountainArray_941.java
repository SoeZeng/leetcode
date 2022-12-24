package extra.array;

import java.util.Scanner;

public class ValidMountainArray_941 {

    public static void main(String[] args) {
        Solution941 sol = new Solution941();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] strings = s.split(",");
            int[] arr = new int[strings.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
            boolean ans = sol.validMountainArray(arr);
            System.out.println(ans);
        }
    }
}

class Solution941 {

    /**
     * 给定一个整数数组 arr，如果它是有效的山脉数组就返回true，否则返回 false。
     *
     * 让我们回顾一下，如果 arr满足下述条件，那么它是一个山脉数组：
     *
     * arr.length >= 3
     * 在0 < i< arr.length - 1条件下，存在i使得：
     * arr[0] < arr[1] < ... arr[i-1] < arr[i]
     * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     *
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;

//        int i = 1;
//        for(; i < arr.length; i++) {
//            if(arr[i] <= arr[i - 1]) break;
//        }
//        if(i == 1 || i > arr.length - 1) return false;
//        for(; i < arr.length; i++) {
//            if(arr[i] >= arr[i - 1]) return false;
//        }
//
//        return true;

        int index = 0;
        while(index < arr.length - 1 && arr[index] < arr[index + 1]) {
            index++;
        }

        // 严格单调递增或严格单调递减都不是有效山脉数组
        if(index == 0 || index == arr.length - 1) return false;

        while(index < arr.length - 1 && arr[index] > arr[index + 1]) {
            index++;
        }

        return index == arr.length - 1;

        /**
         * 双指针
         */
//            int left = 0;
//            int right = arr.length - 1;
//            while(left < arr.length - 1 && arr[left] < arr[left + 1]) {
//                left++;
//            }
//
//            while(right > 0 && arr[right] < arr[right - 1]) {
//                right--;
//            }
//
//            if(left == right && left != 0 && right != arr.length - 1) return true;
//            return false;
    }
}
