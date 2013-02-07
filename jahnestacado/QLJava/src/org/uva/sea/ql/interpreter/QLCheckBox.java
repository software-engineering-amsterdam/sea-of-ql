package org.uva.sea.ql.interpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.Value;


public class QLCheckBox  implements ActionListener {

	private final String varName;
	private final Map<String, Value> declaredVar;
	private final JCheckBox chBox;



	public QLCheckBox(String varName, Map<String, Value> declaredVar) {
		chBox=new JCheckBox("Yes");
		this.varName = varName;
		this.declaredVar = declaredVar;

	}

	public static JCheckBox responsiveCheckBox(String varName,Map<String, Value> declaredVar) {
		QLCheckBox chBox = new QLCheckBox(varName, declaredVar);
		return chBox.getCheckBox();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VariableUpdater varUpdater=new VariableUpdater(varName, declaredVar, new BoolLit(!getState()));
		List<JPanel> questionList=new ArrayList<JPanel>();
		
		JFrame frame = (JFrame) SwingUtilities.getRoot(chBox);
		new SwingVisitor(questionList,varUpdater.getUpdatedValues()).regenerate(frame);

	}

	private JCheckBox getCheckBox() {
		chBox.addActionListener(this);
		chBox.setSelected(getState());
		return chBox;
	}
	
	private boolean getState(){
		return ((BoolLit) declaredVar.get(varName)).getValue();
	}

}
