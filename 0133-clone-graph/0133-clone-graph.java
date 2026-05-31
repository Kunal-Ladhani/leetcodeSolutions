/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Map<Integer, Node> map = new HashMap<>();      
        return cloneUtil(node, map);
    }

    private static Node cloneUtil(Node node, Map<Integer, Node> map) {
        if (node == null)
            return null;
        
        // we mark node that we visit once
        if (map.containsKey(node.val))
            return map.get(node.val);
        
        Node cloneNode = new Node(node.val);
        map.put(cloneNode.val, cloneNode);

        for (Node neighbor : node.neighbors)
            cloneNode.neighbors.add(cloneUtil(neighbor, map));

        return cloneNode;    
    }
}