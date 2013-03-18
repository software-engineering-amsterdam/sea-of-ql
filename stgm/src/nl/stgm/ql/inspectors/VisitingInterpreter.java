package nl.stgm.ql.inspectors;

import java.io.*;
import java.util.HashMap;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.ast.expr.literal.*;

import nl.stgm.ql.interfaces.*;

public class VisitingInterpreter extends RunnableVisitor implements TypeContext,ValueContext,Visitor
{
	private HashMap<String,Identifier> symbols = new HashMap<String,Identifier>();
	private HashMap<String,LiteralExpr> values = new HashMap<String,LiteralExpr>();
	
	public void visit(CalcQuestion cq)
	{
		regCalcQuestion(cq.id(), cq.question(), cq.type(), cq.calculation().reduceValue(this));
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
		regForm(f.id());

		for(FormItem fi: f.formItems())
		{
			fi.accept(this);
		}
	}
	
	public void visit(Question q)
	{
		regQuestion(q.id(), q.question(), q.type());
	}
	
	public void visit(Expr e)
	{
		// no-op, because CalcQuestion and Conditional will call reduceValue() below
		throw new Error("This method should not be called on an Expr.");
	}
	
	public void regForm(String name)
	{
		System.out.println("\n --- " + name.toUpperCase() + " ------------------------------\n");
	}
	
	public void regQuestion(String id, String question, Type type)
	{
		symbols.put(id, new Identifier(id, type, false));
		System.out.print("   " + question + " ");
		switch(type)
		{
			case INT:
				values.put(id, inputInt());
				break;
			case BOOL:
				values.put(id, inputBool());
				break;
			default:
				throw new Error("Unsupported type found in question.");
		}
	}
	
	public void regCalcQuestion(String id, String question, Type type, LiteralExpr value)
	{
		symbols.put(id, new Identifier(id, type, true));
		values.put(id, value);
		System.out.print("   " + question + " ");
		System.out.print(value.toString());
		System.out.println(" (calculated)");
	}
	
	public LiteralExpr lookupValue(String name)
	{
		return values.get(name);
	}
	
	public Type lookupType(String name)
	{
		Identifier s = symbols.get(name);
		
		if(s == null)
		{
			throw new Error(name + " is not defined at this point");
		}
		else
		{
			return s.getType();
		}
	}
	
	//
	// question input tools (could be factored into separate io class)
	//
	
	private Int inputInt()
	{
		return new Int(Integer.parseInt(inputString()));
	}
	
	private Bool inputBool()
	{
		String input = inputString();
		
		if(input.equals("y") || input.equals("yes"))
		{
			return new Bool(true);
		}
		else // if no yes, it will be no ;-)
		{
			return new Bool(false);
		}
	}
	
	private String inputString()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;

		try
		{
			input = br.readLine();
			return input;
		}
		catch (IOException ioe)
		{
			exitWithError("Unknown input error. Please restart.");
			return null; // FML
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
