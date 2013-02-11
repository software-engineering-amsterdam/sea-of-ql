module visualization::ControlFlow

import Prelude;
import analysis::graphs::Graph;
import syntax::AbstractSyntax;
import util::Load;

public data CFNode                                                                
	= entry(loc location)
	| exit()
	| choice(loc location, Expression exp)
	| statement(loc location, Statement stat);

alias CFGraph = tuple[set[CFNode] entry, Graph[CFNode] graph, set[CFNode] exit];  

//CFGraph cflowStat(s:asgStat(QuestionId Id, EXP Exp)) {                                
//   S = statement(s@location, s);
//   return <{S}, {}, {S}>;
//}

CFGraph cflowStat(statement:ifStat(Expression exp, list[Body] body)){
	println("In cflow if statement");
}

CFGraph cflowStat(ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart2)){
   CF1 = cflowStats(Stats1); 
   CF2 = cflowStats(Stats2); 
   E = {choice(Exp@location, Exp)}; 
   return < E, (E * CF1.entry) + (E * CF2.entry) + CF1.graph + CF2.graph, CF1.exit + CF2.exit >;
}

CFGraph cflowStats(list[Statement] Stats){                                        
  if(size(Stats) == 1)
     return cflowStat(Stats[0]);
  CF1 = cflowStat(Stats[0]);
  CF2 = cflowStats(tail(Stats));
  return < CF1.entry, CF1.graph + CF2.graph + (CF1.exit * CF2.entry), CF2.exit >;
}


CFGraph cflowBody(list[Body] Body){
	println("Body : <Body>");
	list[Statement] statements = [];
	visit(Body){
		case Statement s : statements += s;
	};
	println("Statements : <statements>");
	return cflowStats(statements);
}

public CFGraph cflowProgram(Program P){                                           
  if(program(str id, list[Body] Body) := P){  
     CF = cflowBody(Body);
     //CF = cflowStats(Series);
     Entry = entry(P@location);
     Exit  = exit();
     return <{Entry}, ({Entry} * CF.entry) + CF.graph + (CF.exit * {Exit}), {Exit}>;
  } else
    throw "Cannot happen";
}

public CFGraph cflowProgram(str txt) = cflowProgram(load(txt));  