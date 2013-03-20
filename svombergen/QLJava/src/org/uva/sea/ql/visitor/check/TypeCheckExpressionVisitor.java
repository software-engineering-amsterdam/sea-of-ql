package org.uva.sea.ql.visitor.check;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.binaryexpr.*;
import org.uva.sea.ql.ast.primaryexpr.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.unaryexpr.*;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.Messages;

public class TypeCheckExpressionVisitor implements IExpressionVisitor {
	private Map<Ident,Question> identQuestionMap;
	private Messages 	errorMsgs, 
						warningMsgs;
	
	public TypeCheckExpressionVisitor() {
		identQuestionMap = new HashMap<Ident, Question>();
		errorMsgs = new Messages("Errors"); 
		warningMsgs = new Messages("Warnings");
	}
	
	public TypeCheckExpressionVisitor(Map<Ident,Question> map, Messages errMsgs, Messages warnMsgs) {
		identQuestionMap = map;
		errorMsgs = errMsgs;
		warningMsgs = warnMsgs;
	}
	
	private void isBinaryNumeric(Expr exp) {
		if (!exp.isNumeric()) {
			errorMsgs.add(String.format("BinaryExpression is not numeric: %s", exp));
		}
	}
	
	private void isBinaryBoolean(Expr exp) {
		if (!exp.isBoolean()) {
			errorMsgs.add(String.format("BinaryExpression is not boolean: %s", exp));
		}
	}
	
	private void isUnaryNumeric(Expr exp) {
		if (!exp.isNumeric()) {
			errorMsgs.add(String.format("UnaryExpression is not numeric: %s", exp));
		}
	}
	
	private void isUnaryBoolean(Expr exp) {
		if (!exp.isNumeric()) {
			errorMsgs.add(String.format("UnaryExpression is not boolean: %s", exp));
		}
	}
	
	public Messages returnErrorMsgs() {
		return errorMsgs;
	}

	public Messages returnWarningMsgs() {
		return warningMsgs;
	}
	
	//Unary Expressions
	@Override
	public void visit(Ident id) {
		if ( !identQuestionMap.containsKey(id) )
			errorMsgs.add(String.format("Undefined variable: %s", id));
	}
	
	@Override
	public void visit(Int exp) {
		
	}

	@Override
	public void visit(Str exp) {

	}
	
	@Override
	public void visit(Bool exp) {
		
	}
	
	//Binary Expressions
	@Override
	public void visit(Add exp) {
		isBinaryNumeric(exp);
	}
	
	@Override
	public void visit(Div exp) {
		isBinaryNumeric(exp);
	}
	
	@Override
	public void visit(Mul exp) {
		isBinaryNumeric(exp);
	}
	
	@Override
	public void visit(Sub exp) {
		isBinaryNumeric(exp);
	}
	
	@Override
	public void visit(And exp) {
		isBinaryBoolean(exp);
	}
	
	@Override
	public void visit(Eq exp) {
		isBinaryBoolean(exp);
	}
	
	@Override
	public void visit(GEq exp) {
		isBinaryBoolean(exp);
	}
	
	@Override
	public void visit(GT exp) {
		isBinaryBoolean(exp);
	}
	
	@Override
	public void visit(LEq exp) {
		isBinaryBoolean(exp);
	}
	
	@Override
	public void visit(LT exp) {
		isBinaryBoolean(exp);
	}
	
	@Override
	public void visit(NEq exp) {
		isBinaryBoolean(exp);
	}
	
	@Override
	public void visit(Or exp) {
		isBinaryBoolean(exp);
	}
	
	//Unary Expressions
	@Override
	public void visit(Neg exp) {
		isUnaryNumeric(exp);
	}

	@Override
	public void visit(Pos exp) {
		isUnaryNumeric(exp);
	}
	
	@Override
	public void visit(Not exp) {
		isUnaryBoolean(exp);
	}



	
}
