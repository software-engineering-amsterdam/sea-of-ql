package nl.stgm.ql.interpreter;

import java.util.Stack;
import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.interpreter.awtui.*;

public interface PagedUIController
{
	public void show();

	public void pushParent(AWTForm f);
	public void popParent();

	public void clear();
	public void validate();

	public AWTCheckbox createCheckbox(String id);
	public AWTTextField createTextField(String id);
	public AWTLabel createLabel();
	public AWTForm createForm();
	public AWTConditional createConditional();
}
