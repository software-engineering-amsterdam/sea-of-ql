package nl.stgm.ql.interpreter;

import java.util.Vector;
import java.util.HashMap;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

//
//
//
//
//  CONTAINS AST VISITOR + CONTEXT
//

public class InterpreterDocument implements Visitor
{
	private Document document;
	private AWTUIController ui;
	
	private InterpreterContext context;
	private HashMap<AbstractNode,IUIElement> map = new HashMap<AbstractNode,IUIElement>();
	private HashMap<Conditional,Boolean> conditionalValues = new HashMap<Conditional,Boolean>();
	private Vector<Form> forms = new Vector<Form>();
	private int currentForm;
	
	public InterpreterDocument(Document document, AWTUIController ui)
	{
		this.document = document;
		this.ui = ui;
		this.context = new InterpreterContext();
	 
		// gather all forms
		this.document.accept(this);
	}
	
	public boolean hasNextForm()
	{
		return currentForm < forms.size() - 1;
	}
	
	public void nextForm()
	{
		currentForm++;
		clear();
	}
	
	public boolean hasPreviousForm()
	{
		return currentForm > 0;
	}
	
	public void previousForm()
	{
		currentForm--;
		clear();
	}
	
	private void clear()
	{
		map.clear();
		this.update();
	}
	
	public void update()
	{
		// updates ui from current form
		forms.get(currentForm).accept(this);
	}
	
	public void putValue(String name, Value value)
	{
		context.putValue(name, value);
	}

	//
	//
	//
	//
	//  VISITEUR
	//

	public void visit(Document d)
	{
		// gather forms from document
		for(Form f: d.forms())
		{
			this.forms.add(f);
		}

		// set initial state
		if(this.forms.size() > 0)
		{
			this.currentForm = 0;
		}
		else
		{
			// no forms in document
			System.out.println("no valid forms found...");
		}
	}

	public void visit(Form form)
	{
		AWTForm uiElt = (AWTForm) map.get(form);
		if(uiElt == null)
		{
			uiElt = ui.createForm();
			map.put(form, uiElt);
		}

		ui.pushParent(uiElt);
		for(FormItem item: form.formItems())
			item.accept(this);
		ui.popParent();
	}
	
	public void visit(Conditional c)
	{
		AWTForm uiElt = (AWTForm) map.get(c);
		if(uiElt == null)
		{
			uiElt = ui.createForm();
			map.put(c, uiElt);
		}

		ui.pushParent(uiElt);

		Value v = c.condition().reduceValue(context);
		Bool condition;
		if(v.isUnknown())
			condition = new Bool(false);
		else
			condition = (Bool) v;
		
		
		if(condition.getValue() == true)
		{
			if(conditionalValues.get(c) != null && conditionalValues.get(c) == false)
			{
				// map.remove()
				uiElt.clear();
			}
			conditionalValues.put(c, true);
				
			for(Question q: c.ifQuestions())
				q.accept(this);
		}
		else
		{
			if(conditionalValues.get(c) != null && conditionalValues.get(c) == true)
			{
				uiElt.clear();
				System.out.println("CLEAR!!!");
			}
			conditionalValues.put(c, false);
				
			if(c.hasElse())
				for(Question q: c.elseQuestions())
					q.accept(this);
		}
		
		ui.popParent();
	}
	
	public void visit(BoolQuestion q)
	{
		AWTCheckbox uiElt = (AWTCheckbox) map.get(q);
		if(uiElt == null)
		{
			uiElt = ui.createCheckbox(q.id());
			map.put(q, uiElt);
		}
		
		if(context.hasValue(q.id()))
		{
			Bool val = (Bool) context.lookupValue(q.id());
			uiElt.update(q.question(), val.getValue());
		}
		else
		{
			uiElt.update(q.question(), false);
		}
	}
	
	public void visit(IntQuestion q)
	{
		AWTTextField uiElt = (AWTTextField) map.get(q);
		if(uiElt == null)
		{
			uiElt = ui.createTextField(q.id());
			map.put(q, uiElt);
		}
		
		if(context.hasValue(q.id()))
			uiElt.update(q.question(), context.lookupValue(q.id()).toString());
		else
			uiElt.update(q.question(), "");
	}
	
	public void visit(CalcQuestion cq)
	{
		AWTLabel uiElt = (AWTLabel) map.get(cq);
		if(uiElt == null)
		{
			uiElt = ui.createLabel();
			map.put(cq, uiElt);
		}

		try
		{
			uiElt.update(cq.question(), cq.calculation().reduceValue(context).toString());
		}
		catch(ClassCastException e)
		{
			uiElt.update(cq.question(), "");
		}
	}
}
