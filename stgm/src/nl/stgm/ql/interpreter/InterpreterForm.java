package nl.stgm.ql.interpreter;

import java.util.Vector;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

import nl.stgm.ql.inspectors.*;

public class InterpreterForm implements Visitor
{
	private Context context;
	private Form form;
	private int itemCount;
	
	public InterpreterForm(Form form, Context context)
	{
		this.form = form;
		this.context = context;
		
		// immediately gather form information for the first time
		this.update();
	}
	
	public Context context()
	{
		return this.context;
	}
	
	public void update()
	{
		// traverse form contents in ast
		form.accept(this);
	}
	
	public String name()
	{
		return form.id();
	}
	
	public int itemCount()
	{
		return itemCount;
	}
	
	public Form getForm()
	{
		return this.form;
	}
	
	public void visit(Form f)
	{
		// gather all subitems
		for(FormItem fi: f.formItems())
		{
			fi.accept(this);
		}
	}
	
	public void visit(Question q)
	{
		itemCount++;

		context.putSymbol(q.id(), new Symbol(q.id(), q.type(), false));
		//ui.addQuestion(q.question(), q.type());
	}
	
	public void visit(CalcQuestion cq)
	{
		itemCount++;

		//Value value = cq.calculation().reduceValue(context);
		context.putSymbol(cq.id(), new Symbol(cq.id(), cq.type(), true));
		// context.putValue(cq.id(), value);
		// ui.addCalcQuestion(cq.question(), cq.type(), value);
	}
	
	public void visit(Conditional c)
	{
		// Bool v = (Bool) c.condition().reduceValue(context);
		
		if(true)
		{
			for(Question q: c.ifQuestions())
				q.accept(this);
		}
		else
		{
			if(c.hasElse())
				for(Question q: c.elseQuestions())
					q.accept(this);
		}
	}
	
	public void visit(Expr e)
	{
		// no-op, because CalcQuestion and Conditional will call reduceValue() below
		throw new Error("This method should not be called on an Expr.");
	}
	
	public void visit(Document d)
	{
		
	}
}
