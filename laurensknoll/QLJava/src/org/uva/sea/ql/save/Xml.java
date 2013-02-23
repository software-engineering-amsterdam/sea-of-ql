package org.uva.sea.ql.save;

import java.util.List;
import java.util.Observable;

import org.uva.sea.ql.visitor.eval.FormData;
import org.uva.sea.ql.visitor.eval.ui.Application;

public class Xml extends SaveBehaviour {

	private final String path;

	public Xml(String path) {
		this.path = path;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!(o instanceof Application)) {
			throw new IllegalArgumentException(
					"Saver is only able to observe an Application.");
		}

		// Save application data.
		Application app = (Application) o;
		FormData data = app.getFormData();

		// Write data to file.
		this.printData(data);
	}

	public void printData(FormData data) {
		List<FormData> childData = data.getChildren();
		for (FormData child : childData) {
			System.out.println(child.toString());

			this.printData(child);
		}
	}
}
