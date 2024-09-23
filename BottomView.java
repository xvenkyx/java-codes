package prac;

import java.util.*;

// Definition for a binary tree node
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BottomView {

    // Function to return the bottom view of the binary tree
    public ArrayList<Integer> bottomView(Node root) {
        // Map to store the bottom-most node at each horizontal distance
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // Queue for level order traversal, stores pairs of node and its horizontal distance
        Queue<Pair> queue = new LinkedList<>();
        
        // Start with the root node at horizontal distance 0
        if (root != null) {
            queue.add(new Pair(root, 0));
        }
        
        // Perform level-order traversal
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node currNode = p.node;
            int hd = p.hd;

            // Overwrite the horizontal distance with the current node's data
            map.put(hd, currNode.data);
            
            // If there is a left child, add it to the queue with horizontal distance -1
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, hd - 1));
            }
            
            // If there is a right child, add it to the queue with horizontal distance +1
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, hd + 1));
            }
        }
        
        // Extract the bottom view from the map
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer value : map.values()) {
            result.add(value);
        }
        
        return result;
    }
    
    // Helper class to store node and its horizontal distance
    class Pair {
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    // Main method to test the function
    public static void main(String[] args) {
        BottomView tree = new BottomView();
        
        // Construct the tree
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        // Call bottomView function and print the result
        ArrayList<Integer> result = tree.bottomView(root);
        System.out.println(result);  // Output: [5, 10, 3, 14, 25]
    }
}
