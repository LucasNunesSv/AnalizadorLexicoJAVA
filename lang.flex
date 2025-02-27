/* Prototipo de um analizador lexico para linguagem Lang 
 * Lucas Nunes Silveira - 20.2.8040
 * Matheus Lopes Moreira - 20.2.8002
*/

package parser;

import java.util.ArrayList;
import java_cup.runtime.Symbol;

%%

%public
%function nextToken
%type Symbol
%class LangLexer

%line
%column

%unicode

%eofval{
   return new Symbol( yyline, yycolumn, LangParserSym.EOF);
%eofval}

%state ARR,

%{
    private ArrayList<Integer> arr;

    private int toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Impossible error converting " + s + " to integer");
            return 0;
        }
    }

    private float toFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            System.out.println("Impossible error converting " + s + " to float");
            return 0;
        }
    }
%}

/* Macro Definitions */
identifier = [a-z][a-zA-Z0-9_]*
TYID = [A-Z][a-zA-Z0-9_]*
integer = [0-9]+
float = [0-9]*(\.[0-9]+)
white = [ \n\t\r]+
char_normal = "'" [^'\\] "'" 
char_escape = "'" "\\" [ntbr\\\'\"] "'" | "'" "\\" [0-9]{3} "'"
 

comment_block = "{-" !([^]* "-}" [^]*) ("-}")
comment_line = "--" !([^]* "\n" [^]*) ("\n")

%%

<YYINITIAL>{
    "--"  !([^]* \R [^]*) \R  {}

    /* Data types */
    "Int"       { return new Symbol(yyline, yycolumn, LangParserSym.INT); }
    "Float"     { return new Symbol(yyline, yycolumn, LangParserSym.FLOAT); }
    "Char"      { return new Symbol(yyline, yycolumn, LangParserSym.CHAR); }
    "Bool"      { return new Symbol(yyline, yycolumn, LangParserSym.BOOL); }
    {TYID}       { return new Symbol(yyline, yycolumn, LangParserSym.TYID, yytext()); }

    /* Reserved words */
    "data"      { return new Symbol(yyline, yycolumn, LangParserSym.DATA); }
    "if"        { return new Symbol(yyline, yycolumn, LangParserSym.IF); }
    "else"      { return new Symbol(yyline, yycolumn, LangParserSym.ELSE); }
    "iterate"   { return new Symbol(yyline, yycolumn, LangParserSym.ITERATE); }
    "read"      { return new Symbol(yyline, yycolumn, LangParserSym.READ); }
    "print"     { return new Symbol(yyline, yycolumn, LangParserSym.PRINT); }
    "null"     { return new Symbol(yyline, yycolumn, LangParserSym.NULL); }
    "return"    { return new Symbol(yyline, yycolumn, LangParserSym.RETURN); }

    /* Logical literals */
    "true"     { return new Symbol(yyline, yycolumn, LangParserSym.BOOL, true); }
    "false"     { return new Symbol(yyline, yycolumn, LangParserSym.BOOL, false); }

    
    /* Identifiers and literals */
    {identifier} { return new Symbol(yyline, yycolumn, LangParserSym.ID, yytext()); }
    {char_normal} { 
        return new Symbol(yyline, yycolumn, LangParserSym.CHAR_LITERAL, yytext().charAt(1)); 
    }
    {char_escape} { 
        String val = yytext().substring(1, yytext().length() - 1); // Remove aspas simples.
        if (val.startsWith("\\")) { // Verifica se é uma sequência de escape.
            switch (val.charAt(1)) {
                case 'n': return new Symbol(yyline, yycolumn, LangParserSym.NEWLINE);
                case 't': return new Symbol(yyline, yycolumn, LangParserSym.TAB);
                case 'b': return new Symbol(yyline, yycolumn, LangParserSym.BACKSPACE);
                case 'r': return new Symbol(yyline, yycolumn, LangParserSym.CARRIAGERETURN);
                case '\\': return new Symbol(yyline, yycolumn, LangParserSym.BACKSLASH); // Retorna o caractere de barra invertida.
                case '\'': return new Symbol(yyline, yycolumn, LangParserSym.SINGLEQUOTE); // Retorna o caractere de aspa simples.
                case '"': return new Symbol(yyline, yycolumn, LangParserSym.DOUBLEQUOTE); // Retorna o caractere de aspa dupla.
                default:
                    // Verifica se é um código ASCII octal (ex: \065)
                    if (Character.isDigit(val.charAt(1))) {
                        try {
                            String numericValue = val.substring(1); // Pega apenas a parte numérica após a barra invertida
                            int asciiCode = Integer.parseInt(numericValue); // Converte para inteiro sem mudar de base
                            return new Symbol(yyline, yycolumn, LangParserSym.CHAR_LITERAL, (char) asciiCode);
                        } catch (NumberFormatException e) {
                            System.out.println("Escape numérico inválido: " + val);
                        }
                    } else {
                        System.out.println("Escape inválido: " + val);
                    }
            }
        }
    }
    {integer}     { return new Symbol(yyline, yycolumn, LangParserSym.INT_LITERAL, "val: " + toInt(yytext())); }
    {float}      { return new Symbol(yyline, yycolumn, LangParserSym.FLOAT_LITERAL, "val: " + toFloat(yytext())); }
    
    /* Comments (ignored) */
    {comment_block}   { /* Ignorar comentários em bloco*/ }
    {comment_line}    { /* Ignorar comentários em linha*/ }
    {white}      { /* Ignorar espaços */ }

    /* Operators and punctuation */
    "+"          { return new Symbol(yyline, yycolumn, LangParserSym.PLUS); }
    "-"          { return new Symbol(yyline, yycolumn, LangParserSym.MINUS); }
    "*"          { return new Symbol(yyline, yycolumn, LangParserSym.MULT); }
    "/"          { return new Symbol(yyline, yycolumn, LangParserSym.DIV); }
    "%"          { return new Symbol(yyline, yycolumn, LangParserSym.MOD); }
    "="          { return new Symbol( yyline, yycolumn, LangParserSym.ATBR); }
    "=="         { return new Symbol(yyline, yycolumn, LangParserSym.EQ); }
    "!="         { return new Symbol(yyline, yycolumn, LangParserSym.NEQ); }
    "<"          { return new Symbol(yyline, yycolumn, LangParserSym.LT); }
    ">"          { return new Symbol(yyline, yycolumn, LangParserSym.GT); }
    "{"          { return new Symbol(yyline, yycolumn, LangParserSym.LBRACE); }
    "}"          { return new Symbol(yyline, yycolumn, LangParserSym.RBRACE); }
    "["          { return new Symbol(yyline, yycolumn, LangParserSym.LBRACKET); }
    "]"          { return new Symbol(yyline, yycolumn, LangParserSym.RBRACKET); }
    "("          { return new Symbol(yyline, yycolumn, LangParserSym.LPAREN); }
    ")"          { return new Symbol(yyline, yycolumn, LangParserSym.RPAREN); }
    ","          { return new Symbol(yyline, yycolumn, LangParserSym.COMMA); }
    "."          { return new Symbol(yyline, yycolumn, LangParserSym.DOT); }
    ";"          { return new Symbol(yyline, yycolumn, LangParserSym.SEMICOLON); }
    // "::"          { return new Symbol(yyline, yycolumn, LangParserSym.PTR); }
    ":"          { return new Symbol(yyline, yycolumn, LangParserSym.TYPE); }
    
    /* Error for illegal characters */
    [^]          { throw new Error("Expressao Invalida!!! verifique se existem erros lexicos no arquivo teste"); }
}
