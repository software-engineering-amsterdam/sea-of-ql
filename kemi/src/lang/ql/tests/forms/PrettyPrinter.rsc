@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::forms::PrettyPrinter

import lang::ql::\ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::util::ParseHelper;
import lang::ql::util::FormGenerator;
import lang::ql::util::Random;

private bool prettyPrintAndCompare(loc f) = 
  parseForm(f) == parseForm(prettyPrint(parseForm(f)));

private bool prettyPrintAndCompare(str s) = 
  parseForm(s) == parseForm(prettyPrint(parseForm(s)));

public test bool testBasicForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/basic.q|);

public test bool testCalculatedFieldForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/calculatedField.q|);

public test bool testCommentForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/comment.q|);

public test bool testIfCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/ifCondition.q|);

public test bool testIfElseCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/ifElseCondition.q|);

public test bool testIfElseIfCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/ifElseIfCondition.q|);

public test bool testIfElseIfElseCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/ifElseIfElseCondition.q|);

public test bool testMultipleQuestions() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/multipleQuestions.q|);

public test bool testNestedIfElseIfElseCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/nestedIfElseIfElseCondition.q|);

public test bool testUglyFormattedForm() =  
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/duplicateLabels.q|);

public test bool testUglyFormattedForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/uglyFormatted.q|);

public test bool testUndefinedVariableForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/examples/tests/undefinedVariable.q|);

public test bool testRandomForm() = 
  prettyPrintAndCompare(randomForm(5, 3));
