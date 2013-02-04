package org.uva.sea.ql.form;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.interpreter.FormElement;

public class Form {

	private Ident id;
	private List<FormItem> body;
	private Env environment;
	
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
		environment = new Env();
		for (FormItem f : body) {
			if (!f.validate(environment))
				valid = false;
		}
		return valid;
	}
	
	public void eval() {
		for (FormItem f : body) {
			f.eval(environment, this);
		}
	}
	
	public JPanel buildForm() {
		MigLayout ml = new MigLayout("ins 20", "[para]0[][100lp, fill][60lp][95lp, fill]", "");
		JPanel formPanel = new JPanel(ml);
		
		for (FormItem f : body) {
			List<FormElement> components = f.getFormComponents();
			for (FormElement fe : components) {
				formPanel.add(fe.getFormComponent(), fe.getProperties());
			}
		}
		eval();
		return formPanel;
	}
}
