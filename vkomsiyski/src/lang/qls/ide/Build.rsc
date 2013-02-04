module lang::qls::ide::Build

import lang::qls::util::Implode;
import lang::qls::gen::Generate;
import util::IDE;
import ParseTree;
import Message;
import IO;

private loc generated_form = |project://QL-R/src/form/FormGUI.java|;


public Contribution getQLSBuilder() 
  = builder(set[Message] (Tree input) {
  	 writeFile(generated_form, generate(implode(input)));
	 return {};
  });