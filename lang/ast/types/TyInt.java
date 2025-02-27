package lang.ast.types;

import lang.ast.LNode;
import lang.ast.LVisitor;

public class TyInt extends LNode {
    public TyInt(int line, int col) {
        super(line, col);
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }

}
