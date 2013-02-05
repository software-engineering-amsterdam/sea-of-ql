package khosrow.uva.sea.ql.resources;

public interface ITypeCompatible {
	public boolean isCompatibleToInt();
	public boolean isCompatibleToBool();
	public boolean isCompatibleToMoney();
	public boolean isCompatibleToNumeric();
	public boolean isCompatibleToStr();
}
