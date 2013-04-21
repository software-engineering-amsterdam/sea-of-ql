package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;

public class CalcQuestion extends Question
{
	private ASTExpressionNode calculation;
	
	public CalcQuestion(String id, String question, ASTExpressionNode calculation)
	{
		super(id, question);
		this.calculation = calculation;
	}
	
	public ASTExpressionNode getCalculationExpr()
	{
		return this.calculation;
	}
	
	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
