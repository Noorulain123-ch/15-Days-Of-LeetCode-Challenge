class Solution {

    Node[] cloned = new Node[101];  

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // if this node is already cloned, return it
        if (cloned[node.val] != null) {
            return cloned[node.val];
        }

        // create clone
        Node copy = new Node(node.val, new ArrayList<>());
        cloned[node.val] = copy;

        // clone neighbors
        for (Node n : node.neighbors) {
            copy.neighbors.add(cloneGraph(n));
        }

        return copy;
    }
}
