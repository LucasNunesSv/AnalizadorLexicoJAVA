package nodes.reserved;

import nodes.LNode;
import nodes.visitors.*;

public class If extends LNode {
   private Res cond;
   private LNode thn;
   private LNode els;
   
   public If(int l, int c, Res e, LNode ths, LNode els){
      super(l,c);
      cond = e;
      this.thn = thn;
      this.els = els;
   }

   public Res getCond(){ return cond; }
   public LNode getThn(){ return thn; }
   public LNode getElse(){ return els; }

   public void accept(LVisitor v){ v.visit(this); }
}