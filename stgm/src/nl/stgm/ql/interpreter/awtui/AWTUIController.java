package nl.stgm.ql.interpreter.awtui;

import nl.stgm.ql.interpreter.*;

import java.util.Stack;
import java.awt.*;
import java.awt.event.*;

public class AWTUIController implements PagedUIController
{
	PagedUIDelegate delegate;
	Frame window;
	AWTForm form;
	private Stack<AWTForm> parents = new Stack<AWTForm>();
	
	public AWTUIController(PagedUIDelegate delegate)
	{
		this.delegate = delegate;
		
		window = new Frame("Aangifteprogramma");
		window.setMinimumSize(new Dimension(800,600));
		window.add(new AWTPrevNextPanel(delegate), BorderLayout.SOUTH);
		window.add(new AWTLogo(), BorderLayout.NORTH);
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
		window.validate();
	}

	public AWTCheckbox createCheckbox(String id, String label)
	{
		AWTCheckbox elt = new AWTCheckbox(delegate, id, label);
		add(elt);
		return elt;
	}
	
	public AWTTextField createTextField(String id, String label)
	{
		AWTTextField elt = new AWTTextField(delegate, id, label);
		add(elt);
		return elt;
	}
	
	public AWTLabel createLabel(String label)
	{
		AWTLabel elt = new AWTLabel(label);
		add(elt);
		return elt;
	}
	
	public AWTForm createForm()
	{
		AWTForm elt = new AWTForm(delegate);
		add(elt);
		return elt;
	}
	
	public AWTConditional createConditional()
	{
		AWTConditional elt = new AWTConditional(delegate, new AWTForm(delegate), new AWTForm(delegate));
		add(elt);
		return elt;
	}

	private void add(UIElement e)
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
