package lang.ast.decl;

import java.util.ArrayList;

import lang.ast.LNode;
import lang.ast.expr.Exp;
import lang.ast.LVisitor;

public class FunDef extends LNode {

    private String fname;
    private ArrayList<Bind> params;
    private Exp ret;
    private LNode body;

    public FunDef(int l, int c, String s, ArrayList<Bind> params, Exp ret, LNode body) {
        super(l, c);
        fname = s;
        this.params = params;
        this.ret = ret;
        this.body = body;
    }

    public String getFname() {
        return fname;
    }

    public ArrayList<Bind> getParams() {
        return params;
    }

    public LNode getBody() {
        return body;
    }

    public Exp getRet() {
        return ret;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}
