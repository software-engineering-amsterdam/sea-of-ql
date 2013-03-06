@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::forms::SemanticChecker

import Set;
import lang::ql::analysis::SemanticChecker;
import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import util::IDE;

private set[Message] semanticChecker(loc f) = 
  semanticChecker(parseForm(f));
  
private bool semanticChecker(loc f, int numberOfWarnings, int numberOfErrors) {
  messages = semanticChecker(f);
  
  warnings = {m | m <- messages, warning(_, _) := m};
  errors = {m | m <- messages, error(_, _) := m};
  
  return (size(warnings) == numberOfWarnings) && (size(errors) == numberOfErrors);
}
  
public test bool semanticTestBasicForm() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/basic.q|, 0, 0);
  
public test bool semanticTestCalculatedField() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/calculatedField.q|, 0, 0);
  
public test bool semanticTestCommentForm() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/comment.q|, 0, 0);
  
public test bool semanticTestDuplicateLabels() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/duplicateLabels.q|, 0, 3);
  
public test bool semanticTestIfCondition() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/ifCondition.q|, 0, 0);
  
public test bool semanticTestIfElseCondition() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/ifElseCondition.q|, 0, 0);
  
public test bool semanticTestIfElseIfCondition() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/ifElseIfCondition.q|, 0, 4);
  
public test bool semanticTestIfElseIfElseCondition() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/ifElseIfElseCondition.q|, 2, 6);
  
public test bool semanticTestMultipleQuestions() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/multipleQuestions.q|, 0, 0);
  
public test bool semanticTestNestedIfElseIfElseCondition() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/nestedIfElseIfElseCondition.q|, 4, 11);
  
public test bool semanticTestUglyFormattedForm() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/uglyFormatted.q|, 2, 7);
  
public test bool semanticTestUndefinedVariableForm() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/undefinedVariable.q|, 0, 3);
