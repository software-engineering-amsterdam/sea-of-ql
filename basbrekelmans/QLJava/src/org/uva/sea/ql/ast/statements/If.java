package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.types.QLType;

public class If extends Statement {

	private final Statement ifTrue;
	private final Statement ifFalse;
	private final Expression expression;
	
	public If(ICodeLocationInformation info, Expression expression, Statement ifTrue, Statement ifFalse) {
		super(info);
		this.expression = expression;
		this.ifTrue = ifTrue;
		this.ifFalse = ifFalse;
	}
	
	public If(ICodeLocationInformation info, Expression expression, Statement ifTrue) {
		super(info);
		this.expression = expression;
		this.ifTrue = ifTrue;
		this.ifFalse = null;
	}

	public Expression getExpression() {
		return expression;
	}
	
	public Statement getIfTrue() {
		return ifTrue;
	}
	
	public Statement getIfFalse() {
		return ifFalse;
	}
	
}
