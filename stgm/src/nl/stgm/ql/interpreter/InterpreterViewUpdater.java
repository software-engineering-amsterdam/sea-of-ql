package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class InterpreterViewUpdater implements Visitor
{
	private Form form;
	private InterpreterContext context;
	private InterpreterMapping mapping;

	public InterpreterViewUpdater(Form form, InterpreterContext context, InterpreterMapping mapping)
	{
		this.form = form;
		this.context = context;
		this.mapping = mapping;
	}
	
	public void update()
	{
		form.accept(this);
	}

	//
	//
	//
	//
	//  VISITEUR
	//

	public void visit(Document d)
	{
	}

	public void visit(Form form)
	{
		for(FormItem item: form.formItems())
			item.accept(this);
	}
	
	public void visit(Conditional c)
	{
		UIElementConditional uiElt = (UIElementConditional) mapping.get(c);
		Value v = c.condition().getValue(context);

		if(v.getType().isUnknown())
			uiElt.displayPart(false);
		else
			uiElt.displayPart(((Bool) v).getValue());

		for(Question q: c.ifQuestions())
			q.accept(this);
		
		for(Question q: c.elseQuestions())
			q.accept(this);
	}
	
	public void visit(BoolQuestion q)
	{
		UIElementBool uiElt = (UIElementBool) mapping.get(q);
		
		if(context.hasValue(q.id()))
		{
			Bool val = (Bool) context.getValue(q.id());
			uiElt.update(val.getValue());
		}
		else
		{
			uiElt.update(false);
		}
	}
	
	public void visit(IntQuestion q)
	{
		UIElementText uiElt = (UIElementText) mapping.get(q);
		
		if(context.hasValue(q.id()))
			uiElt.update(context.getValue(q.id()).toString());
		else
			uiElt.update("");
	}
	
	public void visit(CalcQuestion cq)
	{
		UIElementLabel uiElt = (UIElementLabel) mapping.get(cq);

		try
		{
			uiElt.update(cq.calculation().getValue(context).toString());
		}
		catch(ClassCastException e)
		{
			uiElt.update("");
		}
	}
}
