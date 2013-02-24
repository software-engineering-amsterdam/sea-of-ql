package khosrow.uva.sea.ql.ui.controls;

public interface IControlVisitor<T> {
	public T visit(IntControl widget);
	public T visit(MoneyControl widget);
	public T visit(StringControl widget);
	public T visit(BoolControl widget);
}
