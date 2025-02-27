package lang.ast.expr;

import lang.ast.LVisitor;

public class IntLit extends Exp {
    private int value;

    public IntLit(int line, int col, int value) {
        super(line, col);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
