package org.uva.sea.ql.runtime.swing;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.runtime.Binding;
import org.uva.sea.ql.runtime.StringValue;
import org.uva.sea.ql.runtime.Value;
import org.uva.sea.ql.runtime.Variable;

public class StringBinding extends Binding<JTextField> {

	public StringBinding(Variable var, JTextField guiComp) {
		
		super(var, guiComp);
		guiComp.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent de) {
				StringBinding.this.onDocumentChanged(de);
			}
			@Override
			public void insertUpdate(DocumentEvent de) {
				StringBinding.this.onDocumentChanged(de);
			}
			@Override
			public void changedUpdate(DocumentEvent de) {
				StringBinding.this.onDocumentChanged(de);
			}
		});
		
	}
	
	private void onDocumentChanged(DocumentEvent de) {
		
		String text = this.getGuiComponent().getText();
		StringValue value = new StringValue(text);
		this.onGuiChanged(value);
	}
	
	@Override
	protected void setGuiValue(Value value) {
		this.getGuiComponent().setText(value.getValue().toString());
	}

}
