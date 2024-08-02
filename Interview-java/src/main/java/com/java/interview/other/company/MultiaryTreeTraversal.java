package com.java.interview.other.company;


import java.util.*;

/**
 * 美的2
 * 多叉树的层次遍历
 *
 * @author 79183
 * @date 2024/3/26 14:38
 */
public class MultiaryTreeTraversal {
    public static void main(String[] args) {
        // 构建多叉树
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.children = Arrays.asList(node2, node3);
        node2.children = Arrays.asList(node4, node5, node6);
        node4.children = Arrays.asList(node7);

        // 层次遍历
        List<Integer> result = levelOrderTraversal(root);
        System.out.println("层次遍历结果：" + result);
    }

    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.children != null) {
                    for (TreeNode child : node.children) {
                        queue.offer(child);
                    }
                }
            }
        }

        return result;
    }

    public static class TreeNode {
        public int val;
        public List<TreeNode> children;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, List<TreeNode> children) {
            this.val = val;
            this.children = children;
        }
    }
}
