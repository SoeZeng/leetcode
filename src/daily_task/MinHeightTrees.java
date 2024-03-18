package daily_task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 */
public class MinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n == 1) {
            result.add(0);
            return result;
        }

        // Floyd：求任意两点间的最短路径 ❌
        // Dijkstra：求源点到任意点的最短路径 ❌
        // 拓扑排序：越是靠里面的节点越有可能是最小高度树。从边缘开始，先找到所有度为1的节点（叶子节点），然后把所有度为1的节点进队列，
        // 然后不断地bfs，最后找到的就是两边同时向中间靠近的节点，那么这个中间节点就相当于把整个距离二分了，那么它当然就是到两边距离最小的点啦，
        // 也就是到其他叶子节点最近的节点了 ✅

        // 创建各个节点的出度表
        int[] degree = new int[n];
        // 创建邻接矩阵表，在每个节点的list存储相邻节点
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for(int[] edge:edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // 队列初始化：叶子节点进队列
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) que.offer(i);
        }

        // 拓扑排序：每次循环结果保存当前层出度为1的结点，也就是叶子结点
        while(!que.isEmpty()) {
            result = new ArrayList<>(); // 每层循环都要new一个新的结果集合，这样最后保存的就是最终的最小高度树的根节点了
            int size = que.size(); // 每一层节点的数量
            for (int i = 0; i < size; i++) {
                int cur = que.poll();
                result.add(cur);

                List<Integer> neighbors = map.get(cur);
                for(int neighbor : neighbors) {
                    degree[neighbor]--;
                    if(degree[neighbor] == 1) que.offer(neighbor);
                }
            }

        }

        return result;
    }
}
