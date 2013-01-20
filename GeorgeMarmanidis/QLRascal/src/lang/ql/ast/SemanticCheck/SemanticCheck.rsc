module lang::ql::ast::SemanticCheck::SemanticCheck

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import lang::ql::ast::SemanticCheck::IdentDeclarations;
import IO;
import lang::ql::ast::SemanticCheck::utilities;
import lang::ql::ast::SemanticCheck::IdentDeclarations;
import lang::ql::ast::SemanticCheck::TypeCheck;

//
public rel[str, str ,Type,bool] checkForm(loc l) = checkForm(load(l)).symbols;
public list[tuple[loc l, str msg]] checkForm1(loc l) = checkForm(load(l)).errors;
public list[tuple[loc l, str msg]] checkForm(str src) = checkForm(load(src)).errors;
//
public TENV checkForm(Form P){                                                
  if(form(str ident,list[FormBodyItem] formBody) := P){
  	 TENV env=<{},[]>;
  	 //find indentifiers
  	 env=getIdentDeclarations(formBody,env);
   	 //and then check FormBody
     return checkFormBody(formBody,env);
     //return env;
  } else
    throw "Syntax error.";
}


