package org.uva.sea.ql.form;

import java.util.List;

import javax.swing.JPanel;

import org.uva.sea.extensions.Tuple;
import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Value;

public class IfElseStatement extends IfStatement {

	private final List<FormItem> elseBody;
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
	public void buildForm(JPanel mainPanel, Env environment, Form form) {
		super.buildForm(mainPanel, environment, form);
		for (FormItem f : elseBody) {
			f.buildForm(mainPanel, elseBodyEnvironment, form);
		}
	}
	
	@Override
	public void setVisible(Boolean visible) {
		// The ifBody will be set to false. This will be overwritten by the eval if setVisible is called
		// by the eval function. If not, this will prevent a visibility bug with nested ifElse statements
		super.setVisible(false);
		for (FormItem f : elseBody) {
			f.setVisible(visible);
		}
	}
	
	@Override
	public void eval(Env environment) {
		setVisible(!isExpressionValid(environment));
		super.setVisible(isExpressionValid(environment));
		evalIfBody(environment);
		if (!isExpressionValid(environment)) {
			for (FormItem f : elseBody) {
				f.eval(elseBodyEnvironment);
			}
		}
	}
	
	@Override
	public boolean isFinished(Env environment) {
		if (!isExpressionValid(environment)) {
			for (FormItem f : elseBody) {
				if (!f.isFinished(elseBodyEnvironment)) {
					return false;
				}
			}
		}
		else {
			return super.isFinished(environment);
		}
		return true;
	}
	
	@Override
	public List<Tuple<Ident, Value>> getAllValues(Env environment) {
		List<Tuple<Ident, Value>> values = super.getAllValues(environment);
		if (!isExpressionValid(environment)) {
			for (FormItem f : elseBody) {
				values.addAll(f.getAllValues(elseBodyEnvironment));
			}
		}
		return values;
	}
}
