package daily_task;

import java.util.*;

/**
 * 给你一个二维数组 edges 表示一个 n 个点的无向图，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和节点 vi 之间有一条需要 lengthi 单位时间通过的无向边。
 *
 * 同时给你一个数组 disappear ，其中 disappear[i] 表示节点 i 从图中消失的时间点，在那一刻及以后，你无法再访问这个节点。
 *
 * 注意，图有可能一开始是不连通的，两个节点之间也可能有多条边。
 *
 * 请你返回数组 answer ，answer[i] 表示从节点 0 到节点 i 需要的 最少 单位时间。如果从节点 0 出发 无法 到达节点 i ，那么 answer[i] 为 -1 。
 */
public class MinimumTime2AccessTheDisappearedNode_3112 {

}

/**
 * 先不管 disappear，用 Dijkstra 算法模板求出 dis 数组，然后把其中 dis[i]≥disappear[i] 的 dis[i] 改成 −1。❌
 * 离节点 0 近的节点 x，其 disappear[x] 很小；离节点 0 远的节点 y，其 disappear[y] 很大。由于 disappear[x] 很小，我们无法通过节点 x，
 * 所以远处的节点 y 实际上也无法到达。但错误做法会因为 dis[y]<disappear[y]，误认为节点 y 可以到达，最终返回错误的答案。
 *
 *
 */
class Solution3112 {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] g = new ArrayList[n]; // 稀疏图用邻接表
        Arrays.setAll(g, i -> new ArrayList<>());
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];
            g[x].add(new int[]{y, w});
            g[y].add(new int[]{x, w});
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        dis[0] = 0;
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int dx = p[0];
            int x = p[1];
            if(dx > dis[x]) continue;
            for(int[] e : g[x]) {
                int y = e[0];
                int newDis = e[1] + dx;
                if(newDis < disappear[y] && (dis[y] < 0 || dis[y] > newDis)) {
                    dis[y] = newDis;
                    pq.offer(new int[]{newDis, y});
                }
            }
        }

        return dis;
    }
}