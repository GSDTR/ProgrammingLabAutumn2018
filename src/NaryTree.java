public class NaryTree {
    NaryTreeNode root = null;
    int dim;
    int size = 0;

    public NaryTree(int dim) {
        this.dim = dim;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public boolean add(int newValue) {
        if (contains(newValue)) return false;
        if (root == null) {
            NaryTreeNode node = new NaryTreeNode(dim);
            node.addValueToNode(newValue);
            root = node;
        } else {
            NaryTreeNode node = root;
            while (true) {
                if (node.isItSuitableNode(newValue)) {
                    node.addValueToNode(newValue);
                    break;
                }
                node = node.getChildNode(newValue);
            }
        }
        size++;
        return true;
    }

    public boolean contains(int value) {
        if (!isEmpty()) {
            return (findNodeForValue(value) != null);
        } else {
            return false;
        }
    }

    public NaryTreeNode getParent(int value) {
        if (root.contains(value)) return null;
        NaryTreeNode node = root;
        NaryTreeNode parent = root;
        while (true) {
            if (node.contains(value)) {
                return parent;
            }
            parent = node;
            node = node.getNextNode(value);
            if (node == null) return null;
        }
    }

    public NaryTreeNode findNodeForValue(int value) {
        NaryTreeNode parent = getParent(value);
        if (parent != null) {
            return parent.getNextNode(value);
        } else {
            if (root.contains(value)) return root;
            else return null;
        }
    }

    public boolean remove(int value) {
        if (!contains(value)) return false;
        if (size == 1) {
            size--;
            root = null;
        } else {
            NaryTreeNode parent = getParent(value);
                if (root.keys[1] == 0) {
                    root = root.child[0];
                    size--;
                    return true;
                }
                NaryTreeNode node;
                if (parent == null) node = root; else node = findNodeForValue(value);
                if (node.keys[1] != 0) {
                    int ind = node.getIndex(value);
                    if (node.child[ind + 1] != null) {
                        int small = node.smallestValue(ind);
                        remove(small);
                        node.keys[ind] = small;
                        return true;
                    }
                    if (node.child[ind + 1] == null && node.child[ind] != null) {
                        int big = node.biggestValue(ind);
                        remove(big);
                        node.keys[ind] = big;
                        return true;
                    }
                    if (node.child[ind + 1] == null && node.child[ind] == null) {
                        node.shiftValues(value);
                        size--;
                        return true;
                    }
                } else {
                    parent.child[parent.getNextIndex(value)] = node.child[0];
                    size--;
                }
        }
        return true;
    }
}