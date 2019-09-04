package com.leetcode.fan.arrays;

/**
 * @author :  PF_23
 * @Description :时间O(n)
 *             空间O(1)
 *
 *             转化成图，目的是求有没有除自环外的环。因为是数组，每个节点的出度是1，所以理论上每个节点只要经过一遍就可以（可理解为从每个节点出发DFS遍             历后，经过的节点都相当于被遍历过，不用再次进入）（也可以理解为从每个节点出发，要么可以发现合法的环，要么直接排除掉，所以每个节点只走一             遍）
 *
 *             DFS染色就可以，既然原数组数字有范围，染色可以直接在原数组上染，加一些题里要求的条件判断
 *             1.找到环的时候跳出
 *             2.排除长度为1的环
 *             3.是不是同一round中的环
 *             4.排除掉发生递增递减变化的情况
 * @date : 2019/09/03.
 */

public class FourFiveSeventh {
    private static boolean circularArrayLoop(int[] nums) {
        if (nums == null) return false;
        int round = 1000;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1000) {
                continue;
            }
            boolean negative = nums[i] < 0;
            int length = 1;
            /** 找到下一跳的下标 */
            int nextIndex = (i + (nums[i] % nums.length) + nums.length) % nums.length;
            nums[i] = ++round;

            while (nums[nextIndex] <= 1000 && nums[nextIndex] != round && (nums[nextIndex] > 0 ^ negative)) {
                int temp = nextIndex;
                nextIndex = nextIndex + (nums[nextIndex] % nums.length);
                nextIndex += nums.length;
                nextIndex %= nums.length;
                if (temp == nextIndex) {
                    length = 1;
                    break;
                }
                nums[temp] = round;
                length++;
            }
            if (nums[nextIndex] != round && nums[nextIndex] > 0 == negative) {
                continue;
            }
            if (length > 1 && nums[nextIndex] == round) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -1, -2, -2};
        long start = System.currentTimeMillis();
        boolean result = circularArrayLoop(nums);
        System.out.println("result:" + result);
        long spendTime = System.currentTimeMillis() - start;
        System.out.println(spendTime);
    }
}

