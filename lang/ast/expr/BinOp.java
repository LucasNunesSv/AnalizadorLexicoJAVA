package lang.ast.expr;

public abstract class BinOp extends Exp {
      private Exp left, right;

      public BinOp(int line, int col, Exp el, Exp er) {
            super(line, col);
            left = el;
            right = er;
      }

      public Exp getLeft() {
            return left;
      }

      public Exp getRight() {
            return right;
      }
}
