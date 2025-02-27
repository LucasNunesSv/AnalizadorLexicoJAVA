package lang.ast.expr;

import lang.ast.LNode;
import lang.ast.LVisitor;

public class CharLit extends LNode {
    public char value;

    public CharLit(int line, int col, char value) {
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
