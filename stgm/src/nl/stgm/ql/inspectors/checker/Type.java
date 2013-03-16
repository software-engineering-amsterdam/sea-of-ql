package nl.stgm.ql.inspectors.checker;

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
		if(expr instanceof Bool)
			return Type.BOOL;
		else if(expr instanceof Int)
			return Type.INT;
		else
			return null;
	}
}
