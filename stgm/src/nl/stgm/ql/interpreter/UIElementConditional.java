package nl.stgm.ql.interpreter;

public interface UIElementConditional extends UIElement
{
	public UIElementContainer truePart();
	public UIElementContainer falsePart();
	public void displayPart(boolean whichPart);
}
