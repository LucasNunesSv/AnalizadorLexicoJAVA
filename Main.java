
/* Prototipo de um analizador lexico para linguagem Lang 
 * Lucas Nunes Silveira - 20.2.8040
 * Matheus Lopes Moreira - 20.2.8002
*/
import java_cup.runtime.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

import lang.ast.LNode;
import lang.ast.visitors.*;
import lang.parser.LangParser;
import lang.parser.LangParserSym;
import lang.parser.LangLexer;

import java.io.FileNotFoundException;

public class Main {
    public static void runLexer(LangLexer lex) throws IOException, Exception {
        Symbol tk = lex.nextToken();
        while (tk.sym != LangParserSym.EOF) {
            System.out.println("(" + tk.left + "," + tk.right + ")" + tk.sym);
            tk = lex.nextToken();
        }
        System.out.println(tk.toString());
    }

    public static void interpret(LangParser p) throws IOException, Exception {
        Symbol presult = p.parse();
        LNode root = (LNode) presult.value;
        if (root != null) {
            Interp v = new Interp();
            root.accept(v);
            System.out.println(v.getStackTop());
        } else {
            System.out.println("oops, erro!");
        }
    }

    public static void checkSyntax(LangParser p) throws IOException, Exception {
        Symbol presult = p.parse();
        LNode root = (LNode) presult.value;
        if (presult != null) {
            System.out.println("accepted");
        } else {
            System.out.println("rejected");
        }
    }

    public static void main(String args[]) throws IOException, Exception {
        int fname = 0;
        if (args.length < 1 || args.length > 2) {
            help();
            System.exit(0);
        } else {
            if (args.length == 2) {
                fname = 1;
            }
            // Criando o Lexer
            LangLexer lex = new LangLexer(new FileReader(args[fname]));
            // Criando o parser (mais ainda não o executamos);
            LangParser p = new LangParser(lex);
            // Testando os argumentos para determinar o que fazer em seguida.
            if (args.length == 2 && args[0].equals("-lex")) {
                runLexer(lex);
                System.exit(0);
            } else if (args.length == 2 && args[0].equals("-i")) {
                interpret(p);
                System.exit(0);
            } else if (args.length == 2 && args[0].equals("-syn")) {
                checkSyntax(p);
                System.exit(0);
            }
        }
    }

    public static void help() {
        System.out.println(" Analisador léxico para calculadora simples");
        System.out.println(" Versão: 0.0");
        System.out.println("   use java Main <nome-de-arquivo>");
        System.out.println("       <nome-de-arquivo> : O caminho relativo ou completo");
        System.out.println("                           para um arquivo de texto contendo");
        System.out.println("                           um programa na linguagem da cacluadora. ");
        System.out.println("                           Provenha exatamente um nome de arquivo");
    }

}
