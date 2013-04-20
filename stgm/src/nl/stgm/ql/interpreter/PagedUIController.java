package nl.stgm.ql.interpreter;

import java.util.Stack;
import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.interpreter.awtui.*;

public interface PagedUIController
{
	public void show();
	public void clear();
	public void validate();
	public UIContainerElement getContainer();

	public void registerPagingDelegate(PagedUIDelegate pagingDelegate);
	public void registerDelegate(UIDelegate uiDelegate);

	public AWTCheckbox createCheckbox(String id, String label);
	public AWTTextField createTextField(String id, String label);
	public AWTLabel createLabel(String label);
	public AWTForm createForm();
	public AWTConditional createConditional();
}
