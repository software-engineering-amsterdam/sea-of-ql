CLASSPATH = src:lib/*
JFLAGS = -cp $(CLASSPATH)

all: test
test: TestExpressions

TestExpressions: src/nl/stgm/ql/parser/test/TestExpressions.class

runtest:
	java -cp src:lib/* org.junit.runner.JUnitCore nl.stgm.ql.parser.test.TestExpressions

%.class: %.java
	javac $(JFLAGS) $<

clean:
	find . -name "*.class" -delete
