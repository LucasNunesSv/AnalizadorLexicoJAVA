package lang.ast.reserved;

import lang.ast.LNode;
import lang.ast.LVisitor;;

public class Return extends LNode {
    private Res e;

    public Return(int line, int col, Res e) {
        super(line, col);
        this.e = e;
    }

    public Res getRes() {
        return e;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}