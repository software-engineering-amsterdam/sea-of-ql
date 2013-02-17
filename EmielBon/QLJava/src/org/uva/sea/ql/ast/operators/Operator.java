package org.uva.sea.ql.ast.operators;

import java.util.List;
import org.uva.sea.ql.ast.*;

public abstract class Operator extends Expression {
	
	protected List<Expression> operands;
	
	protected Operator(List<Expression> operands) {
		this.operands = operands;
	}
	
	public List<Expression> getOperands() {
		return operands;
	}
	
}
