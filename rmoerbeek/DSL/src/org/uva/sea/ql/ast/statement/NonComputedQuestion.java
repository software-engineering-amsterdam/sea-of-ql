package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.visitors.StatementVisitor;

public class NonComputedQuestion extends Question {
	
	//private final Ident id; // identifier of the question
	//private final String label; // actual question shown on screen
	//private final Type type;

	public NonComputedQuestion(Ident id, String l, Type t) {
		super(id, l, t);
		//this.identifier = id;
		//this.label = l;
		//this.type = t;
	}
	
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	//public String getId() {
	//	return identifier;
	//}
	
	//public String getLabel() {
	//	return label;
	//}

	//public Type getType() {
	//	return type;
	//}
	
}
