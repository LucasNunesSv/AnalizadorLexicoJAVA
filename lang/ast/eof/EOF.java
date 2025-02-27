package lang.ast.eof;

import lang.ast.LVisitor;
import lang.ast.LNode;

public class EOF extends LNode {
    public EOF(int line, int col) {
        super(line, col);
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
