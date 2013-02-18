package org.uva.sea.ql.ui;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.statements.LineStatement;
import org.uva.sea.ql.ast.types.BooleanType;

public class LinePane extends Pane implements FocusListener {
	private Expr fieldInitializer;
	private Result fieldResult;
	private JCheckBox jCheckBox;
	private JLabel jLabel;
	private JPanel jPanel;
	private JTextField jTextField;
	private String panelName;

	public LinePane(LineStatement statement) {
		BooleanType booleanType = new BooleanType();

		panelName = statement.getLineName();

		jPanel = new JPanel();
		jPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		jPanel.setLayout(new MigLayout("", "10[350]0[][][][][][][][][][][][][][][][]", "10[]0"));

		jLabel = new JLabel(statement.getDisplayText());

		jPanel.add(jLabel, "cell 0 0,alignx left,aligny top");

		fieldResult = statement.getTypeDescription().getTypeContainer();
		fieldInitializer = statement.getInitalizerExpr();

		if (booleanType.isCompatibleTo(statement.getTypeDescription())) {
			jCheckBox = new JCheckBox("");
			jCheckBox.addActionListener(this);
			jPanel.add(jCheckBox, "cell 12 0,alignx left,aligny top");

		} else {
			jTextField = new JTextField();
			jTextField.addActionListener(this);
			jTextField.setColumns(10);
			jTextField.addFocusListener(this);

			if (statement.getInitalizerExpr() != null) {
				jTextField.setEditable(false);
			}
			jPanel.add(jTextField, "cell 12 0,alignx left,aligny top");

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setChanged();
		notifyObservers(this);
	}

	public String getFieldName() {
		return panelName;
	}

	public Result getFieldValue() {
		if (jCheckBox != null)
			return fieldResult.setValue(jCheckBox.isSelected() ? "true" : "false");

		return fieldResult.setValue(jTextField.getText());
	}

	public void registerAt(JPanel parentPanel, int location) {
		String result = String.format("cell 0 %d ,growx", location);
		parentPanel.add(jPanel, result);
	}

	public void updatecalculatedField(Map<String, Result> symbols) {
		if (fieldInitializer != null) {
			fieldResult = fieldInitializer.eval(symbols);
			if (!jTextField.getText().equals(fieldResult.toString())) {
				jTextField.setText(fieldResult.toString());
				setChanged();
				notifyObservers(this);
			}
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		setChanged();
		notifyObservers(this);
	}
}
