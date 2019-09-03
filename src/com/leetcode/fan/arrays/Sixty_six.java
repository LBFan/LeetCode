package com.leetcode.fan.arrays;

/**
 * Created by : PF
 * Date on : 2018/11/13.
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */

public class Sixty_six {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int add = 1;
        for(int i=len-1;i>=0;i--){
            if (digits[i]+add>9){
                add = 1;
                digits[i] = 0;
            }else {
                digits[i] = digits[i] + add;
                add = 0;
            }
        }
        if(add == 0){
            return digits;
        }else {
            int [] newd = new int[len+1];
            newd[0] = add;
            for(int i=1;i<=len;i++){
                newd[i] = digits[i-1];
            }
            return newd;
        }
    }

    public static void main(String[] args) {
        int[] digits = {9,9,7};
        int[] result = new Sixty_six().plusOne(digits);
        StringBuffer stringBuffer = new StringBuffer().append("[");
        for (int i = 0; i < result.length - 1; i++) {
            stringBuffer.append(result[i])
                    .append(",");
        }
        stringBuffer.append(result[result.length - 1]).append("]");
        System.out.println(stringBuffer);
    }
}

