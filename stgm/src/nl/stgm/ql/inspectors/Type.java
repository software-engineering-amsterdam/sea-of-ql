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
			case "string":
				return STRING;
		}
		return null;
	}

	public static Type translate(LiteralExpr expr)
	{
		if(expr instanceof nl.stgm.ql.ast.expr.literal.Bool)
			return BOOL;
		else if(expr instanceof nl.stgm.ql.ast.expr.literal.Int)
			return INT;
		else
			// not recoverable
			throw new Error("An unknown literal type is in the AST.");
	}
}
