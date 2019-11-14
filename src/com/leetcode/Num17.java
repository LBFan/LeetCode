package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/11/14.
 */

public class Num17 {
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) { // 队头元素长度为到i前一个数字的组合长度，"247"中i= 2， 表示"7"前面的组合长度"24"的长度 2
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String nums = "247";
        List<String> strings = letterCombinations(nums);
        System.out.println(strings.toString());
    }
}

