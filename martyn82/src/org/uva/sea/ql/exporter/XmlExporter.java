package org.uva.sea.ql.exporter;

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

import org.uva.sea.ql.evaluator.environment.Binding;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlExporter extends Exporter {
	private Document document;
	private Element root;

	public XmlExporter( String formName, Map<String, Binding> bindings ) {
		super( formName, bindings );
	}

	@Override
	public void export( String fileName ) {
		this.createDocument();
		this.addQuestions( this.root );
		this.writeToFile( fileName );
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

		this.document = builder.newDocument();
		this.root = this.document.createElement( "form" );

		this.root.setAttribute( "name", this.getName() );
		this.document.appendChild( this.root );

		return document;
	}

	private void addQuestions( Element parent ) {
		Map<String, Binding> bindings = this.getBindings();

		for ( Map.Entry<String, Binding> each : bindings.entrySet() ) {
			this.addQuestion( parent, each.getKey(), each.getValue() );
		}
	}

	private void addQuestion( Element parent, String name, Binding binding ) {
		Element question = this.document.createElement( "question" );
		question.setAttribute( "id", name );

		question.setAttribute( "type", binding.getType().getName() );
		question.setTextContent( binding.getValue().toString() );

		parent.appendChild( question );
	}

	private void writeToFile( String fileName ) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty( OutputKeys.INDENT, "yes" );

			DOMSource source = new DOMSource( this.document );
			StreamResult result = new StreamResult( new File( fileName ) );

			transformer.transform( source, result );
		}
		catch ( TransformerException e ) {
			e.printStackTrace();
			throw new RuntimeException( e );
		}
	}
}
