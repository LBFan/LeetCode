package com.leetcode.fan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 非递归输出桟
 * @date : 2019/12/09.
 */

public class TestTreePrint {

    /**
     * 先序遍历
     *
     * @param root 根节点
     * @return 节点集合
     */
    private static List<Integer> dfsPreOrder(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                results.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            // 转向
            cur = cur.right;
        }
        return results;
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     * @return 节点集合
     */
    private static List<Integer> dfsInOrder(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            results.add(cur.val);
            // 转向
            cur = cur.right;
        }

        return results;
    }

    /**
     * 后序遍历
     *
     * @param root 根节点
     * @return 节点集合
     */
    private static List<Integer> dfsPostOrder(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == last) {
                results.add(cur.val);
                stack.pop();
                // 记录上一个访问的节点
                // 用于判断“访问根节点之前，右子树是否已访问过”
                last = cur;
                // 表示不需要转向，继续弹栈
                cur = null;
            } else {
                cur = cur.right;
            }
        }

        return results;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        left.val = 2;
        right.val = 3;
        root.left = left;
        root.right = right;

        List<Integer> list = dfsPreOrder(root);
        List<Integer> list2 = dfsInOrder(root);
        List<Integer> list3 = dfsPostOrder(root);
        System.out.println(list.toString());
        System.out.println(list2.toString());
        System.out.println(list3.toString());
    }
}