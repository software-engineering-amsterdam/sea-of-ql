module controlFlow::ControlFlowTypes

import analysis::graphs::Graph;
import syntax::AbstractSyntax;

public data CFNode                                                                
	= entry(loc location)
	| exit()
	| choice(loc location, Expression exp)
	| q(loc location, Question question)
	| bo(loc location, Body body)
	| statement(loc location, Statement stat);

public alias CFGraph = tuple[set[CFNode] entry, Graph[CFNode] graph, set[CFNode] exit];  