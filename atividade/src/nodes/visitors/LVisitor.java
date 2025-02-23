package nodes.visitors;

import nodes.reserved.*;
import nodes.ident.*;
import nodes.literals.*;
import nodes.operators.*;
import nodes.charTokens.*;
import nodes.delimiters.*;
import nodes.eof.*;
import nodes.decl.*;
import nodes.Program;

public abstract class LVisitor {
    public abstract void visit(Program p);

    // Palavras reservadas
    public abstract void visit(Data r); // DATA
    public abstract void visit(If r); // IF
    public abstract void visit(Iterate r); // ITERATE
    public abstract void visit(Read r); // READ
    public abstract void visit(Print r); // PRINT
    public abstract void visit(Return r); // RETURN

    // Identificadores e tipos
    public abstract void visit(Identifier i); // ID, TYPE
    public abstract void visit(TypeIdIdentifier i); // TYID
    public abstract void visit(PtrIdentifier i); // PTR

    // Literais
    public abstract void visit(IntLiteral l); // INT
    public abstract void visit(FloatLiteral l); // FLOAT
    public abstract void visit(CharLiteral l); // CHAR
    public abstract void visit(BoolLiteral l); // BOOL
    public abstract void visit(NullLiteral l); // NULL

    // Operadores
    public abstract void visit(PlusOperator o); // PLUS
    public abstract void visit(MinusOperator o); // MINUS
    public abstract void visit(MultOperator o); // MULT
    public abstract void visit(DivOperator o); // DIV
    public abstract void visit(ModOperator o); // MOD
    public abstract void visit(AtbrOperator o); // ATBR
    public abstract void visit(EqOperator o); // EQ
    public abstract void visit(NeqOperator o); // NEQ
    public abstract void visit(LtOperator o); // LT
    public abstract void visit(GtOperator o); // GT
    public abstract void visit(DotOperator o); // DOT

    // Delimitadores
    public abstract void visit(LBrace d); // LBRACE
    public abstract void visit(RBrace d); // RBRACE
    public abstract void visit(LBracket d); // LBRACKET 
    public abstract void visit(RBracket d); // RBRACKET
    public abstract void visit(LParen d); // LPAREN
    public abstract void visit(RParen d); // RPAREN
    public abstract void visit(Comma d); // COMMA, SEMICOLON
    public abstract void visit(Semicolon d); // SEMICOLON

    // Char tokens
    public abstract void visit(CharToken c); // NEWLINE, TAB, BACKSPACE, CARRIAGERETURN, BACKSLASH, SINGLEQUOTE, DOUBLEQUOTE, ASC

    // Outros
    public abstract void visit(FunDef x);
    public abstract void visit(Bind x);
    public abstract void visit(Block x);

    // Fim do arquivo
    public abstract void visit(EOF f); // EOF
}