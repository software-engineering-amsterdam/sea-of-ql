package org.uva.sea.ql;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluate.Error;
import org.uva.sea.ql.evaluate.render.Form;
import org.uva.sea.ql.evaluate.typecheck.TypeChecker;
import org.uva.sea.ql.export.Exporter;
import org.uva.sea.ql.export.XmlExporter;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.QLParser;
import org.uva.sea.ql.ui.ButtonControlEventListener;
import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.ui.control.WindowControl;
import org.uva.sea.ql.ui.swing.SwingControlFactory;

public class Program {
	private final static String SUBMIT_BUTTON_TEXT = "Save";
	private final static String FILE_OPEN_TITLE = "Open QL file";
	private final static String FILE_SAVE_TITLE = "Select file to save";
	private final static String DEFAULT_FILE_DIR = System.getProperty( "user.dir" );
	private final static String QL_FILE_DESCRIPTION = "QL files (.ql)";
	private final static String QL_FILE_FILTER = ".ql";
	private final static String XML_FILE_DESCRIPTION = "XML files (.xml)";
	private final static String XML_FILE_FILTER = ".xml";

	private final ControlFactory factory;
	private final WindowControl window;

	public static void main( String[] args ) {
		String sourceFileName = null;

		if ( args.length > 0 ) {
			sourceFileName = args[ 0 ];
		}

		Program program = new Program();
		program.run( sourceFileName );
	}

	public Program() {
		this.factory = new SwingControlFactory();
		this.window = this.factory.createWindow();
	}

	public void run( String sourceFileName ) {
		if ( sourceFileName == null ) {
			sourceFileName = this.getFileToOpen();
		}

		String source = this.getProgramSource( sourceFileName );

		Statement astRoot = this.parse( source );
		this.typeCheck( astRoot );
		PanelControl panel = this.render( astRoot );

		this.window.setTitle( panel.getName() );
		this.window.addControl( panel );
		this.window.show();
	}

	private void stop() {
		System.exit( 0 );
	}

	private JFrame getWindowHandle() {
		return (JFrame) this.window.getInnerControl();
	}

	private String getFileToOpen() {
		JFileChooser fileOpen = new JFileChooser( DEFAULT_FILE_DIR );
		fileOpen.setDialogTitle( FILE_OPEN_TITLE );
		fileOpen.setDialogType( JFileChooser.OPEN_DIALOG );
		fileOpen.setFileFilter(
			new FileFilter() {
				@Override
				public String getDescription() {
					return QL_FILE_DESCRIPTION;
				}

				@Override
				public boolean accept( File f ) {
					return f.getName().endsWith( QL_FILE_FILTER );
				}
			}
		);

		int result = fileOpen.showOpenDialog( this.getWindowHandle() );

		if ( result == JFileChooser.APPROVE_OPTION ) {
			File selectedFile = fileOpen.getSelectedFile();
			return selectedFile.getAbsolutePath();
		}

		this.stop();
		return null;
	}

	private String getFileToSave() {
		JFileChooser fileSave = new JFileChooser( DEFAULT_FILE_DIR );
		fileSave.setDialogTitle( FILE_SAVE_TITLE );
		fileSave.setDialogType( JFileChooser.SAVE_DIALOG );
		fileSave.setFileFilter(
			new FileFilter() {
				@Override
				public String getDescription() {
					return XML_FILE_DESCRIPTION;
				}

				@Override
				public boolean accept( File f ) {
					return f.getName().endsWith( XML_FILE_FILTER );
				}
			}
		);

		int result = fileSave.showSaveDialog( this.getWindowHandle() );

		if ( result == JFileChooser.APPROVE_OPTION ) {
			File selectedFile = fileSave.getSelectedFile();
			return selectedFile.getAbsolutePath();
		}

		return null;
	}

	private Statement parse( String source ) {
		QLParser parser = new QLParser();
		Statement ast;

		try {
			ast = parser.parse( source );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return ast;
	}

	private boolean typeCheck( Statement root ) {
		TypeChecker checker = new TypeChecker();
		checker.check( root );

		if ( checker.hasErrors() ) {
			for ( Error each : checker.getErrors() ) {
				System.err.println( each.toString() );
			}

			return false;
		}

		return true;
	}

	private PanelControl render( Statement root ) {
		final Form form = new Form( root, this.factory );
		form.addButton( SUBMIT_BUTTON_TEXT, new ButtonControlEventListener() {
			@Override
			public void buttonClicked( ControlEvent event ) {
				String fileName = Program.this.getFileToSave();

				if ( fileName == null ) {
					return;
				}

				Exporter exporter = new XmlExporter( form.getName(), form.getValues() );
				exporter.export( fileName );
			}
		} );
		return form.getFormPanel();
	}

	private String getProgramSource( String fileName ) {
		return TextFileLoader.getFileContents( fileName );
	}
}
