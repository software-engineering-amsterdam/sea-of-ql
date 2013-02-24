package khosrow.uva.sea.ql.ui;

import khosrow.uva.sea.ql.ast.type.*;
import khosrow.uva.sea.ql.ui.controls.*;
import khosrow.uva.sea.ql.visitor.ITypeVisitor;

public class TypeToSwingWidget implements ITypeVisitor<Control>{

	private TypeToSwingWidget(){}
	
	public static Control convert(Type type) {
		TypeToSwingWidget typeToWidget = new TypeToSwingWidget();
		return type.accept(typeToWidget);
	}

	@Override
	public Control visit(Int type) {
		return new IntControl();
	}

	@Override
	public Control visit(Money type) {
		return new MoneyControl();
	}

	@Override
	public Control visit(Bool type) {
		return new BoolControl();
	}

	@Override
	public Control visit(Str type) {
		return new StringControl();
	}	
	
	
}
