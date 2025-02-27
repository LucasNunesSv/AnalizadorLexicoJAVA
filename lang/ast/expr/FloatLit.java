package lang.ast.expr;

import lang.ast.LNode;
import lang.ast.LVisitor;;

public class FloatLit extends LNode {
    public float value;

    public FloatLit(int line, int col, float value) {
        super(line, col);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}