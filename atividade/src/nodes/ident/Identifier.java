package nodes.ident;

import nodes.LNode;
import nodes.visitors.*;

public class Identifier extends LNode {
    private final String name;

    public Identifier(int line, int col, String name) {
        super(line, col);
        this.name = name;
    }

    public String getName() { return name; }

    public void accept(LVisitor v){ v.visit(this); }
}
