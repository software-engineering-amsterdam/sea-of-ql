package nl.stgm.ql.inspectors.checker;

import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;
import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.ast.form.Form;

import nl.stgm.ql.inspectors.*;

public class SemanticChecker extends DocumentInspector
{
	private HashMap<String,Identifier> symbols = new HashMap<String,Identifier>();
	private HashMap<String,Form> forms = new HashMap<String,Form>();
	private Stack<String> crumbs = new Stack<String>();
	private Vector<String> errors = new Vector<String>();
	
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
	
	public void registerIdent(String name, String type, boolean computed)
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
			// identifier is not defined yet
			addError(name + " is not defined at this point");
			return null;
		}
		else
		{
			return s.getType();
		}
	}
	
	public Type translateType(LiteralExpr expr)
	{
		Type t = Type.translate(expr);
		
		if(t == null)
			throw new Error("An unknown literal type is in the AST.");
		else
			return t;
	}
	
	//
	// forms management
	//
	
	public void registerForm(String name, Form f)
	{
		Form previous = forms.get(name);
		
		if(previous == null)
			forms.put(name, f);
		else
			addError("Duplicate form name " + name);
	}
	
	//
	// traversal helper
	//
	
	public void performTypeCheck(Expr expr)
	{
		// upon encountering an Expr, this may be called to perform a type check
		try
		{
			expr.getType(this);
		}
		catch(IncompatibleTypesException e)
		{
			addError("incompatible types in calculation '" + expr.pretty() + "'");
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
		SemanticChecker checkerContext = new SemanticChecker();
		Document document = parseDocument();
		document.check(checkerContext);
		checkerContext.printErrorList();
	}
}
