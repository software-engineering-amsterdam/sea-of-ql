module lang::ql::analysis::TypeMap

import lang::ql::ast::AST;
import util::IDE;

public alias TypeMap = map[IdentDefinition ident, Type \type];
public alias TypeMapMessages = tuple[TypeMap \map, set[Message] messages];

private Message typeError(str name, loc \loc) 
  = error("Identifier is already declared", \loc);

public TypeMapMessages typeMapper(IdentDefinition ident, Type \type, TypeMap tm) {
  if(ident notin tm) {
    t = tm[ident] = \type;
    return <t, {}>;
  }
  
  return <tm, {typeError(ident.ident, ident@location)}>;
} 
