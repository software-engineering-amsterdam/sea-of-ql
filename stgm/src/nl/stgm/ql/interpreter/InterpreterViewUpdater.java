package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;

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
		Value v = c.getConditionExpr().getValue(context);

		if(v.getType().isUnknown())
			uiElt.displayPart(false);
		else
			uiElt.displayPart(((Bool) v).getValue());

		for(Question q: c.getIfQuestions())
			q.accept(this);
		
		for(Question q: c.getElseQuestions())
			q.accept(this);
	}
	
	public void visit(BoolQuestion q)
	{
		UIElementBool uiElt = (UIElementBool) mapping.get(q);
		
		if(context.hasValue(q.getID()))
		{
			Bool val = (Bool) context.getValue(q.getID());
			uiElt.update(val.getValue());
		}
		
		// do not update if no value found (allows for default state other than false)
	}
	
	public void visit(IntQuestion q)
	{
		UIElementText uiElt = (UIElementText) mapping.get(q);
		
		if(context.hasValue(q.getID()))
			uiElt.update(context.getValue(q.getID()).toString());
		else
			uiElt.update("");
	}
	
	public void visit(CalcQuestion cq)
	{
		UIElementLabel uiElt = (UIElementLabel) mapping.get(cq);
		Value value = cq.getCalculationExpr().getValue(context);
		
		if(value.getType().isUnknown())
			uiElt.update("");
		else
			uiElt.update(value.toString());
	}
}
