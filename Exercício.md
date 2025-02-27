## Exercício

Neste diretório, há a seguinte estrutura de pastas e arquivos contendo um projeto para o compilador da linguagem Lang:

```
├── exemplos
├── Exercício.md
├── lang
│   ├── ast
│   │   ├── command
│   │   ├── decl
│   │   ├── expr
│   │   ├── visitors
│   │   ├── types
│   │   ├── Node.java
│   │   ├── NodeVisitor.java
│   │   ├── Program.java
│   │   └── SimpleVisitor.java
│   └── parser
├── langc.sh
├── Lang.java
├── makefile
└── tools
```

O arquivo `makefile` gerencia o processo de geração do analisador léxico e do parser, bem como a compilação dos arquivos-fonte. Para compilar o projeto, basta executar:

```
$ make
```

Após a compilação, o script `langc.sh` pode ser utilizado como atalho para executar o compilador. Exemplo de uso:

```
$ ./langc.sh exemplos/teste.txt
```

O arquivo `Lang.java` contém o método `main` do compilador. Ele aceita as seguintes opções:

-   `-lex` para rodar apenas o analisador léxico;

-   `-syn` para rodar o analisador sintático e verificar se o arquivo é aceito ou rejeitado;

-   `-i` para executar o interpretador.


A pasta `lang` é um pacote Java que contém os subpacotes `ast` e `parser`. O primeiro define a estrutura de dados para representar um programa na linguagem Lang, enquanto o segundo contém os arquivos responsáveis pelos analisadores léxico e sintático.

Algumas classes básicas para a implementação da AST (Abstract Syntax Tree) já foram providas, incluindo os nós para expressões aritméticas (soma e multiplicação), literais inteiros e booleanos, e o comando de atribuição.

O pacote `parser` também contém um esboço de arquivos `flex` e `cup` para um analisador léxico incompleto (com suporte apenas para alguns tokens) e um analisador sintático que reconhece expressões de soma e multiplicação. Atualmente, o parser **não constrói a AST** e apresenta conflitos _shift-reduce_.

### Objetivos

1.  Corrigir os conflitos _shift-reduce_ no parser.

2.  Modificar o parser para que ele construa a AST utilizando os nós já implementados.

3.  Implementar um interpretador para o subconjunto da linguagem Lang já existente (expressões de soma, multiplicação e atribuição), utilizando o padrão _Visitor_ provido.

4.  Adicionar suporte à expressão de subtração e ao comando de impressão na linguagem Lang, e integrar essas novas construções ao interpretador.


> **Dica:** Caso não esteja familiarizado com os conflitos _shift-reduce_, revise as regras de precedência e associatividade no _parser_ para resolvê-los.
