package nl.stgm.ql.inspectors;

import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.ast.expr.literal.*;
import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.ast.form.Form;

import nl.stgm.ql.interfaces.*;

public class VisitingChecker extends RunnableVisitor implements TypeContext, Visitor
{
	private HashMap<String,Identifier> symbols = new HashMap<String,Identifier>();
	private HashMap<String,Form> forms = new HashMap<String,Form>();
	private Stack<String> crumbs = new Stack<String>();
	private Vector<String> errors = new Vector<String>();
	
	public void visit(CalcQuestion cq)
	{
		checkQuestion(cq.id(), cq.type(), true);
		pushCrumb(cq.id());
		cq.calculation().accept(this);
		popCrumb();
	}
	
	public void visit(Conditional c)
	{
		pushCrumb("if(" + c.condition().renderExpression() + ")");

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
		checkForm(f.id(), f);
		
		pushCrumb(f.id());
		for(FormItem fi: f.formItems())
		{
			fi.accept(this);
		}
		popCrumb();
	}
	
	public void visit(Question q)
	{
		checkQuestion(q.id(), q.type(), false);
	}
	
	public void visit(Expr expr)
	{
		// upon encountering an Expr, this may be called to perform a type check
		try
		{
			expr.reduceType(this);
		}
		catch(IncompatibleTypesException e)
		{
			addError("incompatible types in calculation '" + expr.renderExpression() + "'");
		}
	}
	
	//
	// crumb trace is used to give error locations
	//
	
	public void pushCrumb(String name)
	{
		crumbs.push(name);
	}
	
	public void popCrumb()
	{
		crumbs.pop();
	}
	
	//
	// list of defined identifiers
	//
	
	public void checkQuestion(String name, Type type, boolean computed)
	{
		// check if symbol already exists
		Identifier i = symbols.get(name);
		
		if(i == null)
		{
			symbols.put(name, new Identifier(name, type, computed));
		}
		else if(i.isComputed() != computed)
		{
			if(computed)
				addError(name + " is redefined as being calculated instead of input by user");
			else
				addError(name + " is redefined as being input by user instead of calculated");
		}
		else if(!i.isOfType(type))
		{
			addError(name + " is redefined as being of a different datatype");
		}
		else
		{
			// symbol is equivalent, does not need to be added
		}
	}
	
	public Type lookupType(String name)
	{
		Identifier s = symbols.get(name);
		
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
	// forms management
	//
	
	public void checkForm(String name, Form f)
	{
		Form previous = forms.get(name);
		
		if(previous == null)
			forms.put(name, f);
		else
			addError("Duplicate form name " + name);
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
