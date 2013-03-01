package org.uva.sea.ql.ast.visitors;

import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.TypeVisitor;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.literals.QLValue;
import org.uva.sea.ql.gui.listeners.CheckBoxActionListener;
import org.uva.sea.ql.gui.listeners.NumericTextFieldActionListener;
import org.uva.sea.ql.gui.listeners.TextFieldActionListener;

public class TypeRenderingVisitor implements TypeVisitor {

	private JPanel parentPanel;
	private QLValue value;
	private Boolean enabled;

	public TypeRenderingVisitor(JPanel parentPanel, QLValue value,	Boolean enabled) {
		this.parentPanel = parentPanel;
		this.value = value;
		this.enabled = enabled;
	}

	@Override
	public void visit(BooleanType booleanDeclaration) {
		JCheckBox checkBox = new JCheckBox();
		CheckBoxActionListener booleanListener = new CheckBoxActionListener(
				parentPanel);
		checkBox.addActionListener(booleanListener);
		checkBox.setSelected(value.getBooleanValue());
		checkBox.setEnabled(enabled);
		parentPanel.add(checkBox);
	}

	@Override
	public void visit(IntegerType intDeclaration) {
		JFormattedTextField intField = new JFormattedTextField(
				NumberFormat.getIntegerInstance());
		intField.setColumns(8);
		NumericTextFieldActionListener integerListener = new NumericTextFieldActionListener(
				parentPanel, intField);
		intField.addActionListener(integerListener);
		intField.setText(value.toString());
		intField.setEditable(enabled);
		parentPanel.add(intField);
	}

	@Override
	public void visit(StringType stringDeclaration) {
		JTextField strField = new JTextField(20);
		TextFieldActionListener stringListener = new TextFieldActionListener(
				parentPanel, strField);
		strField.addActionListener(stringListener);
		strField.setText(value.toString());
		strField.setEditable(enabled);
		parentPanel.add(strField);
	}

}
