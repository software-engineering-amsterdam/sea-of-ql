package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspector.pretty.*;

public class CalcQuestion extends Question
{
	private Expr calculation;
	
	public CalcQuestion(String id, String question, String type, Expr calculation)
	{
		super(id, question, type);
		this.calculation = calculation;
	}

	public void print(ConsolePrinter context)
	{
		context.print(id + ": " + question + " " + type + " (");
		calculation.print(context);
		context.println(")");
	}
}
