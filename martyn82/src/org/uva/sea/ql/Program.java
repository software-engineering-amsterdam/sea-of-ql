package org.uva.sea.ql;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.uva.sea.ql.evaluate.render.FormBuilder;
import org.uva.sea.ql.export.Exporter;
import org.uva.sea.ql.export.XmlExporter;
import org.uva.sea.ql.ui.ButtonControlEventListener;
import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.ui.swing.SwingControlFactory;

public class Program implements ButtonControlEventListener {
	private final static String SUBMIT_BUTTON_TEXT = "Save";

	private final ControlFactory factory;

	private PanelControl panel;
	private QLForm form;

	public static void main( String[] args ) {
		Program program = new Program();
		program.run();
	}

	public Program() {
		this.factory = new SwingControlFactory();
	}

	public void run() {
		String source = this.getProgramSource();

		this.form = new QLForm( source, this.factory );

		FormBuilder builder = this.form.getBuilder();
		builder.addButton( SUBMIT_BUTTON_TEXT, this );
		this.panel = builder.getPanel();

		this.factory.createWindow( this.panel.getName(), this.panel ).show();
	}

	private String getProgramSource() {
		return TextFileLoader.getFileContents( System.getProperty( "user.dir" ) + "/assets/sample.ql" );
	}

	@Override
	public void buttonClicked( ControlEvent event ) {
		DateFormat format = new SimpleDateFormat( "yyyyMMdd_HHmmss" );
		String dateString = format.format( new Date() );

		Exporter exporter = new XmlExporter( this.panel.getName(), this.form.getValues() );
		exporter.export( System.getProperty( "user.dir" ) + "/formdata/" + dateString + ".xml" );
	}
}
