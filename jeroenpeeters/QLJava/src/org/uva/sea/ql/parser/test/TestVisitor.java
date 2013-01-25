package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.BinaryExpr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Literal;
import org.uva.sea.ql.ast.expression.UnaryExpr;
import org.uva.sea.ql.parser.ASTVisitor;

public class TestVisitor implements ASTVisitor{

	private final Class<? extends ASTNode>[] expectedASTClasses;
	
	private int i = 0;
	
	public TestVisitor(Class<? extends ASTNode>... expectedASTClasses){
		this.expectedASTClasses = expectedASTClasses;
	}

	private void internalVisit(ASTNode node) {
		final String nodeName = node.getClass().getName();
		if(expectedASTClasses.length >= i+1){
			assertEquals(expectedASTClasses[i].getName(), nodeName);
			i++;
		}else{
			fail("No AST elements expected. Found: " + nodeName);
		}
	}
	
	public void finish(){
		if(i != expectedASTClasses.length){
			fail("More AST elements expected, but none found. Next expected element: " + expectedASTClasses[i].getName());
		}
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
		
		while(statementIterator.hasNext()){
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
		statement.getCompoundStatement().accept(this);
	}

	@Override
	public void visit(BinaryExpr expression) {
		this.internalVisit(expression);
	}

	@Override
	public void visit(UnaryExpr expression) {
		this.internalVisit(expression);
	}

	@Override
	public void visit(Ident ident) {
		this.internalVisit(ident);
	}

	@Override
	public void visit(Literal literal) {
		this.internalVisit(literal);
	}

}
