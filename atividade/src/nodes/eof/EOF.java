package nodes.eof;

import nodes.visitors.*;
import nodes.LNode;

public class EOF extends LNode {
    public EOF(int line, int col) { 
        super(line, col); 
    }

    public void accept(LVisitor v){ v.visit(this); }
}
