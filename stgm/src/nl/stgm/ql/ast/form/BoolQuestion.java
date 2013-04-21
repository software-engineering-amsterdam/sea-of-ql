package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;

public class BoolQuestion extends Question
{
	public BoolQuestion(String id, String question)
	{
		super(id, question);
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
