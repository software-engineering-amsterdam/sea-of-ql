package nl.stgm.ql.inspectors.checker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.util.HashMap;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.terminal.*;
import nl.stgm.ql.ast.form.Document;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.*;

//
// Inspector that validates basic semantics of the tree
//
public class SemanticChecker
{
	private HashMap<String,Identifier> symbols = new HashMap<String,Identifier>();
	
	public int results()
	{
		return(symbols.size());
	}
	
	public void registerIdent(String name, String type, boolean computed)
	{
		symbols.put(name, new Identifier(name, type, computed));
	}
	
	public Identifier.Type lookupType(String name)
	{
		Identifier s = symbols.get(name);
		
		if(s != null)
		{
			return(s.getType());
		}
		else
		{
			// identifier is not defined yet
			return(null);
		}
	}
	
	public void typeCheck(Expr expr)
	{
		try
		{
			System.out.println(expr.getType(this));
		}
		catch(Error e)
		{
			System.out.println("Type error.");
		}
	}
	
	public static void main(String[] args)
	{
		RatsParser parser = new RatsParser();
		byte[] file = null;
		String documentSource;
		
		//
		// read the file
		//
		
		try
		{
			// hardcoded single sample file
			Path path = FileSystems.getDefault().getPath("samples", "canonical.qldoc");
			file = Files.readAllBytes(path);
		}
		catch(IOException e)
		{
			System.out.print("Problem loading sample file: ");
			System.out.println(e.getMessage());
			System.exit(1); // generic "error" exit code
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Error: input file too large to fit in memory.");
			System.exit(1); // generic "error" exit code
		}
		catch(SecurityException e)
		{
			System.out.println("Error: no permission to read input file.");
			System.exit(1); // generic "error" exit code
		}

		documentSource = new String(file);
		
		//
		// run the semantic checker
		//
		
		SemanticChecker checker = new SemanticChecker();

		try
		{
			Document document = parser.parse(documentSource);
			document.check(checker);
		}
		catch(ParseError e)
		{
			System.out.print("Error parsing sample file: ");
			System.out.println(e.getMessage());
			System.exit(1); // generic "error" exit code
		}
		
		System.out.println(checker.results());
	}
}
