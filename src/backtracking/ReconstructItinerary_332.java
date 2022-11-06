package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReconstructItinerary_332 {

    public static void main(String[] args) {

    }
}

class Solution {


    // 超出时间限制
    // List<String> ans = new ArrayList<>();
    // List<String> path = new LinkedList<>();
    // int[] used;
    // public List<String> findItinerary(List<List<String>> tickets) {

    //     used = new int[tickets.size()];
    //     path.add("JFK");
    //     backTracing(tickets);
    //     return ans;

    // }

    // public void backTracing(List<List<String>> tickets) {
    //     if(path.size() == tickets.size() + 1) {

    //         if(ans == null || ans.size() == 0) {
    //             ans = new ArrayList<>(path);
    //         } else {
    //             for(int i = 0; i < ans.size(); i++) {
    //                 if(ans.get(i).compareTo(path.get(i)) > 0) {
    //                     ans = new ArrayList<>(path);
    //                     break;
    //                 }else if(ans.get(i).compareTo(path.get(i)) < 0) {
    //                     break;
    //                 }
    //             }
    //         }

    //         return;
    //     }

    //     for(int i = 0; i < tickets.size(); i++) {
    //         if(used[i] == 1) continue;

    //         if(path.size() > 0 && tickets.get(i).get(0).equals(path.get(path.size() - 1))) {

    //             path.add(tickets.get(i).get(1));
    //             used[i] = 1;
    //             backTracing(tickets);
    //             used[i] = 0;
    //             path.remove(path.size() - 1);
    //         }
    //     }
    // }

    List<String> ans;
    List<String> path = new LinkedList<>();
    int[] used;

    /**
     *
     * @param tickets 航线列表
     * @return 按字典排序返回最小的行程组合
     */
    public List<String> findItinerary(List<List<String>> tickets) {

        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        used = new int[tickets.size()];
        path.add("JFK");
        backTracing(tickets);
        return ans;

    }

    public boolean backTracing(List<List<String>> tickets) {
        if(path.size() == tickets.size() + 1) {

            ans = new ArrayList<>(path);
            return true;
        }

        for(int i = 0; i < tickets.size(); i++) {
            if(used[i] == 1) continue;

            if(tickets.get(i).get(0).equals(path.get(path.size() - 1))) {

                path.add(tickets.get(i).get(1));
                used[i] = 1;

                if(backTracing(tickets)) {
                    return true;
                }

                used[i] = 0;
                path.remove(path.size() - 1);
            }
        }

        return false;
    }
}


