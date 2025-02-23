package nodes.ident;

import nodes.LNode;
import nodes.visitors.*;

public class PtrIdentifier extends LNode {
    private final LNode baseType;

    public PtrIdentifier(int line, int col, LNode baseType) {
        super(line, col);
        this.baseType = baseType;
    }

    public LNode getBaseType() {
        return baseType;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
