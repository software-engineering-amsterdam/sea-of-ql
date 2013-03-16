package org.uva.sea.ql.visitor.generator.nodejs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.uva.sea.ql.ast.statement.CompoundStatement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.StatementVisitor;

public class NodeJsGenerator implements StatementVisitor<Void>{

	private final File outputDirectory;
	
	private FileOutputStream baos;
	
	public NodeJsGenerator(File outputDirectory) {
		this.outputDirectory = outputDirectory;
		
	}
	
	public void finish(){
		try {
			this.baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Void visit(Form form) {
		try {
			baos = new FileOutputStream(outputDirectory + File.separator + form.getIdentity().getName() + ".html");
			writeLine("<html>");
			writeLine("<head><title>"+form.getIdentity().getName()+"</title></head");
			writeLine("<body>");
			writeLine("<form>");
			
			form.getCompoundStatement().accept(this);
			
			writeLine("</form>");
			writeLine("</body>");
			writeLine("</html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Void visit(CompoundStatement statement) {
		final Iterator<Statement> statementIterator = statement.getStatementIterator();
		while(statementIterator.hasNext()){
			statementIterator.next().accept(this);
		}
		return null;
	}

	@Override
	public Void visit(Question question) {
		switch(question.getDataType()){
		case BOOLEAN:
			writeLine(question.getLabel().getValue() + ": <input type=\"checkbox\" name=\""+question.getIdent().getName()+"\" /> <br/>");
			break;
		case  INTEGER:
		case MONEY:
		case TEXT:
			writeLine(question.getLabel().getValue() + ": <input type=\"text\" name=\""+question.getIdent().getName()+"\" /> <br/>");
			break;
		}
		
		return null;
	}

	@Override
	public Void visit(IfStatement statement) {
		return statement.getStatement().accept(this);
	}

	@Override
	public Void visit(IfElseStatement statement) {
		statement.getStatement().accept(this);
		statement.getElseStatement().accept(this);
		
		return null;
	}

	private void writeLine(String s){
		try {
			IOUtils.write(s+"\n", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
