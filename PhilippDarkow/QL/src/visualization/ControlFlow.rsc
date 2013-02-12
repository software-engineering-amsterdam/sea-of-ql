module visualization::ControlFlow

import Prelude;
import analysis::graphs::Graph;
import syntax::AbstractSyntax;
import util::Load;

public data CFNode                                                                
	= entry(loc location)
	| exit()
	| choice(loc location, Expression exp)
	| q(loc location, Question question)
	| bo(loc location, Body body)
	| statement(loc location, Statement stat);

alias CFGraph = tuple[set[CFNode] entry, Graph[CFNode] graph, set[CFNode] exit];  

//CFGraph cflowStat(s:asgStat(QuestionId Id, EXP Exp)) {                                
//   S = statement(s@location, s);
//   return <{S}, {}, {S}>;
//}

CFGraph cflowStat(statement:ifStat(Expression exp, list[Body] body)){
	println("In cflow if statement");
	CF1 = cflowCompleteBody(body);
	E = {choice(exp@location, exp)};
	return < E, (E * CF1.entry) + CF1.graph , CF1.exit >; 
}

CFGraph cflowStat(ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart)){
   println("thenpart : <thenpart>");
   CF1 = cflowCompleteBody(thenpart); 
   CF2 = cflowCompleteBody(elsepart); 
   E = {choice(exp@location, exp)}; 
   return < E, (E * CF1.entry) + (E * CF2.entry) + CF1.graph + CF2.graph, CF1.exit + CF2.exit >;
}

CFGraph cflowStats(list[Statement] Stats){                                        
  if(size(Stats) == 1)
     return cflowStat(Stats[0]);
  CF1 = cflowStat(Stats[0]);
  CF2 = cflowStats(tail(Stats));
  return < CF1.entry, CF1.graph + CF2.graph + (CF1.exit * CF2.entry), CF2.exit >;
}

CFGraph cflowQuestion(question:easyQuestion(str id, str labelQuestion, Type tp)){
	println("Question : <question>");
	println("Question Location : <question@location>");
	 Q = q(question@location, question);
	 return <{Q}, {}, {Q}>;
}

CFGraph cflowQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
	
}

CFGraph cflowQues(list[Question] ques){
	
	if(size(ques) == 1) return cflowQuestion(ques[0]);
}


CFGraph cflowCompleteBody(list[Body] Body){
	println("Body : <Body>");
	list[Statement] statements = [];
	visit(Body){
		case Question q : return cflowQuestion(q);
	};
	println("Statements : <statements>");
	return cflowStats(statements);
}

CFGraph cflowBody(list[Body] Body){
	println("Body : <Body>");
	list[Question] ques = [];
	list[Statement] statements = [];
	for(s <- Body){
		println("S : <s>");
		if(getName(s) == "question"){
		visit(s){
			case Question qu : {
				println("QUE : <qu>");
				ques += qu;
			}
		}
		}
	}
	println("HUI : <ques>");
	p = cflowQues(ques);
	println("!!!!P : <p>");
	visit(Body){
		case Statement s : statements += s;
	};
	println("Statements : <statements>");
	jj = cflowStats(statements);
	println("JJ : <jj>");
	return < p.entry, p.graph + jj.graph + (p.exit * jj.entry), jj.exit >;
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