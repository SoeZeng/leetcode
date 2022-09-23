package test;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String s = in.nextLine();
            String t = in.nextLine();

            Solution sol = new Solution();
            int res = sol.func(s, t);
            System.out.println(res);

        }

    }
}

class Solution{
    public int func(String s, String t) {

    }
}


