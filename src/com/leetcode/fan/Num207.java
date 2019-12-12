package com.leetcode.fan;

import java.util.LinkedList;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/06.
 */

public class Num207 {
//    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        // 入度表 广度优先
//        int[] indegrees = new int[numCourses];
//        for (int[] cp : prerequisites) {
//            indegrees[cp[0]]++;
//        }
//        LinkedList<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < numCourses; ++i) {
//            if (indegrees[i] == 0) {
//                queue.addLast(i);
//            }
//        }
//        while (!queue.isEmpty()) {
//            Integer pre = queue.removeFirst();
//            numCourses--;
//            for (int[] req : prerequisites) {
//                if (req[1] != pre) {
//                    continue;
//                }
//                if (--indegrees[req[0]] == 0) {
//                    queue.add(req[0]);
//                }
//            }
//        }
//        return numCourses == 0;
//    }

    // 法二 ： dfs（推荐）

//    static int[] p, ne, h, f, b;

//    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        if ((numCourses * (numCourses - 1) >> 1) < prerequisites.length) {
//            return false;
//        }
//        p = new int[prerequisites.length + 5];
//        ne = new int[p.length];
//        h = new int[numCourses + 5];
//        f = new int[numCourses + 5];
//        b = new int[numCourses + 5];
//        int m = 0;
//        for (int[] e : prerequisites) {
//            //p[i+1] = pre[i][1] + 1
//            p[++m] = e[1] + 1;
//            //ne[i+1] = h[pre[i][0]+1]
//            ne[m] = h[e[0] + 1];
//            //h[pre[i][0]+1] = i+1
//            h[e[0] + 1] = m;
//        }
//        for (int i = 1; i <= numCourses; i++) {
//            if (!dfs(i)) {
//                return false;
//            }
//        }
//        return true;
//    }

//    private static boolean dfs(int x) {
//        if (b[x] != 0) {
//            return b[x] == 1;
//        }
//        f[x] = 1;
//        // i 是边, 递归的是点; p[i] 是终点
//        for (int i = h[x]; i != 0; i = ne[i]) {
//            if (f[p[i]] != 0 || !dfs(p[i])) {
//                b[x] = 2;
//                f[x] = 0;
//                return false;
//            }
//        }
//        b[x] = 1;
//        f[x] = 0;
//        return true;
//    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) {
            adjacency[cp[1]][cp[0]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] adjacency, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (int j = 0; j < adjacency.length; j++) {
            if (adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        int[][] preprequisites = {{0, 1}, {0, 3}, {0, 2}, {2, 4}, {3, 4}};
        int numCourses = 5;
        boolean canFinish = canFinish(numCourses, preprequisites);
        System.out.println(canFinish);
    }
}

