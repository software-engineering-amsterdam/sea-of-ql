package org.uva.sea.ql.gui;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.IVisitorType;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.ast.types.Undefined;
import org.uva.sea.ql.gui.widget.Widget;
import org.uva.sea.ql.gui.widget.WidgetBool;
import org.uva.sea.ql.gui.widget.WidgetInt;
import org.uva.sea.ql.gui.widget.WidgetStr;

public class VisitorTypeToWidget implements IVisitorType<Widget> {

	@Override
	public Widget visit(Bool b) {
		return new WidgetBool();
	}

	@Override
	public Widget visit(Int n) {
		return new WidgetInt();
	}

	@Override
	public Widget visit(Str s) {
		return new WidgetStr();
	}

	@Override
	public Widget visit(Undefined u) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Widget visit(Numeric n) {
		throw new UnsupportedOperationException();
	}

}
