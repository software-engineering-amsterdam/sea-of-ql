JAVAC=javac
JAVA=java
CLASSPATH=src:lib/*
JFLAGS=-cp $(CLASSPATH)

# Main targets
all: parser tests inspectors
parser: QLParser
tests: TestExpressions TestForms
inspectors: PrettyPrinter Checker Interpreter

# Runnable classes
TestExpressions: QLParser src/nl/stgm/ql/parser/test/TestExpressions.class
TestForms: QLParser src/nl/stgm/ql/parser/test/TestForms.class
PrettyPrinter: QLParser src/nl/stgm/ql/inspectors/pretty/PrettyPrinter.class
Checker: QLParser src/nl/stgm/ql/inspectors/checker/Checker.class
Interpreter: QLParser src/nl/stgm/ql/inspectors/interpreter/Interpreter.class

# Generating the parser class
RunRats: src/nl/stgm/ql/parser/rats/RunRats.class
QLParser: src/nl/stgm/ql/parser/rats/QLParser.class
src/nl/stgm/ql/parser/rats/QLParser.java: RunRats src/nl/stgm/ql/parser/rats/*.rats
	$(JAVA) $(JFLAGS) nl.stgm.ql.parser.rats.RunRats

# Run helpers
run/testexpr: TestExpressions
	$(JAVA) $(JFLAGS) org.junit.runner.JUnitCore nl.stgm.ql.parser.test.TestExpressions
run/testform: TestForms
	$(JAVA) $(JFLAGS) org.junit.runner.JUnitCore nl.stgm.ql.parser.test.TestForms
run/pretty: PrettyPrinter
	$(JAVA) $(JFLAGS) nl.stgm.ql.inspectors.pretty.PrettyPrinter
run/check: Checker
	$(JAVA) $(JFLAGS) nl.stgm.ql.inspectors.checker.Checker
run/interpret: Interpreter
	$(JAVA) $(JFLAGS) nl.stgm.ql.inspectors.interpreter.Interpreter

# Utilities
%.class: %.java
	$(JAVAC) $(JFLAGS) $<
clean:
	find . -name "*.class" -delete
	rm src/nl/stgm/ql/parser/rats/QLParser.java
