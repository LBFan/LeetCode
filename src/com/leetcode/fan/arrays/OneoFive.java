package com.leetcode.fan.arrays;

/**
 * Created by : PF
 * Date on : 2018/11/27.
 */

public class OneoFive {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int[] inorder, int preindex, int sInorder, int eInorder) {
        if (preindex > preorder.length - 1 || sInorder > eInorder)
            return null;
        TreeNode treeNode = new TreeNode(preorder[preindex]);

        int index = sInorder;
        for (; index <= eInorder; index++) {
            if (treeNode.val == inorder[index]){
                break;
            }
        }

        treeNode.left = build(preorder, inorder, preindex+1, sInorder, index - 1); // 遍历左子树
        treeNode.right = build(preorder, inorder, preindex+index - sInorder+1, index+1, eInorder); // 遍历右子树

        return treeNode;
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};

        TreeNode result = new OneoFive().buildTree(pre, in);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

