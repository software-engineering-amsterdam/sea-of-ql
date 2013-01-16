module lang::ql::tests::forms::PrettyPrinter

import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::tests::ParseHelper;
import lang::ql::util::FormGenerator;
import lang::ql::util::Random;

private bool prettyPrintAndCompare(loc f) = 
  parseForm(f) == parseForm(prettyPrint(parseForm(f)));

private bool prettyPrintAndCompare(str s) = 
  parseForm(s) == parseForm(prettyPrint(parseForm(s)));

public test bool testBasicForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/basic.q|);

public test bool testCalculatedFieldForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/calculatedField.q|);

public test bool testCommentForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/comment.q|);

public test bool testIfCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/ifCondition.q|);

public test bool testIfElseCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/ifElseCondition.q|);

public test bool testIfElseIfCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/ifElseIfCondition.q|);

public test bool testIfElseIfElseCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|);

public test bool testMultipleQuestions() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/multipleQuestions.q|);

public test bool testNestedIfElseIfElseCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|);

public test bool testUglyFormattedForm() =  
  prettyPrintAndCompare(|project://QL-R-kemi/forms/duplicateLabels.q|);

public test bool testUglyFormattedForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/uglyFormatted.q|);

public test bool testUndefinedVariableForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/forms/undefinedVariable.q|);

public test bool testRandomForm() = 
  prettyPrintAndCompare(randomForm(5, 3));
