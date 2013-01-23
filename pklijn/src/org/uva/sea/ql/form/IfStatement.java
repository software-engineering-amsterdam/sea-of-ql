package org.uva.sea.ql.form;

import java.util.List;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.messages.Message;
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
		for (Message e : errors) {
			System.out.println("! -> " + e.getText());
		}
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
		for (FormItem f : ifBody) {
			if (!f.validate(environment))
				valid = false;
		}
		return errors.size() == 0 && valid;
	}
}
