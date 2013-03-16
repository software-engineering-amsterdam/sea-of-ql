package nl.stgm.ql.inspectors.checker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.terminal.*;
import nl.stgm.ql.ast.form.Document;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.*;

// Inspector that validates basic semantics of the tree

public class SemanticChecker
{
	private HashMap<String,Identifier> symbols = new HashMap<String,Identifier>();
	private Stack<String> crumbs = new Stack<String>();
	private Vector<String> errors = new Vector<String>();
	
	//
	// crumb trace is used to localize errors better
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
		Identifier i = symbols.get(name);
		
		if(i != null && i.isComputed() != computed)
		{
			if(computed)
				addError(name + " is redefined as being calculated");
			else
				addError(name + " is redefined as being input by user");
			return;
		}
		else
		{
			symbols.put(name, new Identifier(name, type, computed));
			return;
		}
	}
	
	public Identifier.Type lookupType(String name)
	{
		Identifier s = symbols.get(name);
		
		if(s != null)
			return(s.getType());
		else
		{
			// identifier is not defined yet
			addError(name + " unknown at this point");
			return(null);
		}
	}
	
	//
	// traversal helpers
	//
	
	// upon encountering an Expr, this may be called to perform a type check
	public void performTypeCheck(Expr expr)
	{
		try
		{
			expr.getType(this);
		}
		catch(Error e)
		{
			addError("type error in expression " + expr.prettyString());
		}
	}
	
	//
	// main checking code
	//
	
	private void addError(String message)
	{
		StringBuilder err = new StringBuilder();
		for(String c: crumbs)
		{
			err.append(c);
			err.append(" > ");
		}
		err.append(message);
		errors.add(err.toString());
	}
	
	public static void main(String[] args)
	{
		RatsParser parser = new RatsParser();
		byte[] file = null;
		String documentSource;
		
		// read the file
		
		try
		{
			// hardcoded single sample file!
			Path path = FileSystems.getDefault().getPath("samples", "canonical.qldoc");
			file = Files.readAllBytes(path);
		}
		catch(IOException e)
		{
			exitWithError("Problem loading sample file: " + e.getMessage());
		}
		catch(OutOfMemoryError e)
		{
			exitWithError("Error: input file too large to fit in memory.");
		}
		catch(SecurityException e)
		{
			exitWithError("Error: no permission to read input file.");
		}

		documentSource = new String(file);
		
		// run the semantic checker
		
		SemanticChecker checker = new SemanticChecker();

		try
		{
			Document document = parser.parse(documentSource);
			document.check(checker);
		}
		catch(ParseError e)
		{
			exitWithError("Error parsing sample file: " + e.getMessage());
		}
		
		for(String e: checker.errors)
			System.out.println(e);		
	}
	
	public static void exitWithError(String message)
	{
		System.out.println(message);
		System.exit(1); // generic "error" exit code
	}
}
