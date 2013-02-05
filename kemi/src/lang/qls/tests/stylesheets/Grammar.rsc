@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::tests::stylesheets::Grammar

import lang::qls::ast::AST;
import lang::qls::tests::ParseHelper;


public test bool testBasic() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/basic.qs|) is stylesheet;

public test bool testCalculatedField() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/calculatedField.qs|)
    is stylesheet;

public test bool testComment() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/comment.qs|) is stylesheet;

public test bool testComplexForm() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/complexForm.qs|)
    is stylesheet;

public test bool testIfCondition() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/ifCondition.qs|)
    is stylesheet;

public test bool testIfElseCondition() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/ifElseCondition.qs|)
    is stylesheet;

public test bool testIfElseIfCondition() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/ifElseIfCondition.qs|)
    is stylesheet;

public test bool testIfElseIfElseCondition() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/ifElseIfElseCondition.qs|)
    is stylesheet;

public test bool testMultipleQuestions() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/multipleQuestions.qs|)
    is stylesheet;

public test bool testNestedIfElseIfElseCondition() = 
  parseStylesheet(
    |project://QL-R-kemi/stylesheets/nestedIfElseIfElseCondition.qs|
  )
    is stylesheet;

public test bool testProposedSyntax() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|)
    is stylesheet;

public test bool testTaxOfficeExample() = 
  parseStylesheet(|project://QL-R-kemi/stylesheets/taxOfficeExample.qs|)
    is stylesheet;
