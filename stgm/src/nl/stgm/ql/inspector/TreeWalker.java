package nl.stgm.ql.inspector;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.*;

public class TreeWalker implements CodeInspector
{
	public void visit(ASTNode node)
	{
		System.out.print("Visiting an instance of class ");
		System.out.println(node.getClass().getName());
	}
	
	public static void main(String[] args)
	{
		RatsParser parser = new RatsParser();
		try
		{
			Form f = parser.parseForm(
				"form Box1HouseOwning { hasSoldHouse: \"Did?\" boolean }"
			);
			f.accept(new TreeWalker());
		}
		catch(ParseError e)
		{
			System.out.println("Error parsing input:");
			System.out.println(e.getMessage());
		}
	}
}
