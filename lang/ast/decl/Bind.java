package lang.ast.decl;

import lang.ast.LVisitor;
import lang.ast.expr.Exp;
import lang.ast.expr.Var;

public class Bind extends Exp {

    private Var v;
    private Exp t;

    public Bind(int line, int col, Exp t, Var v) {
        super(line, col);
        this.t = t;
        this.v = v;
    }

    public Exp getType() {
        return t;
    }

    public Var getVar() {
        return v;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }

}
