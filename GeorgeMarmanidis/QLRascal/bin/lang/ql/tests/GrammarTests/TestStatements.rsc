module lang::ql::tests::GrammarTests::TestStatements

import lang::ql::syntax::QL;
import ParseTree;

public start[ConditionalStatement] parseStatement(str src) = parse(#start[ConditionalStatement], src, |file:///-|);

public test bool testIfCond() = parseStatement("if (a+b) { hasage: \"has age?\" boolean } else { hasName: \"has name?\" boolean}") is ifCond;
public test bool testSimpleIf() = parseStatement("if (a+b) { hasage: \"has age?\" boolean}") is simpleIfCond;

public test bool testElseIf() = parseStatement("if (a+b) { hasage: \"has age?\" boolean} else if (a+b) {hasName: \"has name?\" boolean} else { hasName: \"has name?\" boolean}") is ifElseIfCond;
public test bool testElseIf2() = parseStatement("if (a+b) { hasage: \"has age?\" boolean} else if (a+b) {hasName: \"has name?\" boolean} else if (a+b) {hasName: \"has name?\" boolean} else if (a+b) {hasName: \"has name?\" boolean} else { hasName: \"has name?\" boolean}") is ifElseIfCond;