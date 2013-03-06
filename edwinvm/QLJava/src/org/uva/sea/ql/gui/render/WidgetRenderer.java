package org.uva.sea.ql.gui.render;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Error;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typevisitor.Visitor;
import org.uva.sea.ql.gui.render.widgets.CheckBoxWidget;
import org.uva.sea.ql.gui.render.widgets.MoneyInputWidget;
import org.uva.sea.ql.gui.render.widgets.NumericInputWidget;
import org.uva.sea.ql.gui.render.widgets.TextInputWidget;
import org.uva.sea.ql.gui.render.widgets.Widget;

public class WidgetRenderer implements Visitor<Widget> {
	
	private WidgetRenderer() { }
	
	public static Widget render(Type expressionType) {
		WidgetRenderer typeToWidgetRenderer = new WidgetRenderer();
		return expressionType.accept(typeToWidgetRenderer);
	}

	@Override
	public Widget visit(Bool type)    { return new CheckBoxWidget();     }
	@Override
	public Widget visit(Str type)     { return new TextInputWidget();    }
	@Override
	public Widget visit(Int type)     { return new NumericInputWidget(); }
	@Override
	public Widget visit(Money type)   { return new MoneyInputWidget(); }
	@Override
	public Widget visit(Numeric type) { 
		if (type.getClass() == Money.class) { 
			return new MoneyInputWidget(); 
		}
		return new NumericInputWidget();
	}

	@Override
	public Widget visit(Error type)   { 
		Widget disabledCheckBoxWidget = new CheckBoxWidget();
		disabledCheckBoxWidget.setEnabled(false);
		disabledCheckBoxWidget.setValue(new org.uva.sea.ql.ast.values.Bool(true));
		return disabledCheckBoxWidget;
	}
}