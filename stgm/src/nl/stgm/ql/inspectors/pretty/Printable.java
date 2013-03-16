package nl.stgm.ql.inspectors.pretty;

public interface Printable
{
	// You will need to provide a toString() implementation for each
	// concrete descendant of this class. It will be printed upon encoutering
	// a node of that type.
	//
	// Alternatively, you can override print() to enable a more complex
	// printing flow, printing children first, or adding brackets.
	
	public void print(PrettyPrinter context);
	public String toString() throws UnsupportedOperationException;
}
