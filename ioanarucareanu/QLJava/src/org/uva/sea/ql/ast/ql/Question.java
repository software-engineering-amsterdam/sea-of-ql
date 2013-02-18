package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.StatementVisitor;


public class Question extends Statement {
	
	private Ident id;
	private String label;
	private Type type;
	
	public Question(Ident id, String label, Type type) {
		super();
		this.id = id;
		this.label = label;
		this.type = type;
	}

	public Ident getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}
	
	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean isDependent() {
		
		return false;
	}

}
