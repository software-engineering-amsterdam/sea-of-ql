package nl.stgm.ql.interpreter;

import java.util.Vector;

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
	private InterpreterApplication delegate;
	private Document document;
	private AWTUIController ui;
	
	private InterpreterContext context;
	private InterpreterMapping mapping;
	
	private Vector<Form> forms = new Vector<Form>();
	private int currentForm;
	
	public InterpreterDocument(InterpreterApplication delegate, Document document, AWTUIController ui)
	{
		this.delegate = delegate;
		this.document = document;
		this.ui = ui;

		this.context = new InterpreterContext();
		this.mapping = new InterpreterMapping(delegate);
	 
		// gather all forms
		this.document.accept(this);
	}
	
	public void update()
	{
		// clear ui
		// mapping = new InterpreterMapping(delegate);
		ui.clear();
		
		// generate ui for current form
		forms.get(currentForm).accept(this);
		
		// validate ui
		ui.validate();
	}
	
	public boolean hasNextForm()
	{
		return currentForm < forms.size() - 1;
	}
	
	public void nextForm()
	{
		System.out.println("next");
		assert hasNextForm();
		currentForm++;
		update();
	}
	
	public boolean hasPreviousForm()
	{
		return currentForm > 0;
	}
	
	public void previousForm()
	{
		System.out.println("prev");
		assert hasPreviousForm();
		currentForm--;
		update();
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
		}
	}

	public void visit(Form f)
	{
		for(FormItem fi: f.formItems())
		{
			fi.accept(this);
		}
	}
	
	public void visit(Conditional c)
	{
		Bool v;
		
		try
		{
			v = (Bool) c.condition().reduceValue(context);
		}
		catch(ClassCastException e) // !! TODO !!
		{
			v = new Bool(false);
		}

		if(v != null && v.getValue())
		{
			for(Question q: c.ifQuestions())
				q.accept(this);
		}
		else
		{
			if(c.hasElse())
				for(Question q: c.elseQuestions())
					q.accept(this);
		}
	}
	
	public void visit(Question q)
	{
		System.out.println(q);
		
		if(q.type() == Type.BOOL)
		{
			AWTCheckbox uiElt = mapping.findOrCreateCheckbox(q);
			ui.addElement(uiElt);
			Value value = context.lookupValue(q.id());

			System.out.println(value.getType());
			if(value.getType() == Type.UNKNOWN)
			{
				uiElt.update(q.question(), false);
			}
			else
			{
				Bool val = (Bool) value;
				uiElt.update(q.question(), val.getValue());
			}
		}
		
		if(q.type() == Type.INT)
		{
			AWTTextField uiElt = mapping.findOrCreateTextField(q);
			ui.addElement(uiElt);
			Value value = context.lookupValue(q.id());

			if(value.getType() == Type.UNKNOWN)
			{
				uiElt.update(q.question(), "");
			}
			else
			{
				Int val = (Int) value;
				uiElt.update(q.question(), Integer.toString(val.getValue()));
			}
		}
	}
	
	public void visit(CalcQuestion cq)
	{
		AWTLabel uiElt = mapping.findOrCreateLabel(cq);
		ui.addElement(uiElt);

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
