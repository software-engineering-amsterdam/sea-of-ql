package org.uva.sea.ql.ast;

import java.util.ArrayList;

import org.uva.sea.ql.ast.expression.Expression;

public class ExpressionList extends ArrayList<Expression> implements ASTNode{

	private static final long serialVersionUID = -1814752875073648007L;
	
	public ExpressionList(Expression expression){
		this.add(expression);
	}

}
