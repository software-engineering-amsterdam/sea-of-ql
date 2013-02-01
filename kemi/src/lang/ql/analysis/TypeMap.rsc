module lang::ql::analysis::TypeMap

import lang::ql::analysis::Messages;
import lang::ql::analysis::State;
import lang::ql::ast::AST;
import util::IDE;

public TypeMapMessages typeMapper(IdentDefinition ident, Type \type, TypeMap tm) {
  if(ident notin tm) {
    t = tm[ident] = \type;
    return <t, {}>;
  }
  
  if(tm[ident] != \type) {
    return <tm, {redeclaredMessage(\type@location)}>;
  }
  
  return <tm, {alreadyDeclaredMessage(ident.ident, ident@location)}>;
} 
