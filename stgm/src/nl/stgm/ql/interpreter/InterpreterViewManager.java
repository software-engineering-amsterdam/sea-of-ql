package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.interpreter.awtui.*;

import java.util.List;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class InterpreterViewManager implements Visitor
{
	private PagedUIDelegate delegate;
	private Document document;
	private PagedUIController ui;
	
	private InterpreterContext context;
	private InterpreterMapping mapping = new InterpreterMapping();

	private InterpreterFormList forms;
	private UIContainerElement parent;
	
	public InterpreterViewManager(PagedUIDelegate delegate, Document document, InterpreterContext context, PagedUIController ui)
	{
		this.delegate = delegate;
		this.document = document;
		this.context = context;
		this.ui = ui;
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
		AWTForm uiElt = (AWTForm) ui.createForm();
		parent.addElement(uiElt);
		parent = uiElt;

		for(FormItem item: form.formItems())
			item.accept(this);
	}
	
	public void visit(Conditional c)
	{
		AWTConditional uiElt = (AWTConditional) ui.createConditional();
		UIContainerElement prev = parent;
		
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
		AWTCheckbox uiElt = (AWTCheckbox) ui.createCheckbox(q.id(), q.question());
		mapping.put(q, uiElt);
		parent.addElement(uiElt);
	}
	
	public void visit(IntQuestion q)
	{
		AWTTextField uiElt = (AWTTextField) ui.createTextField(q.id(), q.question());
		mapping.put(q, uiElt);
		parent.addElement(uiElt);
	}
	
	public void visit(CalcQuestion q)
	{
		AWTLabel uiElt = (AWTLabel) ui.createLabel(q.question());
		mapping.put(q, uiElt);
		parent.addElement(uiElt);
	}
}
