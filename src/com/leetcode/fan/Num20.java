package com.leetcode.fan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/11/14.
 */

public class Num20 {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        // 一个桟就解决了,遇到左括号压入，遇到右括号时，判断栈顶元素是否与当前括号匹配，匹配则弹出继续；否则返回false
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }

        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

//    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
//        put('{','}'); put('[',']'); put('(',')'); put('?','?');
//    }};
//
//    public boolean isValid(String s) {
//        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
//        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
//        for(Character c : s.toCharArray()){
//            if(map.containsKey(c)) stack.addLast(c);
//            else if(map.get(stack.removeLast()) != c) return false;
//        }
//        return stack.size() == 1;
//    }

    public static void main(String[] args) {
        String s = "{}()[]";
        String s1 = "{(})[]";

        boolean valid = isValid(s);
        boolean valid1 = isValid(s1);
        System.out.println(valid);
        System.out.println(valid1);
    }
}

