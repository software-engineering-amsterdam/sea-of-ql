package khosrow.uva.sea.ql.ui.controls;

public interface IControlVisitor<T> {
	public T visit(IntWidget widget);
	public T visit(MoneyWidget widget);
	public T visit(StringWidget widget);
	public T visit(BoolWidget widget);
}
