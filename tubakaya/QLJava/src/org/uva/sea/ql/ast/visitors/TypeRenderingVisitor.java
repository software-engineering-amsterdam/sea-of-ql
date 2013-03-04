package org.uva.sea.ql.ast.visitors;

import java.text.NumberFormat;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.TypeVisitor;
import org.uva.sea.ql.ast.literals.QLValue;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.gui.FormPanel;
import org.uva.sea.ql.gui.listeners.CheckBoxActionListener;
import org.uva.sea.ql.gui.listeners.NumericTextFieldActionListener;
import org.uva.sea.ql.gui.listeners.TextFieldActionListener;

public class TypeRenderingVisitor implements TypeVisitor<JComponent> {

	private FormPanel formPanel;
	private Map<Identifier, QLValue> identifierValueMap;
	private Identifier identifier;
	private QLValue value;
	private Boolean enabled;

	public TypeRenderingVisitor(FormPanel formPanel,
			Map<Identifier, QLValue> identifierValueMap, Identifier identifier,
			QLValue value, Boolean enabled) {
		this.formPanel = formPanel;
		this.identifierValueMap = identifierValueMap;
		this.identifier = identifier;
		this.value = value;
		this.enabled = enabled;
	}

	@Override
	public JComponent visit(BooleanType booleanDeclaration) {
		JCheckBox checkBox = new JCheckBox();
		CheckBoxActionListener booleanListener = new CheckBoxActionListener(
				formPanel, identifierValueMap, identifier, checkBox);
		checkBox.addActionListener(booleanListener);
		checkBox.setSelected(value.getBooleanValue());
		checkBox.setEnabled(enabled);
		return checkBox;
	}

	@Override
	public JComponent visit(IntegerType intDeclaration) {
		JFormattedTextField intField = new JFormattedTextField(
				NumberFormat.getIntegerInstance());
		intField.setColumns(8);
		NumericTextFieldActionListener integerListener = new NumericTextFieldActionListener(
				formPanel, identifierValueMap, identifier, intField);
		intField.addActionListener(integerListener);
		intField.setText(value.getIntegerValue().toString());
		intField.setEditable(enabled);
		return intField;
	}

	@Override
	public JComponent visit(StringType stringDeclaration) {
		JTextField strField = new JTextField();
		strField.setColumns(8);
		TextFieldActionListener stringListener = new TextFieldActionListener(
				formPanel, identifierValueMap, identifier, strField);
		strField.addActionListener(stringListener);
		strField.setText(value.getStringValue());
		strField.setEditable(enabled);
		return strField;
	}

}
