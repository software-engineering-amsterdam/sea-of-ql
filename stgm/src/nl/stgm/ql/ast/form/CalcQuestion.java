package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.expr.Expr;

public class CalcQuestion extends Question
{
	private Expr calculation;
	
	public CalcQuestion(String id, String question, String type, Expr calculation)
	{
		super(id, question, type);
		this.calculation = calculation;
	}
}
