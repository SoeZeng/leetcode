package daily_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
给你一个有 n 个节点的 有向带权 图，节点编号为 0 到 n - 1 。图中的初始边用数组 edges 表示，其中 edges[i] = [fromi, toi, edgeCosti] 表示从 fromi 到 toi 有一条代价为 edgeCosti 的边。

请你实现一个 Graph 类：

Graph(int n, int[][] edges) 初始化图有 n 个节点，并输入初始边。
addEdge(int[] edge) 向边集中添加一条边，其中 edge = [from, to, edgeCost] 。数据保证添加这条边之前对应的两个节点之间没有有向边。
int shortestPath(int node1, int node2) 返回从节点 node1 到 node2 的路径 最小 代价。如果路径不存在，返回 -1 。一条路径的代价是路径中所有边代价之和。
 */
public class ClassofGraph2GetShortestPath_2642 {

}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
class Graph {
    int n;
    int[][] weights;
    private static final int INF = Integer.MAX_VALUE / 3; // 防止更新最短路径时加法溢出


    public Graph(int n, int[][] edges) {
        this.n = n;
        this.weights = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(weights[i], INF);
            weights[i][i] = 0;
        }

        for (int[] edge : edges) {
            this.weights[edge[0]][edge[1]] = edge[2];
        }

        // Floyd();
    }

    public void addEdge(int[] edge) {

        /** Floyd **/
        /*int from = edge[0];
        int to = edge[1];
        int cost = edge[2];
        if(cost > weights[from][to]) return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                weights[i][j] = Math.min(weights[i][j], weights[i][from] + cost + weights[to][j]);
            }
        }*/

        /** Dijkstra **/
        weights[edge[0]][edge[1]] = edge[2];
    }

    public int shortestPath(int node1, int node2) {

        // return weights[node1][node2] == INF ? -1 : weights[node1][node2];

        /** Dijkstra **/
        return Dijkstra(node1, node2);

    }

    // the k must be the outermost --> dp[k][i][j] = Math.min(dp[k][i][j], dp[k-1][i][k] + dp[k-1][k][j])
    private void Floyd() {
        /*for(int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                for (int k = 0; k < this.n; k++) {
                    if(this.edges[i][k] == -1 || this.edges[k][j] == -1) continue;
                    int cost = this.edges[i][k] + this.edges[k][j];
                    if(this.edges[i][j] == -1 || this.edges[i][j] > cost) {
                        this.edges[i][j] = cost;
                    }
                }
            }
        }*/

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if(weights[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    weights[i][j] = Math.min(weights[i][j], weights[i][k] + weights[k][j]);
                }
            }
        }
    }

    // 贪心，找最短路径，广度优先搜索刷新最短距离
    private int Dijkstra(int start, int end) {
        int[] dis = new int[n]; // 从 start 出发，到各个点的最短路径长度，如果不存在则为无穷大
        Arrays.fill(dis, INF);
        dis[start] = 0;
        boolean[] visited = new boolean[n];
        while(true) {
            int x = -1; // 指向当前最短路径的终点
            for (int i = 0; i < n; i++) {
                if(!visited[i] && (x < 0 || dis[i] < dis[x])) x = i;
            }

            if(x < 0 || dis[x] == INF) return -1;  // 所有从 start 能到达的点都被更新了

            if(x == end) return dis[x];

            visited[x] = true;  // 标记，在后续的循环中无需反复更新 x 到其余点的最短路长度
            // 更新最短路径长度
            for (int y = 0; y < n; y++) {
                dis[y] = Math.min(dis[y], dis[x] + weights[x][y]);
            }
        }

    }
}

// 邻接表+堆优化Dijsktra
class Graph1 {
    private final List<int[]>[] g;
    private final int n;
    public Graph1(int n, int[][] edges){
        this.n = n;
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        g[edge[0]].add(new int[]{edge[1], edge[2]});
    }

    // 优先队列，优先队列ADT是一种数据结构，它支持插入和删除最小值操作（返回并删除最小元素）或删除最大值操作（返回并删除最大元素）
    // 升序优先队列，总是先删除最小的元素
    public int shortestPath(int node1, int node2) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[node1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, node1});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int x = cur[1];

            if(x == node2) return d;

            if(d <= dis[x]) {
                for (int[] edge : g[x]) {
                    int y = edge[0];
                    int w = edge[1];
                    if(dis[y] > dis[x] + w) {
                        dis[y] = dis[x] + w;
                        pq.offer(new int[]{dis[y], y});
                    }
                }
            }
        }

        return -1;
    }

}
