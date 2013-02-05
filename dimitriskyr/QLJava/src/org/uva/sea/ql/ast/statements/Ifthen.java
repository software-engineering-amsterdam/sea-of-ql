package org.uva.sea.ql.ast.statements;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

import java.util.*;

public class IfThen extends Statement {
	private Expr expression;
	private List<Statement> ifBlock;
	
	public IfThen (Expr expression, List<Statement> thenBlock){
		this.expression=expression;
		this.ifBlock = thenBlock;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	public List<Statement> getBlock() {
		return ifBlock;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
