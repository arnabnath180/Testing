package com.example.Testing;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    void bfsAndDfsUndirectedGraph() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 0); // Adding the equivalent edge for an undirected graph
        graph.addEdge(0, 2);
        graph.addEdge(2, 0); // Adding the equivalent edge for an undirected graph
        graph.addEdge(1, 2);
        graph.addEdge(2, 1); // Adding the equivalent edge for an undirected graph
        graph.addEdge(2, 3);
        graph.addEdge(3, 2); // Adding the equivalent edge for an undirected graph


        // Expected BFS traversal starting from vertex 2: 2 0 3 1
        Set<Integer> bfsExpected = Set.of(2, 0, 3, 1);
        Set<Integer> bfsActual = new HashSet<>();
        captureOutput(() -> graph.bfs(2), bfsActual);

        assertTrue(bfsExpected.containsAll(bfsActual) && bfsActual.containsAll(bfsExpected),
                "BFS traversal mismatch");

        // Expected DFS traversal starting from vertex 2: 2 0 1 3
        Set<Integer> dfsExpected = Set.of(2, 0, 1, 3);
        Set<Integer> dfsActual = new HashSet<>();
        captureOutput(() -> graph.dfs(2), dfsActual);

        assertTrue(dfsExpected.containsAll(dfsActual) && dfsActual.containsAll(dfsExpected),
                "DFS traversal mismatch");
    }

    private void captureOutput(Runnable runnable, Set<Integer> result) {
        // Redirect System.out.println to capture the output
        var originalOut = System.out;
        try {
            var outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));
            runnable.run();
            String[] outputNodes = outputStream.toString().trim().split("\\s+");
            for (String node : outputNodes) {
                result.add(Integer.parseInt(node));
            }
        } finally {
            // Restore System.out to its original state
            System.setOut(originalOut);
        }
    }

    @Test
    void testGraphWithCycle() {
        Graph graphWithCycle = new Graph();
        graphWithCycle.addEdge(0, 1);
        graphWithCycle.addEdge(1, 2);
        graphWithCycle.addEdge(2, 0);

        assertTrue(graphWithCycle.hasCycle(), "Graph with cycle should return true for hasCycle");
    }

    @Test
    void testGraphWithoutCycle() {
        Graph graphWithoutCycle = new Graph();
        graphWithoutCycle.addEdge(0, 1);
        graphWithoutCycle.addEdge(1, 2);

        assertFalse(graphWithoutCycle.hasCycle(), "Graph without cycle should return false for hasCycle");
    }

    @Test
    void testTopologicalSort() {
        Graph graph = new Graph();
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        assertFalse(graph.hasCycle(), "Graph should not have a cycle");

        List<Integer> result = graph.topologicalSort();
        Integer[] expectedOrder = {5, 4, 0, 2, 3, 1}; // Expected topological order

        assertArrayEquals(expectedOrder, result.toArray(), "Topological sort order is incorrect");

    }

}
