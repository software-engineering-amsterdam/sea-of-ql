CLASSPATH = src:lib/*
JFLAGS = -cp $(CLASSPATH)

# Main targets
all: RunRats TestExpressions

# Runnable classes (containing 'main' function)
RunRats: src/nl/stgm/ql/parser/rats/RunRats.class
TestExpressions: src/nl/stgm/ql/parser/test/TestExpressions.class
TestForms: src/nl/stgm/ql/parser/test/TestForms.class
TreeWalker: src/nl/stgm/ql/inspector/TreeWalker.class

# Generated parser class
QLParser: src/nl/stgm/ql/parser/rats/QLParser.class
src/nl/stgm/ql/parser/rats/QLParser.java: RunRats src/nl/stgm/ql/parser/rats/*.rats
	java -cp $(CLASSPATH) nl.stgm.ql.parser.rats.RunRats

# Utilities
run/rats: RunRats
	java -cp $(CLASSPATH) nl.stgm.ql.parser.rats.RunRats
run/testexpr: QLParser TestExpressions
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore nl.stgm.ql.parser.test.TestExpressions
run/testform: QLParser TestForms
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore nl.stgm.ql.parser.test.TestForms
run/treewalker: QLParser TreeWalker
	java -cp $(CLASSPATH) nl.stgm.ql.inspector.TreeWalker

# Helpers
%.class: %.java
	javac $(JFLAGS) $<
clean:
	find . -name "*.class" -delete
	rm src/nl/stgm/ql/parser/rats/QLParser.java
