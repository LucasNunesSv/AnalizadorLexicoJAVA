/* Prototipo de um analizador lexico para linguagem Lang 
 * Lucas Nunes Silveira - 20.2.8040
 * Matheus Lopes Moreira - 20.2.8002
*/

// Enumeração de tipos de tokens reconhecidos pelo lexer
public enum TK {
   // Palavras reservadas
   DATA,
   IF,
   ELSE,
   ITERATE,
   READ,
   PRINT,
   RETURN,

   // Identificadores e tipos
   ID,
   TYID,
   TYPE,
   INT,
   FLOAT,
   CHAR,
   BOOL,

   // Literais
   INT_LITERAL,
   FLOAT_LITERAL,
   CHAR_LITERAL,
   BOOL_LITERAL,
   NULL,

   // Operadores
   PLUS,    // +
   MINUS,   // -
   MULT,    // *
   DIV,     // /
   MOD,     // %
   ATBR,    // =
   EQ,      // ==
   NEQ,     // !=
   LT,      // <
   GT,      // >
   DOT,  // .

   // Delimitadores
   LBRACE,  // {
   RBRACE,  // }
   LBRACKET,  // [
   RBRACKET,  // ]
   LPAREN,  // (
   RPAREN,  // )
   COMMA,   // ,
   SEMICOLON, // ;

   // Char tokens
   NEWLINE,
   TAB,
   BACKSPACE,
   CARRIAGERETURN,
   BACKSLASH,
   SINGLEQUOTE,
   DOUBLEQUOTE,

   // Fim do arquivo
   EOF
}

