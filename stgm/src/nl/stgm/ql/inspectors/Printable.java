package nl.stgm.ql.inspectors;

public interface Printable
{
	public void print(PrettyPrinter context);
	public String prettyString() throws UnsupportedOperationException;
}
