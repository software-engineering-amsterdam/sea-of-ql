module lang::ql::tests::forms::SemanticChecker

import Set;
import analysis::graphs::Graph;
import lang::ql::ast::AST;
import lang::ql::analysis::FlowGraph;
import lang::ql::analysis::IdentifierOccurrences;
import lang::ql::ide::Outline;
import lang::ql::analysis::SemanticChecker;
import lang::ql::analysis::TypeChecker;
import lang::ql::tests::ParseHelper;
import lang::ql::util::FormGenerator;
import lang::ql::util::Random;
import util::IDE;

private set[Message] semanticChecker(loc f) = 
  semanticChecker(parseForm(f));
  
private bool semanticChecker(loc f, int numberOfErrors) = 
  size(semanticChecker(f)) == numberOfErrors;
  
private bool duplicateIdentifiers(loc f, int count) {
  def = identifierDefinitions(parseForm(f));
  return 
    size(duplicateIdentifierMessages(def)) == count;
}   
  
private bool duplicateQuestions(loc f, int count) {
  def = identifierDefinitions(parseForm(f));
  return 
    size(duplicateQuestionMessages(def)) == count;
}

private bool useBeforeDeclarations(loc f, int count) {
  fm = parseForm(f);
  us = identifierUses(fm);
  def = identifierDefinitions(fm);
  fgraph = flowGraph(fm);
  return 
    size(useBeforeDeclarationMessages(us, def, fgraph)) == count;
}

private bool typeChecker(loc f, int count) {
  fm = parseForm(f);
  def = identifierDefinitions(fm);
  return 
    size(typeChecker(fm, def)) == count;
}

public test bool duplicateIdentifiersTestBasicForm() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/basic.q|, 0);
  
public test bool duplicateIdentifiersTestCalculatedField() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/calculatedField.q|, 0);
  
public test bool duplicateIdentifiersTestCommentForm() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/comment.q|, 0);
  
public test bool duplicateIdentifiersTestUglyFormattedForm() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/duplicateLabels.q|, 5);
  
public test bool duplicateIdentifiersTestIfCondition() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/ifCondition.q|, 0);
  
public test bool duplicateIdentifiersTestIfElseCondition() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/ifElseCondition.q|, 0);
  
public test bool duplicateIdentifiersTestIfElseIfCondition() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/ifElseIfCondition.q|, 0);
  
public test bool duplicateIdentifiersTestIfElseIfElseCondition() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|, 4);
  
public test bool duplicateIdentifiersTestMultipleQuestions() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/multipleQuestions.q|, 0);
  
public test bool duplicateIdentifiersTestNestedIfElseIfElseCondition() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|, 6);
  
public test bool duplicateIdentifiersTestUglyFormattedForm() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/uglyFormatted.q|, 4);
  
public test bool duplicateIdentifiersTestUndefinedVariableForm() = 
  duplicateIdentifiers(|project://QL-R-kemi/forms/undefinedVariable.q|, 0);
  
// Duplicate questions

public test bool duplicateQuestionsTestBasicForm() = 
  duplicateQuestions(|project://QL-R-kemi/forms/basic.q|, 0);
  
public test bool duplicateQuestionsTestCalculatedField() = 
  duplicateQuestions(|project://QL-R-kemi/forms/calculatedField.q|, 0);
  
public test bool duplicateQuestionsTestCommentForm() = 
  duplicateQuestions(|project://QL-R-kemi/forms/comment.q|, 0);
  
public test bool duplicateQuestionsTestUglyFormattedForm() = 
  duplicateQuestions(|project://QL-R-kemi/forms/duplicateLabels.q|, 0);
  
public test bool duplicateQuestionsTestIfCondition() = 
  duplicateQuestions(|project://QL-R-kemi/forms/ifCondition.q|, 0);
  
public test bool duplicateQuestionsTestIfElseCondition() = 
  duplicateQuestions(|project://QL-R-kemi/forms/ifElseCondition.q|, 0);
  
public test bool duplicateQuestionsTestIfElseIfCondition() = 
  duplicateQuestions(|project://QL-R-kemi/forms/ifElseIfCondition.q|, 0);
  
public test bool duplicateQuestionsTestIfElseIfElseCondition() = 
  duplicateQuestions(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|, 4);
  
public test bool duplicateQuestionsTestMultipleQuestions() = 
  duplicateQuestions(|project://QL-R-kemi/forms/multipleQuestions.q|, 0);
  
public test bool duplicateQuestionsTestNestedIfElseIfElseCondition() = 
  duplicateQuestions(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|, 8);
  
public test bool duplicateQuestionsTestUglyFormattedForm() = 
  duplicateQuestions(|project://QL-R-kemi/forms/uglyFormatted.q|, 4);
  
public test bool duplicateQuestionsTestUndefinedVariableForm() = 
  duplicateQuestions(|project://QL-R-kemi/forms/undefinedVariable.q|, 0);
  
// Use before declarations
  
public test bool useBeforeDeclarationsTestBasicForm() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/basic.q|, 0);
  
public test bool useBeforeDeclarationsTestCalculatedField() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/calculatedField.q|, 0);
  
public test bool useBeforeDeclarationsTestCommentForm() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/comment.q|, 0);
  
public test bool useBeforeDeclarationsTestUglyFormattedForm() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/duplicateLabels.q|, 0);
  
public test bool useBeforeDeclarationsTestIfCondition() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/ifCondition.q|, 0);
  
public test bool useBeforeDeclarationsTestIfElseCondition() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/ifElseCondition.q|, 0);
  
public test bool useBeforeDeclarationsTestIfElseIfCondition() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/ifElseIfCondition.q|, 4);
  
public test bool useBeforeDeclarationsTestIfElseIfElseCondition() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|, 4);
  
public test bool useBeforeDeclarationsTestMultipleQuestions() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/multipleQuestions.q|, 0);
  
public test bool useBeforeDeclarationsTestNestedIfElseIfElseCondition() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|, 8);
  
public test bool useBeforeDeclarationsTestUglyFormattedForm() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/uglyFormatted.q|, 5);
  
public test bool useBeforeDeclarationsTestUndefinedVariableForm() = 
  useBeforeDeclarations(|project://QL-R-kemi/forms/undefinedVariable.q|, 3);
  
// Typechecker:

public test bool typeCheckerTestBasicForm() = 
  typeChecker(|project://QL-R-kemi/forms/basic.q|, 0);
  
public test bool typeCheckerTestCalculatedField() = 
  typeChecker(|project://QL-R-kemi/forms/calculatedField.q|, 0);
  
public test bool typeCheckerTestCommentForm() = 
  typeChecker(|project://QL-R-kemi/forms/comment.q|, 0);
  
public test bool typeCheckerTestIfCondition() = 
  typeChecker(|project://QL-R-kemi/forms/ifCondition.q|, 1);
  
public test bool typeCheckerTestIfElseCondition() = 
  typeChecker(|project://QL-R-kemi/forms/ifElseCondition.q|, 1);
  
public test bool typeCheckerTestIfElseIfCondition() = 
  typeChecker(|project://QL-R-kemi/forms/ifElseIfCondition.q|, 0);
  
public test bool typeCheckerTestIfElseIfElseCondition() = 
  typeChecker(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|, 0);
  
public test bool typeCheckerTestMultipleQuestions() = 
  typeChecker(|project://QL-R-kemi/forms/multipleQuestions.q|, 0);
  
public test bool typeCheckerTestNestedIfElseIfElseCondition() = 
  typeChecker(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|, 0);
  
public test bool typeCheckerTestUglyFormattedForm() = 
  typeChecker(|project://QL-R-kemi/forms/uglyFormatted.q|, 1);
  
public test bool typeCheckerTestUndefinedVariableForm() = 
  typeChecker(|project://QL-R-kemi/forms/undefinedVariable.q|, 1);
  
// And all tests combined:

public test bool semanticTestBasicForm() = 
  semanticChecker(|project://QL-R-kemi/forms/basic.q|, 0);
  
public test bool semanticTestCalculatedField() = 
  semanticChecker(|project://QL-R-kemi/forms/calculatedField.q|, 0);
  
public test bool semanticTestCommentForm() = 
  semanticChecker(|project://QL-R-kemi/forms/comment.q|, 0);
  
public test bool semanticTestUglyFormattedForm() = 
  semanticChecker(|project://QL-R-kemi/forms/duplicateLabels.q|, 5);
  
public test bool semanticTestIfCondition() = 
  semanticChecker(|project://QL-R-kemi/forms/ifCondition.q|, 1);
  
public test bool semanticTestIfElseCondition() = 
  semanticChecker(|project://QL-R-kemi/forms/ifElseCondition.q|, 1);
  
public test bool semanticTestIfElseIfCondition() = 
  semanticChecker(|project://QL-R-kemi/forms/ifElseIfCondition.q|, 4);
  
public test bool semanticTestIfElseIfElseCondition() = 
  semanticChecker(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|, 4);
  
public test bool semanticTestMultipleQuestions() = 
  semanticChecker(|project://QL-R-kemi/forms/multipleQuestions.q|, 0);
  
public test bool semanticTestNestedIfElseIfElseCondition() = 
  semanticChecker(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|, 6);
  
public test bool semanticTestUglyFormattedForm() = 
  semanticChecker(|project://QL-R-kemi/forms/uglyFormatted.q|, 4);
  
public test bool semanticTestUndefinedVariableForm() = 
  semanticChecker(|project://QL-R-kemi/forms/undefinedVariable.q|, 3);
