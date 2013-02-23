package org.uva.sea.ql.core.dom.visitors;

import java.util.ArrayList;
import java.util.List;
import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Identifier;
import org.uva.sea.ql.core.dom.Variable;
import org.uva.sea.ql.core.dom.operators.ArithmeticOperator;
import org.uva.sea.ql.core.dom.operators.ConditionalOperator;
import org.uva.sea.ql.core.dom.operators.RelationalOperator;
import org.uva.sea.ql.core.dom.operators.UnaryOperator;
import org.uva.sea.ql.core.dom.operators.arithmetic.Add;
import org.uva.sea.ql.core.dom.operators.arithmetic.Div;
import org.uva.sea.ql.core.dom.operators.arithmetic.Mul;
import org.uva.sea.ql.core.dom.operators.arithmetic.Sub;
import org.uva.sea.ql.core.dom.operators.conditional.And;
import org.uva.sea.ql.core.dom.operators.conditional.Or;
import org.uva.sea.ql.core.dom.operators.relational.Eq;
import org.uva.sea.ql.core.dom.operators.relational.GEq;
import org.uva.sea.ql.core.dom.operators.relational.GT;
import org.uva.sea.ql.core.dom.operators.relational.LEq;
import org.uva.sea.ql.core.dom.operators.relational.LT;
import org.uva.sea.ql.core.dom.operators.relational.NEq;
import org.uva.sea.ql.core.dom.operators.unary.Neg;
import org.uva.sea.ql.core.dom.operators.unary.Not;
import org.uva.sea.ql.core.dom.operators.unary.Pos;
import org.uva.sea.ql.core.dom.types.primitive.BooleanLiteral;
import org.uva.sea.ql.core.dom.types.primitive.IntLiteral;
import org.uva.sea.ql.core.dom.types.primitive.MoneyLiteral;
import org.uva.sea.ql.core.dom.types.primitive.StringLiteral;
import org.uva.sea.ql.parsers.exceptions.IdentifierNotDefinedException;

public class ExpressionVisitorToCheckIdentifierDefinitions implements ExpressionVisitor {

	private List<Variable> variableList;
	private List<IdentifierNotDefinedException> exceptions;
	
	public ExpressionVisitorToCheckIdentifierDefinitions(List<Variable> variableList){
		this.variableList=variableList;
		this.exceptions=new ArrayList<IdentifierNotDefinedException>();
	}
	
	public List<IdentifierNotDefinedException> getExceptions() {
		return exceptions;
	}
	
	@Override
	public void visit(BooleanLiteral booleanLiteral) {
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
		this.callAcceptOnIdentifiers(add);
	}

	@Override
	public void visit(Div div) {
		this.callAcceptOnIdentifiers(div);
	}
	
	@Override
	public void visit(Sub sub) {
		this.callAcceptOnIdentifiers(sub);
	}

	@Override
	public void visit(Mul mul) {
		this.callAcceptOnIdentifiers(mul);
	}

	@Override
	public void visit(And and) {
		this.callAcceptOnIdentifiers(and);
	}

	@Override
	public void visit(Or or) {
		this.callAcceptOnIdentifiers(or);	
	}

	@Override
	public void visit(Eq eq) {
		this.callAcceptOnIdentifiers(eq);	
	}

	@Override
	public void visit(GEq gEq) {
		this.callAcceptOnIdentifiers(gEq);	
	}

	@Override
	public void visit(GT gT) {
		this.callAcceptOnIdentifiers(gT);	
	}

	@Override
	public void visit(LEq lEq) {
		this.callAcceptOnIdentifiers(lEq);	
	}

	@Override
	public void visit(LT lT) {
		this.callAcceptOnIdentifiers(lT);	
	}

	@Override
	public void visit(NEq nEq) {
		this.callAcceptOnIdentifiers(nEq);	
	}

	@Override
	public void visit(Neg neg) {
		this.callAcceptOnIdentifiers(neg);	
	}

	@Override
	public void visit(Not not) {
		this.callAcceptOnIdentifiers(not);	
	}

	@Override
	public void visit(Pos pos) {
		this.callAcceptOnIdentifiers(pos);	
	}

	private void callAcceptOnIdentifiers(ArithmeticOperator arithmeticOperator){
		arithmeticOperator.getLhs().accept(this);
		arithmeticOperator.getRhs().accept(this);
	}
	
	private void callAcceptOnIdentifiers(ConditionalOperator conditionalOperator){
		conditionalOperator.getLhs().accept(this);
		conditionalOperator.getRhs().accept(this);
	}
	
	private void callAcceptOnIdentifiers(RelationalOperator relationalOperator){
		relationalOperator.getLhs().accept(this);
		relationalOperator.getRhs().accept(this);
	}
	
	private void callAcceptOnIdentifiers(UnaryOperator unaryOperator){
		unaryOperator.getExpression().accept(this);
	}
	
	@Override
	public void visit(Identifier identifier) {
		if(!IdentifierBelongsToAVariable(identifier)){
			exceptions.add(new IdentifierNotDefinedException(identifier));
		}
	}
	
	private boolean IdentifierBelongsToAVariable(Identifier identifier){		
		boolean identifierBelongsToAVariable=false;
		
		for(Variable variable : variableList)	{
			if(variable.identifier.getName() == identifier.getName()){
				identifierBelongsToAVariable=true;
				break;
			}
		}
		return identifierBelongsToAVariable;			
	}
}
