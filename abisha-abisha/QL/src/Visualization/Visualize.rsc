module Visualization::Visualize

import Prelude;
import vis::Figure;
import vis::KeySym;

import syntax::Abstract;
import Visualization::ControlFlow;

//  Convert expressions into text
public str make(moneyCon(real M)) = "<M>";
public str make(boolCon(bool B)) = "<B>";
public str make(integer(bool B)) = "<B>";
public str make(strCon(str S)) = S;
public str make(str S) = S;
public str make(Type T) = "<T>";

public str make(question:uncomputedQuestion(str id, str labelQuestion, Type tp)) 
{
	return "<make(id)> + <make(labelQuestion)> + <make(tp)>";    
}

public str make(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)) 
{
	return "<make(id)> + <make(labelQuestion)> + <make(tp)>+<make(exp)>";    
}

public str make(syntax::Abstract::id(str Id)) = Id;
public str make(add(Expression E1, Expression E2)) = "<make(E1)> + <make(E2)>";
public str make(sub(Expression E1, Expression E2)) = "<make(E1)> - <make(E2)>";
public str make(not(Expression E1, Expression E2)) = "<make(E1)> ! <make(E2)>";
public str make(mul(Expression E1, Expression E2)) = "<make(E1)> * <make(E2)>";
public str make(div(Expression E1, Expression E2)) = "<make(E1)> / <make(E2)>";
public str make(lt(Expression E1, Expression E2)) = "<make(E1)> \< <make(E2)>";
public str make(leq(Expression E1, Expression E2)) = "<make(E1)> \<= <make(E2)>";
public str make(gt(Expression E1, Expression E2)) = "<make(E1)> \> <make(E2)>";
public str make(geq(Expression E1, Expression E2)) = "<make(E1)> \>= <make(E2)>";
public str make(eq(Expression E1, Expression E2)) = "<make(E1)> == <make(E2)>";
public str make(neq(Expression E1, Expression E2)) = "<make(E1)> != <make(E2)>";
public str make(and(Expression E1, Expression E2)) = "<make(E1)> && <make(E2)>";
public str make(or(Expression E1, Expression E2)) = "<make(E1)> || <make(E2)>";

//  Add an editor to a node
FProperty editIt(CFNode n) =
   	(n has location) ? onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers)
   	{
   		edit(n.location,[]); return true;
   	}): onMouseDown(bool (int butnr, map[KeyModifier,bool] modifiers) {return false;});
        
//  Visualize one CFG node

Figure visNode(CFNode n:entry(loc location)) = box(text("ENTRY"), vis::Figure::id(getId(n)), fillColor("red"), gap(4));

Figure visNode(CFNode n:exit()) = box(text("EXIT"),  vis::Figure::id(getId(n)), fillColor("grey"), gap(4));

Figure visNode(CFNode n:choice(loc location, Expression exp)) = ellipse(text(make(exp)),  vis::Figure::id(getId(n)), fillColor("yellow"), gap(8), editIt(n));

Figure visNode(CFNode n:statement(loc location, asgStat(QuestionId Id, EXP Exp))) = box(text("<Id> := <make(Exp)>"),  vis::Figure::id(getId(n)), gap(8), editIt(n));
        
//  Define the id for each CFG node

str getId(entry(loc location)) = "ENTRY";
str getId(exit()) = "EXIT";
default str getId(CFNode n) = "<n.location>";

//  Visualize a complete CFG

public Figure visCFG(rel[CFNode, CFNode] CFGGraph)
{
	nodeSet = {};
    edges = [];
    for(< CFNode cf1, CFNode cf2> <- CFGGraph)
    {
    	nodeSet += {cf1, cf2};
        edges += edge(getId(cf1), getId(cf2), toArrow(triangle(5, fillColor("black"))));
    }
       nodes = [visNode(n) | n <- nodeSet];
       return graph(nodes, edges, hint("layered"), gap(20));
}