module lang::ql::analysis::TypeMap

import lang::ql::analysis::State;
import lang::ql::ast::AST;
import util::IDE;

private Message alreadyDeclaredMessage(loc \loc) 
  = error("Identifier is already declared.", \loc);
  
private Message redeclaredMessage(loc \loc) 
  = error("Identifier is declared with a different type.", \loc);  

public TypeMapMessages typeMapper(IdentDefinition ident, Type \type, TypeMap tm) {
  if(ident notin tm) {
    t = tm[ident] = \type;
    return <t, {}>;
  }
  
  if(tm[ident] != \type) {
    return <tm, {redeclaredMessage(\type@location)}>;
  }
  
  return <tm, {alreadyDeclaredMessage(ident@location)}>;
} 
