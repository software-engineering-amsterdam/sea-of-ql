package nl.stgm.ql.ast;

public interface Visitable
{
	public abstract void accept(Visitor visitor);
}
