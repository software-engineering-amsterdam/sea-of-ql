module lang::ql::ide::Check

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import lang::ql::util::Typecheck;
import lang::ql::util::Environment;
import lang::ql::util::Message;
import util::IDE;
import ParseTree;
import Message;

public Contribution getQLAnnotator() 
  = annotator(Tree (Tree input) {
	  return input[@messages=annotate(implode(input))];
    });
       
    
private set[Message] annotate(node input) {

	// get declarations, references, and declaration errors
	env = getEnvironment(input);

	// check expressions types	
	messages = checkTypes(env);
	
	return env.messages + messages;
}

           
// check expression types
private set[Message] checkTypes(Environment env) =
	{typeError(env.references[e].name, e@location) |
	 e <- env.references, !expected(env.references[e], e, env.declarations)};
