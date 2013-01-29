package org.uva.sea.ql.ast.types;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Container;

import net.miginfocom.swing.MigLayout;

public class BoolType extends Type {

	@Override
	public String toString() {
		return "Boolean";
	}
	
	@Override
	public Component getAnswerField(boolean enabled) {
		Container c = new Container();
		c.setLayout(new MigLayout("ins 1"));
		CheckboxGroup group = new CheckboxGroup();
		Checkbox yes = new Checkbox("Yes", group, false);
		Checkbox no = new Checkbox("No", group, false);
		yes.setEnabled(enabled);
		no.setEnabled(enabled);
		c.add(yes);
		c.add(no);
		return c;
	}
}
