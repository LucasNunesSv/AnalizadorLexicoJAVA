package nodes.reserved;

import nodes.LNode;
import nodes.visitors.*;

public class Iterate extends LNode {
    private final LNode condition;
    private final LNode body;

    public Iterate(int line, int col, LNode condition, LNode body) {
        super(line, col);
        this.condition = condition;
        this.body = body;
    }

    public LNode getCondition() { return condition; }
    public LNode getBody() { return body; }

    public void accept(LVisitor v){ v.visit(this); }
}
