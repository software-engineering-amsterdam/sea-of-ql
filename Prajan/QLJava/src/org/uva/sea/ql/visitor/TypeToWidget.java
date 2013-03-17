package org.uva.sea.ql.visitor;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.alg.Bool;
import org.uva.sea.ql.ast.alg.Int;
import org.uva.sea.ql.ast.alg.Money;
import org.uva.sea.ql.ast.alg.Str;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.gen.TypeError;
import org.uva.sea.ql.gui.State;
import org.uva.sea.ql.observer.CheckBoxControl;
import org.uva.sea.ql.observer.Control;
import org.uva.sea.ql.observer.TextBoxControl;

public class TypeToWidget implements TypeVisitor<Control> {
	private final State state;
	private final Ident identifier;

	public TypeToWidget(State state, Ident identifier) {
		this.state = state;
		this.identifier = identifier;
	}

	@Override
	public Control visit(BoolType type) {
		final CheckBoxControl temp = new CheckBoxControl();
		temp.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// update variable
				TypeToWidget.this.state.addEnv(identifier, new Bool(temp.isSelected()));

			}
		});
		return temp;
	}

	@Override
	public Control visit(StrType type) {
		final TextBoxControl textBoxControl = new TextBoxControl();
		textBoxControl.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				update();
			}

			public void removeUpdate(DocumentEvent e) {
				update();
			}

			public void insertUpdate(DocumentEvent e) {
				update();
			}

			public void update() {
				// update variable
				TypeToWidget.this.state.addEnv(identifier, new Str(textBoxControl.getText()));
			}
		});

		return textBoxControl;
	}

	@Override
	public Control visit(IntType type) {
		final TextBoxControl textBoxControl = new TextBoxControl();
		textBoxControl.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				update();
			}

			public void removeUpdate(DocumentEvent e) {
				update();
			}

			public void insertUpdate(DocumentEvent e) {
				update();
			}

			public void update() {
				int value = 0;
				try {
					if (!textBoxControl.getText().isEmpty()) {
						value = Integer.parseInt(textBoxControl.getText());
						// update the variable
						TypeToWidget.this.state.addEnv(identifier, new Int(value));
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error: Please enter a number", "Error Massage", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		return textBoxControl;
	}

	@Override
	public Control visit(MoneyType type) {
		final TextBoxControl textBoxControl = new TextBoxControl();
		textBoxControl.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				update();
			}

			public void removeUpdate(DocumentEvent e) {
				update();
			}

			public void insertUpdate(DocumentEvent e) {
				update();
			}

			public void update() {
				double value = 0;
				try {
					if (!textBoxControl.getText().isEmpty()) {
						value = Double.parseDouble(textBoxControl.getText());
						// update the variable
						TypeToWidget.this.state.addEnv(identifier, new Money(value));
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error: Please enter a number", "Error Massage", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		return textBoxControl;
	}

	@Override
	public Control visit(NumericType type) {
		throw new UnsupportedOperationException("unsupported operation");
	}

	@Override
	public Control visit(TypeError type) {
		throw new UnsupportedOperationException("unsupported operation");
	}

}
