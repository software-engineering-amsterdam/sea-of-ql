package nl.stgm.ql.inspectors;

public interface Visitable
{
	public abstract void accept(Visitor visitor);
}
