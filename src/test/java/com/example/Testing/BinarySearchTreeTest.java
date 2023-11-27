package com.example.Testing;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    @Test
    void testInsertAndInorderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // Inorder traversal: 2 3 4 5 6 7 8
        assertEquals("2 3 4 5 6 7 8", captureOutput(() -> bst.inorderTraversal()));
    }

    @Test
    void testSearch() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        assertTrue(bst.search(6));
        assertFalse(bst.search(1));
    }

    @Test
    void testPreorderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // Preorder traversal: 5 3 2 4 7 6 8
        assertEquals("5 3 2 4 7 6 8", captureOutput(() -> bst.preorderTraversal()));
    }

    @Test
    void testPostorderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // Postorder traversal: 2 4 3 6 8 7 5
        assertEquals("2 4 3 6 8 7 5", captureOutput(() -> bst.postorderTraversal()));
    }

    @Test
    void testLevelOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // Level order traversal: 5 3 7 2 4 6 8
        assertEquals("5 3 7 2 4 6 8", captureOutput(() -> bst.levelOrderTraversal()));
    }

    @Test
    void testVerticalOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // Vertical order traversal:
        // 2
        // 3
        // 5 6
        // 7
        // 8
        assertEquals("2 3 5 4 6 7 8", captureOutput(() -> bst.verticalOrderTraversal()));
    }

    // Helper method to capture console output
    private String captureOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        runnable.run();

        System.setOut(originalOut);
        return outputStream.toString().trim();
    }

}
