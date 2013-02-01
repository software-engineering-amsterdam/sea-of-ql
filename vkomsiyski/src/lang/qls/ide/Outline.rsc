module lang::qls::ide::Outline

import lang::qls::ast::AST;
import lang::qls::util::Implode;
import util::IDE;
import ParseTree;
import Node;


public Contribution getQLSOutliner() 
  = outliner(node(Tree input) {
	  return "outline"(outline(implode(input)));
    });
    
public node outline(FormStyle style) = 
	makeOutlineNode("style", style.name, style@location, [outline(rule) | rule <- style.rules]);
	
private node outline(StyleRule r:typed(\type, rules)) =
	makeOutlineNode("typed", \type.name, r@location, [outline(rule) | rule <- rules]);
	
private node outline(StyleRule r:id(name, rules)) =
	makeOutlineNode("id", name, r@location, [outline(rule) | rule <- rules]);
	
private node outline(StyleRule r:group(name, questions)) =
	makeOutlineNode("group", "group <name>", r@location, [outline(q) | q <- questions]);

private node outline(Rule r:color(name)) =
	makeOutlineNode("typed", "color: <name>", r@location, []);

private node outline(Rule r:min(val)) =
	makeOutlineNode("typed", "minimum: <val>", r@location, []);

private node outline(Rule r:max(val)) =
	makeOutlineNode("typed", "maximum: <val>", r@location, []);

private node outline(Rule r:step(val)) =
	makeOutlineNode("typed", "step size: <val>", r@location, []);

private node outline(Rule r:font(name)) =
	makeOutlineNode("typed", "font: <name>", r@location, []);

private node outline(Rule r:width(size)) =
	makeOutlineNode("typed", "width: <size>", r@location, []);

private node outline(Rule r:widget(\type)) =
	makeOutlineNode("typed", "widget: <\type.name>", r@location, []);
	
private node outline(str question) = question();

private node makeOutlineNode(str name, str label, loc location, list[node] children) =
	setAnnotations(makeNode(name, children), ("label" : label, "loc" : location));
	