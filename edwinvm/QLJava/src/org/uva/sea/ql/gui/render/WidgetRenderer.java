package org.uva.sea.ql.gui.render;

import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Error;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typevisitor.Visitor;

public class WidgetRenderer implements Visitor<Widget> {
	
	private WidgetRenderer() { }
	
	public static Widget render(Type expressionType) {
		WidgetRenderer typeToWidgetRenderer = new WidgetRenderer();
		return expressionType.accept(typeToWidgetRenderer);
	}

	@Override
	public Widget visit(Bool type)    { return renderCheckBoxWidget();          }
	
	@Override
	public Widget visit(Int type)     { return renderNumericInputFieldWidget(); }
	
	@Override
	public Widget visit(Money type)   { return renderNumericInputFieldWidget(); }

	@Override
	public Widget visit(Numeric type) { return renderNumericInputFieldWidget(); }

	@Override
	public Widget visit(Str type)     { return renderInputFieldWidget();        }

	@Override
	public Widget visit(Error type)   { return renderDisabledCheckBoxWidget();  }
	
	private Widget renderInputFieldWidget() {
		JTextField inputFieldWidget = new JTextField(15);
		return new Widget(inputFieldWidget);
	}
	
	private Widget renderNumericInputFieldWidget() {
		JTextField inputFieldWidget = new JFormattedTextField(NumberFormat.getInstance());
		inputFieldWidget.setColumns(10);
		inputFieldWidget.setHorizontalAlignment(JTextField.RIGHT);
		return new Widget(inputFieldWidget);
	}
	
	private Widget renderCheckBoxWidget() {
		return new Widget(new JCheckBox());
	}
	
	private Widget renderDisabledCheckBoxWidget() {
		JCheckBox disabledCheckBoxWidget = new JCheckBox();
		disabledCheckBoxWidget.setEnabled(false);
		return new Widget(disabledCheckBoxWidget);
	}
	
}