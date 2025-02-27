package lang.ast;

import lang.ast.command.*;
import lang.ast.delimiters.*;
import lang.ast.expr.*;
import lang.ast.types.*;
import lang.ast.reserved.*;
import lang.ast.eof.*;
import lang.ast.decl.*;

public abstract class LVisitor {
    public abstract void visit(Program p);

    public abstract void visit(FunDef p);

    public abstract void visit(Bind p);

    // command
    public abstract void visit(Attrib c);

    // expr
    public abstract void visit(PlusOperator o); // PLUS

    public abstract void visit(MinusOperator o); // MINUS

    public abstract void visit(MultOperator o); // MULT

    public abstract void visit(DivOperator o); // DIV

    public abstract void visit(ModOperator o); // MOD

    public abstract void visit(EqOperator o); // EQ

    public abstract void visit(NeqOperator o); // NEQ

    public abstract void visit(LtOperator o); // LT

    public abstract void visit(GtOperator o); // GT

    public abstract void visit(DotOperator o); // DOT

    public abstract void visit(BoolLit o);

    public abstract void visit(IntLit o);

    public abstract void visit(FloatLit o);

    public abstract void visit(CharLit o);

    public abstract void visit(Var o);

    // types
    public abstract void visit(TyId t);

    public abstract void visit(TyBool t);

    public abstract void visit(TyInt t);

    public abstract void visit(TyFloat t);

    public abstract void visit(TyChar t);

    public abstract void visit(TyNull t);

    // delimiters
    public abstract void visit(Comma d);

    public abstract void visit(LBrace d);

    public abstract void visit(RBrace d);

    public abstract void visit(LBracket d);

    public abstract void visit(RBracket d);

    public abstract void visit(LParen d);

    public abstract void visit(RParen d);

    public abstract void visit(Semicolon d);

    // reserved
    public abstract void visit(Data r);

    public abstract void visit(If r);

    public abstract void visit(Iterate r);

    public abstract void visit(Print r);

    public abstract void visit(Read r);

    public abstract void visit(Res r);

    public abstract void visit(Return r);

    // EOF
    public abstract void visit(EOF e);
}