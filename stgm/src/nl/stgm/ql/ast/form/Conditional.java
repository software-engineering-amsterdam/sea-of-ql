package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

import java.util.List;

public class Conditional extends FormItem
{
	private Expr condition;
	private List<Question> ifQuestions;
	private List<Question> elseQuestions;
	
	public Conditional(Expr condition, List<Question> ifQuestions, List<Question> elseQuestions)
	{
		this.condition = condition;
		this.ifQuestions = ifQuestions;
		this.elseQuestions = elseQuestions;
	}

	public Conditional(Expr condition, List<Question> ifQuestions)
	{
		this.condition = condition;
		this.ifQuestions = ifQuestions;
		this.elseQuestions = null;
	}

	public void print(PrettyPrinter context)
	{
		context.print("if(");
		condition.print(context);
		context.println(") {");
				
		context.increaseIndent();
		for (Question q: ifQuestions)
			q.print(context);
		context.decreaseIndent();
		
		context.println("}");

		if(elseQuestions != null)
		{
			context.println("else {");
			context.increaseIndent();
			for (Question q: elseQuestions)
			{
				q.print(context);
			}
			context.decreaseIndent();
			context.println("}");
		}
	}

	public void check(SemanticChecker context)
	{
		context.pushCrumb("if(" + condition.pretty() + ")");

		condition.check(context);

		for(Question q: ifQuestions)
			q.check(context);

		if(elseQuestions != null)
			for(Question q: elseQuestions)
				q.check(context);
		
		context.popCrumb();
	}

	public void interpret(Interpreter context)
	{
		Bool v = (Bool) condition.evaluate(context);
		
		if(v.getBooleanValue())
		{
			for(Question q: ifQuestions)
				q.interpret(context);
		}
		else
		{
			if(elseQuestions != null)
				for(Question q: elseQuestions)
					q.interpret(context);
		}
	}
}
