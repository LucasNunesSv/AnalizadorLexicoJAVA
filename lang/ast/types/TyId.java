package lang.ast.types;

import lang.ast.LNode;
import lang.ast.LVisitor;

public class TyId extends LNode {
    private String typeName;

    public TyId(int line, int col, String typeName) {
        super(line, col);
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
