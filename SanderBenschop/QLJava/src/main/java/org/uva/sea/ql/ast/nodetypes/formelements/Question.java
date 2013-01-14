package org.uva.sea.ql.ast.nodetypes.formelements;

import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.ast.nodetypes.primary.Str;
import org.uva.sea.ql.ast.nodetypes.primary.ValuedPrimaryExpression;

public class Question extends QLStatement {

    private final Ident identifier;
    private final Str label;
    private final ValuedPrimaryExpression<?> datatype;

    public Question(Ident identifier, Str label, ValuedPrimaryExpression<?> datatype) {
        
    	this.identifier = identifier;
        this.label = label;
        this.datatype = datatype;
    }

	public Ident getIdentifier() {
		
		return identifier;
	}

	public Str getLabel() {
		
		return label;
	}

	public ValuedPrimaryExpression<?> getDatatype() {
		
		return datatype;
	}
}
