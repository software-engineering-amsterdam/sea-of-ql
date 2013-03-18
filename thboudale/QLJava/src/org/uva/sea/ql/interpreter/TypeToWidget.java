package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.interpreter.controls.AControl;
import org.uva.sea.ql.interpreter.controls.BoolControl;
import org.uva.sea.ql.interpreter.controls.IntControl;
import org.uva.sea.ql.interpreter.controls.StrControl;
import org.uva.sea.ql.visitor.ITypeVisitor;

public class TypeToWidget implements ITypeVisitor<AControl> {
	private final boolean isEditable;
	
	public TypeToWidget(boolean isEditable) {
		this.isEditable = isEditable;
	}

	@Override
	public AControl visit(BoolType type) {
		return new BoolControl();
	}

	@Override
	public AControl visit(IntType type) {
		IntControl ctrl = new IntControl();
		ctrl.setEditable(isEditable);
		return ctrl;
	}

	@Override
	public AControl visit(StringType type) {
		StrControl ctrl = new StrControl();
		ctrl.setEditable(isEditable);
		return ctrl;
	}

	@Override
	public AControl visit(ErrorType type) {
		return null;
	}
}