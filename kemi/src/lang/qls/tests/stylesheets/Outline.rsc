@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::tests::stylesheets::Outline

import lang::qls::ast::AST;
import lang::qls::ide::Outline;
import lang::qls::tests::ParseHelper;
import IO;

private node outline(loc f) = 
  outlineStylesheet(parseStylesheet(f));

private node outline(str s) =
  outlineStylesheet(parseStylesheet(s));


public test bool testBasic() = 
  outline(|project://QL-R-kemi/stylesheets/basic.qs|) > "outline"();

public test bool testCalculatedField() = 
  outline(|project://QL-R-kemi/stylesheets/calculatedField.qs|) > "outline"();

public test bool testComment() = 
  outline(|project://QL-R-kemi/stylesheets/comment.qs|) > "outline"();

public test bool testComplexForm() = 
  outline(|project://QL-R-kemi/stylesheets/complexForm.qs|) > "outline"();

public test bool testIfCondition() = 
  outline(|project://QL-R-kemi/stylesheets/ifCondition.qs|) > "outline"();

public test bool testIfElseCondition() = 
  outline(|project://QL-R-kemi/stylesheets/ifElseCondition.qs|) > "outline"();

public test bool testIfElseIfCondition() = 
  outline(|project://QL-R-kemi/stylesheets/ifElseIfCondition.qs|) > "outline"();

public test bool testIfElseIfElseCondition() = 
  outline(|project://QL-R-kemi/stylesheets/ifElseIfElseCondition.qs|)
    > "outline"();

public test bool testMultipleQuestions() = 
  outline(|project://QL-R-kemi/stylesheets/multipleQuestions.qs|) > "outline"();

public test bool testNestedIfElseIfElseCondition() = 
  outline(|project://QL-R-kemi/stylesheets/nestedIfElseIfElseCondition.qs|)
    > "outline"();

public test bool testProposedSyntax() = 
  outline(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|) > "outline"();

public test bool testTaxOfficeExample() = 
  outline(|project://QL-R-kemi/stylesheets/taxOfficeExample.qs|) > "outline"();

  