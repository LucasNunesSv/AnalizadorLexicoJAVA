/* Lexer para Lang */

import java.util.ArrayList;

%%

%public
%function nextToken
%type Token
%class LangLexer

%line
%column

%unicode

%eofval{
   return new Token( yyline, yycolumn, TK.EOF);
%eofval}

%state ARR,

%{
    private ArrayList<Integer> arr;

    private int toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter " + s + " para inteiro.");
            return 0;
        }
    }
%}

identifier = [a-z][a-zA-Z0-9_]*
TYID = [A-Z][a-zA-Z0-9_]*
number = [0-9]+
float = [0-9]+(\.[0-9]+)?
white = [ \n\t\r]+
comment = (/*([^]|[\r\n]|(*+([^/]|[\r\n])))*+/)|(//.)

%%

<YYINITIAL>{
    "data"      { return new Token(yyline, yycolumn, TK.DATA); }
    "if"        { return new Token(yyline, yycolumn, TK.IF); }
    "else"      { return new Token(yyline, yycolumn, TK.ELSE); }
    "iterate"   { return new Token(yyline, yycolumn, TK.ITERATE); }
    "read"      { return new Token(yyline, yycolumn, TK.READ); }
    "print"     { return new Token(yyline, yycolumn, TK.PRINT); }
    "return"    { return new Token(yyline, yycolumn, TK.RETURN); }
    {identifier} { return new Token(yyline, yycolumn, TK.ID, yytext()); }
    {TYID}       { return new Token(yyline, yycolumn, TK.TYID, yytext()); }
    {number}     { return new Token(yyline, yycolumn, TK.INT, toInt(yytext())); }
    {float}      { return new Token(yyline, yycolumn, TK.FLOAT, Float.parseFloat(yytext())); }
    {comment}    { /* Ignorar comentários */ }
    {white}      { /* Ignorar espaços */ }
    "+"          { return new Token(yyline, yycolumn, TK.PLUS); }
    "-"          { return new Token(yyline, yycolumn, TK.MINUS); }
    "*"          { return new Token(yyline, yycolumn, TK.MULT); }
    "/"          { return new Token(yyline, yycolumn, TK.DIV); }
    "%"          { return new Token(yyline, yycolumn, TK.MOD); }
    "="          { return new Token( yyline, yycolumn, TK.ATBR); }
    "=="         { return new Token(yyline, yycolumn, TK.EQ); }
    "!="         { return new Token(yyline, yycolumn, TK.NEQ); }
    "<"          { return new Token(yyline, yycolumn, TK.LT); }
    "{"          { return new Token(yyline, yycolumn, TK.LBRACE); }
    "}"          { return new Token(yyline, yycolumn, TK.RBRACE); }
    "("          { return new Token(yyline, yycolumn, TK.LPAREN); }
    ")"          { return new Token(yyline, yycolumn, TK.RPAREN); }
    ","          { return new Token(yyline, yycolumn, TK.COMMA); }
    ";"          { return new Token(yyline, yycolumn, TK.SEMICOLON); }
    [^]          { throw new Error("Caractere ilegal: " + yytext()); }
}
