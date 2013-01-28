package org.uva.sea.ql.form;

import java.util.List;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;

public class Form {

	private Ident id;
	private List<FormItem> body;
	
	public Form(Ident id, List<FormItem> formItems) {
		this.id = id;
		this.body = formItems;
	}

	public Ident getIdentity() {
		return id;
	}
	
	public String getName() {
		return id.getName();
	}
	
	public List<FormItem> getBody() {
		return body;
	}

	public void print() {
		System.out.println("formItems: " + id.getName());
		for (FormItem f : body) {
			f.print(0);
		}		
	}
	
	public boolean checkFormValidity() {
		boolean valid = true;
		Env environment = new Env();
		for (FormItem f : body) {
			if (!f.validate(environment))
				valid = false;
		}
		return valid;
	}
	
	public JPanel buildForm() {
		JPanel formPanel = new JPanel();
//		formPanel.setLayout(new MigLayout("fillx"));
		for (FormItem f : body) {
			formPanel.add(f.getFormComponent());
		}
		return formPanel;
	}
}
