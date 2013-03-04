package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.types.TypeBool;
import org.uva.sea.ql.ast.types.TypeError;
import org.uva.sea.ql.ast.types.TypeInt;
import org.uva.sea.ql.ast.types.TypeString;
import org.uva.sea.ql.ast.visitor.VisitorTypes;

public class TypeToWidgetVisitor implements VisitorTypes<Control> {

	@Override
	public Control visit(TypeBool typeBool) {
		return new CheckBox();
	}

	@Override
	public Control visit(TypeError typeError) {
		return null;
	}

	@Override
	public Control visit(TypeInt typeInt) {
		return new IntField();
	}

	@Override
	public Control visit(TypeString typeString) {
		return new TextField();
	}

}
