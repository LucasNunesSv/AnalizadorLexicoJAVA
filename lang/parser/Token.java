/* Prototipo de um analizador lexico para linguagem Lang 
 * Lucas Nunes Silveira - 20.2.8040
 * Matheus Lopes Moreira - 20.2.8002
*/
package lang.parser;

public class Token {

    public Object value;
    public TK tk;
    public int line;
    public int column;

    public Token(int line, int column, TK t) {
        this.line = line;
        this.column = column;
        value = null;
        tk = t;
    }

    public Token(int line, int column, TK t, Object v) {
        this.line = line;
        this.column = column;
        tk = t;
        value = v;
    }

    public String toString() {
        return "(" + line + "," + column + ") TK: " + tk + (value == null ? "" : " - val [" + value.toString() + "] ");
    }

}
