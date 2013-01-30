package org.uva.sea.ql.form;

import java.awt.Container;
import java.util.List;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.interpreter.FormElement;

public class IfElseStatement extends IfStatement {

	private final List<FormItem> elseBody;
	private Container elseBodyContainer;
	
	public IfElseStatement(Expr expression, List<FormItem> ifBody, List<FormItem> elseBody) {
		super(expression, ifBody);
		this.elseBody = elseBody;
	}

	
	public List<FormItem> getElseBody() {
		return elseBody;
	}

	@Override
	public void print(int level) {
		printIndent(level);
		System.out.println("IF expr: "+ getExpression());
		printErrors();
		for (FormItem f : getIfBody()) {
			f.print(level + 1);
		}
		printIndent(level);
		System.out.println("ELSE");
		for (FormItem f : elseBody) {
			f.print(level + 1);
		}
	}
	
	@Override
	public boolean validate(Env environment) {
		boolean valid = super.validate(environment);
		Env elseBodyEnvironment = new Env(environment);
		for (FormItem f : elseBody) {
			if (!f.validate(elseBodyEnvironment))
				valid = false;
		}
		return errors.size() == 0 && valid;
	}
	
	@Override
	public List<FormElement> getFormComponents() {
		List<FormElement> components = super.getFormComponents();
		elseBodyContainer = getBodyFormContainer(elseBody);
		components.add(new FormElement(elseBodyContainer, "span, growx"));
		return components;
	}
	
	@Override
	public void eval(Env environment, Form form) {
		super.eval(environment, form);
		elseBodyContainer.setVisible(!isExpressionValid(environment));
	}
}
