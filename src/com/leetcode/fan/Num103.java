package com.leetcode.fan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description :  二叉树的锯齿形层次遍历
 * @date : 2019/12/05.
 */

public class Num103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 左右子节点放在队列里面，flag为true，左->右遍历；flag为false，右->左遍历，
        // tmp表示当前层的节点val
        List<Integer> tmp = new ArrayList<>();
        // num表示下一层的节点个数; count表示当前层还有几个节点没有遍历
        int num = 0, count = 1;
        // flag==false表示当前层是奇数层; flag==true表示当前层是偶数层; 约定: root是奇数层
        boolean flag = false;
        //创建双端队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        //加入root
        queue.add(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            //奇数层:弹出队首元素; 左孩子先加入队尾,右孩子后加入队尾
            if (flag == false) {
                cur = queue.pollFirst();
                tmp.add(cur.val);
                if (cur.left != null) {
                    queue.addLast(cur.left);
                    num++;
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                    num++;
                }
            }
            //偶数层:弹出队尾元素; 右孩子先加入队首,左孩子后加入队首
            else {
                cur = queue.pollLast();
                tmp.add(cur.val);
                if (cur.right != null) {
                    queue.addFirst(cur.right);
                    num++;
                }
                if (cur.left != null) {
                    queue.addFirst(cur.left);
                    num++;
                }
            }
            count--;
            if (count == 0) {
                count = num;
                num = 0;
                flag = !flag;
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

