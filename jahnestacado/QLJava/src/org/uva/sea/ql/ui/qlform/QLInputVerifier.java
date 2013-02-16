package org.uva.sea.ql.ui.qlform;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.Type;

public class QLInputVerifier implements KeyListener {
	private final JLabel alertMsg;
	private final JTextField inputTextField;
	private final Type type;
	public final static String WARNING_LABEL_ID="WARNING_LABEL_ID";

	private QLInputVerifier(JLabel alertMsg, JComponent component, Type type) {
		this.alertMsg = alertMsg;
		this.inputTextField = (JTextField) component;
		this.type = type;
		setSettings();
	}
	
	private void setSettings(){
		alertMsg.setForeground(Color.red);
		inputTextField.addKeyListener(this);
		alertMsg.setName(WARNING_LABEL_ID);
		alertMsg.setFont(new Font("Courier New", Font.ITALIC, 10));
	}

	public static JLabel getVerifier(JComponent component, Type type) {
		JLabel alertMsg = new JLabel();
		new QLInputVerifier(alertMsg, component, type);
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
		if (!isNumChar(input)) {
			alertMsg.setText("*accepts only numeric characters*");
			return;
		}

		alertMsg.setText("");

	}

	private void stringVerifier(String input) {
		if (!isStringChar(input)) {
			alertMsg.setText("*accepts only string characters*");
			return;
		}

		alertMsg.setText("");
	}

	public static boolean isStringChar(String input) {
		return !input.matches(".*\\d.*");
	}

	public static boolean isNumChar(String input) {
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
