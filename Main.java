
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main{


  public static void main(String args[]){

       if(args.length != 1){
          help();
          System.exit(0);
       }
       try{
          LangLexer lex = new LangLexer(new FileReader(args[0]) );
          Token t = lex.nextToken();
          while(t.tk != TK.EOF){
              System.out.println(t.toString());
              t = lex.nextToken();
          }
          System.out.println(t.toString());
       }catch(FileNotFoundException e){
           System.out.println("O arquivo " + args[0] + " não foi encontrado.");
       }catch(Exception e){
           System.out.println("Erro ao processar " + args[0] );
           e.printStackTrace();
       }
  }

  public static void help(){
      System.out.println(" Analisador léxico para calculadora simples");
      System.out.println(" Versão: 0.0");
      System.out.println("   use java Main <nome-de-arquivo>");
      System.out.println("       <nome-de-arquivo> : O caminho relativo ou completo");
      System.out.println("                           para um arquivo de texto contendo");
      System.out.println("                           um programa na linguagem da cacluadora. ");
      System.out.println("                           Provenha exatamente um nome de arquivo");
  }


}
