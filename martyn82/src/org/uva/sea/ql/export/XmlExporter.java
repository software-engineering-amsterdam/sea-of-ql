package org.uva.sea.ql.export;

import java.io.File;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.uva.sea.ql.evaluate.render.Binding;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlExporter extends Exporter {
	public XmlExporter( String formName, Map<String, Binding> bindings ) {
		super( formName, bindings );
	}

	@Override
	public void export( String fileName ) {
		Document document = this.createDocument();
		this.addQuestions( document, document.getFirstChild() );
		this.writeToFile( document, fileName );
	}

	private Document createDocument() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		try {
			builder = factory.newDocumentBuilder();
		}
		catch ( ParserConfigurationException e ) {
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		Document document = builder.newDocument();
		Element root = document.createElement( "form" );

		root.setAttribute( "name", this.getName() );
		document.appendChild( root );

		return document;
	}

	private void addQuestions( Document document, Node parent ) {
		Map<String, Binding> bindings = this.getBindings();

		for ( Map.Entry<String, Binding> each : bindings.entrySet() ) {
			this.addQuestion( document, parent, each.getKey(), each.getValue() );
		}
	}

	private void addQuestion( Document document, Node parent, String name, Binding binding ) {
		Element question = document.createElement( "question" );
		question.setAttribute( "id", name );

		question.setAttribute( "type", binding.getType().getName() );
		question.setTextContent( binding.getValue().toString() );

		parent.appendChild( question );
	}

	private void writeToFile( Document document, String fileName ) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty( OutputKeys.INDENT, "yes" );

			DOMSource source = new DOMSource( document );
			StreamResult result = new StreamResult( new File( fileName ) );

			transformer.transform( source, result );
		}
		catch ( TransformerException e ) {
			e.printStackTrace();
			throw new RuntimeException( e );
		}
	}
}
