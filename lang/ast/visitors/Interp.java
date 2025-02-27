package lang.ast.visitors;

import lang.ast.LVisitor;
import lang.ast.Program;
import lang.ast.expr.*;
import lang.ast.reserved.*;

import java.util.*;
import lang.ast.types.*;
import lang.ast.command.*;
import lang.ast.decl.*;
import lang.ast.delimiters.*;
import lang.ast.eof.*;

public class Interp extends LVisitor {

  public Stack<Object> stk;

  public Interp() {
    stk = new Stack<Object>();
  }

  public Object getStackTop() {
    return stk.peek();
  }

  // public void visit(Attrib c);

  public void visit(MinusOperator e) {
  };

  public void visit(PlusOperator e) {
    e.getLeft().accept(this);
    e.getRight().accept(this);
    Integer r = (Integer) stk.pop() + (Integer) stk.pop();
    stk.push(r);
  };

  public void visit(MultOperator e) {
    e.getLeft().accept(this);
    e.getRight().accept(this);
    Integer r = (Integer) stk.pop() * (Integer) stk.pop();
    stk.push(r);
  };

  public void visit(DivOperator e) {
  };

  public void visit(Var e) {
  };

  public void visit(IntLit e) {
    stk.push(e.getValue());
  };

  public void visit(BoolLit e) {
    stk.push(e.getValue());
  };

  public void visit(TyBool t) {
  };

  public void visit(TyInt t) {
  }

  public void visit(Program p) {
  }

  public void visit(FunDef p) {
  }

  public void visit(Bind p) {
  }

  public void visit(Attrib c) {
  }

  public void visit(ModOperator o) {
  }

  public void visit(EqOperator o) {
  }

  public void visit(NeqOperator o) {
  }

  public void visit(LtOperator o) {
  }

  public void visit(GtOperator o) {
  }

  public void visit(DotOperator o) {
  }

  public void visit(FloatLit o) {
  }

  public void visit(CharLit o) {
  }

  public void visit(TyId t) {
  }

  public void visit(TyFloat t) {
  }

  public void visit(TyChar t) {
  }

  public void visit(TyNull t) {
  }

  public void visit(Comma d) {
  }

  public void visit(LBrace d) {
  }

  public void visit(RBrace d) {
  }

  public void visit(LBracket d) {
  }

  public void visit(RBracket d) {
  }

  public void visit(LParen d) {
  }

  public void visit(RParen d) {
  }

  public void visit(Semicolon d) {
  }

  public void visit(Data r) {
  }

  public void visit(If r) {
  }

  public void visit(Iterate r) {
  }

  public void visit(Print r) {
  }

  public void visit(Read r) {
  }

  public void visit(Res r) {
  }

  public void visit(Return r) {
  }

  public void visit(EOF e) {
  };

}
