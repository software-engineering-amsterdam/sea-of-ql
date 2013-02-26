package org.uva.sea.ql.ast.visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.operators.*;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.conditional.*;
import org.uva.sea.ql.ast.operators.relational.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.types.declarations.TypeDeclaration;
import org.uva.sea.ql.ast.types.primitive.*;
import org.uva.sea.ql.parsers.exceptions.ExpressionTypeNotCompatibleException;

public class ExpressionVisitorToCheckTypeCompatibility implements ExpressionVisitor{

	private List<ExpressionTypeNotCompatibleException> exceptions;
	
	public ExpressionVisitorToCheckTypeCompatibility(){
		this.exceptions= new ArrayList<ExpressionTypeNotCompatibleException>();
	}
	
	public List<ExpressionTypeNotCompatibleException> getExceptions() {
		return exceptions;
	}
	
	@Override
	public void visit(BooleanLiteral booleanLiteral) {
	}

	@Override
	public void visit(Identifier identifier) {
	}

	@Override
	public void visit(IntLiteral integerLiteral) {
	}

	@Override
	public void visit(MoneyLiteral moneyLiteral) {
	}

	@Override
	public void visit(StringLiteral stringLiteral) {
	}

	@Override
	public void visit(Add add) {
		callAcceptOnExpressions(add);
	}

	@Override
	public void visit(Div div) {
		callAcceptOnExpressions(div);
	}

	@Override
	public void visit(Sub sub) {
		callAcceptOnExpressions(sub);
	}

	@Override
	public void visit(Mul mul) {
		callAcceptOnExpressions(mul);
	}

	@Override
	public void visit(And and) {
		callAcceptOnExpressions(and);
	}

	@Override
	public void visit(Or or) {
		callAcceptOnExpressions(or);
	}

	@Override
	public void visit(Eq eq) {
		callAcceptOnExpressions(eq);
	}

	@Override
	public void visit(GEq gEq) {
		callAcceptOnExpressions(gEq);
	}

	@Override
	public void visit(GT gT) {
		callAcceptOnExpressions(gT);
	}

	@Override
	public void visit(LEq lEq) {
		callAcceptOnExpressions(lEq);
	}

	@Override
	public void visit(LT lT) {
		callAcceptOnExpressions(lT);
	}

	@Override
	public void visit(NEq nEq) {
		callAcceptOnExpressions(nEq);
	}

	@Override
	public void visit(Neg neg) {
		neg.getExpression().accept(this);
		
		TypeDeclaration typeLhs = neg.getExpression().getType();
		
		if(!typeLhs.isCompatibleToInteger()){
			addExceptionToList(neg.getExpression());
		}
	}

	@Override
	public void visit(Not not) {
		not.getExpression().accept(this);
		
		TypeDeclaration typeLhs = not.getExpression().getType();
		
		if(!typeLhs.isCompatibleToBoolean()){
			addExceptionToList(not.getExpression());
		}
	}

	@Override
	public void visit(Pos pos) {
		pos.getExpression().accept(this);
		
		TypeDeclaration typeLhs = pos.getExpression().getType();
		
		if(!typeLhs.isCompatibleToInteger()){
			addExceptionToList(pos.getExpression());
		}
	}

	private void callAcceptOnExpressions(ArithmeticOperator arithmeticOperator){
		arithmeticOperator.getLhs().accept(this);
		arithmeticOperator.getRhs().accept(this);
		
		TypeDeclaration typeLhs = arithmeticOperator.getLhs().getType();
		
		if(!typeLhs.isCompatibleToInteger()){
			addExceptionToList(arithmeticOperator.getLhs());
		}
		
		TypeDeclaration typeRhs = arithmeticOperator.getRhs().getType();
		
		if(!typeRhs.isCompatibleToInteger()){
			addExceptionToList(arithmeticOperator.getRhs());
		}
	}
	
	private void callAcceptOnExpressions(ConditionalOperator conditionalOperator){
		conditionalOperator.getLhs().accept(this);
		conditionalOperator.getRhs().accept(this);
		
		TypeDeclaration typeLhs = conditionalOperator.getLhs().getType();
		
		if(!typeLhs.isCompatibleToBoolean()){
			addExceptionToList(conditionalOperator.getLhs());
		}
		
		TypeDeclaration typeRhs = conditionalOperator.getRhs().getType();
		
		if(!typeRhs.isCompatibleToBoolean()){
			addExceptionToList(conditionalOperator.getRhs());
		}
	}
	
	private void callAcceptOnExpressions(RelationalOperator relationalOperator){
		relationalOperator.getLhs().accept(this);
		relationalOperator.getRhs().accept(this);
		
		TypeDeclaration typeLhs = relationalOperator.getLhs().getType();
		TypeDeclaration typeRhs = relationalOperator.getRhs().getType();	
		
		if(!(typeLhs.isCompatibleToInteger() && typeRhs.isCompatibleToInteger())){
			if(!(typeLhs.isCompatibleToBoolean() && typeRhs.isCompatibleToBoolean())){
				addExceptionToList(relationalOperator.getLhs());
				addExceptionToList(relationalOperator.getRhs());
			}
		}
	}

	private void addExceptionToList(Expression expression){
		exceptions.add(new ExpressionTypeNotCompatibleException(expression));
	}
}
