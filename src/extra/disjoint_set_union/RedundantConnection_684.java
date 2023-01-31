package extra.disjoint_set_union;

import java.util.Scanner;

public class RedundantConnection_684 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            Solution684 sol = new Solution684();
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[][] edges = new int[arr.length/2][2];
            int idx = 0;
            for (int i = 0; i < edges.length; i++) {
                for (int j = 0; j < 2; j++) {
                    edges[i][j] = Integer.parseInt(arr[idx++]);
                }
            }
            int[] res = sol.findRedundantConnection(edges);
            System.out.print("[" + res[0] + "," + res[1] + "]");
        }
    }
}

class Solution684 {
    int n = 1001;
    int[] father = new int[n];

    /**
     * 树可以看成是一个连通且 无环的无向图。
     *
     * 给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n中间，且这条附加的边不属于树中已存在的边。
     * 图的信息记录于长度为 n 的二维数组 edges，edges[i] = [ai, bi]表示图中在 ai 和 bi 之间存在一条边。
     *
     * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组edges最后出现的边。
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {

        int[] res = null;
        init(father);

        for(int[] edge : edges) {
            if(same(edge[0],edge[1])) res = edge;
            joint(edge[0],edge[1]);
        }

        return res;

    }

    // 并查集初始化
    public void init(int[] father) {
        for(int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    // 并查集寻根
    public int find(int u) {
//        if(father[u] == u) return u;
//        return find(father[u]);

        return (u == father[u]) ? u : (father[u] = find(father[u]));
    }

    // 将边加入并查集
    public void joint(int u, int v) {
        u = find(u);
        v = find(v);
        if(u != v) {
            father[v] = u;
        }
    }

    // 判断u和v是否是同一个根
    public boolean same(int u, int v) {
        u = find(u);
        v = find(v);

        return u == v;
    }
}
