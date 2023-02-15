package graphy;

import java.util.*;

public class CourseSchedule_207 {

    public static void main(String[] args) {

    }
}

class Solution {

    /**
     *
     * @param numCourses 课程数目
     * @param prerequisites 先修课程对
     * @return 是否能修完所有课程
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        // 拓扑排序
        int[] inDegrees = new int[numCourses];
        Arrays.fill(inDegrees, 0);
        Map<Integer, Set<Integer>> adjTable = new HashMap<>();
        Queue<Integer> que = new LinkedList<>();

        for(int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[1]]++;
            if(adjTable.containsKey(prerequisite[0])) {
                adjTable.get(prerequisite[0]).add(prerequisite[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(prerequisite[1]);
                adjTable.put(prerequisite[0], set);
            }
        }

        for(int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0) que.offer(i);
        }

        while(!que.isEmpty()) {
            int k = que.poll();
            if(adjTable.containsKey(k)) {
                for(int v : adjTable.get(k)) {
                    inDegrees[v]--;
                    if(inDegrees[v] == 0) que.offer(v);
                }
            }
        }


        for(int inDegree : inDegrees) {
            if(inDegree > 0) return false;
        }
        return true;
    }
}
