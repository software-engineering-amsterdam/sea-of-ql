CLASSPATH = src:lib/*
JFLAGS = -cp $(CLASSPATH)

# Main targets
all: RunRats TestExpressions

# Runnable classes
RunRats: src/nl/stgm/ql/parser/rats/RunRats.class
TestExpressions: src/nl/stgm/ql/parser/test/TestExpressions.class

# Utilities
run/rats: RunRats
	java -cp $(CLASSPATH) nl.stgm.ql.parser.rats.RunRats
run/test: TestExpressions
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore nl.stgm.ql.parser.test.TestExpressions

# Helpers
%.class: %.java
	javac $(JFLAGS) $<
clean:
	find . -name "*.class" -delete
