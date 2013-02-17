package org.uva.sea.ql.visitor.evaluator;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.ui.control.LabelControl;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.visitor.TypeVisitor;
import org.uva.sea.ql.visitor.evaluator.value.Value;

class ControlRenderer implements TypeVisitor<Control> {
	private final ControlFactory factory;

	public ControlRenderer( ControlFactory factory ) {
		this.factory = factory;
	}

	public PanelControl createPanel() {
		return this.factory.createPanel();
	}

	public LabelControl createLabel( String label ) {
		return this.factory.createLabel( label );
	}

	public Control createEditableControlFromType( Type type, Value value ) {
		return this.createControlFromType( type, value, true );
	}

	public Control createReadOnlyControlFromType( Type type, Value value ) {
		return this.createControlFromType( type, value, false );
	}

	private Control createControlFromType( Type type, Value value, boolean editable ) {
		Control component = type.accept( this );
		component.setEnabled( editable );
		component.setValue( value );
		return component;
	}

	@Override
	public Control visit( BooleanType node ) {
		return this.factory.createCheckBox();
	}

	@Override
	public Control visit( IntegerType node ) {
		return this.factory.createNumberBox();
	}

	@Override
	public Control visit( StringType node ) {
		return this.factory.createTextBox();
	}

	@Override
	public Control visit( MoneyType node ) {
		return this.factory.createMoneyBox();
	}
}
