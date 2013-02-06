package org.uva.sea.ql.interpreter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.Type;

public class QLVerifier implements KeyListener {
	private final JLabel alertMsg;
	private final JTextField inputTextField;
	private final Type type;

	private QLVerifier(JLabel alertMsg, JComponent component, Type type) {
		this.alertMsg = alertMsg;
		alertMsg.setForeground(Color.red);
		this.inputTextField = (JTextField) component;
		this.type = type;
		inputTextField.addKeyListener(this);
		alertMsg.setFont(new Font("Courier New", Font.ITALIC, 10));

	}

	
	public static JLabel getVerifier(JComponent component, Type type) {
		JLabel alertMsg = new JLabel();
		new QLVerifier(alertMsg, component, type);
		return alertMsg;
	}

	
	private void setVerifierMsg() {
		String input = inputTextField.getText();
		if (type.isCompatibleToNumericType()) {
			numVerifier(input);
			return;
		}
		stringVerifier(input);
	}

	
	private void numVerifier(String input) {
		if (!isNum(input)) {
			alertMsg.setText("*accepts only numeric characters*");
			return;
		}

	    alertMsg.setText("");

	}

	private void stringVerifier(String input) {
		if (!isString(input)) {
			alertMsg.setText("*accepts only string characters*");
			return;
		}

		alertMsg.setText("");
	}

	
	public static boolean isString(String input) {
		return !input.matches(".*\\d.*");
	}
	

	public static boolean isNum(String input) {
		try {
			Float.parseFloat(input);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	
	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		setVerifierMsg();

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
