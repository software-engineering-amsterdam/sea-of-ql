module lang::qls::ide::Outline

import Set;
import Node;
import ParseTree;
import util::IDE;

import lang::qls::ast::AST;
import lang::qls::util::Implode;
import lang::qls::util::Parse;

// The root note of the stylesheet
public node outlineStylesheet(Stylesheet sh) =
  "outline"(outline(sh))
  [@label="Stylesheet"]
  [@\loc=sh@location];

// Helper function to create nodes with appropriate annotations and members.
private node createNode(str name, str label, loc location, list[node] children)
  = setAnnotations(makeNode(name, children), ("label": label, "loc": location));


// Below this are functions to rewrite the Tree to a tree of Nodes for the outliner

private node outline(Stylesheet sh) =
  "stylesheet"([outline(e) | e <- sh.statements])
  [@label="Stylesheet (<size(sh.statements)>)"]
  [@\loc=sh@location];

private node outline(Statement s: 
  classDefinition(str ident, set[ClassRule] classRules))
    = createNode(
      "ClassDefinition",
      "class <ident> (<size(classRules)>)",
      s@location,
      [outline(cr) | cr <- classRules]
    );

private node outline(ClassRule r: 
  classRule(str ident))
    = createNode(
      "ClassRule",
      ident,
      r@location,
      []
    );

private node outline(Statement s: 
  styleDefinition(StyleIdent: typeStyleIdent(ident), set[StyleRule] styleRules)) = 
  createNode(
    "TypeStyleDefinition",
    "<ident> (<size(styleRules)>)",
    s@location,
    [outline(r) | r <- styleRules]
  );

private node outline(Statement s: 
  styleDefinition(StyleIdent: classStyleIdent(ident), set[StyleRule] styleRules)) = 
    createNode(
      "ClassStyleDefinition",
      "<ident> (<size(styleRules)>)",
      s@location,
      [outline(r) | r <- styleRules]
    );

private node outline(Statement s: 
  styleDefinition(StyleIdent: questionStyleIdent(ident), set[StyleRule] styleRules)) =
    createNode(
      "IdentStyleDefinition",
      "<ident> (<size(styleRules)>)",
      s@location,
      [outline(r) | r <- styleRules]
    );

private node outline(StyleRule r: 
  typeStyleRule(str attr, TypeStyleValue: radio())) =
    createNode(
      "StyleRule",
      "<attr> radio",
      r@location,
      []
    );

private node outline(StyleRule r: 
  typeStyleRule(str attr, TypeStyleValue: checkbox())) =
    createNode(
      "StyleRule",
      "<attr> checkbox",
      r@location,
      []
    );

private node outline(StyleRule r: 
  widthStyleRule(str attr, int \value)) =
    createNode(
      "StyleRule",
      "<attr> <\value>",
      r@location,
      []
    );
