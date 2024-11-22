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
   PTR,
   TYPE,

   // Literais
   INT,
   FLOAT,
   CHAR,
   BOOL,
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
   ACCESS,  // .

   // Delimitadores
   LBRACE,  // {
   RBRACE,  // }
   LBRACKET,  // [
   RBRACKET,  // ]
   LPAREN,  // (
   RPAREN,  // )
   COMMA,   // ,
   SEMICOLON, // ;

   // Fim do arquivo
   EOF
}

