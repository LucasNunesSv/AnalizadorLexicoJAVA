1) No terminal, entre no diretorio atividade/

2) Depois gere as classes na pasta out:
javac -d out $(find src -name "*.java")

3) Por fim, rode:
java -cp out AST

Cada vez que algum .java for alterado, deve-se rodar o passo 2 novamente e depois o 3!