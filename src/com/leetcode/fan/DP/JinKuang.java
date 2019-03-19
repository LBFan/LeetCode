package com.leetcode.fan.DP;

/**
 * Created by : PF
 * Date on : 2018/12/21.
 */

public class JinKuang {
    public static void main(String[] args) {
        int n = 5, w = 10;
        int[] g = {400, 500, 200, 300, 350}; // 每座金矿的黄金数
        int[] p = {5, 5, 3, 4, 3}; // 五座金矿分别需要的工人数
        int result = new JinKuang().getMostGold(n, w, g, p);
        System.out.println("最大金矿数 ：" + result);
    }

    public int getMostGold(int n, int w, int[] g, int[] p) {
        int[] preResults = new int[w];
        int[] results = new int[w];

        // 填充边界格子的值
        for (int i = 0; i < w; i++) {
            if (i < p[0] - 1)
                preResults[i] = 0;
            else
                preResults[i] = g[0];
        }

        // 填充其余格子的值，外层循环是金矿数量，内层循环式工人数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (j < p[i] - 1)
                    results[j] = preResults[j];
                else
                    results[j] = Math.max(preResults[j], preResults[j - p[i]] + g[i]);
            }
            preResults = results;
        }
        return results[w];
    }
}

