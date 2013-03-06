/**
 * This module contains code revelant to the IDE outline view  
 * contains functions in order to add new elemnts to the OENV(outline)
 * @author  Gerson Delgado
 * @version 1.0, 15/02/2013
 */
 
module lang::ql::ide::Outline::Environment

import lang::ql::ast::AST;
import Node;
import List;

alias OENV = tuple[ 
	list[node] qstns, list[node] conds
	];

public OENV addQstn(OENV nds, str id, str qstnLabel, DataType qstnDataType, loc qstnLoc) 
	= nds[qstns = nds.qstns + setAnnotations("<id>"(qstnLabel,qstnDataType), ("Label":"<id>", ":Location":qstnLoc))];
	
public OENV addCond(OENV nds, str id, Expr condExpr, loc condLoc) 
	= nds[conds = nds.conds + setAnnotations("Conditions"(<id>,condExpr), ("Label":"<id>", "Location":condLoc))];

