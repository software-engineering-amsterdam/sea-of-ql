package nl.stgm.ql.ast;

import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public abstract class AbstractNode implements Printable, Checkable, Interpretable
{
	// hint:
	// public abstract void print(PrettyPrinter context);
	// public abstract void check(Checker context);
	// public abstract void interpret(Interpreter context);
}
