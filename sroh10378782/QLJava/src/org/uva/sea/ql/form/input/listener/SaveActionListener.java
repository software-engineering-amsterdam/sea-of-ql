package org.uva.sea.ql.form.input.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.form.gui.state.State;
import org.uva.sea.ql.form.input.listener.Messages.Message;
import org.uva.sea.ql.values.Value;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SaveActionListener implements ActionListener {
	
	private final String IDENT_XML_TAG = "IDENT";
	private final String IDENT_XML_ATTRIBUTE = "identifier";
	private final String VALUE_XML_TAG = "VALUE";
	private final String SUCCESS_MSG = "Save QL result !";
	private final String FILE_QL_IDENT = "_Questionaire_";
	private final String FILE_QL_EXTENTION = ".xml";
	
	private Ident ident;
	private State state;
	private String path;
	
	public SaveActionListener(State state, Ident formIdent, String path){
		this.ident = formIdent;
		this.state = state;
		this.path = path;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.saveValueEnvironment(this.state, this.ident, this.path);
	}
	
	private Message saveValueEnvironment(State state, Ident formIdent, String path){
		State tempState = state;
		Date now = new Date();
		Message retVal;
		
		String filename = path + formIdent.getValue() + FILE_QL_IDENT + now.getTime() + FILE_QL_EXTENTION;
		
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("QLVALUES");
			doc.appendChild(rootElement);
			Map<Ident, Value> map = tempState.getValueEnv();
			
			for(Ident i : map.keySet()){
				Element id = doc.createElement(IDENT_XML_TAG);
				rootElement.appendChild(id);
				Attr attr = doc.createAttribute(IDENT_XML_ATTRIBUTE);
				attr.setValue(i.getValue());
				id.setAttributeNode(attr);
				Element val = doc.createElement(VALUE_XML_TAG);
				val.appendChild(doc.createTextNode(map.get(i).toString()));
				id.appendChild(val);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
	 		transformer.transform(source, result);
	 		
	 		retVal = new Message(SUCCESS_MSG, false);
		  } catch (ParserConfigurationException pce) {
			  retVal = new Message(pce.getMessage(), false);
		  } catch (TransformerException tfe) {
			  retVal = new Message(tfe.getMessage(), false);
		  }
		return retVal;
	}
}
