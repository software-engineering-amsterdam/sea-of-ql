module visualization::ControlFlow

import Prelude;
import Graph;
import syntax::AbstractSyntax;
import typeChecker::Load;

public data CFNode                                                                
	= entry(loc location)
	| exit()
	| choice(loc location, EXP exp)
	| statement(loc location, STATEMENT stat);

alias CFGraph = tuple[set[CFNode] entry, Graph[CFNode] graph, set[CFNode] exit];  

CFGraph cflowStat(s:asgStat(PicoId Id, EXP Exp)) {                                
   S = statement(s@location, s);
   return <{S}, {}, {S}>;
}

CFGraph cflowStat(ifElseStat(EXP Exp,                                             
                              list[STATEMENT] Stats1,
                              list[STATEMENT] Stats2)){
   CF1 = cflowStats(Stats1); 
   CF2 = cflowStats(Stats2); 
   E = {choice(Exp@location, Exp)}; 
   return < E, (E * CF1.entry) + (E * CF2.entry) + CF1.graph + CF2.graph, CF1.exit + CF2.exit >;
}

CFGraph cflowStats(list[STATEMENT] Stats){                                        
  if(size(Stats) == 1)
     return cflowStat(Stats[0]);
  CF1 = cflowStat(Stats[0]);
  CF2 = cflowStats(tail(Stats));
  return < CF1.entry, CF1.graph + CF2.graph + (CF1.exit * CF2.entry), CF2.exit >;
}

public CFGraph cflowProgram(PROGRAM P){                                           
  if(program(list[DECL] Decls, list[STATEMENT] Series) := P){
     CF = cflowStats(Series);
     Entry = entry(P@location);
     Exit  = exit();
     return <{Entry}, ({Entry} * CF.entry) + CF.graph + (CF.exit * {Exit}), {Exit}>;
  } else
    throw "Cannot happen";
}

public CFGraph cflowProgram(str txt) = cflowProgram(load(txt));  