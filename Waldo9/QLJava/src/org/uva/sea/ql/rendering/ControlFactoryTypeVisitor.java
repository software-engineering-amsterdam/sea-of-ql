package org.uva.sea.ql.rendering;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.TypeVisitor;
import org.uva.sea.ql.rendering.controls.CheckBox;
import org.uva.sea.ql.rendering.controls.Control;
import org.uva.sea.ql.rendering.controls.IntegerField;
import org.uva.sea.ql.rendering.controls.TextField;

public class ControlFactoryTypeVisitor implements TypeVisitor<Control> {

	@Override
	public Control visit(IntType intType) {		
		return new IntegerField();
	}

	@Override
	public Control visit(StringType stringType) {		
		return new TextField();
	}

	@Override
	public Control visit(BoolType boolType) {		
		return new CheckBox();
	}
	
	@Override
	public Control visit(ErrorType errorType) {
		return null;
	}

}
