package nodes.literals;

import nodes.visitors.*;

public class FloatLiteral extends Lit {
    public float value;

    public FloatLiteral(int line, int col, float value) {
        super(line, col);
        this.value = value;
    }

    public float getValue() { return value; }

    public void accept(LVisitor v){ v.visit(this); }
}