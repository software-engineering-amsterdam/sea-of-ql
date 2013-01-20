module lang::ql::ast::SemanticCheck::utilities
import IO;
import lang::ql::ast::AST;

alias TENV = tuple[ rel[str variableName,str variableLabel, Type variableType,bool isComputed] symbols, list[tuple[loc l, str msg]] errors];//maybe needs list instead of rel
public TENV addSymbol(TENV env, str ident, str label,Type idType,bool isComputed) = env[symbols = env.symbols + <ident, label,idType,isComputed>];
public TENV addError(TENV env, loc l, str msg) = env[errors = env.errors + <l, msg>];