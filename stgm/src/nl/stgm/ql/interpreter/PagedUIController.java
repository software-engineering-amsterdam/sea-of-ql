package nl.stgm.ql.interpreter;

import java.util.Stack;
import java.awt.*;
import java.awt.event.*;

public interface PagedUIController
{
	public void show();
	public void clear();
	public void validate();

	public UIElementContainer getContainer();

	public UIElementBool createCheckbox(String id, String label);
	public UIElementInt createTextField(String id, String label);
	public UIElementLabel createLabel(String label);
	public UIElementContainer createForm();
	public UIElementConditional createConditional();
}
