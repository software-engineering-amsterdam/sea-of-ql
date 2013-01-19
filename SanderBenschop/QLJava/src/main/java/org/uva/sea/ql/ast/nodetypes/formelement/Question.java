package org.uva.sea.ql.ast.nodetypes.formelement;

import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.ast.nodetypes.primary.Primary;
import org.uva.sea.ql.ast.nodetypes.primary.Str;
import org.uva.sea.ql.parser.visitor.ASTNodeVisitor;

public class Question extends QLStatement {

    private final Ident identifier;
    private final Str label;
    private final Str datatype;

    public Question(Ident identifier, Str label, Str datatype) {
        
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

	public Primary<?> getDatatype() {
		
		return datatype;
	}

    @Override
    public void accept(ASTNodeVisitor visitor) {
    }
}
