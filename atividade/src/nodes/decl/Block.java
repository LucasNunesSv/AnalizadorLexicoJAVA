package nodes.decl;

import java.util.ArrayList;
import nodes.LNode;
import nodes.visitors.*;

public class Block extends LNode {
    private ArrayList<LNode> statements;

    public Block(int line, int col, ArrayList<LNode> statements) {
        super(line, col);
        this.statements = statements;
    }

    public ArrayList<LNode> getStatements() {
        return statements;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
