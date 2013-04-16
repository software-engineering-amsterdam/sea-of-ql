package nl.stgm.ql.interpreter;

import java.util.Stack;
import java.awt.*;
import java.awt.event.*;

public class AWTUIController
{
	InterpreterApplication delegate;
	Frame window;
	AWTForm form;
	private Stack<AWTForm> parents = new Stack<AWTForm>();
	
	public AWTUIController(InterpreterApplication delegate)
	{
		this.delegate = delegate;
		
		window = new Frame("Aangifteprogramma");
		window.setMinimumSize(new Dimension(800,600));
		window.add(new AWTPrevNextPanel(delegate), BorderLayout.SOUTH);
	}
	
	public void show()
	{
		window.setVisible(true);
	}
	
	public void pushParent(AWTForm f)
	{
		parents.push(f);
	}
	
	public void popParent()
	{
		parents.pop();
	}
	
	public void clear()
	{
		window.remove(form);
	}

	public void validate()
	{
		window.pack();
	}

	public AWTCheckbox createCheckbox(String id)
	{
		AWTCheckbox elt = new AWTCheckbox(delegate, id);
		add(elt);
		return elt;
	}
	
	public AWTTextField createTextField(String id)
	{
		AWTTextField elt = new AWTTextField(delegate, id);
		add(elt);
		return elt;
	}
	
	public AWTLabel createLabel() // TODO not using ID
	{
		AWTLabel elt = new AWTLabel(delegate);
		add(elt);
		return elt;
	}
	
	public AWTForm createForm() // TODO not using ID
	{
		AWTForm elt = new AWTForm(delegate);
		add(elt);
		return elt;
	}
	
	public AWTForm createConditional() // TODO not using ID
	{
		AWTForm elt = new AWTForm(delegate);
		add(elt);
		return elt;
	}

	private void add(IUIElement e)
	{
		if(parents.empty())
		{
			// first element is the parent form
			assert e instanceof AWTForm;
			this.form = (AWTForm) e;
			window.add((AWTForm)e, BorderLayout.CENTER);
		}
		else
		{
			// sub elements
			parents.peek().addElement(e);
		}
	}
}
