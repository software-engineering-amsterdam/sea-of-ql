package org.uva.sea.ql.save;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.FormData;
import org.uva.sea.ql.visitor.eval.ui.Application;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

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

		Application app = (Application) o;
		FormData data = app.getFormData();
		DOMSource xml = this.createXmlFromData(data);
		this.writeXmlToFile(xml, this.path);
	}

	private DOMSource createXmlFromData(FormData data) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();

		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Document document = documentBuilder.newDocument();

		Element rootElement = this.createElement(document, data);
		document.appendChild(rootElement);

		return new DOMSource(document);
	}

	private Element createElement(Document document, FormData data) {
		Element root = document.createElement("data");

		Map<Ident, AbstractValue> values = data.getValues();
		for (Map.Entry<Ident, AbstractValue> value : values.entrySet()) {
			Element element = document.createElement(value.getKey().getName());
			Text text = document.createTextNode(value.getValue().toString());
			element.appendChild(text);

			root.appendChild(element);
		}

		List<FormData> childData = data.getChildren();
		for (FormData child : childData) {
			Element element = this.createElement(document, child);
			root.appendChild(element);
		}

		return root;
	}

	public void writeXmlToFile(DOMSource xml, String path) {
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return;
		}

		File file = new File(path);
		StreamResult result = new StreamResult(file);
		try {
			transformer.transform(xml, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
