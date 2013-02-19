/**
 * This module contains function for the generation of the IDE Outline view 
 * Contains functions in order to match the current QL syntax and generate a outline view 
 * @author  Gerson Delgado
 * @version 1.0, 15/02/2013
 */
 
module lang::ql::ide::Outline::Generator

import lang::ql::ast::AST;
import Node;
import List;
import lang::ql::ide::Outline::Environment;

/**
* Generator function for the outline view 
* This function make node(s) that will be used by the outliner 
*/  
public node genOutline(form(str id, list[Element] fElems)){
	OENV tempNodes = <[],[]>; 
	outNodes = getOutline(fElems, tempNodes);
	node outQstns = makeNode("Questions (<size(outNodes.qstns)>)", outNodes.qstns);
	node outConds = makeNode("Conditions (<size(outNodes.conds)>)", outNodes.conds); 
 	node outline = makeNode("form", [outQstns, outConds]);
 	return outline;
 }
 
private OENV getOutline(list[Element] fElems, OENV nds){
	visit(fElems){
		case qstn:computableQuestion(_,_,_,_) 
			: nds = getOutline(qstn, nds);
		case qstn:singleQuestion(_,_,_) 
			: nds = getOutline(qstn, nds);
		case cond:singleIfCondition(_,_) 
			: nds = getOutline(cond, nds);
		case cond:ifElseCondition(_,_,_) 
			: nds = getOutline(cond, nds);
	}
	return nds;	
} 

private OENV getOutline(question(Question qstn), OENV nds) 
	= getOutline(qstn, nds);
	
private OENV getOutline(qstn:singleQuestion(str qstnIdent, str qstnLabel, DataType qstnDataType), OENV nds)
	= addQstn(nds, qstnIdent, qstnLabel, qstnDataType, qstn@location);
	

private OENV getOutline(qstn:computableQuestion(str cqstnIdent, str cqstnLabel, DataType cqstnDataType, Expr cqstnExpr), OENV nds)
 	= addQstn(nds, cqstnIdent, cqstnLabel, cqstnDataType, qstn@location);

private OENV getOutline(condition(Condition cond), OENV nds)
	= getOutline(cond, nds);
	 	
private OENV getOutline(cond:singleIfCondition(Expr ifEval, list[Element] ifQstns), OENV nds) {
	nds0 = addCond(nds, "If", ifEval, cond@location);
	nds1 = getOutline(ifQstns, nds0);
	return nds1;
}

private OENV getOutline(cond:ifElseCondition(Expr ifEval, list[Element] ifQstns, list[Element] elseQstns), OENV nds) {
	nds0 = getOutline(ifQstns, nds);
	nds1 = getOutline(elseQstns, nds0);
	nds2 = addCond(nds1, "If Else", ifEval, cond@location);
	return nds2 ;
}

