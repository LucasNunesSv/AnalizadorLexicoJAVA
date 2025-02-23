package nodes.literals;

import nodes.visitors.*;

public class IntLiteral extends Lit {
    public int value;

    public IntLiteral(int line, int col, int value) {
        super(line, col);
        this.value = value;
    }

    public int getValue() { return value; }

    public void accept(LVisitor v){ v.visit(this); }
}