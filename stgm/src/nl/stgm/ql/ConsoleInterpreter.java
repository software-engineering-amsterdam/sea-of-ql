package nl.stgm.ql.interpreter;

import java.io.*;
import nl.stgm.ql.data.*;

public class ConsoleUI
{
	public void presentForm(String name)
	{
		System.out.println("\n --- " + name.toUpperCase() + " ------------------------------\n");
	}
	
	public Value askQuestion(String question, Type type)
	{
		System.out.print("   " + question + " ");
		
		switch(type)
		{
			case INT:
				return(inputInt());
			case BOOL:
				return(inputBool());
			default:
				throw new Error("Unsupported type found in question.");
		}
	}
	
	public void presentCalcQuestion(String question, Type type, Value value)
	{
		System.out.print("   " + question + " ");
		System.out.print(value.toString());
		System.out.println(" (calculated)");
	}
	
	public Int inputInt()
	{
		return new Int(Integer.parseInt(inputString()));
	}
	
	public Bool inputBool()
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
	
	public String inputString()
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
			throw new Error("Unknown input error. Please restart.");
		}
	}
}