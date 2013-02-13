module lang::ql::tests::TestQuestions

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::util::Parse;

private Question p(str src) = implode(#Question, parseQuestion(src));

public test bool testNonComputed1() = p("abc: \"A label:\" int") is noncomputed;
public test bool testNonComputed2() = p("def123: \"\" bool") is noncomputed;
public test bool testNonComputed3() = p("zyx: \"LABEL\" string") is noncomputed;

public test bool testComputed1() = p("abc: \"A label:\" int(ijk + 2)") is computed;
public test bool testComputed2() = p("def123: \"\" bool(1 \> 2)") is computed;
public test bool testComputed3() = p("zyx: \"LABEL\" string(str)") is computed;