package nl.stgm.ql.interpreter;

import java.util.HashMap;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.data.*;

import nl.stgm.ql.inspectors.*;

public class InterpreterMapping
{
	// private HashMap<AbstractNode,IUIElement> map = new HashMap<AbstractNode,IUIElement>();
	// private AWTUIController ui;
	// 
	// public InterpreterMapping(AWTUIController ui)
	// {
	// 	this.ui = ui;
	// }
	// 
	// public void add(AbstractNode n, IUIElement e)
	// {
	// 	map.put(n, e);
	// }
	// 
	// public void clear()
	// {
	// 	map.clear();
	// }
	// 
	// public IUIElement findOrCreate(Form form)
	// {
	// 	AWTForm uiElt = map.get(form);
	// 	if(uiElt == null)
	// 	{
	// 		uiElt = ui.createForm();
	// 		map.put(form, uiElt)
	// 	}
	// 	return uiElt;
	// }
	// 
	// public IUIElement findOrCreate(Conditional c)
	// {
	// 	AWTForm uiElt = map.get(c);
	// 	if(uiElt == null)
	// 	{
	// 		uiElt = ui.createForm();
	// 		map.put(c, uiElt)
	// 	}
	// 	return uiElt;
	// }
	// 
	// public IUIElement findOrCreate(Question q)
	// {
	// 	AWTCheckbox uiElt = map.get(q);
	// 	if(uiElt == null)
	// 	{
	// 		uiElt = ui.createForm();
	// 		map.put(q, uiElt)
	// 	}
	// 	return uiElt;
	// }
	// 
}
