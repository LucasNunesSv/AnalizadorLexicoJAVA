
all: lex
	javac -cp . Main.java

lex: lang.flex
	java -jar tools/jflex.jar -nobak lang.flex

clean:
	find -name "*.class" -delete
	rm LangLexer.java
