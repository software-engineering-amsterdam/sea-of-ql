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
import lang::qls::\ast::AST;
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
  semanticChecker(|project://QL-R-kemi/examples/tests/basic.qs|, 0, 0);

public test bool testCalculatedField() = 
  semanticChecker(
    |project://QL-R-kemi/examples/tests/calculatedField.qs|,
    0,
    0
  );

public test bool testComment() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/comment.qs|, 0, 0);

public test bool testComplexForm() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/complexForm.qs|, 0, 0);

public test bool testIfCondition() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/ifCondition.qs|, 0, 0);

public test bool testIfElseCondition() = 
  semanticChecker(
    |project://QL-R-kemi/examples/tests/ifElseCondition.qs|,
    0,
    0
  );

public test bool testIfElseIfCondition() = 
  semanticChecker(
    |project://QL-R-kemi/examples/tests/ifElseIfCondition.qs|,
    0,
    0
  );

public test bool testIfElseIfElseCondition() = 
  semanticChecker(
    |project://QL-R-kemi/examples/tests/ifElseIfElseCondition.qs|,
    0,
    0
  );

public test bool testMultipleQuestions() = 
  semanticChecker(
    |project://QL-R-kemi/examples/tests/multipleQuestions.qs|,
    0,
    0
  );

public test bool testNestedIfElseIfElseCondition() = 
  semanticChecker(
    |project://QL-R-kemi/examples/tests/nestedIfElseIfElseCondition.qs|,
    0,
    0
  );

public test bool testProposedSyntax() = 
  semanticChecker(
    |project://QL-R-kemi/examples/tests/proposedSyntax.qs|,
    0,
    0
  );

public test bool testTaxOfficeExample() = 
  semanticChecker(
    |project://QL-R-kemi/examples/taxOffice/taxOfficeExample.qs|,
    0,
    0
  );

// Also misses six question definitions
public test bool testWrongFilename() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/wrongFilename.qs|, 6, 1);

public test bool testWithoutForm() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/withoutForm.qs|, 0, 1);

// Also contains slider with invalid range
public test bool testQuestionReuse() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/questionReuse.qs|, 0, 2);

// Also contains slider with invalid range, invalid attrs and invalid widgets
public test bool testUndefinedQuestions() = 
  semanticChecker(
    |project://QL-R-kemi/examples/tests/undefinedQuestions.qs|,
    0,
    10
  );

public test bool testDoubleName() = 
  semanticChecker(|project://QL-R-kemi/examples/tests/doubleName.qs|, 3, 0);

public test bool testDefaultRedefinition() = 
  semanticChecker(
    |project://QL-R-kemi/examples/tests/defaultRedefinition.qs|,
    3,
    0
  );
