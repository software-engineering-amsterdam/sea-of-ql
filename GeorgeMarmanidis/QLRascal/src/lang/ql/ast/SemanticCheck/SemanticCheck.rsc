@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::ast::SemanticCheck::SemanticCheck

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import IO;
import util::IDE;
import lang::ql::ast::SemanticCheck::utilities;
import lang::ql::ast::SemanticCheck::IdentDeclarationsCheck;
import lang::ql::ast::SemanticCheck::TypeCheck;
import lang::ql::ast::SemanticCheck::DuplicateLabelsCheck;
import ParseTree;

public set[Message] semanticCheck(Form form) = getErrors(checkForm(form));

//we check a form here for undeclared variables, 
//declaration errors(duplicate idents,duplicate labels)
//and for type errors.
TENV checkForm(Form P){                                                
  if(form(str ident,list[FormBodyItem] formBody) := P){
  	 TENV env=<{},[],[]>;
  	 env=getIdentDeclarations(formBody,env);
   	 env=duplicateLabelsCheck(env);
     return checkFormBody(formBody,env);
  } else
    throw "Syntax error.";
}


