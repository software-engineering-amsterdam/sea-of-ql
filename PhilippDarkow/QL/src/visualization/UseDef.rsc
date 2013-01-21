module visualization::UseDef

import Prelude;
import syntax::AbstractSyntax;
import visualization::ControlFlow;

set[Occurrence] usesExp(EXP e, STATEMENT s) = 
  u:id(QuestionId Id) := e ? {< u@location, Id, s>}
                       : {< u@location, Id, s> | /u:id(QuestionId Id) <- e };
     
set[Occurrence] usesStat(s:asgStat(QuestionId Id, EXP e)) = usesExp(e, s);

set[Occurrence] usesStat(s: ifElseStat(EXP e,
                              list[STATEMENT] s1,
                              list[STATEMENT] s2)) =
   usesExp(e, s) + usesStats(s1) + usesStats(s2);

set[Occurrence] usesStats(list[STATEMENT] stats) =  
   {*usesStat(s) | s <- stats};

public set[Occurrence] uses(PROGRAM p) = usesStats(p.stats);

public set[Occurrence] defs(PROGRAM p) =                 
   { < stat@location, v, stat > | /stat:asgStat(QuestionId v, EXP e) <- p.stats};