module controlFlow::ControlFlow

import Prelude;
import syntax::AbstractSyntax;
import util::Load;
import controlFlow::ControlFlowQuestion;
import controlFlow::ControlFlowTypes;


/** Method to to get the CFGraph of an if statement
* @param ifStat the if statement
* @param body the body in the if statement
* @return CFGraph
* @author Philipp
*/
CFGraph cflowStat(statement:ifStat(Expression exp, list[Body] body)){
	CF1 = cflowCompleteBody(body);
	E = {choice(exp@location, exp)};
	return < E, (E * CF1.entry) + CF1.graph , CF1.exit >; 
}

/** Method to to get the CFGraph of an if else statement
* @param ifElseStat the if else statement
* @param thenpart the body in the if statement
* @param elsepart the body in the else statement
* @return CFGraph
* @author Philipp
*/
CFGraph cflowStat(ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart)){
   CF1 = cflowCompleteBody(thenpart); 
   CF2 = cflowCompleteBody(elsepart); 
   E = {choice(exp@location, exp)}; 
   return < E, (E * CF1.entry) + (E * CF2.entry) + CF1.graph + CF2.graph, CF1.exit + CF2.exit >;
}

/** Method to to get the CFGraph of a list of statements
* @param Stats the list of statements
* @return CFGraph
* @author Philipp
*/
CFGraph cflowStats(list[Statement] Stats){                                        
  if(size(Stats) == 1)
     return cflowStat(Stats[0]);
  CF1 = cflowStat(Stats[0]);
  CF2 = cflowStats(tail(Stats));
  return < CF1.entry, CF1.graph + CF2.graph + (CF1.exit * CF2.entry), CF2.exit >;
}


CFGraph cflowCompleteBody(list[Body] Body){
	list[Statement] statements = [];
	visit(Body){
		case Question q : return cflowQuestion(q);
	};
}

/** Method to to get the CFGraph of the body
* @param Body a list with the body
* @return CFGraph
* @author Philipp
*/
CFGraph cflowBody(list[Body] Body){
	list[Statement] statements = [];
	questionsGraph = getFirstQuestionsOfForm(Body);
	visit(Body){
		case Statement s : statements += s;
	};
	statementGraph = cflowStats(statements);
	return < questionsGraph.entry, questionsGraph.graph + statementGraph.graph + 
				(questionsGraph.exit * statementGraph.entry), statementGraph.exit >;
}

/** Method to to get the CFGraph of a QL program
* @param P the program
* @return CFGraph
* @author Philipp
*/
public CFGraph cflowProgram(Program P){                                           
  if(program(str id, list[Body] Body) := P){  
     CF = cflowBody(Body);
     Entry = entry(P@location);
     Exit  = exit();
     return <{Entry}, ({Entry} * CF.entry) + CF.graph + (CF.exit * {Exit}), {Exit}>;
  } else
    throw "Cannot happen";
}

public CFGraph cflowProgram(str txt) = cflowProgram(load(txt));  