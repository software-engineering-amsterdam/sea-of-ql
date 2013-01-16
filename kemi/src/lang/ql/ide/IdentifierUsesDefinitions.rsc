module lang::ql::ide::IdentifierUsesDefinitions

import lang::ql::ast::AST;

public alias Occurence = tuple[loc location, str \type, Expr expr];

public set[Occurence] identifierUses(Form form) = uses(form.formElements);

public set[Occurence] identifierDefinitions(Form f) =                 
  { < q@location, \type, ident(id) > | /q:question(qtext, \type, id) <- f.formElements} +
  { < q@location, \type, ident(id) > | /q:question(qtext, \type, id, cfield) <- f.formElements};

private set[Occurence] uses(list[Statement] formElements) = {*uses(e) | e <- formElements};

private set[Occurence] uses(Statement item:
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) {
  return
    uses(ifPart) +
    {*uses(e) | e <- elseIfs} +
    {*uses(e.body) | e <- elsePart};
}

private set[Occurence] uses(Conditional cond:
  conditional(Expr condition, list[Statement] body)) {
  return uses(condition) + {*uses(e) | e <- body};
}

private set[Occurence] uses(Statement item: question(Question question)) = uses(question);

private set[Occurence] uses(Question q:
  question(questionText, answerDataType, answerIdentifier)) {
  return {};
}

private set[Occurence] uses(Question q:
  question(questionText, answerDataType, answerIdentifier, calculatedField)) {
  return {<q@location, answerDataType, ident(answerIdentifier)>}; 
}

private set[Occurence] uses(Expr e) = 
  u:ident(str name) := e ? {< u@location, "", ident(name)>}
                       : {< u@location, "", ident(name)> | /u:ident(str name) <- e };
