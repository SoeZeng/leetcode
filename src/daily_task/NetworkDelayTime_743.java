package daily_task;

import java.util.Arrays;

/**
 * 有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 */
public class NetworkDelayTime_743 {

}

class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n][n];
        final int INF = Integer.MAX_VALUE / 2;
        for(int[] row : g) {
            Arrays.fill(row, INF);
        }

        for(int[] time : times) {
            g[time[0] - 1][time[1] - 1] = time[2];
        }

        int maxTime = 0;
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        boolean[] visited = new boolean[n];
        dis[k - 1] = 0;
        while(true) {
            int x = -1;
            for (int i = 0; i < n; i++) {
                if(!visited[i] && (x < 0 || dis[i] < dis[x])) {
                    x = i;
                }
            }

            if(x < 0) return maxTime;
            if(dis[x] == INF) return -1;

            visited[x] = true;
            maxTime = Math.max(maxTime, dis[x]);

            for(int y = 0; y < n; y++) {
                dis[y] = Math.min(dis[y], dis[x] + g[x][y]);
            }
        }

    }
}
