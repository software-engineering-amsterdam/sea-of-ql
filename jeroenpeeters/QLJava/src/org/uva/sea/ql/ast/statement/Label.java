package org.uva.sea.ql.ast.statement;

import java.util.Iterator;

import org.uva.sea.ql.ast.ExpressionList;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.literal.TextLiteral;

public class Label extends Statement {

	private final TextLiteral label;
	private final ExpressionList expressionList;
	
	public Label(final TextLiteral label, final ExpressionList expressionList){
		this.label = label;
		this.expressionList = expressionList;
	}

	public Iterator<Expression> getExpressions() {
		return expressionList.iterator();
	}

	public TextLiteral getLabel() {
		return label;
	}

	public <T> T accept(final StatementVisitor<T> v){
		return v.visit(this);
	}

}
