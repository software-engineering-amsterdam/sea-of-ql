package org.uva.sea.ql.gui.visitor;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.gui.elements.CheckBox;
import org.uva.sea.ql.gui.elements.Control;
import org.uva.sea.ql.gui.elements.TextField;
import org.uva.sea.ql.visitor.TypeVisitor;

public class TypeToWidgetVisitor implements TypeVisitor<Control>{
	
	public TypeToWidgetVisitor(){
		
	}
	
	@Override
	public Control visit(Type t) {
		System.out.println("Verkeerde");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Control visit(StrType s) {
		return new TextField();
	}

	@Override
	public Control visit(IntType i) {
		return new TextField();
	}

	@Override
	public Control visit(BoolType b) {
		return new CheckBox();
	}

	@Override
	public Control visit(NullType n) {
		// TODO Auto-generated method stub
		return null;
	}	


}
