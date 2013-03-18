package nl.stgm.ql.inspectors;

import java.util.HashMap;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class VisitingInterpreter extends RunnableVisitor implements TypeContext, ValueContext, Visitor
{
	private HashMap<String,Symbol> symbols = new HashMap<String,Symbol>();
	private HashMap<String,Value> values = new HashMap<String,Value>();
	private ConsoleUI ui = new ConsoleUI();
	
	public void visit(CalcQuestion cq)
	{
		Value value = cq.calculation().reduceValue(this);
		
		symbols.put(cq.id(), new Symbol(cq.id(), cq.type(), true));
		values.put(cq.id(), value);
		ui.presentCalcQuestion(cq.question(), cq.type(), value);
	}
	
	public void visit(Conditional c)
	{
		Bool v = (Bool) c.condition().reduceValue(this);
		
		if(v.getValue())
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
	
	public void visit(Document d)
	{
		for(Form f: d.forms())
		{
			f.accept(this);
		}
	}
	
	public void visit(Form f)
	{
		ui.presentForm(f.id());

		for(FormItem fi: f.formItems())
		{
			fi.accept(this);
		}
	}
	
	public void visit(Question q)
	{
		symbols.put(q.id(), new Symbol(q.id(), q.type(), false));
		Value value = ui.askQuestion(q.question(), q.type());
		values.put(q.id(), value);
	}
	
	public void visit(Expr e)
	{
		// no-op, because CalcQuestion and Conditional will call reduceValue() below
		throw new Error("This method should not be called on an Expr.");
	}
	
	public Value lookupValue(String name)
	{
		return values.get(name);
	}
	
	public Type lookupType(String name)
	{
		Symbol s = symbols.get(name);
		
		if(s == null)
		{
			throw new Error(name + " is not defined at this point");
		}
		else
		{
			return s.getType();
		}
	}
	
	public static void main(String[] args)
	{
		VisitingInterpreter ip = new VisitingInterpreter();
		Document document = parseDocument("canonical.qldoc");
		document.accept(ip);
		System.out.println();
	}
}
