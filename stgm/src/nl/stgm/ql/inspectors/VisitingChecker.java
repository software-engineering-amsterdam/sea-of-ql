package nl.stgm.ql.inspectors;

import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class VisitingChecker extends RunnableVisitor implements TypeContext, Visitor
{
	private HashMap<String,Symbol> symbols = new HashMap<String,Symbol>();
	private HashMap<String,Form> forms = new HashMap<String,Form>();
	private Stack<String> crumbs = new Stack<String>();
	private Vector<String> errors = new Vector<String>();
	
	public void visit(CalcQuestion cq)
	{
		String name = cq.id();
		Type type = cq.type();
		boolean computed = true;
		
		addSymbol(name, new Symbol(name, type, computed));

		pushCrumb(cq.id());
		cq.calculation().accept(this);
		popCrumb();
	}
	
	public void visit(Conditional c)
	{
		pushCrumb("if(" + c.condition().renderExpressionString() + ")");

		c.condition().accept(this);

		for(Question q: c.ifQuestions())
			q.accept(this);

		if(c.hasElse())
			for(Question q: c.elseQuestions())
				q.accept(this);
		
		popCrumb();
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
		Form previous = forms.get(f.id());
		
		if(previous == null)
			forms.put(f.id(), f);
		else
			addError("Duplicate form name " + f.id());
		
		pushCrumb(f.id());
		for(FormItem fi: f.formItems())
		{
			fi.accept(this);
		}
		popCrumb();
	}
	
	public void visit(Question q)
	{
		String name = q.id();
		Type type = q.type();
		boolean computed = false;
		
		addSymbol(name, new Symbol(name, type, computed));
	}
	
	public void visit(Expr expr)
	{
		// upon encountering an Expr, this may be called to perform a type check
		try
		{
			expr.inferType(this);
		}
		catch(IncompatibleTypesException e)
		{
			addError("incompatible types in calculation '" + expr.renderExpressionString() + "'");
		}
	}
	
	//
	// crumb trace is used to give error locations
	//
	
	private void pushCrumb(String name)
	{
		crumbs.push(name);
	}
	
	private void popCrumb()
	{
		crumbs.pop();
	}
	
	private void addSymbol(String name, Symbol s)
	{
		// check if symbol already exists
		Symbol i = symbols.get(name);
		
		if(i == null)
		{
			symbols.put(name, s);
		}
		else if(i.isComputed() != s.isComputed())
		{
			if(s.isComputed())
				addError(name + " is redefined as being calculated instead of input by user");
			else
				addError(name + " is redefined as being input by user instead of calculated");
		}
		else if(!i.isOfType(s.getType()))
		{
			addError(name + " is redefined as being of a different datatype");
		}
		else
		{
			// symbol is equivalent, does not need to be added (though it could be seen as an error)
		}
	}
	
	public Type getSymbolType(String name)
	{
		Symbol s = symbols.get(name);
		
		if(s == null)
		{
			addError(name + " is not defined at this point");
			
			// we'll allow to continue in order to catch more errors
			return null;
		}
		else
		{
			return s.getType();
		}
	}
		
	//
	// main checking code
	//
	
	private void addError(String message)
	{
		StringBuilder err = new StringBuilder();

		if(crumbs.size() > 0)
		{
			for(String c: crumbs)
			{
				err.append(c);
				err.append(" / ");
			}
			err.append("\n     ");
		}

		err.append(message);
		errors.add(err.toString());
	}
	
	// error list could be refactored into its own class to prevent this strange public method
	public void printErrorList()
	{
		if(errors.size() == 0)
		{
			System.out.println("No errors found.");
			System.exit(0);
		}
		
		System.out.println();

		int line = 1;
		for(String e: errors)
		{
			System.out.print(" " + String.valueOf(line) + ": ");
			System.out.println(e);
			line++;
		}

		System.out.println();
	}

	public static void main(String[] args)
	{
		VisitingChecker checkerContext = new VisitingChecker();
		Document document = parseDocument("errors.qldoc");
		document.accept(checkerContext);
		checkerContext.printErrorList();
	}
}
