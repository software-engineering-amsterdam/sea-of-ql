package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.interpreter.awtui.*;

import java.util.List;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class InterpreterViewManager implements Visitor, PagedUIDelegate
{
	private Document document;
	private PagedUIController ui;
	
	private InterpreterContext context = new InterpreterContext();
	private InterpreterMapping mapping = new InterpreterMapping();
	private InterpreterViewUpdater updater;

	private List<Form> forms = new Vector<Form>();
	private int currentForm;
	private UIContainerElement parent;
	
	public InterpreterViewManager(Document document, PagedUIController ui)
	{
		this.document = document;
		this.context = context;
		this.ui = ui;

		// gather all forms
		this.document.accept(this);

		// set initial state
		if(this.forms.size() > 0)
			this.currentForm = 0;
		else
			// no forms in document
		System.out.println("no valid forms found...");

		this.createForm();

		ui.registerPagingDelegate(this);
	}
	
	//
	//
	//
	//
	//  FORM MANAGEMENT
	//

	public void nextClicked()
	{
		if(hasNextForm())
		{
			ui.clear();
			nextForm();
			// this.update();
		}	
	}
	
	public void previousClicked()
	{
		if(hasPreviousForm())
		{
			ui.clear();
			previousForm();
			// this.update();
		}
	}

	public boolean hasNextForm()
	{
		return currentForm < forms.size() - 1;
	}
	
	public void nextForm()
	{
		currentForm++;
		createForm();
	}
	
	public boolean hasPreviousForm()
	{
		return currentForm > 0;
	}
	
	public void previousForm()
	{
		currentForm--;
		createForm();
	}
	
	private void createForm()
	{
		Form form = forms.get(currentForm);
		
		// clear temporary data
		mapping.clear();
		
		// create updater
		this.updater = new InterpreterViewUpdater(form, context, mapping, ui);
		ui.registerDelegate(updater);

		// build form ui
		parent = ui.getContainer();
		form.accept(this);
		
		// load initial form values
		updater.update();
	}
	
	public void update()
	{
		updater.update();
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
