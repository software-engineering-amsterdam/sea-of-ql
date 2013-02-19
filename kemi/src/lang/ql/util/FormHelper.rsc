module lang::ql::util::FormHelper

import lang::ql::\ast::AST;

private list[Statement] getConditionalBodies(Statement cond) = 
  cond.ifPart.body + 
  [*ei.body | ei <- cond.elseIfs] +
  [*ep.body | ep <- cond.elsePart];  

public set[str] getDirectDescendingIdents(Statement cond) =
  getDirectDescendingIdents(getConditionalBodies(cond));

public set[str] getDescendingIdents(Statement cond) =
  getDescendingIdents(getConditionalBodies(cond));
  
public set[str] getDirectDescendingIdents(list[Statement] items) =
  {q.answerIdentifier.ident | i <- items, question(Question q) := i};

public set[str] getDescendingIdents(list[Statement] items) =
  {q.answerIdentifier.ident | i <- items, /question(Question q) := i};

public str getBlockSuffix() =
  "Block";

public str getDefaultLabelText() =
  "Choose an answer";

public str getLabelTextTrue() =
  "Yes";
  
public str getLabelTextFalse() =
  "No";
