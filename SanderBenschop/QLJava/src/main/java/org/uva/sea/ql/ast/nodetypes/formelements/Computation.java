package org.uva.sea.ql.ast.nodetypes.formelements;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.ast.nodetypes.primary.Str;

public class Computation extends QLStatement {
    
	private final Ident identifier;
    private final Str label;
	private final QLExpression expression;
    
	public Computation(Ident identifier, Str label, QLExpression expression) {
		
		this.identifier = identifier;
		this.label = label;
		this.expression = expression;
	}

	public Ident getIdentifier() {
		
		return identifier;
	}

	public Str getLabel() {
		
		return label;
	}

	public QLExpression getExpression() {
		
		return expression;
	}
}
