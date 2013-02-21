package org.uva.sea.ql.parser.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.uva.sea.ql.ast.ASTNode;
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
import org.uva.sea.ql.visitor.ASTVisitor;

public class TestVisitor implements ASTVisitor {

	private final List<Class<? extends ASTNode>> visitedASTClassesList;

	public TestVisitor() {
		this.visitedASTClassesList = new ArrayList<>();
	}

	private void internalVisit(ASTNode node) {
		// build a list of the traversed/visited AST classess
		visitedASTClassesList.add(node.getClass());
	}

	public void assertAST(@SuppressWarnings("unchecked") Class<? extends ASTNode>... expectedASTClasses) {
		Assert.assertArrayEquals(
				"Observed AST does not match with the expected hierarchy",
				expectedASTClasses,
				visitedASTClassesList.toArray(new Class[visitedASTClassesList.size()]));
	}

	@Override
	public void visit(Form form) {
		this.internalVisit(form);
		form.getCompoundStatement().accept(this);
	}

	@Override
	public void visit(CompoundStatement statement) {
		this.internalVisit(statement);
		Iterator<Statement> statementIterator = statement.getStatementIterator();

		while (statementIterator.hasNext()) {
			statementIterator.next().accept(this);
		}
	}

	@Override
	public void visit(Question question) {
		this.internalVisit(question);
	}

	@Override
	public void visit(IfStatement statement) {
		this.internalVisit(statement);
		statement.getExpression().accept(this);
		statement.getStatement().accept(this);
	}

	@Override
	public void visit(Identifier ident) {
		this.internalVisit(ident);
	}

	@Override
	public void visit(Literal literal) {
		this.internalVisit(literal);
	}

	@Override
	public void visit(IfElseStatement statement) {
		this.visit((IfStatement)statement);
		statement.getElseStatement().accept(this);
	}
	
	private void visitBinary(BinaryExpr expression){
		this.internalVisit(expression);
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
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
	
	private void visitUnary(UnaryExpr expression){
		this.internalVisit(expression);
		expression.getExpr().accept(this);
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
