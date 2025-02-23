package nodes;

import nodes.visitors.LVisitor;

public abstract class LNode {
    private int l, c;

    public LNode(int line, int col) {
        l = line;
        c = col;
    }

    public int getLine() {
        return l;
    }

    public int getColumn() {
        return c;
    }

    public abstract void accept(LVisitor visitor);
}