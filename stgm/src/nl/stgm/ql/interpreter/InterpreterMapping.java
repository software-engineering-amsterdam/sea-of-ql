package nl.stgm.ql.interpreter;

import java.util.HashMap;

import nl.stgm.ql.ast.*;

import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.data.*;

import nl.stgm.ql.inspectors.*;

public class InterpreterMapping
{
	private HashMap<AbstractNode,IUIElement> map = new HashMap<AbstractNode,IUIElement>();
	private InterpreterApplication delegate;
	
	public InterpreterMapping(InterpreterApplication delegate)
	{
		this.delegate = delegate;
	}

	public AWTCheckbox findOrCreateCheckbox(Question n)
	{
		AWTCheckbox elt = (AWTCheckbox) map.get(n);
		if(elt == null)
		{
			elt = new AWTCheckbox(delegate, n.id());
			map.put(n, elt);
		}
		return elt;
	}
	
	public AWTTextField findOrCreateTextField(Question n)
	{
		AWTTextField elt = (AWTTextField) map.get(n);
		if(elt == null)
		{
			elt = new AWTTextField(delegate, n.id());
			map.put(n, elt);
		}
		return elt;
	}
	
	public AWTLabel findOrCreateLabel(CalcQuestion n)
	{
		AWTLabel elt = (AWTLabel) map.get(n);
		if(elt == null)
		{
			elt = new AWTLabel(delegate);
			map.put(n, elt);
		}
		return elt;
	}
	
	public AWTForm findOrCreateForm(Conditional n)
	{
		AWTForm elt = (AWTForm) map.get(n);
		if(elt == null)
		{
			elt = new AWTForm(delegate);
			map.put(n, elt);
		}
		return elt;	
	}
}
