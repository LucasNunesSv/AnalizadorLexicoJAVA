import nodes.visitors.LVisitor;
import nodes.reserved.*;
import nodes.literals.*;
import nodes.ident.*;
import nodes.operators.*;
import nodes.eof.*;
import nodes.decl.*;
import nodes.delimiters.*;

import nodes.Program;
import nodes.charTokens.CharToken;
import nodes.LNode;

public class ASTPrinter extends LVisitor {
    private int indentLevel = 0;

    private void indent() {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("    ");
        }
    }

    @Override
    public void visit(Program p) {
        indent();
        System.out.println("Program:");
        indentLevel++;
        for (FunDef f : p.getFuncs()) {
            f.accept(this);
        }
        indentLevel--;
    }

    @Override
    public void visit(Data r) {
        indent();
        System.out.print("Data " + r.getName() + " = ");
        r.getInitValue().accept(this);
        System.out.println();
    }

    @Override
    public void visit(If r) {
        indent();
        System.out.println("If Statement");
        indentLevel++;
        r.getCond().accept(this);
        r.getThn().accept(this);
        if (r.getElse() != null) {
            indent();
            System.out.println("Else");
            r.getElse().accept(this);
        }
        indentLevel--;
    }

    @Override
    public void visit(Iterate r) {
        indent();
        System.out.println("Iterate Loop");
        indentLevel++;
        r.getCondition().accept(this);
        r.getBody().accept(this);
        indentLevel--;
    }

    @Override
    public void visit(Read r) {
        indent();
        System.out.println("Read");
    }

    @Override
    public void visit(Print r) {
        indent();
        System.out.print("Print: ");
        r.getRes().accept(this);
        System.out.println();
    }

    @Override
    public void visit(Return r) {
        indent();
        System.out.print("Return: ");
        r.getRes().accept(this);
        System.out.println();
    }

    @Override
    public void visit(Identifier i) {
        System.out.print("Identifier(" + i.getName() + ")");
    }

    @Override
    public void visit(TypeIdIdentifier t) {
        System.out.print("TypeIdIdentifier(" + t.getTypeName() + ")");
    }

    @Override
    public void visit(PtrIdentifier p) {
        System.out.print("PtrIdentifier(" + p.getBaseType() + ")");
    }

    @Override
    public void visit(IntLiteral l) {
        System.out.print("IntLiteral(" + l.getValue() + ")");
    }

    @Override
    public void visit(FloatLiteral l) {
        System.out.print("FloatLiteral(" + l.getValue() + ")");
    }

    @Override
    public void visit(CharLiteral l) {
        System.out.print("CharLiteral(" + l.getValue() + ")");
    }

    @Override
    public void visit(BoolLiteral l) {
        System.out.print("BoolLiteral(" + l.getValue() + ")");
    }

    @Override
    public void visit(NullLiteral l) {
        System.out.print("Null");
    }

    @Override
    public void visit(PlusOperator o) {
        System.out.print("PlusOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(MinusOperator o) {
        System.out.print("MinusOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(MultOperator o) {
        System.out.print("MultOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(DivOperator o) {
        System.out.print("DivOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(ModOperator o) {
        System.out.print("ModOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(AtbrOperator o) {
        System.out.print("AtbrOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(EqOperator o) {
        System.out.print("EqOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(NeqOperator o) {
        System.out.print("NeqOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(LtOperator o) {
        System.out.print("LtOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(GtOperator o) {
        System.out.print("GtOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(DotOperator o) {
        System.out.print("DotOperator(" + o.toString() + ")");
    }

    @Override
    public void visit(LBrace d) {
        indent();
        System.out.print("LBrace(" + d.toString() + ")");
    }

    @Override
    public void visit(RBrace d) {
        indent();

        System.out.print("RBrace(" + d.toString() + ")");
    }

    @Override
    public void visit(LBracket d) {
        indent();

        System.out.print("LBracket(" + d.toString() + ")");
    }

    @Override
    public void visit(RBracket d) {
        indent();

        System.out.print("RBracket(" + d.toString() + ")");
    }

    @Override
    public void visit(LParen d) {
        indent();

        System.out.print("LParen(" + d.toString() + ")");
    }

    @Override
    public void visit(RParen d) {
        indent();

        System.out.print("RParen(" + d.toString() + ")");
    }

    @Override
    public void visit(Comma d) {
        indent();

        System.out.print("Comma(" + d.toString() + ")");
    }

    @Override
    public void visit(Semicolon d) {
        indent();

        System.out.print("Semicolon(" + d.toString() + ")");
    }

    @Override
    public void visit(CharToken c) {
        indent();
        System.out.println("CharToken: " + c.getValue());
    }

    @Override
    public void visit(FunDef f) {
        indent();
        System.out.println("Function: " + f.getFname());
        indentLevel++;
        for (Bind param : f.getParams()) {
            param.accept(this);
        }
        f.getBody().accept(this);
        indentLevel--;
    }

    @Override
    public void visit(Block b) {
        indent();
        System.out.println("Block:");
        indentLevel++;
        for (LNode stmt : b.getStatements()) {
            stmt.accept(this);
            System.out.println();
        }
        indentLevel--;
    }

    @Override
    public void visit(Bind b) {
        indent();
        System.out.println("Bind");
    }

    @Override
    public void visit(EOF f) {
        System.out.println("End of file");
    }
}
