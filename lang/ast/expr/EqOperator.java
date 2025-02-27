package lang.ast.expr;

import lang.ast.LVisitor;;

public abstract class EqOperator extends BinOp {
    public EqOperator(int line, int col, Exp el, Exp er) {
        super(line, col, el, er);
    }

    public String toString() {
        return "==";
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}