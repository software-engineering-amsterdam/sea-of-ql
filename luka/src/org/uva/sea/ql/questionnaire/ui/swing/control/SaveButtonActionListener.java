package org.uva.sea.ql.questionnaire.ui.swing.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.questionnaire.State;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SaveButtonActionListener implements ActionListener {

	private final State state;
	private final String fileLocation;

	public SaveButtonActionListener(State state, String fileLocation) {
		this.state = state;
		this.fileLocation = fileLocation;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		final XStream xstream = new XStream(new DomDriver());
		try {

			FileOutputStream output = new FileOutputStream(this.fileLocation);

			Writer out = new BufferedWriter(new OutputStreamWriter(output,
					"UTF-8"));

			xstream.alias("Questionnaire", Map.class);

			xstream.registerConverter(new Converter() {

				@Override
				public boolean canConvert(Class type) {
					return type == HashMap.class;
				}

				@Override
				public Object unmarshal(HierarchicalStreamReader arg0,
						UnmarshallingContext arg1) {
					return null;
				}

				@Override
				public void marshal(Object source,
						HierarchicalStreamWriter writer,
						MarshallingContext context) {
					Map<Ident, Value> map = (Map<Ident, Value>) source;
					for (Map.Entry<Ident, Value> entry : map.entrySet()) {
						Value value = entry.getValue();
						writer.startNode("answer");
						writer.addAttribute("questionId", entry.getKey()
								.toString());
						writer.setValue(value.getValue().toString());
						writer.endNode();
					}

				}
			});

			xstream.toXML(this.state.getEnv(), out);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
