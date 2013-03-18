package nl.stgm.ql.inspectors;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;

public enum Type
{
	INT, BOOL, STRING;
		
	public static Type parse(String source)
	{
		switch(source)
		{
			case "int":
				return INT;
			case "boolean":
				return BOOL;
			default:
				// error in the document
				return null;
				// throw new Exception("Unknown type " + source + " found.");
		}
	}

	public static Type translate(LiteralExpr expr)
	{
		if(expr instanceof Bool)
			return BOOL;
		else if(expr instanceof Int)
			return INT;
		else
			// error in our code
			throw new Error("An unknown literal type is in the AST.");
	}
	
	public String toString()
	{
		switch(this)
		{
			case INT:
				return "int";
			case BOOL:
				return "boolean";
			default:
				throw new Error("This is impossible.");
		}
	}
}
