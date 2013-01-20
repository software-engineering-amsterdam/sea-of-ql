package nl.stgm.ql.inspector;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.*;

/***
 * Simple inspector that walks the tree depth-first and prints out class names
 */
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
			Document f = parser.parse(
				"form Box1HouseOwning { hasSoldHouse: \"Did?\" boolean } form Box1HouseOwning { hasSoldHouse: \"Did?\" boolean }"
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
