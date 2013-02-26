module Visualization::UseDef

import Prelude;
import syntax::Abstract;
import Visualization::ControlFlow;

set[Occurrence] usesExp(Expression e, Statement s) = 
  u:id(QuestionireId Id) := e ? {< u@location, Id, s>}
                       : {< u@location, Id, s> | /u:id(QuestionireId Id) <- e };
     
set[Occurrence] usesStat(s: ifStat(Expression e, list[Body] s1)) 
{
	println("IN USEDEF EXP : <e>");
	usesExp(e, s);
}

set[Occurrence] usesStat(s: ifElseStat(Expression e,list[Statement] s1,list[Statement] s2)) = usesExp(e, s) + usesStats(s1) + usesStats(s2);

set[Occurrence] usesStats(list[Statement] stats) = {*usesStat(s) | s <- stats};


public set[Occurrence] uses(Form p) 
{println("IN USES : <p.questionnaireName>");
	usesStats(p.stats);
}

public set[Occurrence] defs(Form p) 
{
	return { < question@location, id, question > | /question:uncomputedQuestion(str id, str questionLabel, Type tp) <- p.body[0].question};
}
 
