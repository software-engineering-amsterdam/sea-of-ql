package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;

public class IntQuestion extends Question
{
	public IntQuestion(String id, String question)
	{
		super(id, question);
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
