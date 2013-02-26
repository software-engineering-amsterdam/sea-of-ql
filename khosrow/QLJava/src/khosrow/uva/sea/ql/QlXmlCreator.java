package khosrow.uva.sea.ql;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.env.Env;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class QlXmlCreator {
	private final File file;
	
	private QlXmlCreator(File file) {
		this.file = file;
	}
	
	public static void create(String path, Form form, Env env) throws IOException {
		 File f = new File(path);
         f.createNewFile();
         QlXmlCreator creator = new QlXmlCreator(f);
         creator.createXML(form, env);
	}
	
	public void createXML(Form form, Env env)
    {
     try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
 
            Element rootElement = doc.createElement("form");
            rootElement.setAttribute("name", form.getIdent().getName());
            
            for(Ident ident:env.getSymbolTable().keySet()) {
            	Element element = doc.createElement("ident");
            	element.setAttribute("name", ident.getName());
            	element.setTextContent(env.valueOf(ident).toString());    
            	rootElement.appendChild(element);
            }

            doc.appendChild(rootElement);
 
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            t.transform(source, result);
 
       } 
     catch(Exception e) {
    	 throw new RuntimeException(e.getMessage());
       } 
    }

}
