import nodes.ident.*;
import nodes.literals.*;
import nodes.reserved.*;
import nodes.Program;
import nodes.decl.*;
import nodes.delimiters.*;
import nodes.eof.*;
import java.util.ArrayList;
import java.util.List;

public class AST {
    public static void main(String[] args) {
        // fun main() {
        // data x = 42;
        // print(x);
        // }

        // Cria um identificador para x
        Identifier x = new Identifier(1, 5, "x");

        // Cria um valor inteiro 42
        IntLiteral valor = new IntLiteral(1, 10, 42);

        // Cria o nó Data para representar a atribuição 'data x = 42;'
        Data datax = new Data(1, 0, new TypeIdIdentifier(1, 0, "int"), "x", valor);

        // Criando um nó Print para 'print(x);'
        Print printx = new Print(2, 0, x);

        // Criando uma lista vazia de parâmetros, já que "main" não recebe argumentos
        ArrayList<Bind> params = new ArrayList<>();
        Lit retType = new NullLiteral(0, 0);

        LBrace lbrace = new LBrace(0, 0);
        RBrace rbrace = new RBrace(3, 0);
        EOF eof = new EOF(0, 0);

        // Criando o corpo da função (Agrupando `datax` e `printx` em um bloco)
        Block mainBody = new Block(0, 0, new ArrayList<>(List.of(lbrace, datax, printx, rbrace, eof)));

        // Criando a função "main"
        FunDef mainFunc = new FunDef(0, 0, "main", params, retType, mainBody);

        // Criando o programa com essa função
        Program program = new Program(0, 0, new ArrayList<>(List.of(mainFunc)));

        // Chamando o ASTPrinter
        ASTPrinter printer = new ASTPrinter();
        program.accept(printer);
    }
}
