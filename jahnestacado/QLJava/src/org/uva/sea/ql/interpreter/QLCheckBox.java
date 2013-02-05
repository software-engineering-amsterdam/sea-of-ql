package org.uva.sea.ql.interpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.Value;


@SuppressWarnings("rawtypes")
public class QLCheckBox extends JCheckBox implements ActionListener {

	private final String varName;
	private final Map<String, Value> declaredVar;
	private final boolean state;


	public QLCheckBox(String varName, Map<String, Value> declaredVar) {
		super("Yes");
		this.varName = varName;
		this.declaredVar = declaredVar;
		state =  ((BoolLit) declaredVar.get(varName)).getValue();

	}

	public static JCheckBox responsiveCheckBox(String varName,Map<String, Value> declaredVar) {
		QLCheckBox chBox = new QLCheckBox(varName, declaredVar);
		return chBox.getCheckBox();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VariableEnvironment.refreshForm(varName, declaredVar, new BoolLit(!state));
	}

	private JCheckBox getCheckBox() {
		this.addActionListener(this);
		this.setSelected(state);
		return this;
	}

}
