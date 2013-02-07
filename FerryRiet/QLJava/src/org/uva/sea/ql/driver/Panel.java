package org.uva.sea.ql.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;
import org.uva.sea.ql.ast.operators.ExpressionResult;
import org.uva.sea.ql.ast.types.BooleanType;

public class Panel implements VisitorResult {
	private String panelName;
	private JPanel jPanel;
	private JTextField jTextField;
	private JCheckBox jCheckBox;
	private JLabel jLabel;
	private ExpressionResult fieldResult;
	private Expr fieldInitializer;

	public Panel(LineStatement statement) {
		BooleanType booleanType = new BooleanType();

		panelName = statement.getLineName();

		jPanel = new JPanel();
		jLabel = new JLabel(statement.getDisplayText());

		jPanel.setLayout(new MigLayout("",
				"[200][][][][][][][][][][][][][][][][]", "[]"));

		jPanel.add(jLabel, "cell 0 0,alignx left,aligny top");

		fieldResult = statement.getTypeDescription().getTypeContainer();
		fieldInitializer = statement.getInitalizerExpr();

		if (booleanType.isCompatibleTo(statement.getTypeDescription())) {
			jCheckBox = new JCheckBox("");
			jPanel.add(jCheckBox, "cell 12 0");

		} else {
			jTextField = new JTextField();
			jTextField.setColumns(10);
			if (statement.getInitalizerExpr() != null)
				jTextField.setEditable(false);
			jPanel.add(jTextField, "cell 12 0,growx");
			;
		}
	}

	public void updatecalculatedField(HashMap<String, ExpressionResult> symbols) {
		if (fieldInitializer != null) {
			fieldResult = fieldInitializer.eval(symbols);
			jTextField.setText(fieldResult.toString());
		}
	}

	public boolean actionSource(ActionEvent ev) {
		return jTextField == null ? ev.getSource() == jCheckBox : ev
				.getSource() == jTextField;
	}

	public void registerAt(JPanel parentPanel, int location) {
		StringBuilder stringBuilder = new StringBuilder("cell 0 ");

		stringBuilder.append(location);
		stringBuilder.append(" ,growx");

		parentPanel.add(jPanel, stringBuilder.toString());
	}

	public ExpressionResult getFieldValue() {
		if (jCheckBox != null)
			return fieldResult.setValue(jCheckBox.isSelected() ? "true"
					: "false");
		else
			return fieldResult.setValue(jTextField.getText());
	}

	public void registerActionListener(ActionListener actionHandler) {
		if (jCheckBox != null)
			jCheckBox.addActionListener(actionHandler);
		else {
			jTextField.addActionListener(actionHandler);
		}
	}

	public String getFieldName() {
		return panelName;
	}
}
