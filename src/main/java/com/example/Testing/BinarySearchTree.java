package com.example.Testing;

import java.util.*;

public class BinarySearchTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertRecursive(node.left, val);
        } else if (val > node.val) {
            node.right = insertRecursive(node.right, val);
        }

        return node;
    }

    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(TreeNode node, int val) {
        if (node == null) {
            return false;
        }

        if (val == node.val) {
            return true;
        } else if (val < node.val) {
            return searchRecursive(node.left, val);
        } else {
            return searchRecursive(node.right, val);
        }
    }

    public void inorderTraversal() {
        inorderTraversalRecursive(root);
    }

    private void inorderTraversalRecursive(TreeNode node) {
        if (node != null) {
            inorderTraversalRecursive(node.left);
            System.out.print(node.val + " ");
            inorderTraversalRecursive(node.right);
        }
    }

    public void preorderTraversal() {

        preorderTraversalRecursive(root);
        System.out.println();
    }

    private void preorderTraversalRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderTraversalRecursive(node.left);
            preorderTraversalRecursive(node.right);
        }
    }

    public void postorderTraversal() {

        postorderTraversalRecursive(root);
        System.out.println();
    }

    private void postorderTraversalRecursive(TreeNode node) {
        if (node != null) {
            postorderTraversalRecursive(node.left);
            postorderTraversalRecursive(node.right);
            System.out.print(node.val + " ");
        }
    }

    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        System.out.println();
    }

    public void verticalOrderTraversal() {

        Map<Integer, List<Integer>> verticalMap = new TreeMap<>();
        verticalOrderTraversalRecursive(root, 0, verticalMap);

        for (List<Integer> values : verticalMap.values()) {
            for (int value : values) {
                System.out.print(value + " ");
            }

        }
        System.out.println();
    }

    private void verticalOrderTraversalRecursive(TreeNode node, int distance, Map<Integer, List<Integer>> verticalMap) {
        if (node == null) {
            return;
        }

        if (!verticalMap.containsKey(distance)) {
            verticalMap.put(distance, new ArrayList<>());
        }

        verticalMap.get(distance).add(node.val);

        verticalOrderTraversalRecursive(node.left, distance - 1, verticalMap);
        verticalOrderTraversalRecursive(node.right, distance + 1, verticalMap);
    }


}
