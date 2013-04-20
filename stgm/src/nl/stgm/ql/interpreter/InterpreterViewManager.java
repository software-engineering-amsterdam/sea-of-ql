package nl.stgm.ql.interpreter;

import java.util.List;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.interpreter.awtui.*;

public class InterpreterViewManager implements Visitor
{
	private Document document;
	private InterpreterContext context;
	private PagedUIController ui;
	
	private InterpreterMapping mapping = new InterpreterMapping();
	private InterpreterViewUpdater updater;

	private Map<Conditional,Boolean> conditionalValues = new HashMap<Conditional,Boolean>();

	private List<Form> forms = new Vector<Form>();
	private int currentForm;
	
	public InterpreterViewManager(Document document, InterpreterContext context, PagedUIController ui)
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
	}
	
	//
	//
	//
	//
	//  FORM MANAGEMENT
	//

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
		this.clear();
		
		// build form ui
		form.accept(this);
		
		// create updater
		this.updater = new InterpreterViewUpdater(form, context, mapping, ui);
			
		// load initial form values
		updater.update();
	}
	
	private void clear()
	{
		conditionalValues.clear();
		mapping.clear();
	}
	
	public void update()
	{
		updater.update();
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

		ui.pushParent(uiElt);
		for(FormItem item: form.formItems())
			item.accept(this);
		ui.popParent();
	}
	
	public void visit(Conditional c)
	{
		AWTConditional uiElt = (AWTConditional) ui.createConditional();
		mapping.put(c, uiElt);

		ui.pushParent(uiElt.truePart());
		for(Question q: c.ifQuestions())
			q.accept(this);
		ui.popParent();

		if(c.hasElse())
		{
			ui.pushParent(uiElt.falsePart());
			for(Question q: c.elseQuestions())
				q.accept(this);
			ui.popParent();
		}
	}
	
	public void visit(BoolQuestion q)
	{
		AWTCheckbox uiElt = (AWTCheckbox) ui.createCheckbox(q.id(), q.question());
		mapping.put(q, uiElt);
	}
	
	public void visit(IntQuestion q)
	{
		AWTTextField uiElt = (AWTTextField) ui.createTextField(q.id(), q.question());
		mapping.put(q, uiElt);
	}
	
	public void visit(CalcQuestion q)
	{
		AWTLabel uiElt = (AWTLabel) ui.createLabel(q.question());
		mapping.put(q, uiElt);
	}
}
