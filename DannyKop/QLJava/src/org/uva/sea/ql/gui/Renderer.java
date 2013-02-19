package org.uva.sea.ql.gui;


import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.expressions.binary.Add;
import org.uva.sea.ql.ast.expressions.binary.And;
import org.uva.sea.ql.ast.expressions.binary.BinExpr;
import org.uva.sea.ql.ast.expressions.binary.Div;
import org.uva.sea.ql.ast.expressions.binary.Eq;
import org.uva.sea.ql.ast.expressions.binary.GEq;
import org.uva.sea.ql.ast.expressions.binary.GT;
import org.uva.sea.ql.ast.expressions.binary.LEq;
import org.uva.sea.ql.ast.expressions.binary.LT;
import org.uva.sea.ql.ast.expressions.binary.Mul;
import org.uva.sea.ql.ast.expressions.binary.NEq;
import org.uva.sea.ql.ast.expressions.binary.Or;
import org.uva.sea.ql.ast.expressions.binary.Sub;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpr;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.IfThen;
import org.uva.sea.ql.ast.form.IfThenElse;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.gui.elements.Control;
import org.uva.sea.ql.gui.visitor.TypeToWidgetVisitor;
import org.uva.sea.ql.visitor.Visitor;


/**
 * Class: Renderer
 * @author Danny
 */
public class Renderer implements Visitor<Void> {

	private final JPanel panel;
	/**
	 * render
	 * Convenience method. Just calls render(List<FormElement>)
	 * @param f
	 * @return JPanel
	 */
	public static JPanel render(Form f){
		return Renderer.render(f.getElements());
	}
	/**
	 * render
	 * @param f
	 * @return JPanel
	 */
	public static JPanel render(List<FormElement> f){
		Renderer r = new Renderer();
		for(FormElement fe : f){
			fe.accept(r);
		}
		return r.getPanel();
	}
	/**
	 * Constructor
	 */
	private Renderer() {
		this.panel = new JPanel(new MigLayout("wrap 2"));
	}
	/**
	 * getPanel
	 * @return
	 */
	private JPanel getPanel(){
		return this.panel;
	}
	
	/**
	 * addLabel
	 * @param description
	 */
	private void addLabel(String description){
		this.panel.add(new JLabel(description));
	}
	/**
	 * addComponent
	 * @param con
	 */
	private void addComponent(Control con){
		this.panel.add(con.getComponent());
	}
	/**
	 * addPanel
	 * @param pnl
	 */
	private void addPanel(JPanel pnl){
		this.panel.add(pnl, "wrap");
	}
	/**
	 * typeToWidget
	 * Computes which widget is needed for the type
	 * @param t - type
	 * @param visible - must the comp be visible at the start
	 * @return Control
	 */
	private Control typeToWidget(Type t, boolean visible){		
		TypeToWidgetVisitor vis = new TypeToWidgetVisitor();
		return t.accept(vis);
	}

	@Override
	public Void visit(Form f) {
		for(FormElement fe : f.getElements()){
			fe.accept(this);
		}
		return null;
	}

	@Override
	public Void visit(FormElement fe) {
		fe.accept(this);
		return null;
	}

	@Override
	public Void visit(Question q) {
		addLabel(q.getDescription());
		Control con = typeToWidget(q.getType(), true);
		addComponent(con);
		return null;
	}

	@Override
	public Void visit(Computation c) {
		addLabel(c.getDescription());
		Control con = typeToWidget(c.getType(), false);
		addComponent(con);
		return null;
	}

	@Override
	public Void visit(IfThen i) {
		JPanel tr = render(i.getIfElements());
		tr.setVisible(false);
		addPanel(tr);
		
		return null;
	}

	@Override
	public Void visit(IfThenElse i) {
		JPanel tr = render(i.getIfElements());
		JPanel fl = render(i.getElseElements());
		tr.setVisible(false);
		fl.setVisible(false);
		addPanel(tr);
		addPanel(fl);
		
		return null;
	}

	@Override
	public Void visit(Ident i) {
		
		return null;
	}

	@Override
	public Void visit(BinExpr b) {
		
		return null;
	}

	@Override
	public Void visit(UnaryExpr u) {
		
		return null;
	}

	@Override
	public Void visit(Expr e) {
		
		return null;
	}

	@Override
	public Void visit(Type t) {
		
		return null;
	}

	@Override
	public Void visit(Add a) {
		
		return null;
	}

	@Override
	public Void visit(And a) {
		
		return null;
	}

	@Override
	public Void visit(Div d) {
		
		return null;
	}

	@Override
	public Void visit(Mul m) {
		
		return null;
	}

	@Override
	public Void visit(Or o) {
		
		return null;
	}

	@Override
	public Void visit(Sub s) {
		
		return null;
	}

	@Override
	public Void visit(Eq e) {
		
		return null;
	}

	@Override
	public Void visit(GEq g) {
		
		return null;
	}

	@Override
	public Void visit(GT g) {
		
		return null;
	}

	@Override
	public Void visit(LEq l) {
		
		return null;
	}

	@Override
	public Void visit(LT l) {
		
		return null;
	}

	@Override
	public Void visit(NEq n) {
		
		return null;
	}

	@Override
	public Void visit(Neg n) {
		
		return null;
	}

	@Override
	public Void visit(Not n) {
		
		return null;
	}

	@Override
	public Void visit(Pos p) {
		
		return null;
	}


}
