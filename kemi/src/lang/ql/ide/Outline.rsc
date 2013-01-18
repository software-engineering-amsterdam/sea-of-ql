module lang::ql::ide::Outline

import List;
import Node;
import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::ide::Outline;
import lang::ql::util::Implode;
import lang::ql::util::Parse;
import util::IDE;

public node outlineForm(Form form) {
  return 
    "outline"(outline(form))
    [@label="Form"]
    [@\loc=form@location];
}

private node createNode(str name, str label, loc location, list[node] children)
  = setAnnotations(makeNode(name, children), ("label": label, "loc": location));

private node outlineBranch(str name, str label, loc location, list[Statement] items) {
  return
    "<name>"([outline(i) | i <- items])
    [@label="<label>"]
    [@\loc=location];
}

private node outline(Form form) {
  return  
    "form"([outline(e) | e <- form.formElements])
    [@label="Form <form.formName> (<size(form.formElements)>)"]
    [@\loc=form@location];
}

private node outline(Statement item:
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) {
  str name = "IfCondition";
  str label = "If (<prettyPrint(ifPart.condition)>)";

  bool elseIfBlock = false;
  bool elseBlock = false;

  children = [outlineBranch("ifPart", "<prettyPrint(ifPart.condition)>", ifPart@location, ifPart.body)];

  if (elseIfs != []) {
    elseIfBlock = true;
    children += [outlineBranch("elseIf", "<prettyPrint(b.condition)>", b@location, b.body) | b <- elseIfs];
  }

  if(elsePart != []) {
    elseBlock = true;
    ElsePart ep = head(elsePart);
    children += [outlineBranch("elsePart", "else", ep@location, ep.body)];
  }

  if(elseIfBlock && elseBlock) {
    name = "ifElseIfElseCondition";
    label = "If (<prettyPrint(ifPart.condition)>) elseif... else";
  } else if(elseIfBlock) {
    name = "ifElseIfCondition";
    label = "If (<prettyPrint(ifPart.condition)>) elseif...";
  } else if(elseBlock) {
    name = "ifElseCondition";
    label = "If (<prettyPrint(ifPart.condition)>) else ...";
  }
  
  return createNode(name, label, item@location, children);
}

private node outline(Statement item: 
  question(Question question)) = 
    outline(question);

private node outline(Question q:
  question(questionText, answerDataType, answerIdentifier)) {
  str name = "Question";
  str label = "Q: <answerDataType>:<questionText>";

  return createNode(name, label, q@location, []);
}

private node outline(Question q:
  question(questionText, answerDataType, answerIdentifier, calculatedField)) {
  str name = "CalculatedQuestion";
  str label = "CQ: <answerDataType>:<questionText>(<calculatedField>)";
  
  return createNode(name, label, q@location, []);
}
