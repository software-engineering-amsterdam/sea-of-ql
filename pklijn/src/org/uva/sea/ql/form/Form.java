package org.uva.sea.ql.form;

import java.awt.Component;
import java.util.List;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.interpreter.FormElement;

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
		MigLayout ml = new MigLayout("ins 20, debug", "[para]0[][100lp, fill][60lp][95lp, fill]", "");
		JPanel formPanel = new JPanel(ml);
		
//		formPanel.setLayout(new MigLayout("fillx"));
		for (FormItem f : body) {
			List<FormElement> components = f.getFormComponents();
			for (FormElement fe : components) {
				formPanel.add(fe.getFormComponent(), fe.getProperties());
			}
//			formPanel.add(f.getFormComponent());
		}
		return formPanel;
	}
}
