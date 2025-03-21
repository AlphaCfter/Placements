package graphs;

import java.util.*;

public class BFSGraph {

    // Method to create a sample graph
    private static void createGraph(HashMap<Integer, ArrayList<Integer>> matrix) {
        matrix.put(0, new ArrayList<>());
        matrix.put(1, new ArrayList<>());
        matrix.put(2, new ArrayList<>());
        matrix.put(3, new ArrayList<>());

        matrix.get(0).add(1);
        matrix.get(0).add(2);
        matrix.get(0).add(3);

        matrix.get(1).add(4);
        matrix.get(1).add(7);

        matrix.get(2).add(5);

        matrix.get(3).add(6);

        // Queue is not used here in the creation process, but may be helpful in other cases
        Queue<Integer> queue = new LinkedList<>();

        // Checking if the graph is empty, but not used in the current implementation
        // if(matrix == null){
        //     System.out.println("The graph is empty");
        // }

        // No root nodes, so the output will differ depending on the node visited first
    }

    // Method to traverse the graph using BFS starting from the 'root' node
    public static void traverseBFS(HashMap<Integer, ArrayList<Integer>> matrix, Integer root) {
        if (!matrix.containsKey(root)) {
            System.out.println("Root node does not exist in the graph.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            System.out.print(currentNode + " ");

            // Get neighbors of the current node
            ArrayList<Integer> neighbors = matrix.get(currentNode);

            // Add all unvisited neighbors to the queue
            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    // Method to display the graph structure
    private static void displayGraph(HashMap<Integer, ArrayList<Integer>> matrix) {
        for (Map.Entry<Integer, ArrayList<Integer>> entry : matrix.entrySet()) {
            System.out.println("Node " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        HashMap<Integer, ArrayList<Integer>> matrix = new HashMap<>();

        // Creating the graph structure
        createGraph(matrix);

        // Displaying the graph structure
        System.out.println("Graph structure:");
        displayGraph(matrix);

        // Performing BFS traversal starting from node 0
        Integer root = 0;
        System.out.print("BFS traversal starting from node " + root + ": ");
        traverseBFS(matrix, root);
    }
}
