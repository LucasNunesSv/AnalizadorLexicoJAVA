package lang.ast.reserved;

import lang.ast.LNode;
import lang.ast.LVisitor;;

public class If extends LNode {
   private Res cond;
   private LNode thn;
   private LNode els;

   public If(int l, int c, Res e, LNode ths, LNode els) {
      super(l, c);
      cond = e;
      this.els = els;
   }

   public Res getCond() {
      return cond;
   }

   public LNode getThn() {
      return thn;
   }

   public LNode getElse() {
      return els;
   }

   public void accept(LVisitor v) {
      v.visit(this);
   }
}