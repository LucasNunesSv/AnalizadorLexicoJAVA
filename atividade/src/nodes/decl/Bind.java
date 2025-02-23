package nodes.decl;

import nodes.visitors.*;
import nodes.literals.*;
import nodes.LNode;

public class Bind extends LNode {

    private Lit v;
    private Lit t;

    public Bind(int line, int col, Lit t, Lit v) {
        super(line, col);
        this.t = t;
        this.v = v;
    }

    public Lit getType() {
        return t;
    }

    public Lit getVar() {
        return v;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
