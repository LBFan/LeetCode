package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :
 * 算法
 * <p>
 * 计算所有的 P[i] 在模 K 意义下的值。如果说一共有 C_xC
 * x
 * ​
 * 个 P[i] \equiv x \pmod{K}P[i]≡x(modK)。那么，就有个可行的连续子数组。
 * <p>
 * <p>
 * 举一个例子，给定数组为 A = [4,5,0,-2,-3,1]。那么 P = [0,4,9,9,7,4,5]，同时 C_0 = 2, C_2 = 1, C_4 = 4C
 * 0
 * ​
 * =2,C
 * 2
 * ​
 * =1,C
 * 4
 * ​
 * =4：
 * <p>
 * 对于 C_0 = 2C
 * 0
 * ​
 * =2（P[0]P[0]、P[6]P[6]），这表示一共有 \binom{2}{2} = 1(
 * 2
 * 2
 * ​
 * )=1 的连续子数组的和能被 KK 整除，也就是 A[0:6] = [4, 5, 0, -2, -3, 1]A[0:6]=[4,5,0,−2,−3,1]。
 * <p>
 * 对于 C_4 =4
 * =4（P[1]P[1]、P[2]P[2]、P[3]P[3]、P[5]P[5]），这表示一共有 \binom{4}{2} = 6(
 * 2
 * 4)=6 个连续子数组的和能被 KK 整除，分别是 A[1:2]A[1:2]、A[1:3]A[1:3]、A[1:5]A[1:5]、A[2:3]A[2:3]、A[2:5]A[2:5]、A[3:5]A[3:5]。
 * @date : 2019/09/25.
 */

public class NineSevenFourth {
    public static int subarraysDivByK(int[] A, int K) {
        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + A[i];

        int[] count = new int[K];
        for (int x : P)
            count[(x % K + K) % K]++;

        int ans = 0;
        for (int v : count)
            ans += v * (v - 1) / 2;
        return ans;
    }

    public static void main(String[] args) {

    }
}

