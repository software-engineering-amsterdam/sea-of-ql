module lang::qls::ide::Outline

import List;
import Node;
import ParseTree;
import util::IDE;

import lang::qls::ast::AST;
//import lang::qls::compiler::PrettyPrinter;
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
  classDefinition(str ident, list[ClassRule] classRules))
    = createNode(
      "ClassDefinition",
      "class <ident> (<size(classRules)>)",
      s@location,
      [outline(cr) | cr <- classRules]
    );

private node outline(ClassRule cr: 
  classRule(str ident))
    = createNode(
      "ClassRule",
      ident,
      cr@location,
      []
    );

private node outline(Statement s: 
  typeStyleDefinition(str ident, list[StyleRule] styleRules)) = 
  createNode(
    "TypeStyleDefinition",
    "<ident> (<size(styleRules)>)",
    s@location,
    [outline(sr) | sr <- styleRules]
  );

private node outline(Statement s: 
  classStyleDefinition(str ident, list[StyleRule] styleRules)) = 
    createNode(
      "ClassStyleDefinition",
      "<ident> (<size(styleRules)>)",
      s@location,
      [outline(sr) | sr <- styleRules]
    );

private node outline(Statement s: 
  identStyleDefinition(str ident, list[StyleRule] styleRules)) =
    createNode(
      "IdentStyleDefinition",
      "<ident> (<size(styleRules)>)",
      s@location,
      [outline(sr) | sr <- styleRules]
    );

private node outline(StyleRule sr: 
  styleRule(str attr, StyleAttrValue \value)) =
    createNode(
      "StyleRule",
      "<attr> <\value.\value>",
      sr@location,
      []
    );
