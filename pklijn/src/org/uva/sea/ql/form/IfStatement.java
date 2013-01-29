package org.uva.sea.ql.form;

import java.awt.Component;
import java.awt.Container;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.interpreter.FormElement;
import org.uva.sea.ql.messages.Error;

public class IfStatement extends FormItem {

	private final Expr expression;
	private final List<FormItem> ifBody;
	
	public IfStatement(Expr expression, List<FormItem> ifBody) {
		this.expression = expression;
		this.ifBody = ifBody;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	public List<FormItem> getIfBody() {
		return ifBody;
	}
	
	@Override
	public void print(int level) {
		printIndent(level);
		System.out.println("IF expr: "+ expression);
		printErrors();
		for (FormItem f : ifBody) {
			f.print(level + 1);
		}
	}

	@Override
	public boolean validate(Env environment) {
		boolean valid = true;
		errors.addAll(expression.checkType(environment));
		if (!(expression.typeOf(environment) instanceof BoolType)) {
			errors.add(new Error("Ifstatement requires the expression to give a boolean result"));
		}
		Env ifBodyEnvironment = new Env(environment);
		for (FormItem f : ifBody) {
			if (!f.validate(ifBodyEnvironment))
				valid = false;
		}
		return errors.size() == 0 && valid;
	}

	@Override
	public List<FormElement> getFormComponents() {
		List<FormElement> components = new ArrayList<FormElement>();
		
		Container ifBodyContainer = new Container();
		ifBodyContainer.setLayout(new MigLayout("ins 0, debug", "[para]15[][100lp, fill][60lp][95lp, fill]", ""));
		for (FormItem f : ifBody) {
			for (FormElement fe : f.getFormComponents()) {
				ifBodyContainer.add(fe.getFormComponent(), fe.getProperties());
			}
		}
		components.add(new FormElement(ifBodyContainer, "span, growx"));

		return components;
	}
}
