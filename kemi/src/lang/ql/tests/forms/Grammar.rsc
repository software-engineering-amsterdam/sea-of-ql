@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::tests::forms::Grammar

import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::ql::util::FormGenerator;
import lang::ql::util::Random;

public test bool testForm1() = parseForm("form Hello { \"Income?\" money myIncome }") is form;
public test bool testForm1() = parseForm("form Hello { \"Tax?\" money myTax = myIncome * 0.40 }") is form;

public test bool testBasicForm() = parseForm(|project://QL-R-kemi/examples/tests/basic.q|) is form;
public test bool testCommentForm() = parseForm(|project://QL-R-kemi/examples/tests/comment.q|) is form;
public test bool testMultiparseleQuestions() = parseForm(|project://QL-R-kemi/examples/tests/multipleQuestions.q|) is form;
public test bool testIfCondition() = parseForm(|project://QL-R-kemi/examples/tests/ifCondition.q|) is form;
public test bool testIfElseCondition() = parseForm(|project://QL-R-kemi/examples/tests/ifElseCondition.q|) is form;
public test bool testIfElseIfCondition() = parseForm(|project://QL-R-kemi/examples/tests/ifElseIfCondition.q|) is form;
public test bool testIfElseIfElseCondition() = parseForm(|project://QL-R-kemi/examples/tests/ifElseIfElseCondition.q|) is form;
public test bool testNestedIfElseIfElseCondition() = parseForm(|project://QL-R-kemi/examples/tests/nestedIfElseIfElseCondition.q|) is form;
public test bool testCalculatedField() = parseForm(|project://QL-R-kemi/examples/tests/calculatedField.q|) is form;
public test bool testUglyFormattedForm() = parseForm(|project://QL-R-kemi/examples/tests/uglyFormatted.q|) is form;

public test bool testUndefinedVariableForm() = parseForm(|project://QL-R-kemi/examples/tests/undefinedVariable.q|) is form;

public test bool testUglyFormattedForm() = parseForm(|project://QL-R-kemi/examples/tests/duplicateLabels.q|) is form;

public test bool testRandomForm() = parseForm(randomForm(5, 3)) is form;
