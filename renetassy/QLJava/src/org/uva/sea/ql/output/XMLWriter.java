package org.uva.sea.ql.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.uva.sea.ql.evaluation.values.Value;
import org.uva.sea.ql.renderer.Renderer;
import org.uva.sea.ql.renderer.State;


public class XMLWriter {
	
	private final State state;
	
	private static final String XML_FILE = "/home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/test/results.xml";
	
	public XMLWriter(Renderer r) {
		
		this.state = r.getState();
		
		String xml = convertToXML(state.getEnv(),"root");
		
		FileWriter fstream = null;
		try {
			fstream = new FileWriter(XML_FILE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fstream);
		
		try {
			out.write(xml);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String convertToXML(Map<String, Value> map, String root) {
        
		StringBuilder sb = new StringBuilder("<");
        sb.append(root);
        sb.append(">");

        for (Entry<String, Value> e : map.entrySet()) {
            sb.append("<");
            sb.append(e.getKey());
            sb.append(">");

            sb.append(e.getValue().getValue());
            sb.append("</");
            sb.append(e.getKey());
            sb.append(">");
        }

        sb.append("</");
        sb.append(root);
        sb.append(">");

        return sb.toString();
    }
}
