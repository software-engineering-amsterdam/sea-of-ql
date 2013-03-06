package org.uva.sea.ql.gui;

import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.IVisitorType;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.StrType;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.gui.widget.Widget;
import org.uva.sea.ql.gui.widget.WidgetBool;
import org.uva.sea.ql.gui.widget.WidgetInt;
import org.uva.sea.ql.gui.widget.WidgetStr;

public class VisitorTypeToWidget implements IVisitorType<Widget> {

	@Override
	public Widget visit(BoolType b) {
		return new WidgetBool();
	}

	@Override
	public Widget visit(IntType n) {
		return new WidgetInt();
	}

	@Override
	public Widget visit(StrType s) {
		return new WidgetStr();
	}

	@Override
	public Widget visit(UndefinedType u) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Widget visit(NumericType n) {
		throw new UnsupportedOperationException();
	}

}
