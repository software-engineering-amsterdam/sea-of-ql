/**
 * This module define parse functions for each DataType   
 * A parse function return a parse tree from an input text
 * @author  Gerson Delgado
 * @version 1.0, 21/01/2013
 */
 
module lang::ql::util::Parse

import lang::ql::syntax::QL;
import ParseTree;

public Expr parseExpression(str src) = parse(#Expr, src);
public Expr parseExpression(str src, loc l) = parse(#Expr, src, l);

public DataType parseDataType(str src) = parse(#DataType, src);
public DataType parseDataType(str src, loc l) = parse(#DataType, src, l);

public start[Form] parse(str src) = parse(#start[Form], src);
public start[Form] parse(str src, loc l) = parse(#start[Form], src, l);

public Element parseStatement(str src) = parse(#Statement, src);
public Element parseStatement(str src, loc l) = parse(#Statement, src, l);

public Question parseQuestion(str src) = parse(#Question, src);
public Question parseQuestion(str src, loc l) = parse(#Question, src, l);

public Condition parseCondition(str src) = parse(#Condition, src);
public Condition parseCondition(str src, loc l) = parse(#Condition, src, l);

public ElseIf parseElseIf(str src) = parse(#ElseIf, src);
public ElseIf parseElseIf(str src, loc l) = parse(#ElseIf, src, l);

