package nl.stgm.ql.interpreter;

import java.util.Map;
import java.util.HashMap;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.interpreter.awtui.*;

public class InterpreterViewUpdater implements Visitor
{
	private Form form;
	private InterpreterContext context;
	private InterpreterMapping mapping;
	private PagedUIController ui;

	// TODO should probably be moved to view because we shouldn't know view state
	private Map<Conditional,Boolean> conditionalValues = new HashMap<Conditional,Boolean>();

	public InterpreterViewUpdater(Form form, InterpreterContext context, InterpreterMapping mapping, PagedUIController ui)
	{
		this.form = form;
		this.context = context;
		this.mapping = mapping;
		this.ui = ui;
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
		AWTConditional uiElt = (AWTConditional) mapping.get(c);
		Value v = c.condition().getValue(context);

		if(v.getType().isUnknown())
		{
			uiElt.displayPart(false);
		}
		else
		{
			Boolean prev = conditionalValues.get(c);
			Boolean curr = ((Bool) v).getValue();
			if(prev != curr)
			{
				conditionalValues.put(c, curr);
				uiElt.displayPart(curr);
			}
		}
		
		for(Question q: c.ifQuestions())
			q.accept(this);
		
		for(Question q: c.elseQuestions())
			q.accept(this);
	}
	
	public void visit(BoolQuestion q)
	{
		AWTCheckbox uiElt = (AWTCheckbox) mapping.get(q);
		
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
		AWTTextField uiElt = (AWTTextField) mapping.get(q);
		
		if(context.hasValue(q.id()))
			uiElt.update(context.getValue(q.id()).toString());
		else
			uiElt.update("");
	}
	
	public void visit(CalcQuestion cq)
	{
		AWTLabel uiElt = (AWTLabel) mapping.get(cq);

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
