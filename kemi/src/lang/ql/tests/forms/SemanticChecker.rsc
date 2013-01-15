module lang::ql::tests::forms::SemanticChecker

import Set;
import lang::ql::ast::AST;
import lang::ql::ide::Outline;
import lang::ql::ide::SemanticChecker;
import lang::ql::tests::ParseHelper;
import lang::ql::util::FormGenerator;
import lang::ql::util::Random;
import util::IDE;

private set[Message] semanticChecker(loc f) = 
  semanticChecker(parseForm(f));
  
private bool semanticChecker(loc f, int numberOfErrors) = 
  size(semanticChecker(f)) == numberOfErrors;

public test bool testBasicForm() = 
  semanticChecker(|project://QL-R-kemi/forms/basic.q|, 0);
  
public test bool testCalculatedField() = 
  semanticChecker(|project://QL-R-kemi/forms/calculatedField.q|, 0);
  
public test bool testCommentForm() = 
  semanticChecker(|project://QL-R-kemi/forms/comment.q|, 0);
  
public test bool testUglyFormattedForm() = 
  semanticChecker(|project://QL-R-kemi/forms/duplicateLabels.q|, 5);
  
public test bool testIfCondition() = 
  semanticChecker(|project://QL-R-kemi/forms/ifCondition.q|, 0);
  
public test bool testIfElseCondition() = 
  semanticChecker(|project://QL-R-kemi/forms/ifElseCondition.q|, 0);
  
public test bool testIfElseIfCondition() = 
  semanticChecker(|project://QL-R-kemi/forms/ifElseIfCondition.q|, 0);
  
public test bool testIfElseIfElseCondition() = 
  semanticChecker(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|, 8);
  
public test bool testMultipleQuestions() = 
  semanticChecker(|project://QL-R-kemi/forms/multipleQuestions.q|, 0);
  
public test bool testNestedIfElseIfElseCondition() = 
  semanticChecker(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|, 14);
  
public test bool testUglyFormattedForm() = 
  semanticChecker(|project://QL-R-kemi/forms/uglyFormatted.q|, 8);
