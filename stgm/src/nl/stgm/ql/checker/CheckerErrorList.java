package nl.stgm.ql.checker;

import java.util.Stack;
import java.util.List;
import java.util.Vector;

public class CheckerErrorList
{
	private Stack<String> crumbs = new Stack<String>();
	private List<String> errors = new Vector<String>();
	
	public void pushCrumb(String name)
	{
		crumbs.push(name);
	}
	
	public void popCrumb()
	{
		crumbs.pop();
	}
	
	public void add(String message)
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
	
	public void printList()
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
}
