@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::ast::semanticcheck::SemanticCheck

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import IO;
import util::IDE;
import lang::ql::ast::semanticcheck::TypeEnvUtils;
import lang::ql::ast::semanticcheck::IdentDeclarationsCheck;
import lang::ql::ast::semanticcheck::TypeCheck;
import lang::ql::ast::semanticcheck::DuplicateLabelsCheck;
import lang::ql::ast::semanticcheck::CyclicCheck;
import ParseTree;

public set[Message] semanticCheck(Form form) = getErrors(checkForm(form));

//we check a form here for undeclared variables, 
//declaration errors(duplicate idents,duplicate labels)
//and for type errors.
public TENV checkForm(Form P){                                                
  if(form(ident,formBody) := P){
  	 TENV env=<{},[],[]>;
  	 env=getIdentDeclarations(formBody,env);
   	 env=duplicateLabelsCheck(env);
   	 env=checkCyclicDepen(formBody,env);
     return checkFormBody(formBody,env);
  } else
    throw "Syntax error.";
}


