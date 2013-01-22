package org.uva.sea.ql.ast.formelement;

import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.primary.Datatype;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Question implements QLStatement {

    private final Ident identifier;
    private final Str label;
    private final Class<? extends Datatype<?>> datatype;

    public Question(Ident identifier, Str label, Class<? extends Datatype<?>> datatype) {
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

	public Class<? extends Datatype<?>> getDatatype() {
		return datatype;
	}

    @Override
    public void accept(ASTNodeVisitor visitor) {
        identifier.accept(visitor);
        visitor.visitQuestion(this);
    }
}
