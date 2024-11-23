public class Token {

   public Object value;
   public TK tk;
   public int line;
   public int column;

   public Token(int line, int column, TK t){
       this.line = line;
       this.column = column;
       value = null;
       tk = t;
   }

   public Token(int line, int column, TK t, Object v){
       this(line,column,t);
       value = v;
   }

   public String toString(){
       return "(" + line + "," + column+ ") TK: " + tk +  (value == null ? "" : " - (" + value.toString() + ")");
   }

}
