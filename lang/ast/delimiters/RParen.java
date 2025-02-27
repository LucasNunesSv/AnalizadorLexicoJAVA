package lang.ast.delimiters;

import lang.ast.LVisitor;

public class RParen extends Delimiter {
    public RParen(int line, int col) {
        super(line, col);
    }

    public String toString() {
        return ")";
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }

}
