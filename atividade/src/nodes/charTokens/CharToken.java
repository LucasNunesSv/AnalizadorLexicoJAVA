package nodes.charTokens;

import nodes.LNode;

public abstract class CharToken extends LNode {
    private final char value;

    public CharToken(int line, int col, char value) {
        super(line, col);
        this.value = value;
    }

    public char getValue() { return value; }
}