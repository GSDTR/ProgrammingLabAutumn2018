public class NaryTreeNode {
    int[] keys;
    NaryTreeNode[] child;

    public NaryTreeNode(int dim) {
        this.keys = new int[dim - 1];//ссылки на потомков
        this.child = new NaryTreeNode[dim];//сортированные числа, значения узла
    }

    public void addValueToNode(int value) {
        for (int j = 0; j < keys.length; j++) {
            if (keys[j] == 0) {
                keys[j] = value;
                break;
            }
        }
    }

    public void addChildNode(int index) {
        child[index] = new NaryTreeNode(child.length);
    }

    public boolean isItSuitableNode(int value) {
        for (int j = 0; j < keys.length; j++) {
            if (keys[j] > value) {
                return false;
            }
        }
        return (keys[keys.length - 1] == 0);
    }

    public NaryTreeNode getChildNode(int value) {
        for (int j = 0; j < keys.length; j++) {
            if (keys[j] > value) {
                if (child[j] == null) {
                    addChildNode(j);
                }
                return child[j];
            }
        }
        if (child[child.length - 1] == null) {
            addChildNode(child.length - 1);
        }
        return child[child.length - 1];
    }

    public NaryTreeNode getNextNode(int value) {
        return child[getNextIndex(value)];
    }

    public int getNextIndex(int value) {
        for (int j = 0; j < keys.length; j++) {
            if (keys[j] > value) {
                return j;
            }
        }
        return child.length - 1;
    }

    public boolean contains(int value) {
        for (int j = 0; j < keys.length; j++) {
            if (keys[j] == value) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(int value) {
        for (int j = 0; j < keys.length; j++) {
            if (keys[j] == value) {
                return j;
            }
        }
        return 0;
    }

    public int biggestValue(int index) {
        NaryTreeNode node = child[index];
        while (true) {
            for (int j = 0; j < node.keys.length - 1; j++) {
                if (node.keys[j] == 0) {
                    index = j - 1;
                    break;
                }
            }
            if (node.keys[node.keys.length - 1] != 0) index = node.keys.length - 1;
            if (node.child[index + 1] == null) {
                return node.keys[index];
            } else {
                node = node.child[index + 1];
            }
        }
    }

    public int smallestValue(int index) {
        NaryTreeNode node = child[index + 1];
        while (true) {
            if (node.child[0] != null) {
                node = node.child[0];
            } else {
                return node.keys[0];
            }
        }
    }

    public void shiftValues(int i) {
        for (int j = 0; j < keys.length - 1; j++) {
            if (keys[j] >= i) {
                keys[j] = keys[j + 1];
                child[j] = child[j + 1];
            }
        }
        keys[keys.length - 1] = 0;
        child[child.length - 2] = child[child.length - 1];
        child[child.length - 1] = null;
    }
}
