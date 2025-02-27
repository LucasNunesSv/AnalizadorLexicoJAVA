
all: Lang.class

Lang.class: lang/parser/LangLexer.java lang/parser/LangParser.java
	javac -cp .:tools/java-cup-11b-runtime.jar Main.java

lang/parser/LangParser.java:
	java -jar tools/java-cup-11b.jar -destdir lang/parser/ lang/parser/lang.cup

lang/parser/LangLexer.java:
	java -jar tools/jflex.jar -nobak	-d lang/parser lang/parser/lang.flex

cleanClasses:
	find -name "*.class" -delete

clean: cleanClasses cleanParser

cleanParser:
	rm lang/parser/LangLexer.java
	rm lang/parser/LangParser.java
	rm lang/parser/LangParserSym.java
