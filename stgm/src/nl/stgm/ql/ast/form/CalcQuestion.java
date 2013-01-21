package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspector.CodeInspector;

public class CalcQuestion extends Question
{
	private Expr calculation;
	
	public CalcQuestion(String id, String question, String type, Expr calculation)
	{
		super(id, question, type);
		this.calculation = calculation;
	}

	public String toString()
	{
		return("Calculated Question: " + question);
	}

	public void accept(CodeInspector inspector)
	{
		calculation.accept(inspector);
		inspector.visit(this);
	}
}
