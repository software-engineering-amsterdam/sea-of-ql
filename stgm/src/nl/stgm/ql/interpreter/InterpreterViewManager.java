package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.interfaces.*;

import java.util.List;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class InterpreterViewManager implements Visitor
{
	private PagedUIDelegate delegate;
	private Document document;
	private InterpreterContext context;
	private PagedUIController ui;
	private InterpreterMapping mapping;

	private InterpreterFormList forms;
	private UIElementContainer parent;
	
	public InterpreterViewManager(PagedUIDelegate delegate, Document document, InterpreterContext context, PagedUIController ui)
	{
		this.delegate = delegate;
		this.document = document;
		this.context = context;
		this.ui = ui;
		this.mapping = new InterpreterMapping();
	}
	
	public InterpreterFormList getFormList()
	{
		if(this.forms == null)
		{
			this.forms = new InterpreterFormList();
			this.document.accept(this);
		}

		if(this.forms.size() == 0)
		{
			throw new Error("Got an empty document.");
		}
		
		return this.forms;
	}
	
	public InterpreterViewUpdater load(Form form)
	{
		// clear temporary data
		mapping.clear();
		ui.clear();

		// build form ui
		parent = ui.getContainer();
		form.accept(this);

		// create updater
		InterpreterViewUpdater updater = new InterpreterViewUpdater(form, context, mapping);
		return updater;
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
			this.forms.add(f);
	}

	public void visit(Form form)
	{
		UIElementContainer uiElt = ui.createForm();
		parent.addElement(uiElt);
		parent = uiElt;

		for(FormItem item: form.formItems())
			item.accept(this);
	}
	
	public void visit(Conditional c)
	{
		UIElementConditional uiElt = ui.createConditional();
		UIElementContainer prev = parent;
		
		mapping.put(c, uiElt);
		parent.addElement(uiElt);

		parent = uiElt.truePart();
		for(Question q: c.ifQuestions())
			q.accept(this);

		if(c.hasElse())
		{
			parent = uiElt.falsePart();
			for(Question q: c.elseQuestions())
				q.accept(this);
		}
		
		parent = prev;
	}
	
	public void visit(BoolQuestion q)
	{
		UIElementBool uiElt = ui.createCheckbox(q.id(), q.question());
		mapping.put(q, uiElt);
		parent.addElement(uiElt);
	}
	
	public void visit(IntQuestion q)
	{
		UIElementInt uiElt = ui.createTextField(q.id(), q.question());
		mapping.put(q, uiElt);
		parent.addElement(uiElt);
	}
	
	public void visit(CalcQuestion q)
	{
		UIElementLabel uiElt = ui.createLabel(q.question());
		mapping.put(q, uiElt);
		parent.addElement(uiElt);
	}
}