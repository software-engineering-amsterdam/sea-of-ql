module lang::ql::tests::forms::IdentifierUsesDefinitions

import Set;
import List; 
import lang::ql::ast::AST;
import lang::ql::ide::IdentifierUsesDefinitions;
import lang::ql::ide::SemanticChecker;
import lang::ql::tests::ParseHelper;
import lang::ql::util::Random;
import util::IDE;

private bool usesDefsCounter(loc f, int numberOfUses, int numberOfDefinitions) =
  (size(identifierUses(parseForm(f))) == numberOfUses) &&
  (size(identifierDefinitions(parseForm(f))) == numberOfDefinitions);

public test bool testBasicForm() = 
  usesDefsCounter(|project://QL-R-kemi/forms/basic.q|, 0, 1);
  
public test bool testCalculatedField() = 
  usesDefsCounter(|project://QL-R-kemi/forms/calculatedField.q|, 1, 2);
  
public test bool testCommentForm() = 
  usesDefsCounter(|project://QL-R-kemi/forms/comment.q|, 0, 2);
  
public test bool testUglyFormattedForm() = 
  usesDefsCounter(|project://QL-R-kemi/forms/duplicateLabels.q|, 0, 6);
  
public test bool testIfCondition() = 
  usesDefsCounter(|project://QL-R-kemi/forms/ifCondition.q|, 3, 4);
  
public test bool testIfElseCondition() = 
  usesDefsCounter(|project://QL-R-kemi/forms/ifElseCondition.q|, 2, 7);
  
public test bool testIfElseIfCondition() = 
  usesDefsCounter(|project://QL-R-kemi/forms/ifElseIfCondition.q|, 5, 4);
  
public test bool testIfElseIfElseCondition() = 
  usesDefsCounter(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|, 5, 8);
  
public test bool testMultipleQuestions() = 
  usesDefsCounter(|project://QL-R-kemi/forms/multipleQuestions.q|, 0, 3);
  
public test bool testNestedIfElseIfElseCondition() = 
  usesDefsCounter(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|, 9, 12);
  
public test bool testUglyFormattedForm() = 
  usesDefsCounter(|project://QL-R-kemi/forms/uglyFormatted.q|, 6, 8);
  
public test bool testUndefinedVariableForm() = 
  usesDefsCounter(|project://QL-R-kemi/forms/undefinedVariable.q|, 4, 3);
