package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.interpreter.awtui.*;

import java.util.Map;
import java.util.HashMap;

public class InterpreterViewUpdater implements Visitor, UIDelegate
{
	private Form form;
	private InterpreterContext context;
	private InterpreterMapping mapping;
	private PagedUIController ui;

	public InterpreterViewUpdater(Form form, InterpreterContext context, InterpreterMapping mapping, PagedUIController ui)
	{
		this.form = form;
		this.context = context;
		this.mapping = mapping;
		this.ui = ui;
	}

	public void answerChanged(String id, Integer value)
	{
		if(value == null)
			context.removeValue(id);
		else
			context.putValue(id, new Int(value));
		
		this.update();
	}
	
	public void answerChanged(String id, boolean value)
	{
		context.putValue(id, new Bool(value));
		this.update();
	}

	public void update()
	{
		form.accept(this);
		ui.validate();
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
