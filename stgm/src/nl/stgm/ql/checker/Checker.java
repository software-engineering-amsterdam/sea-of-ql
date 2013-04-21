package nl.stgm.ql.checker;

import java.util.Map;
import java.util.HashMap;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.data.*;

public class Checker implements Visitor, TypeCheckContext
{
	private CheckerErrorList errors;
	private CheckerSymbolList symbols;
	
	private Map<String,Form> forms = new HashMap<String,Form>();

	public Checker(CheckerErrorList errors)
	{
		this.errors = errors;
		this.symbols = new CheckerSymbolList(errors);
	}
	
	//
	// TypeCheckContext
	//
	
	public void registerError(TypeCheckable expr, String errorMessage)
	{
		errors.add(expr.toString() + ": " + errorMessage);
	}

	public Type getType(String id)
	{
		return symbols.getType(id);
	}

	//
	// Visitor
	//
	
	public void visit(CalcQuestion cq)
	{
		errors.pushCrumb(cq.getID());
		Type type = cq.getCalculationExpr().checkType(this);
		errors.popCrumb();

		symbols.add(cq.getID(), new CheckerSymbol(cq.getID(), type, true));
	}
	
	public void visit(Conditional c)
	{
		errors.pushCrumb("if(" + c.getConditionExpr().render() + ")");

		c.getConditionExpr().checkType(this);

		for(Question q: c.getIfQuestions())
			q.accept(this);

		if(c.hasElse())
			for(Question q: c.getElseQuestions())
				q.accept(this);
		
		errors.popCrumb();
	}
	
	public void visit(Document d)
	{
		if(d.getForms().size() == 0)
			errors.add("Warning: no (valid) forms in document. This could be a parse error.");
		
		for(Form f: d.getForms())
		{
			f.accept(this);
		}
	}
	
	public void visit(Form f)
	{
		Form previous = forms.get(f.getID());
		
		if(previous == null)
			forms.put(f.getID(), f);
		else
			errors.add("Duplicate form name " + f.getID());
		
		errors.pushCrumb(f.getID());
		for(FormItem fi: f.formItems())
		{
			fi.accept(this);
		}
		errors.popCrumb();
	}
	
	public void visit(BoolQuestion q)
	{
		String name = q.getID();
		
		symbols.add(name, new CheckerSymbol(name, new BoolType(), false));
	}
	
	public void visit(IntQuestion q)
	{
		String name = q.getID();
		
		symbols.add(name, new CheckerSymbol(name, new IntType(), false));
	}
}
