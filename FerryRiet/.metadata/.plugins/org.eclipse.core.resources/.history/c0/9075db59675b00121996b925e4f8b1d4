package org.uva.sea.ql.ast;

public class MoneyType extends TypeDescription {

	private Expr expression;

	public MoneyType(Expr x) {
		expression = x;
	}

	@Override
	public void eval() {
		System.out.print("money");
		// TODO Auto-generated method stub
		if (expression != null) {
			System.out.print("(");
			expression.eval();
			System.out.print(")");
		}
	}

}
