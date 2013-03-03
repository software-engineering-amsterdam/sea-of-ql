package org.uva.sea.ql.gui;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.uva.sea.ql.ast.expr.value.Value;

public class XMLConverter {

	  public XMLConverter(Map<String, Value> value , File file) { 
	        try {
	            XMLConverter.toXml(value, new FileWriter(file));
	        }
	        catch(IOException e) {
	            e.printStackTrace();
	        }
	        catch(XMLStreamException e) {
	            e.printStackTrace();
	        }
	    }

	    @SuppressWarnings("unchecked")
		public static <K,V> void toXml(Map<K, V> map, Writer out) throws IOException, XMLStreamException {
	        XMLStreamWriter xsw = null;
	        try {
	            try {
	                XMLOutputFactory xof = XMLOutputFactory.newInstance();
	                xsw = xof.createXMLStreamWriter(out);
	                xsw.writeStartDocument();
	                xsw.writeCharacters("\n");
	                xsw.writeStartElement("entries");
	                xsw.writeCharacters("\n");
	                for(Map.Entry<K, V> e : map.entrySet()) {
	                    xsw.writeStartElement("entry");
	                    xsw.writeCharacters("\n\t");
	                    xsw.writeStartElement("question");
	                    xsw.writeCharacters(e.getKey().toString());
	                    xsw.writeEndElement();
	                    xsw.writeCharacters("\n\t");
	                    xsw.writeStartElement("value");
	                    xsw.writeCharacters(valueNormilizer((Entry<String, Value>) e));
	                    xsw.writeEndElement();
	                    xsw.writeCharacters("\n");
	                    xsw.writeEndElement();
	                    xsw.writeCharacters("\n");
	                }
	                xsw.writeEndElement();
	                xsw.writeEndDocument();
	            }
	            finally {
	                if (out != null) {
	                    try { out.close() ; } catch(IOException e) {}      
	                }
	            }
	        }
	        finally {
	            if (xsw != null) {
	                try { xsw.close() ; } catch(XMLStreamException e) {}    
	            }
	        }
	    }
	    
	    private static String valueNormilizer (Entry<String, Value> e) {
	    	return e.getValue().getValue().toString();
	    }
}
