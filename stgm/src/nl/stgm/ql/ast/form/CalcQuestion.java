package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public class CalcQuestion extends Question
{
	private Expr calculation;
	
	public CalcQuestion(String id, String question, String type, Expr calculation)
	{
		super(id, question, type);
		this.calculation = calculation;
	}

	public void print(PrettyPrinter context)
	{
		context.print(id + ": " + question + " " + type + " (");
		calculation.print(context);
		context.println(")");
	}

	public void check(SemanticChecker context)
	{
		context.registerIdent(this.id, this.type, true);

		context.pushCrumb(this.id);
		calculation.check(context);
		context.popCrumb();
	}

	public void interpret(Interpreter context)
	{
		context.regCalcQuestion(this.id, this.question, this.calculation.reduceValue(context));
	}
}
