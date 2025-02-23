package nodes.delimiters;

import nodes.visitors.LVisitor;

public class RBrace extends Delimiter {
    public RBrace(int line, int col) {
        super(line, col);
    }

    public String toString() {
        return "}";
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
