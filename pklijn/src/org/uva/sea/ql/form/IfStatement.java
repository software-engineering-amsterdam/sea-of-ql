package org.uva.sea.ql.form;

import java.util.ArrayList;
import java.util.List;
import org.uva.sea.ql.ast.Expr;

public class IfStatement extends FormItem {

	private Expr expression;
	private List<FormItem> ifBody;
	private List<FormItem> elseBody;
	
	public IfStatement(Expr expression, List<FormItem> ifBody, List<FormItem> elseBody) {
		this.expression = expression;
		this.ifBody = ifBody;
		this.elseBody = (elseBody != null) ? elseBody : new ArrayList<FormItem>();
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	public List<FormItem> getIfBody() {
		return ifBody;
	}
	
	public List<FormItem> getElseBody() {
		return elseBody;
	}

	@Override
	public void print(int level) {
		printIndent(level);
		System.out.println("IF expr: "+ expression);
		for (FormItem f : ifBody) {
			f.print(level + 1);
		}
		if (elseBody.size() > 0) {
			printIndent(level);
			System.out.println("ELSE");
			for (FormItem f : elseBody) {
				f.print(level + 1);
			}
		}
	}
}
