package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.parser.ASTVisitor;

public class IfElseStatement extends IfStatement {

	private final CompoundStatement elseCompoundStatement;
	
	public IfElseStatement(Expression expr, CompoundStatement compoundStatement, CompoundStatement elseCompoundStatement) {
		super(expr, compoundStatement);
		this.elseCompoundStatement = elseCompoundStatement;
	}

	public CompoundStatement getElseCompoundStatement() {
		return elseCompoundStatement;
	}
	
	public void accept(ASTVisitor v){
		v.visit(this);
	}
	
}