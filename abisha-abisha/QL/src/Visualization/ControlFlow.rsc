module Visualization::ControlFlow

import Prelude;
import analysis::graphs::Graph;
import syntax::Abstract;
import load::Load;

public data CFNode                                                                
	= entry(loc location)
	| exit()
	| choice(loc location, Expression exp)
	| q(loc location, Question question)
	| statement(loc location, Statement stat)
	;

alias CFGraph = tuple[set[CFNode] entry, Graph[CFNode] graph, set[CFNode] exit];  

CFGraph cflowStat(statement:ifStat(Expression exp, list[Body]Stats ))
{
	CF1 = cflowCompleteBody(body);
	E = 
	{
		choice(exp@location, exp)
	};
	return < E, (E * CF1.entry) + CF1.graph , CF1.exit >; 
}

CFGraph cflowStat(ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart))
{
   	CF1 = cflowStat(thenpart); 
   	CF2 = cflowStat(elsepart); 
   	E = 
   	{
   		choice(exp@location, exp)
   	}; 
   return < E, (E * CF1.entry) + (E * CF2.entry) + CF1.graph + CF2.graph, CF1.exit + CF2.exit >;
}

CFGraph cflowStats(list[Body] Stats)
{                                        
  if(size(Stats) == 1)
     return cflowStat(Stats[0]);
  CF1 = cflowStat(Stats[0]);
  CF2 = cflowStats(tail(Stats));
  return < CF1.entry, CF1.graph + CF2.graph + (CF1.exit * CF2.entry), CF2.exit >;
}

CFGraph cflowQuestion(question:uncomputedQuestion(str id, str labelQuestion, Type tp))
{
	 Q = q(question@location, question);
	 return <{Q}, {}, {Q}>;
}

CFGraph cflowQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp))
{
 Q = q(question@location, question);
	 return <{Q}, {}, {Q}>;
}

public CFGraph cflowForm(Form F)
{                                           
	if(form(str id, list[Body] Stat) := F)
	{  
    	CF = cflowStat(Stat);
     	Entry = entry(F@location);
     	Exit  = exit();
     	return <{Entry}, ({Entry} * CF.entry) + CF.graph + (CF.exit * {Exit}), {Exit}>;
  	}
  	else
    throw "Cannot happen";
}
public CFGraph cflowForm(str txt) = cflowForm(load(txt));  