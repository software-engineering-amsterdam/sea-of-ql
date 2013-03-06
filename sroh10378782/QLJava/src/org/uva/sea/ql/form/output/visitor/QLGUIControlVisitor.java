package org.uva.sea.ql.form.output.visitor;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.form.gui.components.GUIControl;
import org.uva.sea.ql.types.TBool;
import org.uva.sea.ql.types.TInt;
import org.uva.sea.ql.types.TMoney; 
import org.uva.sea.ql.types.TNumeric;
import org.uva.sea.ql.types.TStr;
import org.uva.sea.ql.types.Type;
import org.uva.sea.ql.types.visitor.Visitor;

public class QLGUIControlVisitor implements Visitor {
	private final GUIControl control;
	
	private QLGUIControlVisitor(Type type){
		control = new GUIControl();
	}
	
	public static GUIControl getControl(Type type, boolean readonly){
		QLGUIControlVisitor controlRenderer = new QLGUIControlVisitor(type);
		type.accept(controlRenderer);
		return controlRenderer.getControl(readonly);
	}
	
	private GUIControl getControl(boolean readonly){
		control.setReadOnly(readonly);
		return control;
	}
	
	@Override
	public void visit(TBool bool) {
		JCheckBox checkBox = new JCheckBox();
		this.control.addCheckBox(checkBox);
	}

	@Override
	public void visit(TInt integer) {
		JTextField textField = new JTextField();
		this.control.addNumericTextkBox(textField);
	}

	@Override
	public void visit(TStr string) {
		JTextField textField = new JTextField();
		this.control.addTextkBox(textField);
	}

	@Override
	public void visit(TMoney money) {
		JTextField textField = new JTextField();
		this.control.addNumericTextkBox(textField);
	}

	@Override
	public void visit(TNumeric numeric) {
		JTextField textField = new JTextField();
		this.control.addNumericTextkBox(textField);
	}
}
