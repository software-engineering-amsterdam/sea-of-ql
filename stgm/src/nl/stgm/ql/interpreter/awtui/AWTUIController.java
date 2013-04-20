package nl.stgm.ql.interpreter.awtui;

import nl.stgm.ql.interpreter.*;

import java.util.Stack;
import java.awt.*;
import java.awt.event.*;

public class AWTUIController implements PagedUIController
{
	PagedUIDelegate pagingDelegate;
	UIDelegate uiDelegate;
	
	AWTWindow window = new AWTWindow("Aangifteprogramma");
	AWTForm form;
	
	public void registerPagingDelegate(PagedUIDelegate pagingDelegate)
	{
		this.pagingDelegate = pagingDelegate;
	}
	
	public void registerDelegate(UIDelegate uiDelegate)
	{
		this.uiDelegate = uiDelegate;
	}
	
	public void show()
	{
		window.add(new AWTPrevNextPanel(pagingDelegate), BorderLayout.SOUTH);
		window.add(new AWTLogo(), BorderLayout.NORTH);
		window.setVisible(true);
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
	
	public UIContainerElement getContainer()
	{
		return this.window;
	}

	public AWTCheckbox createCheckbox(String id, String label)
	{
		return new AWTCheckbox(uiDelegate, id, label);
	}
	
	public AWTTextField createTextField(String id, String label)
	{
		return new AWTTextField(uiDelegate, id, label);
	}
	
	public AWTLabel createLabel(String label)
	{
		return new AWTLabel(label);
	}
	
	public AWTForm createForm()
	{
		AWTForm elt = new AWTForm(uiDelegate);
		this.form = elt;
		window.add(elt, BorderLayout.CENTER);
		return elt;
	}
	
	public AWTConditional createConditional()
	{
		return new AWTConditional(uiDelegate);
	}
}
