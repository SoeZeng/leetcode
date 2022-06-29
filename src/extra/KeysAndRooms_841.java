package extra;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms_841 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。
         * 然而，你不能在没有获得钥匙的时候进入锁住的房间。
         *
         * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。
         * 你可以拿上所有钥匙去解锁其他房间。
         *
         * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
         *
         * @param rooms
         * @return
         */
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {

            boolean[] visit = new boolean[rooms.size()];
            Queue<Integer> que = new LinkedList<>();

//            List<Integer> key = new LinkedList<>(); // 存放未访问过的房间的钥匙
//            key.add(0);
//            int cnt = 0; // 记录访问过的房间数量
//
//            while(!key.isEmpty()) {
//                cnt++;
//                int k = key.get(0);
//                List<Integer> list  = rooms.get(k);
//                visit[k] = true;
//                for(int num : list) {
//                    if(!key.contains(num) && !visit[num]) key.add(num);
//                }
//                key.remove(0);
//            }
//
//            return cnt == rooms.size();

            /**
             * 广度优先遍历
             */

//            que.offer(0);
//            visit[0] = true;
//
//            while(!que.isEmpty()) {
//                int k = que.peek();
//                que.poll();
//                List<Integer> keys = rooms.get(k);
//                for(int key : keys) {
//                    if(!visit[key]) que.offer(key);
//                    visit[key] = true;
//                }
//            }

            /**
             * 深度优先遍历
             */
            dfs(0, rooms, visit);

            for(int i = 0; i < visit.length; i++) {
                if(!visit[i]) return false;
            }

            return true;
        }

        public void dfs(int key, List<List<Integer>> rooms, boolean[] visit) {
            if(visit[key]) return;

            visit[key] = true;
            List<Integer> keys = rooms.get(key);
            for(int k : keys) {
                dfs(k, rooms, visit);
            }
        }
    }
}
