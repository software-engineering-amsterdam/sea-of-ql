package khosrow.uva.sea.ql.ui;

import khosrow.uva.sea.ql.ast.type.*;
import khosrow.uva.sea.ql.ui.controls.Control;
import khosrow.uva.sea.ql.visitor.ITypeVisitor;

public class TypeToSwingWidget implements ITypeVisitor<Control>{

	private TypeToSwingWidget(){}
	
	public static Control convert(Type type) {
		TypeToSwingWidget typeToWidget = new TypeToSwingWidget();
		return type.accept(typeToWidget);
	}

	@Override
	public Control visit(Int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Control visit(Money type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Control visit(Bool type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Control visit(Str type) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}
