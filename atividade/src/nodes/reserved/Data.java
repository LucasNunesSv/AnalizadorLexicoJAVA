package nodes.reserved;

import nodes.LNode;
import nodes.visitors.*;

public class Data extends LNode {
    private final LNode type;
    private final String name;
    private final LNode initValue;

    public Data(int line, int col, LNode type, String name, LNode initValue) {
        super(line, col);
        this.type = type;
        this.name = name;
        this.initValue = initValue;
    }

    public LNode getType() { return type; }
    public String getName() { return name; }
    public LNode getInitValue() { return initValue; }
    
   public void accept(LVisitor v){ v.visit(this); }
}
