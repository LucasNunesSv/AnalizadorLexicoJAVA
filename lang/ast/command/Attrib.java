package lang.ast.command;

import lang.ast.LNode;
import lang.ast.LVisitor;
import lang.ast.expr.Exp;

public class Attrib extends LNode{

    private Exp lhs;
    private Exp e;

    public Attrib(int line, int col, Exp lhs, Exp e) {
        super(line, col);
        this.lhs = lhs;
        this.e = e;
    }

    public Exp getExp() {
        return e;
    }

    public Exp getLhs() {
        return lhs;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }

}
