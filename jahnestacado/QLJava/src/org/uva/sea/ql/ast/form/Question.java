package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Question extends BodyElements  {
	private final String id;
	private final String label;
	private final Type type;

	public Question(String id, String label, Type type) {
			this.id=id;
			this.label=label;
			this.type=type;
		
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}
	
	

}
