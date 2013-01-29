module lang::ql::analysis::LabelMap

import lang::ql::analysis::Messages;
import lang::ql::analysis::State;
import lang::ql::ast::AST;
import util::IDE;

public LabelMapMessages labelMapper(QuestionText qt, IdentDefinition ident, LabelMap lm) {
  if(qt notin lm) {
    t = lm[qt] = ident;
    return <t, {}>;
  }    

  return <lm, {labelError(qt@location)}>;
} 
