module Visualization::UseDef

import Prelude;
import syntax::abstractSyntax;
import Visualization::ControlFlow;

set[Occurrence] usesExp(Expression e, Statement s) = 
  u:id(QuestionireId Id) := e ? {< u@location, Id, s>}
                       : {< u@location, Id, s> | /u:id(QuestionireId Id) <- e };
     
//set[Occurrence] usesStat(s:asgStat(QuestionId Id, Expression Exp)) = usesExp(Exp, s);

set[Occurrence] usesStat(s: ifElseStat(Expression e,list[Statement] s1,list[Statement] s2)) = usesExp(e, s) + usesStats(s1) + usesStats(s2);

set[Occurrence] usesStats(list[Statement] stats) = {*usesStat(s) | s <- stats};

public set[Occurrence] uses(Program p) = usesStats(p.stats);

public set[Occurrence] defs(Program p) = { < stat@location, v, stat > | /stat:asgStat(QuestioniireId v, EXP e) <- p.stats};