package org.uva.sea.ql.parser.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.ObjectUtils.Null;
import org.junit.Assert;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntLiteral;
import org.uva.sea.ql.ast.expression.literal.TextLiteral;
import org.uva.sea.ql.ast.statement.CompoundStatement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Label;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.StatementVisitor;

/**
 * Visitor used in Unit tests. This visiter traverses the QL AST and creates a flat view of the AST in an array.
 * @author jpeeters
 *
 */
public class TestVisitor implements ExpressionVisitor<Void>, StatementVisitor<Void> {

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
	public Void visit(Form form) {
		this.internalVisit(form);
		return form.getCompoundStatement().accept(this);
	}

	@Override
	public Void visit(CompoundStatement statement) {
		this.internalVisit(statement);
		Iterator<Statement> statementIterator = statement.getStatementIterator();

		while (statementIterator.hasNext()) {
			statementIterator.next().accept(this);
		}
		
		return null;
	}

	@Override
	public Void visit(Question question) {
		this.internalVisit(question);
		return null;
	}
	
	

	@Override
	public Void visit(Label label) {
		this.internalVisit(label);
		return null;
	}

	@Override
	public Void visit(IfStatement statement) {
		this.internalVisit(statement);
		statement.getExpression().accept(this);
		statement.getStatement().accept(this);
		
		return null;
	}

	@Override
	public Void visit(Identifier ident) {
		this.internalVisit(ident);
		return null;
	}
	
	@Override
	public Void visit(BooleanLiteral literal) {
		this.internalVisit(literal);
		return null;
	}

	@Override
	public Void visit(IntLiteral literal) {
		this.internalVisit(literal);
		return null;
	}

	@Override
	public Void visit(TextLiteral literal) {
		this.internalVisit(literal);
		return null;
	}

	@Override
	public Void visit(IfElseStatement statement) {
		this.visit((IfStatement)statement);
		statement.getElseStatement().accept(this);
		return null;
	}
	
	private void visitBinary(BinaryExpression expression){
		this.internalVisit(expression);
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
	}

	@Override
	public Void visit(Add expression) {
		this.visitBinary(expression);
		return null;
	}

	@Override
	public Void visit(Div expression) {
		this.visitBinary(expression);
		return null;
	}

	@Override
	public Void visit(Mul expression) {
		this.visitBinary(expression);
		return null;
	}

	@Override
	public Void visit(Sub expression) {
		this.visitBinary(expression);
		return null;
	}

	@Override
	public Void visit(And expression) {
		this.visitBinary(expression);
		return null;
	}

	@Override
	public Void visit(Eq expression) {
		this.visitBinary(expression);
		return null;
	}

	@Override
	public Void visit(GEq expression) {
		this.visitBinary(expression);
		return null;
	}

	@Override
	public Void visit(LEq expression) {
		this.visitBinary(expression);
		return null;
	}

	@Override
	public Void visit(GT expression) {
		this.visitBinary(expression);
		return null;
	}

	
	@Override
	public Void visit(LT expression) {
		this.visitBinary(expression);
		return null;
	}

	@Override
	public Void visit(NEq expression) {
		this.visitBinary(expression);
		return null;
	}

	@Override
	public Void visit(Or expression) {
		this.visitBinary(expression);
		return null;
	}
	
	private void visitUnary(UnaryExpression expression){
		this.internalVisit(expression);
		expression.getExpr().accept(this);
	}

	@Override
	public Void visit(Neg expression) {
		this.visitUnary(expression);
		return null;
	}

	@Override
	public Void visit(Pos expression) {
		this.visitUnary(expression);
		return null;
	}

	@Override
	public Void visit(Not expression) {
		this.visitUnary(expression);
		return null;
	}

}
