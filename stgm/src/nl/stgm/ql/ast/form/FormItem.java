package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.checker.*;

public abstract class FormItem extends AbstractElement
{
	public abstract void check(SemanticChecker context);
}
