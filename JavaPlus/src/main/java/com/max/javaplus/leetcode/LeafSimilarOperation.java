package com.max.javaplus.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className LeafSimilarOperation
 * @date 2021/5/10 9:23
 * @desc 叶子相似的树
 **/
public class LeafSimilarOperation {

    /**
     * Definition for a binary tree node.
     **/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 规则  顺序 从上到下  从左到右边

        // 按照规则 循环拿到每个节点的数据   将末梢节点 按顺序添加到集合中
        List<Integer> aNums = new ArrayList<>(128);
        List<Integer> bNums = new ArrayList<>(128);

        aNums = getValidData(root1, new ArrayList<TreeNode>(128));
        bNums = getValidData(root2, new ArrayList<TreeNode>(128));

        if (aNums.size() != bNums.size()) {
            return false;
        }
        for (int i = 0; i < aNums.size(); i++) {
            if (!aNums.get(i).equals(bNums.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getValidData(TreeNode root1, ArrayList<TreeNode> aNodes) {
        ArrayList<Integer> nums = new ArrayList<>(128);
        // 递归获取所有节点
        preNodeLoop(root1, aNodes);

        aNodes.forEach(node -> {
            if (null == node.left && null == node.right) {
                nums.add(node.val);
            }
        });
        return nums;
    }

    /**
     * 按前置排序存储所有节点数据
     **/
    public static void preNodeLoop(TreeNode node, List<TreeNode> result) {
        if (null == node) {
            return;
        }
        result.add(node);
        preNodeLoop(node.left, result);
        preNodeLoop(node.right, result);
    }
}
