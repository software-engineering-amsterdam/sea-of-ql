module lang::qls::compiler::web::JS

import IO;
import lang::ql::ast::AST;
import lang::qls::ast::AST;
import lang::qls::util::StyleHelper;

import util::ValueUI;

public void JS(Form form, Stylesheet sheet, loc dest) {
  dest += "styling.js";
  
  writeFile(dest, JS(form, sheet));
}

private str JS(Form form, Stylesheet sheet) { 
  str ret = "";
  
  pds = [pd | def <- sheet.definitions, definition(PageDefinition pd) := def];
  for(pd <- pds)
    ret += createPageDefinition(form, pd);
    
  sds = [sd | def <- sheet.definitions, definition(SectionDefinition sd) := def];
  for(sd <- sds)
    ret += sectionDefinition(form, sd);
    
  qds = [qd | def <- sheet.definitions, definition(QuestionDefinition qd) := def];
  for(qd <- qds)
    ret += QuestionDefinition(form, qd);
    
  dds = [dd | def <- sheet.definitions, definition(DefaultDefinition dd) := def];
  for(dd <- dds)
    ret += defaultDefinition(form, dd);    

  return ret;  
}

private str createPageDefinition(Form form, PageDefinition pd) {
  str ret = "<pd.ident>";
  
  str ident = pd.ident;
  
  sds = [sd | def <- pd.pageRules, pageRule(SectionDefinition sd) := def];
  for(sd <- sds)
    ret += sectionDefinition(form, sd);
    
  qds = [qd | def <- pd.pageRules, pageRule(QuestionDefinition qd) := def];
  for(qd <- qds)
    ret += questionDefinition(form, qd);
    
  dds = [dd | def <- pd.pageRules, pageRule(DefaultDefinition dd) := def];
  for(dd <- dds)
    ret += defaultDefinition(form, dd);
  
  return ret;
}

private str sectionDefinition(Form form, SectionDefinition psd) {
  str ret = "";

  sds = [sd | def <- psd.sectionRules, sectionRule(SectionDefinition sd) := def];
  for(sd <- sds)
    ret += sectionDefinition(form, sd);
    
  qds = [qd | def <- psd.sectionRules, sectionRule(QuestionDefinition qd) := def];
  for(qd <- qds)
    ret += questionDefinition(form, qd);
    
  dds = [dd | def <- psd.sectionRules, sectionRule(DefaultDefinition dd) := def];
  for(dd <- dds)
    ret += defaultDefinition(form, dd);

  return ret;
}

private str questionDefinition(Form form, QuestionDefinition pqd) {
  str ret = "";
  if(questionDefinition(str ident) := pqd) {
    ret += "END: <ident>";
  } else {
    tsrs = [def | def <- pqd.styleRules, typeStyleRule(_, _) := def];
    for(tsr <- tsrs)
      ret += typeStyleRule(form, tsr);
      
    wsrs = [def | def <- pqd.styleRules, widthStyleRule(_, _) := def];
    for(wsr <- wsrs)
      ret += widthStyleRule(form, wsr);
  }

  return ret;
}

private str typeStyleRule(Form form, StyleRule sr) {
  str ret = "<sr.attr> :: <typeStyleValue(form, sr.typeValue)>";
  return ret;
}

private str widthStyleRule(Form form, StyleRule sr) {
  str ret = "<sr.attr> :: <sr.widthValue>";
  return ret;
}

private str typeStyleValue(Form form, TypeStyleValue tsv: radio(str name)) {
  str ret = "Radio: <name>";
  return ret;
}

private str typeStyleValue(Form form, TypeStyleValue tsv: checkbox(str name)) {
  str ret = "Checkbox: <name>";
  return ret;
}

private str defaultDefinition(Form form, DefaultDefinition dd) {
  str ret = "";
  
  ret += "Type ident: <dd.ident>";

  tsrs = [def | def <- dd.styleRules, typeStyleRule(_, _) := def];
  for(tsr <- tsrs)
    ret += typeStyleRule(form, tsr);
    
  wsrs = [def | def <- dd.styleRules, widthStyleRule(_, _) := def];
  for(wsr <- wsrs)
    ret += widthStyleRule(form, wsr);

  return ret;
}