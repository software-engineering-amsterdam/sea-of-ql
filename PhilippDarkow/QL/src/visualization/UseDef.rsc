module visualization::UseDef

import Prelude;
import syntax::AbstractSyntax;
import visualization::ControlFlow;

set[Occurrence] usesExp(Expression e, Statement s) = 
  u:id(str Id) := e ? {< u@location, Id, s>}
                       : {< u@location, Id, s> | /u:id(str Id) <- e };
     
// set[Occurrence] usesStat(s:asgStat(QuestionId Id, Expression e)) = usesExp(e, s);

set[Occurrence] usesStat(s: ifStat(Expression e, list[Body] s1)) {
	println("IN USEDEF EXP : <e>");
	usesExp(e, s);
}

set[Occurrence] usesStat(s: ifElseStat(Expression e,
                              list[STATEMENT] s1,
                              list[STATEMENT] s2)) =
   usesExp(e, s) + usesStats(s1) + usesStats(s2);

set[Occurrence] usesStats(list[Statement] stats) =  
   {*usesStat(s) | s <- stats};

public set[Occurrence] uses(Program p) = usesStats(p.stats);

// Need to check in abstract syntax Occurence
public set[Occurrence] defs(Program p) =                 
   { < stat@location, v, stat > | /stat:ifStat(Expression e, list[Body] s1) <- p.body};