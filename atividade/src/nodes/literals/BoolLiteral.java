package nodes.literals;

import nodes.visitors.*;

public class BoolLiteral extends Lit {
    public boolean value;

    public BoolLiteral(int line, int col, boolean value) {
        super(line, col);
        this.value = value;
    }

    public boolean getValue() { return value; }

    public void accept(LVisitor v){ v.visit(this); }
}