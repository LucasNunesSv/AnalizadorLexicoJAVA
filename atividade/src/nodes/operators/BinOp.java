package nodes.operators;

public abstract class BinOp extends Op {
      private Op left, right;

      public BinOp(int line, int col, Op el, Op er){
           super(line,col);
           left = el;
           right = er;
      }

      public Op getLeft(){return left;}
      public Op getRight(){return right;}
}
