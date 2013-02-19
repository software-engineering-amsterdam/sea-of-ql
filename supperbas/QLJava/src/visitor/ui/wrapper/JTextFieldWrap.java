package visitor.ui.wrapper;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

import visitor.Environment;

public class JTextFieldWrap extends Wrapper {

	private JTextField field;
	private Environment env;
	
	public JTextFieldWrap(Environment env) {
		System.out.println("X" + env.getValEnv());
		this.env = env;
		this.field = new JTextField();
	}

	@Override
	public void setEnabled(boolean enabled) {
		field.setEditable(enabled);
	}

	@Override
	public void setVisible(boolean visible) {
		field.setVisible(visible);
	}

	@Override
	public void setValue(String value) {
		field.setText(value);
	}

	@Override
	public String getValue() {
		return field.getText();
	}

	@Override
	public void addListener(final WrapperEventListener listener) {
		final Wrapper wrp = this;
		field.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent focusEvent) {
				JTextField component = (JTextField) focusEvent.getSource();
				JTextFieldWrap.this.setValue(component.getText());
				listener.change(new WrapperEvent(JTextFieldWrap.this));
			}

			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
	}

	@Override
	public JTextField getComponent() {
		return field;
	}

	public Environment getEnv() {
		System.out.println("X" + env.getValEnv());
		return env;
	}

}
