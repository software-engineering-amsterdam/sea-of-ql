package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.StringValue;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.semanticchecker.QLItemSemanticVisitor;


public class Question implements QLItem {
	
	private final Ident id;
	private final StringValue label;
	private final Type type;
	private final Value<?> answer;  
	
	public Question(Ident id, StringValue label, Type type) {
		super();
		this.id = id;
		this.label = label;
		this.type = type;
		this.answer = type.createValueOfType();
	}

	public Ident getId() {
		return id;
	}

	public StringValue getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

	public Value<?> getAnswer() {
		return answer;
	}

	@Override
	public void accept(QLItem visitableElement, QLItemSemanticVisitor visitor) {
		
		visitor.visit((Question) visitableElement);
	}

}
