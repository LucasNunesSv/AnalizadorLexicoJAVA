package lang.ast.expr;

import lang.ast.LVisitor;

public class Var extends Exp {
    private final String name;

    public Var(int line, int col, String name) {
        super(line, col);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
