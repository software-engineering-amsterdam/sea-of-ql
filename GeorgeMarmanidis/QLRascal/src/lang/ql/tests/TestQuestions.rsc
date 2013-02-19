@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::tests::ASTTests::TestQuestions

import lang::ql::syntax::QL;
import ParseTree;
import IO;
import lang::ql::ast::AST;

private Question pQue(str src) = implodeQue(parseQue(src, |file:///-|));
private start[Question] parseQue(str src, loc l) = parse(#start[Question], src, l);
private Question implodeQue(Tree t) = implode(#Question, t);


public test bool testQuestion1() = pQue("kostas: \"has name?\" boolean") is simpleQuestion;
public test bool testQuestion2() = pQue("kostas: \"has name?\" money") is simpleQuestion;
public test bool testQuestion3() = pQue("kostas: \"hasname?\" boolean kostas+   b*(a+2)") is computedQuestion;