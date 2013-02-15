package org.uva.sea.ql.form;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.uva.sea.extensions.Tuple;
import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.messages.Error;

public class IfStatement extends FormItem {

	private final Expr expression;
	private final List<FormItem> ifBody;
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
	public void buildForm(JPanel mainPanel, Env environment, Form form) {
		for (FormItem f : ifBody) {
			f.buildForm(mainPanel, ifBodyEnvironment, form);
		}
	}
	
	@Override
	public void setVisible(Boolean visible) {
		for (FormItem f : ifBody) {
			f.setVisible(visible);
		}
	}
	
	@Override
	public void eval(Env environment) {
		setVisible(isExpressionValid(environment));
		evalIfBody(environment);
	}
	
	protected void evalIfBody(Env environment) {
		if (isExpressionValid(environment)) {
			for (FormItem f : ifBody) {
				f.eval(ifBodyEnvironment);
			}
		}
	}
	
	protected boolean isExpressionValid(Env environment) {
		Value expressionValue = expression.eval(environment);
		if (expressionValue.getClass().equals(new BoolValue().getClass())) {
			return ((BoolValue)expressionValue).getValue();
		}
		return false;
	}

	@Override
	public boolean isFinished(Env environment) {
		if (isExpressionValid(environment)) {
			for (FormItem f : ifBody) {
				if (!f.isFinished(ifBodyEnvironment)) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public List<Tuple<Ident, Value>> getAllValues(Env environment) {
		List<Tuple<Ident, Value>> values = new ArrayList<Tuple<Ident, Value>>();
		if (isExpressionValid(environment)) {
			for (FormItem f : ifBody) {
				values.addAll(f.getAllValues(ifBodyEnvironment));
			}
		}
		return values;
	}
}
