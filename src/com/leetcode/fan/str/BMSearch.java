package com.leetcode.fan.str;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/17.
 */

public class BMSearch {
    private static final int SIZE = 256;

    /**
     * bm-algorithm
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return 主串与模式串第一个匹配的字符的位置
     */
    public static int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
        generateBC(b, m, bc); // 构建坏字符哈希表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0; // j表示主串与模式串匹配的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i + j] != b[j]) break; // 坏字符对应模式串中的下标是j
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            int x = j - bc[(int) a[i + j]];
            int y = 0;
            if (j < m - 1) { // 如果有好后缀的话
                y = moveByGS(j, m, suffix, prefix);
            }
            // 这里等同于将模式串往后滑动j-bc[(int)a[i+j]]位
            i = i + Math.max(x, y);
        }
        return -1;
    }

    /**
     * 生成散列表
     *
     * @param b  模式串
     * @param m  模式串长度
     * @param bc 散列表
     */
    private static void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < m; ++i) {
            bc[i] = -1;// initial
        }
        for (int i = 0; i < m; i++) {
            int ascii = (int) b[i]; // 计算b[i]的ASCII值
            bc[ascii] = i;
        }
    }

    // j表示坏字符对应的模式串中的字符下标; m表示模式串长度
    private static int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // 好后缀长度
        if (suffix[k] != -1) return j - suffix[k] + 1;
        for (int r = j + 2; r <= m - 1; ++r) {
            if (prefix[m - r] == true) {
                return r;
            }
        }
        return m;
    }

    /**
     * 好后缀
     *
     * @param b      模式串
     * @param m      模式串长度
     * @param suffix suffix数组的下标k，表示后缀子串的长度，
     *               下标对应的数组值存储的是，在**模式串**中跟好后缀{u}相匹配的子串{u*}的 起始下标值
     * @param prefix 记录模式串的后缀子串是否能匹配模式串的前缀子串
     */
    private static void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; i++) { //初始化
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; ++i) {
            int j = i;
            int k = 0; // 公共后缀子串长度
            while (j >= 0 && b[j] == b[m - 1 - k]) { // 与b[0, m-1]求公共后缀子串
                --j;
                ++k;
                suffix[k] = j + 1; //j+1表示公共后缀子串在b[0, i]中的起始下标
            }
            if (j == -1) { //如果公共后缀子串也是模式串的前缀子串
                prefix[k] = true;
            }

        }
    }

    public static void main(String[] args) {
        char[] b = {'a', 'b', 'c', 'a', 'b', 'c'};
        int m = 6;
        int[] bc = new int[SIZE];
        generateBC(b, m, bc);
        System.out.println(bc.toString());
    }
}
