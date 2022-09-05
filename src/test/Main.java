package test;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            int n = Integer.parseInt(scan.nextLine());
            String s = scan.nextLine();
            String[] arr = s.split(" ");
            int[] nums = new int[arr.length];
            for(int i = 0; i < arr.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }

            Solution sol = new Solution();
            List<Integer> res = sol.func(n, nums);
            System.out.println(res);
        }


    }
}

class Solution{
    public List<Integer> func(int n, int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int min = 0;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(nums[j] == min) min++;
            }
            result.add(min);
        }
        return result;
    }
}
