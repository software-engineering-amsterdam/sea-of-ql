package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class AWTFormController implements ItemListener, Visitor
{
	ApplicationController delegate;
	InterpreterForm form;
	Panel panel;
	
	public AWTFormController(ApplicationController delegate, InterpreterForm form)
	{
		this.delegate = delegate;
		this.form = form;
		
		this.panel = new Panel();
		this.panel.setPreferredSize(new Dimension(800, 600));
		this.panel.setLayout(new GridLayout(6, 2));
		
		this.update();
	}
	
	public Panel getPanel()
	{
		return this.panel;
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		System.out.println("check!");
	}
	
	public void update()
	{
		// reload controls from model
		panel.removeAll();
		form.getForm().accept(this);
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
		// Bool v = (Bool) c.condition().reduceValue(context);
		
		if(true)
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
				TextField tf = new TextField("", 7);
				this.panel.add(tf);
				break;
			case BOOL:
				Checkbox checkbox = new Checkbox(q.question());
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
		Label answer = new Label("0");
		this.panel.add(answer);
	}
	
	public void visit(Expr e)
	{
	}
}
