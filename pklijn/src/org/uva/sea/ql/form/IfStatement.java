package org.uva.sea.ql.form;

import java.util.List;
import org.uva.sea.ql.ast.Expr;

public class IfStatement extends FormItem {

	private Expr expression;
	private List<FormItem> ifBody;
	
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
		for (FormItem f : ifBody) {
			f.print(level + 1);
		}
	}
}
