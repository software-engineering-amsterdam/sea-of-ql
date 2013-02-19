/**
 * This module define overloaded parse functions for each DataType   
 * A parse function return a parse tree from an input text
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module lang::ql::util::Parse

import lang::ql::syntax::QL;
import ParseTree;

public Expr parseExpression(str src) 
	= parse(#Expr, src);

public DataType parseDataType(str src) 
	= parse(#DataType, src);

public Form parseForm(str src) 
	= parse(#Form, src);

public start[Form] parseForm(str src, loc l) 
	= parse(#start[Form], src, l);

public Element parseStatement(str src) 
	= parse(#Statement, src);

public Question parseQuestion(str src) 
	= parse(#Question, src);

public start[Condition] parseCondition(str src) 
	= parse(#start[Condition], src);




