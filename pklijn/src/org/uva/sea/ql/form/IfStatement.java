package org.uva.sea.ql.form;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.extensions.Tuple;
import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.interpreter.FormElement;
import org.uva.sea.ql.messages.Error;

public class IfStatement extends FormItem {

	private final Expr expression;
	private final List<FormItem> ifBody;
	private JPanel ifBodyContainer;
	private Env ifBodyEnvironment;
	
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
	public String getPrintableText(int level) {
		String printableText = getIndent(level);
		printableText += "if (" + expression + ")\n";
		printableText += getErrorText();
		for (FormItem f : ifBody) {
			printableText += f.getPrintableText(level + 1);
		}
		return printableText;
	}

	@Override
	public boolean validate(Env environment) {
		boolean valid = true;
		errors.addAll(expression.checkType(environment));
		if (!(expression.typeOf(environment).equals(new BoolType()))) {
			errors.add(new Error("Ifstatement requires the expression to give a boolean result"));
		}
		ifBodyEnvironment = new Env(environment);
		for (FormItem f : ifBody) {
			if (!f.validate(ifBodyEnvironment))
				valid = false;
		}
		return errors.size() == 0 && valid;
	}

	@Override
	public List<FormElement> getFormComponents() {
		List<FormElement> components = new ArrayList<FormElement>();
		ifBodyContainer = getBodyFormContainer(ifBody);
		components.add(new FormElement(ifBodyContainer, "span, growx"));
		return components;
	}
	
	protected JPanel getBodyFormContainer(List<FormItem> body) {
		JPanel bodyContainer = new JPanel(new MigLayout("ins 0", "[para]15[][100lp, fill][60lp][95lp, fill]", ""));
		for (FormItem f : body) {
			for (FormElement fe : f.getFormComponents()) {
				bodyContainer.add(fe.getFormComponent(), fe.getProperties());
			}
		}
		return bodyContainer;
		
	}

	@Override
	public void eval(Env environment, Form form) {
		ifBodyContainer.setVisible(isExpressionValid(environment));
		for (FormItem f : ifBody) {
			f.eval(ifBodyEnvironment, form);
		}
	}
	
	protected boolean isExpressionValid(Env environment) {
		Value expressionValue = expression.eval(environment);
		if (expressionValue != null && expressionValue.getClass().equals(new BoolValue().getClass())) {
			return ((BoolValue)expressionValue).getValue();
		}
		return false;
	}

	@Override
	public List<Tuple<Ident, Value>> getAllValues() {
		List<Tuple<Ident, Value>> values = ifBodyEnvironment.getAllValues();
		for (FormItem f : ifBody) {
			values.addAll(f.getAllValues());
		}
		return values;
	}
}
