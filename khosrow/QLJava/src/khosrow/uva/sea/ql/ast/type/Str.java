package khosrow.uva.sea.ql.ast.type;

public class Str extends Type {

	@Override
	public boolean IsCompatibleTo(Type t) {		
		return t.IsCompatibleToStr();
	}
	
	@Override
	public boolean IsCompatibleToStr() {
		return true;
	}
}
