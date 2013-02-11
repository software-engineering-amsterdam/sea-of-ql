package org.uva.sea.ql.form;

import java.util.List;

import javax.swing.JPanel;

import org.uva.sea.extensions.Tuple;
import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.interpreter.FormElement;

public class IfElseStatement extends IfStatement {

	private final List<FormItem> elseBody;
	private JPanel elseBodyContainer;
	private Env elseBodyEnvironment;
	
	public IfElseStatement(Expr expression, List<FormItem> ifBody, List<FormItem> elseBody) {
		super(expression, ifBody);
		this.elseBody = elseBody;
	}

	
	public List<FormItem> getElseBody() {
		return elseBody;
	}

	@Override
	public String getPrintableText(int level) {
		String printableText = super.getPrintableText(level);
		printableText += getIndent(level) + "else\n";
		for (FormItem f : elseBody) {
			printableText += f.getPrintableText(level + 1);
		}
		return printableText;
	}
	
	@Override
	public boolean validate(Env environment) {
		boolean valid = super.validate(environment);
		elseBodyEnvironment = new Env(environment);
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
		for (FormItem f : elseBody) {
			f.eval(elseBodyEnvironment, form);
		}
		elseBodyContainer.setVisible(!isExpressionValid(environment));
	}
	
	@Override
	public List<Tuple<Ident, Value>> getAllValues() {
		List<Tuple<Ident, Value>> values = elseBodyEnvironment.getAllValues();
		values.addAll(super.getAllValues());
		return values;
	}
}
