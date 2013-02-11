@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::tests::stylesheets::PrettyPrinter

import lang::qls::ast::AST;
import lang::qls::compiler::PrettyPrinter;
import lang::qls::util::ParseHelper;

private bool prettyPrintAndCompare(loc f) = 
  parseStylesheet(f) == parseStylesheet(prettyPrint(parseStylesheet(f)));

private bool prettyPrintAndCompare(str s) = 
  parseStylesheet(s) == parseStylesheet(prettyPrint(parseStylesheet(s)));

public test bool testBasic() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/basic.qs|);

public test bool testCalculatedField() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/calculatedField.qs|);

public test bool testComment() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/comment.qs|);

public test bool testComplexForm() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/complexForm.qs|);

public test bool testIfCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/ifCondition.qs|);

public test bool testIfElseCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/ifElseCondition.qs|);

public test bool testIfElseIfCondition() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/ifElseIfCondition.qs|);

public test bool testIfElseIfElseCondition() = 
  prettyPrintAndCompare(
    |project://QL-R-kemi/stylesheets/ifElseIfElseCondition.qs|
  );

public test bool testMultipleQuestions() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/multipleQuestions.qs|);

public test bool testNestedIfElseIfElseCondition() = 
  prettyPrintAndCompare(
    |project://QL-R-kemi/stylesheets/nestedIfElseIfElseCondition.qs|
  );

public test bool testProposedSyntax() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|);

public test bool testTaxOfficeExample() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/taxOfficeExample.qs|);
