package org.uva.sea.ql.visitor;

import java.util.Iterator;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.ASTVisitor;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfElseStatement;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.binary.Add;
import org.uva.sea.ql.ast.expression.binary.And;
import org.uva.sea.ql.ast.expression.binary.BinaryExpr;
import org.uva.sea.ql.ast.expression.binary.Div;
import org.uva.sea.ql.ast.expression.binary.Eq;
import org.uva.sea.ql.ast.expression.binary.GEq;
import org.uva.sea.ql.ast.expression.binary.GT;
import org.uva.sea.ql.ast.expression.binary.LEq;
import org.uva.sea.ql.ast.expression.binary.LT;
import org.uva.sea.ql.ast.expression.binary.Mul;
import org.uva.sea.ql.ast.expression.binary.NEq;
import org.uva.sea.ql.ast.expression.binary.Or;
import org.uva.sea.ql.ast.expression.binary.Sub;
import org.uva.sea.ql.ast.expression.literal.Literal;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;
import org.uva.sea.ql.ast.expression.unary.UnaryExpr;

/**
 * Implements the visiting behavior for all the {@link ASTNode}s.
 * @author jpeeters
 *
 */
public abstract class BaseVisitor implements ASTVisitor {

	@Override
	public void visit(Form form) {
		form.getCompoundStatement().accept(this);
	}

	@Override
	public void visit(CompoundStatement statement) {
		final Iterator<Statement> statementIterator = statement.getStatementIterator();
		while(statementIterator.hasNext()){
			statementIterator.next().accept(this);
		}
	}

	@Override
	public void visit(final Question question) {
	}

	@Override
	public void visit(IfStatement statement) {
		statement.getExpression().accept(this);
		statement.getStatement().accept(this);
	}

	@Override
	public void visit(IfElseStatement statement) {
		statement.getExpression().accept(this);
		statement.getStatement().accept(this);
		statement.getExpression().accept(this);
	}

	@Override
	public void visit(Identifier identifier) {
	}

	@Override
	public void visit(Literal literal) {
	}
	
	protected void visitBinary(BinaryExpr expression){
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
	}
	
	protected void visitUnary(UnaryExpr expression){
		expression.getExpr().accept(this);
	}

	@Override
	public void visit(Add expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(Div expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(Mul expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(Sub expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(And expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(Eq expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(GEq expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(LEq expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(GT expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(LT expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(NEq expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(Or expression) {
		this.visitBinary(expression);
	}

	@Override
	public void visit(Neg expression) {
		this.visitUnary(expression);
	}

	@Override
	public void visit(Pos expression) {
		this.visitUnary(expression);
		
	}

	@Override
	public void visit(Not expression) {
		this.visitUnary(expression);
	}

}