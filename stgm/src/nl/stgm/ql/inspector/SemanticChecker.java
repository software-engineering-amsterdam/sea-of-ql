package nl.stgm.ql.inspector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.util.HashMap;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.ast.types.*;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.*;

//
// Inspector that validates basic semantics of the tree
//
public class SemanticChecker implements CodeInspector
{
	private HashMap<String,Ident> symbols = new HashMap<String,Ident>();
	
	public void visit(Ident node)
	{
		symbols.put(node.getName(), node);
	}
	
	public void visit(BinaryExpr node)
	{
		// check if result of left is same type as result of right argument
		if(node.getLeft().getClass() != node.getRight().getClass())
			System.out.println("Error: " + node.toString() + " has two different argument types.");
	}
	
	public void visit(UnaryExpr node)
	{
		System.out.println(node.getClass());
	}
	
	public void visit(CalcQuestion node)
	{
		System.out.println(node.getClass());
	}
	
	public void visit(Question node)
	{
		System.out.println(node.getClass());
	}
	
	public void visit(Conditional node)
	{
		System.out.println(node.getClass());
	}
	
	public void visit(Document node)
	{
		System.out.println(node.getClass());
	}
	
	public void visit(Form node)
	{
		System.out.println(node.getClass());
	}
	
	public void visit(Expr node)
	{
		System.out.println(node.getClass());
	}
	
	public int results()
	{
		return(symbols.size());
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
			document.accept(checker);
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
