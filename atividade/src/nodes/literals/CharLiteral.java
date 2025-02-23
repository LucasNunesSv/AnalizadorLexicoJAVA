package nodes.literals;

import nodes.visitors.*;

public class CharLiteral extends Lit {
    public char value;

    public CharLiteral(int line, int col, char value) {
        super(line, col);
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}