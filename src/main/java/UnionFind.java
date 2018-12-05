public class UnionFind {

    Node[] nodes;

    public UnionFind makeSet(int[] data) {
        nodes = new Node[data.length];
        for (int i = 0; i < data.length; i++) {
            nodes[i] = new Node(data[i]);
        }

        return this;
    }

    public Node find(Node node) {
        if (node != node.parent) {
            //path compression as recursion unwinds
            node.parent = find(node.parent);
        }
        return node.parent;
    }

    public void union(Node x, Node y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x.rank > y.rank) {
                y.parent = x;
            } else {
                x.parent = y;
                if (x.rank == y.rank) {
                    y.rank++;
                }
            }
        }
    }

    class Node {
        private int data;
        private int rank;
        private Node parent;

        public Node(int data) {
            this.data = data;
            this.rank = 0;
            this.parent = this;
        }
    }

}
