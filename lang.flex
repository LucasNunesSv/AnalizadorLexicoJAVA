/* Prototipo de um analizador lexico para linguagem Lang 
 * Lucas Nunes Silveira - 20.2.8040
 * Matheus Lopes Moreira - 20.2.8002
*/

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

// char_normal = "'" [a-zA-Z0-9 ] "'" 
char_normal = "'" [^'\\] "'" 
// char_escape = "'" ("\\n" | "\\t" | "\\b" | "\\r" | "\\'" | "\\\"" | "\\\\" [0-7]{1,3}) "'"
char_escape = "'" "\\" [ntbr\\\'\"] "'" | "'" "\\" [0-7]{1,3} "'"
 

comment_block = "{-" !([^]* "-}" [^]*) ("-}")
comment_line = "--" !([^]* "\n" [^]*) ("\n")

%%

<YYINITIAL>{
    "data"      { return new Token(yyline, yycolumn, TK.DATA); }
    "if"        { return new Token(yyline, yycolumn, TK.IF); }
    "else"      { return new Token(yyline, yycolumn, TK.ELSE); }
    "iterate"   { return new Token(yyline, yycolumn, TK.ITERATE); }
    "read"      { return new Token(yyline, yycolumn, TK.READ); }
    "print"     { return new Token(yyline, yycolumn, TK.PRINT); }
    "null"     { return new Token(yyline, yycolumn, TK.NULL); }
    "true"     { return new Token(yyline, yycolumn, TK.BOOL, "val: true"); }
    "false"     { return new Token(yyline, yycolumn, TK.BOOL, "val: false"); }
    "return"    { return new Token(yyline, yycolumn, TK.RETURN); }
    {identifier} { return new Token(yyline, yycolumn, TK.ID, "val: " + yytext()); }
    {TYID}       { return new Token(yyline, yycolumn, TK.TYID, "val: " + yytext()); }
    {char_normal} { 
        return new Token(yyline, yycolumn, TK.CHAR, "val: " + yytext().charAt(1)); 
    }
    {char_escape} { 
        String val = yytext().substring(1, yytext().length() - 1); // Remove aspas simples.
        if (val.startsWith("\\")) { // Verifica se é uma sequência de escape.
            switch (val.charAt(1)) {
                case 'n': return new Token(yyline, yycolumn, TK.NEWLINE, "val: \\n");
                case 't': return new Token(yyline, yycolumn, TK.TAB, "val: \\t");
                case 'b': return new Token(yyline, yycolumn, TK.BACKSPACE, "val: \\b");
                case 'r': return new Token(yyline, yycolumn, TK.CARRIAGERETURN, "val: \\r");
                case '\\': return new Token(yyline, yycolumn, TK.BACKSLASH, "val: \\\\"); // Retorna o caractere de barra invertida.
                case '\'': return new Token(yyline, yycolumn, TK.SINGLEQUOTE, "val: \\\'"); // Retorna o caractere de aspa simples.
                case '"': return new Token(yyline, yycolumn, TK.DOUBLEQUOTE, "val: \\\""); // Retorna o caractere de aspa dupla.
                default:
                    // Verifica se é um código ASCII (ex: \065)
                    if (Character.isDigit(val.charAt(1))) {
                        String asciiString = val.substring(1); // Remove o caractere de escape.
                        int asciiCode = Integer.parseInt(asciiString, 8); // Converte octal para decimal
                        return new Token(yyline, yycolumn, TK.ASC, "val: " + asciiCode);
                    } else {
                        System.out.println("Escape inválido: " + val);
                    }
            }
        }
    }
    {number}     { return new Token(yyline, yycolumn, TK.INT, "val: " + toInt(yytext())); }
    {float}      { return new Token(yyline, yycolumn, TK.FLOAT, "val: " + Float.parseFloat(yytext())); }
    {comment_block}   { /* Ignorar comentários em bloco*/ }
    {comment_line}    { /* Ignorar comentários em linha*/ }
    {white}      { /* Ignorar espaços */ }
    "+"          { return new Token(yyline, yycolumn, TK.PLUS, "+"); }
    "-"          { return new Token(yyline, yycolumn, TK.MINUS, "-"); }
    "*"          { return new Token(yyline, yycolumn, TK.MULT, "*"); }
    "/"          { return new Token(yyline, yycolumn, TK.DIV, "/"); }
    "%"          { return new Token(yyline, yycolumn, TK.MOD, "%"); }
    "="          { return new Token( yyline, yycolumn, TK.ATBR, "="); }
    "=="         { return new Token(yyline, yycolumn, TK.EQ, "=="); }
    "!="         { return new Token(yyline, yycolumn, TK.NEQ, "!="); }
    "<"          { return new Token(yyline, yycolumn, TK.LT, "<"); }
    ">"          { return new Token(yyline, yycolumn, TK.GT, ">"); }
    "{"          { return new Token(yyline, yycolumn, TK.LBRACE, "{"); }
    "}"          { return new Token(yyline, yycolumn, TK.RBRACE, "}"); }
    "["          { return new Token(yyline, yycolumn, TK.LBRACKET, "["); }
    "]"          { return new Token(yyline, yycolumn, TK.RBRACKET, "]"); }
    "("          { return new Token(yyline, yycolumn, TK.LPAREN, "("); }
    ")"          { return new Token(yyline, yycolumn, TK.RPAREN, ")"); }
    ","          { return new Token(yyline, yycolumn, TK.COMMA, ","); }
    "."          { return new Token(yyline, yycolumn, TK.DOT, "."); }
    ";"          { return new Token(yyline, yycolumn, TK.SEMICOLON, ";"); }
    "::"          { return new Token(yyline, yycolumn, TK.PTR, "::"); }
    ":"          { return new Token(yyline, yycolumn, TK.TYPE, ":"); }
    [^]          { throw new Error("Expressao Invalida!!! verifique se existem erros lexicos no arquivo teste"); }
}
