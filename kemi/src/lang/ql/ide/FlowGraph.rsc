module lang::ql::ide::FlowGraph

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::ast::Graph;

public set[CG] formGraph(Form form) = 
  formGraph(root(form, form@location), form.formElements);

private set[CG] formGraph(GraphNode parent, list[Statement] formElements) = 
  {*formGraph(parent, e) | e <- formElements};

private set[CG] formGraph(GraphNode parent, Statement item:
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) {
  cur = statement(item, item@location);
  return {<parent, cur>} +  
    formGraph(cur, ifPart) + 
    {*formGraph(cur, e) | e <- elseIfs} +
    {*formGraph(cur, e.body) | e <- elsePart};
}

private set[CG] formGraph(GraphNode parent, Conditional cond:
  conditional(Expr condition, list[Statement] body)) {
  cur = conditional(cond, cond@location);
  return {<parent, cur>}+ formGraph(cur, condition) + {*formGraph(cur, e) | e <- body};
}

private set[CG] formGraph(GraphNode parent, Statement item: question(Question question)) = formGraph(parent, question);

private set[CG] formGraph(GraphNode parent, Question q:
  question(questionText, answerDataType, answerIdentifier)) {
  return {<parent, question(q, q@location)>};
}

private set[CG] formGraph(GraphNode parent, Question q:
  question(questionText, answerDataType, answerIdentifier, calculatedField)) {
  cur = question(q, q@location);
  return {<parent, cur>} + formGraph(cur, calculatedField);
}

private set[CG] formGraph(GraphNode parent, Expr e) {
  return {<parent, expr(e, e@location)>};
}
