package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class AWTFormController implements Visitor
{
	ApplicationController delegate;
	InterpreterForm form;
	Panel panel;
	
	public AWTFormController(ApplicationController delegate, InterpreterForm form)
	{
		this.delegate = delegate;
		this.form = form;
		
		this.panel = new Panel(new GridLayout(6, 2));
		this.panel.setPreferredSize(new Dimension(800, 600));
		
		this.update();
	}
	
	public Panel getPanel()
	{
		return this.panel;
	}
	
	public void update()
	{
		// reload controls from model
		panel.removeAll();
		form.getForm().accept(this);
	}
	
	public void addQuestion(Question q)
	{
		
	}

	//
	//
	//
	//   VISITEUR
	//

	public void visit(Document d)
	{
		// nothing to do
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
			v = (Bool) c.condition().reduceValue(form.context());
		}
		catch(NullPointerException e)
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
		// add question box
		switch(q.type())
		{
			case INT:
				Label label = new Label(q.question());
				this.panel.add(label);
				AWTTextField tf = new AWTTextField(delegate, q, (Int)form.context().getValue(q.id()));
				this.panel.add(tf);
				break;
			case BOOL:
				AWTCheckbox checkbox = new AWTCheckbox(delegate, q, (Bool)form.context().getValue(q.id()));
				this.panel.add(checkbox);
				Label answer = new Label("");
				this.panel.add(answer);
				break;
		}
	}
	
	public void visit(CalcQuestion cq)
	{
		// add label
		Label label = new Label(cq.question());
		this.panel.add(label);
		
		try
		{
			Int v = (Int) cq.calculation().reduceValue(form.context());
			if(v != null)
			{
				Label answer = new Label(v.toString());
				this.panel.add(answer);
			}
		}
		catch(NullPointerException e) {}
	}
	
	public void visit(Expr e)
	{
	}
}
