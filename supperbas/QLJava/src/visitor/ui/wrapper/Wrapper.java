package visitor.ui.wrapper;

import java.awt.Component;
import javax.swing.JLabel;

import visitor.Environment;

public abstract class Wrapper {
	abstract public Component getComponent();

	abstract public void setEnabled(boolean enabled);

	abstract public void setVisible(boolean visible);

	abstract public void setValue(String value);

	abstract public String getValue();

	abstract public void addListener(final WrapperEventListener wrapperEventListener);

	abstract public Environment getEnv();

	private JLabel label = new JLabel();

	public void setLabel(String name) {
		this.label.setText(name);
	}

	public JLabel getLabel() {
		return label;
	}
}
