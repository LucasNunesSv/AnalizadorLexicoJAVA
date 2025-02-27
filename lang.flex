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
float = [0-9]*(\.[0-9]+)
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
    "true"     { return new Token(yyline, yycolumn, TK.BOOL, true); }
    "false"     { return new Token(yyline, yycolumn, TK.BOOL, false); }
    "return"    { return new Token(yyline, yycolumn, TK.RETURN); }
    {identifier} { return new Token(yyline, yycolumn, TK.ID, yytext()); }
    {TYID}       { return new Token(yyline, yycolumn, TK.TYID, yytext()); }
    {char_normal} { 
        return new Token(yyline, yycolumn, TK.CHAR, yytext().charAt(1)); 
    }
    {char_escape} { 
        String val = yytext().substring(1, yytext().length() - 1); // Remove aspas simples.
        if (val.startsWith("\\")) { // Verifica se é uma sequência de escape.
            switch (val.charAt(1)) {
                case 'n': return new Token(yyline, yycolumn, TK.NEWLINE);
                case 't': return new Token(yyline, yycolumn, TK.TAB);
                case 'b': return new Token(yyline, yycolumn, TK.BACKSPACE);
                case 'r': return new Token(yyline, yycolumn, TK.CARRIAGERETURN);
                case '\\': return new Token(yyline, yycolumn, TK.BACKSLASH); // Retorna o caractere de barra invertida.
                case '\'': return new Token(yyline, yycolumn, TK.SINGLEQUOTE); // Retorna o caractere de aspa simples.
                case '"': return new Token(yyline, yycolumn, TK.DOUBLEQUOTE); // Retorna o caractere de aspa dupla.
                default:
                    // Verifica se é um código ASCII octal (ex: \065)
                    if (Character.isDigit(val.charAt(1))) {
                        try {
                            String numericValue = val.substring(1); // Pega apenas a parte numérica após a barra invertida
                            int asciiCode = Integer.parseInt(numericValue); // Converte para inteiro sem mudar de base
                            return new Token(yyline, yycolumn, TK.CHAR, (char) asciiCode);
                        } catch (NumberFormatException e) {
                            System.out.println("Escape numérico inválido: " + val);
                        }
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
    "+"          { return new Token(yyline, yycolumn, TK.PLUS); }
    "-"          { return new Token(yyline, yycolumn, TK.MINUS); }
    "*"          { return new Token(yyline, yycolumn, TK.MULT); }
    "/"          { return new Token(yyline, yycolumn, TK.DIV); }
    "%"          { return new Token(yyline, yycolumn, TK.MOD); }
    "="          { return new Token( yyline, yycolumn, TK.ATBR); }
    "=="         { return new Token(yyline, yycolumn, TK.EQ); }
    "!="         { return new Token(yyline, yycolumn, TK.NEQ); }
    "<"          { return new Token(yyline, yycolumn, TK.LT); }
    ">"          { return new Token(yyline, yycolumn, TK.GT); }
    "{"          { return new Token(yyline, yycolumn, TK.LBRACE); }
    "}"          { return new Token(yyline, yycolumn, TK.RBRACE); }
    "["          { return new Token(yyline, yycolumn, TK.LBRACKET); }
    "]"          { return new Token(yyline, yycolumn, TK.RBRACKET); }
    "("          { return new Token(yyline, yycolumn, TK.LPAREN); }
    ")"          { return new Token(yyline, yycolumn, TK.RPAREN); }
    ","          { return new Token(yyline, yycolumn, TK.COMMA); }
    "."          { return new Token(yyline, yycolumn, TK.DOT); }
    ";"          { return new Token(yyline, yycolumn, TK.SEMICOLON); }
    "::"          { return new Token(yyline, yycolumn, TK.PTR); }
    ":"          { return new Token(yyline, yycolumn, TK.TYPE); }
    [^]          { throw new Error("Expressao Invalida!!! verifique se existem erros lexicos no arquivo teste"); }
}
