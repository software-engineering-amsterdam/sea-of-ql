package nl.stgm.ql.inspectors.interpreter;

import java.io.*;
import java.util.HashMap;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;
import nl.stgm.ql.ast.form.Document;

import nl.stgm.ql.inspectors.*;

public class Interpreter extends DocumentInspector implements Semantic
{
	private HashMap<String,Identifier> symbols = new HashMap<String,Identifier>();
	private HashMap<String,LiteralExpr> values = new HashMap<String,LiteralExpr>();
	
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
		Interpreter ip = new Interpreter();
		Document document = parseDocument("canonical.qldoc");
		document.interpret(ip);
		System.out.println();
	}
}
