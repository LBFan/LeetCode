package com.leetcode.fan.str;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 测试括号是否匹配 另外一种更优解：使用stack
 * @date : 2019/09/03.
 */

public class Test {
    private static boolean isValid(String s) {
//        int length;
//        do {
//            length = s.length();
//            s = s.replace("()","").replace("[]", "").replace("{}", "");
//        } while (length != s.length());
//        return s.length() == 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // left : push ; right:pop
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            }
            if (s.charAt(i) == '[' && stack.peek() == ']') {
                stack.pop();
            }
            if (s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "((([][])))";
        boolean result = isValid(s);
        System.out.println(result);
    }
}

