package lang.ast.types;

import lang.ast.LNode;
import lang.ast.LVisitor;

public class TyBool extends LNode {

    public TyBool(int line, int col) {
        super(line, col);
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
