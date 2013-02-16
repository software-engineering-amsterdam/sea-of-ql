package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.swing.control.Control;

public abstract class Type {

	public abstract Control accept(TypeVisitor visitor);
	public abstract Value getDefaultValue();

	public abstract boolean isCompatibleTo(Type t);

	public boolean isCompatibleToInt() {
		return false;
	}

	public boolean isCompatibleToNumeric() {
		return false;
	}

	public boolean isCompatibleToStr() {
		return false;
	}

	public boolean isCompatibleToBool() {
		return false;
	}

	public boolean isCompatibleToMoney() {
		return false;
	}
	
	public boolean isCompatibleToDoule(){
		return false;
	}
	
	
}
