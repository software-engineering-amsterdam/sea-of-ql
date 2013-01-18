module lang::ql::ide::Outline

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import lang::ql::util::Unparse;
import util::IDE;
import ParseTree;
import Node;
import List;
import Exception;


public Contribution getOutliner() 
  = outliner(node(Tree input) {
	  return "outline"(outline(implode(input)));
    });


private node makeOutlineNode(str name, str label, loc location, list[node] children) =
	setAnnotations(makeNode(name, children), ("label" : label, "loc" : location));


private node outline(Form form) =
	makeOutlineNode("form", form.name, form@location, getNodesFromStatements(form.statements));
  	
private node outline(Statement input:regular(\type, name, _)) =
	makeOutlineNode("reg", "<name> :<\type>", input@location, []);

private node outline(Statement input:computed(\type, name, _, expr)) =
	makeOutlineNode("com", "<name> = <unparse(expr)> : <\type>", input@location, []);

private node outline(Statement input:conditional(_, _, _)) =
	makeOutlineNode("con", "if (<unparse(input.\if.condition)>)", input@location, 
				    getNodesFromStatements(flatten(input)));



private list[node] getNodesFromStatements(list[Statement] s) 
  = ["regular"([outline(r) | r <- separate(s).regularQuestions])
  			  [@label="Regular Questions (<size(separate(s).regularQuestions)>)"],
	 "computed"([outline(c) | c <- separate(s).computedQuestions])
	 		   [@label="Computed Questions (<size(separate(s).computedQuestions)>)"],
	 "conditional"([outline(c) | c <- separate(s).conditionals])
	 			  [@label="Conditionals (<size(separate(s).conditionals)>)"]];


// return a list of all top level statements contained in a conditional
private list[Statement] flatten(Statement s:conditional(_,[],e)) = s.\if.body + e;  
private list[Statement] flatten(Statement s:conditional(_,ei,e)) 
  = s.\if.body + flatten(conditional(head(ei), tail(ei), e));  


// return a tuple with groups of different kinds of statements
private SeparatedStatements separate(list[Statement] s) = 
  <[r | r:regular(_,_,_) <- s], [c | c:computed(_,_,_,_) <- s], [c | c:conditional(_,_,_) <- s]>;


