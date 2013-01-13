CLASSPATH = src:lib/*
JFLAGS = -cp $(CLASSPATH)

all: test

test: ast ParseError IParse TestExpressions

ParseError: src/nl/stgm/ql/parser/test/ParseError.class
IParse: src/nl/stgm/ql/parser/test/IParse.class
TestExpressions: src/nl/stgm/ql/parser/test/TestExpressions.class

ast: ASTNode Expr Ident Int

ASTNode: src/nl/stgm/ql/ast/ASTNode.class
Expr: src/nl/stgm/ql/ast/Expr.class
Ident: src/nl/stgm/ql/ast/Ident.class
Int: src/nl/stgm/ql/ast/Int.class

%.class: %.java
	javac $(JFLAGS) $<

clean:
	rm -f *.class
