module lang::ql::analysis::FlowGraph

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::ast::Graph;

public set[CG] flowGraph(Form form) = 
  flowGraph(root(form, form@location), form.formElements);

private set[CG] flowGraph(GraphNode parent, list[Statement] formElements) = 
  {* flowGraph(parent, e) | e <- formElements};

private set[CG] flowGraph(GraphNode parent, Statement item:
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) {
  cur = statement(item, item@location);
  return {<parent, cur>} +  
    flowGraph(cur, ifPart) + 
    {* flowGraph(cur, e) | e <- elseIfs} +
    {* flowGraph(cur, e.body) | e <- elsePart};
}

private set[CG] flowGraph(GraphNode parent, Conditional cond:
  conditional(Expr condition, list[Statement] body)) {
  cur = conditional(cond, cond@location);
  return {<parent, cur>} + flowGraph(cur, condition) + {* flowGraph(cur, e) | e <- body};
}

private set[CG] flowGraph(GraphNode parent, Statement item: question(Question question)) = flowGraph(parent, question);

private set[CG] flowGraph(GraphNode parent, Question q:
  question(questionText, answerDataType, answerIdentifier)) {
  return {<parent, question(q, q@location)>};
}

private set[CG] flowGraph(GraphNode parent, Question q:
  question(questionText, answerDataType, answerIdentifier, calculatedField)) {
  cur = question(q, q@location);
  return {<parent, cur>} + flowGraph(cur, calculatedField);
}

private set[CG] flowGraph(GraphNode parent, Expr e) {
  return {<parent, expr(e, e@location)>};
}
