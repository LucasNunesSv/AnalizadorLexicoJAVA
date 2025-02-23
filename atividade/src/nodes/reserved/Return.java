package nodes.reserved;

import nodes.LNode;
import nodes.visitors.*;

public class Return extends LNode {
    private Res e;

    public Return(int line, int col, Res e){
        super(line,col);
        this.e = e;
    }

    public Res getRes(){ return e;}

    public void accept(LVisitor v){v.visit(this);}
}