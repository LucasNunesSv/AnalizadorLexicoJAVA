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

   // Literais
   INT,
   FLOAT,

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

   // Delimitadores
   LBRACE,  // {
   RBRACE,  // }
   LPAREN,  // (
   RPAREN,  // )
   COMMA,   // ,
   SEMICOLON, // ;

   // Fim do arquivo
   EOF
}
