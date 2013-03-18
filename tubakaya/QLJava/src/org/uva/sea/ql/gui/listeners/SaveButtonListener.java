package org.uva.sea.ql.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import javax.swing.JOptionPane;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literals.QLValue;
import org.uva.sea.ql.gui.listeners.helpers.SerializableIdentifierValueMap;

public class SaveButtonListener extends ButtonListener {

	public SaveButtonListener(Map<Identifier, QLValue> identifierValueMap) {
		super(identifierValueMap);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		serializeIdentifierValueMap();
	}

	private void serializeIdentifierValueMap() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(
					"C:\\Tubis\\School\\Software Construction\\valueList.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			SerializableIdentifierValueMap serializableValueList = new SerializableIdentifierValueMap(
					this.identifierValueMap);
			objectOutputStream.writeObject(serializableValueList);
			objectOutputStream.close();
			fileOutputStream.close();
			JOptionPane.showMessageDialog(null, "Your information is saved.");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}
