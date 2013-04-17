package nl.stgm.ql.interfaces;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

public interface Visitor
{
	public void visit(Document d);
	public void visit(Form f);
	public void visit(Conditional c);
	public void visit(IntQuestion q);
	public void visit(BoolQuestion q);
	public void visit(CalcQuestion cq);
}
