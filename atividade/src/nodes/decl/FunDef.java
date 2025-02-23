package nodes.decl;

import nodes.LNode;
import nodes.literals.Lit;
import nodes.visitors.*;
import java.util.ArrayList;

public class FunDef extends LNode {

    private String fname;
    private ArrayList<Bind> params;
    private Lit ret;
    private LNode body;

    public FunDef(int l, int c, String s, ArrayList<Bind> params, Lit ret, LNode body) {
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

    public Lit getRet() {
        return ret;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }

}
