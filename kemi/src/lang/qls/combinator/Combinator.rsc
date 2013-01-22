module lang::qls::combinator::Combinator

import IO;
import String;

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::qls::ast::AST;
import lang::qls::tests::ParseHelper;


public Statement getClassDefinition(str className, Stylesheet s) {
  visit(s) {
    case d:classDefinition(className, _): return d;
  }
  //TODO: not found
}

public Statement getStyleDefinition(StyleIdent ident, Stylesheet s) {
  visit(s) {
    case d:styleDefinition(ident, _): return d;
  }
  //TODO: not found
}

public StyleIdent getTypeIdent(StyleIdent: questionStyleIdent(ident), Form f) {
  ident = substring(ident, 1, size(ident));
  visit(f) {
    case question(_, \type, ident):
      return typeStyleIdent(\type);
  }
  //TODO: not found
}

public StyleIdent getClassIdent(StyleIdent: questionStyleIdent(ident), Stylesheet s) {
  visit(s) {
    case classDefinition(name, classRules):
      if(classRule(ident) in classRules)
        return classStyleIdent(".<name>");
  }
  //TODO: not found
}

public set[StyleRule] getStyleRules(str ident, Stylesheet s, Form f) {
  ident = questionStyleIdent("#<ident>");

  return getTypeStyleRules(ident, s, f) +
    getClassStyleRules(ident, s) +
    getQuestionStyleRules(ident, s);
}
  //TODO: importance and stuff

private set[StyleRule] getTypeStyleRules(StyleIdent ident, Stylesheet s, Form f) =
  getStyleDefinition(getTypeIdent(ident, f), s).styleRules;

private set[StyleRule] getClassStyleRules(StyleIdent ident, Stylesheet s) =
  getStyleDefinition(getClassIdent(ident, s), s).styleRules;

private set[StyleRule] getQuestionStyleRules(StyleIdent ident, Stylesheet s) =
  getStyleDefinition(ident, s).styleRules;


public void main() {
  Form f = parseForm(|project://QL-R-kemi/forms/multipleQuestions.q|);
  Stylesheet s = parseStylesheet(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|);
  sr = getStyleRules("fieldTwo", s, f);
  iprintln(sr);
}