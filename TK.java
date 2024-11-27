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

