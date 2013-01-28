module lang::ql::analysis::LabelMap

import lang::ql::ast::AST;
import util::IDE;

public alias labelMap = map[QuestionText ident, Type \type];
public alias labelMapMessages = tuple[labelMap \map, set[Message] messages];

public labelMapMessages createLabelMap(Form form) {
  labelMap labelMap = ();
  messages = {};
  for(e <- form.formElements) {
    <tm, ms> = createLabelMap(labelMap, e);
    messages += ms;
    labelMap += tm;
  }
  return <labelMap, messages>;
}

private labelMapMessages createLabelMap(labelMap tm, Statement item: question(Question question)) = 
  createLabelMap(tm, question);

private labelMapMessages createLabelMap(labelMap tm, Question q: 
  question(questionText, answerDataType, answerIdentifier)) =
    processIdentifier(questionText, answerDataType, q@location, tm);

private labelMapMessages createLabelMap(labelMap tm, Question q: 
  question(questionText, answerDataType, answerIdentifier, calculatedField)) =
    processIdentifier(questionText, answerDataType, q@location, tm);


private labelMapMessages createLabelMap(labelMap tm, Statement item: 
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) {
  
  messages = {};
  
  list[Statement] stmts = ifPart.body + 
    [e | ei <- elseIfs, e <- ei.body] +
    [e | ep <- elsePart, e <- ep.body];
   
  for(e <- stmts) {
    <t, ms> = createLabelMap(tm, e);
    messages += ms;
    tm += t;
  }
   
  return <tm, messages>;
}

private Message typeError(str text, loc \loc) 
  = warning("Question \"<text>\" is already defined", \loc);

private labelMapMessages processIdentifier(QuestionText qt, Type \type, loc \loc, labelMap tm) {
  if(qt notin tm) {
    t = tm[qt] = \type;
    return <t, {}>;
  }    

  return <tm, {typeError(qt.text, \loc)}>;
} 
