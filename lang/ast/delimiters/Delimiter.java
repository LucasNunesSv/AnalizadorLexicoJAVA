package lang.ast.delimiters;

import lang.ast.LNode;

public abstract class Delimiter extends LNode {
    public Delimiter(int line, int col) {
        super(line, col);
    }
}
