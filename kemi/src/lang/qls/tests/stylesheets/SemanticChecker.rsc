@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::tests::stylesheets::SemanticChecker

import Set;
import lang::qls::analysis::SemanticChecker;
import lang::qls::ast::AST;
import lang::qls::util::ParseHelper;
import util::IDE;

private set[Message] semanticChecker(loc f) = 
  semanticChecker(parseStylesheet(f));
  
private bool semanticChecker(loc f, int numberOfWarnings, int numberOfErrors) {
  messages = semanticChecker(f);
  
  warnings = {m | m <- messages, warning(_, _) := m};
  errors = {m | m <- messages, error(_, _) := m};
  
  return size(warnings) == numberOfWarnings && size(errors) == numberOfErrors;
}

public test bool testBasic() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/basic.qs|, 0, 0);

public test bool testCalculatedField() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/calculatedField.qs|, 0, 0);

public test bool testComment() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/comment.qs|, 0, 0);

public test bool testComplexForm() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/complexForm.qs|, 0, 0);

public test bool testIfCondition() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/ifCondition.qs|, 0, 0);

public test bool testIfElseCondition() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/ifElseCondition.qs|, 0, 0);

public test bool testIfElseIfCondition() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/ifElseIfCondition.qs|, 0, 0);

public test bool testIfElseIfElseCondition() = 
  semanticChecker(
    |project://QL-R-kemi/stylesheets/ifElseIfElseCondition.qs|,
    0,
    0
  );

public test bool testMultipleQuestions() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/multipleQuestions.qs|, 0, 0);

public test bool testNestedIfElseIfElseCondition() = 
  semanticChecker(
    |project://QL-R-kemi/stylesheets/nestedIfElseIfElseCondition.qs|,
    0,
    0
  );

public test bool testProposedSyntax() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|, 0, 0);

public test bool testTaxOfficeExample() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/taxOfficeExample.qs|, 0, 0);


public test bool testWrongFilename() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/wrongFilename.qs|, 0, 1);

public test bool testWithoutForm() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/withoutForm.qs|, 0, 1);

public test bool testQuestionReuse() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/questionReuse.qs|, 0, 1);

public test bool testUndefinedQuestions() = 
  semanticChecker(
    |project://QL-R-kemi/stylesheets/undefinedQuestions.qs|,
    0,
    2
  );

public test bool testDoubleName() = 
  semanticChecker(|project://QL-R-kemi/stylesheets/doubleName.qs|, 3, 0);

public test bool testDefaultRedefinition() = 
  semanticChecker(
    |project://QL-R-kemi/stylesheets/defaultRedefinition.qs|,
    1,
    0
  );
