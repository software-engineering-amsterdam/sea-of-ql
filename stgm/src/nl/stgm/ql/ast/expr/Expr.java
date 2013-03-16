package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;

public abstract class Expr extends AbstractElement
{
	public abstract Identifier.Type getType(SemanticChecker context);
}
