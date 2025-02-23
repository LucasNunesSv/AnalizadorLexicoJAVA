package nodes.literals;

import nodes.visitors.*;

public class NullLiteral extends Lit {
    public NullLiteral(int line, int col) {
        super(line, col);
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
