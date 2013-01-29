module lang::ql::analysis::LabelMap

import lang::ql::ast::AST;
import util::IDE;

public alias LabelMap = map[QuestionText text, IdentDefinition ident];
public alias LabelMapMessages = tuple[LabelMap \map, set[Message] messages];

private Message labelError(loc \loc) 
  = warning("The question is already defined", \loc);

public LabelMapMessages labelMapper(QuestionText qt, IdentDefinition ident, LabelMap lm) {
  if(qt notin lm) {
    t = lm[qt] = ident;
    return <t, {}>;
  }    

  return <lm, {labelError(qt@location)}>;
} 
