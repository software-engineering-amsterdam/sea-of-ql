module lang::ql::ide::IdentifierUsesDefinitions

import lang::ql::ast::AST;

public alias Occurrence = tuple[loc location, str \type, Expr expr];

public set[Occurrence] identifierUses(Form form) = uses(form.formElements);

public set[Occurrence] identifierDefinitions(Form f) =                 
  { < q@location, \type, ident(id) > | /q:question(qtext, \type, id) <- f.formElements} +
  { < q@location, \type, ident(id) > | /q:question(qtext, \type, id, cfield) <- f.formElements};

private set[Occurrence] uses(list[Statement] formElements) = {*uses(e) | e <- formElements};

private set[Occurrence] uses(Statement item:
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) {
  return
    uses(ifPart) +
    {*uses(e) | e <- elseIfs} +
    {*uses(e.body) | e <- elsePart};
}

private set[Occurrence] uses(Conditional cond:
  conditional(Expr condition, list[Statement] body)) {
  return uses(condition) + {*uses(e) | e <- body};
}

private set[Occurrence] uses(Statement item: question(Question question)) = uses(question);

private set[Occurrence] uses(Question q:
  question(questionText, answerDataType, answerIdentifier)) {
  return {};
}

private set[Occurrence] uses(Question q:
  question(questionText, answerDataType, answerIdentifier, calculatedField)) {
  return uses(calculatedField); 
}

private set[Occurrence] uses(Expr e) = 
  u:ident(str name) := e ? {< u@location, "", ident(name)>}
                       : {< u@location, "", ident(name)> | /u:ident(str name) <- e };
