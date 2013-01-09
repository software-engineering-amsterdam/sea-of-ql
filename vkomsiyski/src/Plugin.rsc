module Plugin

import util::IDE;
import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ide::Outline;
import ParseTree;

private str LANG = "QL-R";
private str EXT = "q";


public void main() {
  registerLanguage(LANG, EXT, Tree(str src, loc l) {
     return parse(src, l);
  });
  
  registerContributions(LANG, {getOutliner()});
  
  /*
   contribs = {
  		outliner(node (Form input) {
    		return outlineForm(implode(input));
  		}),
  		annotator(demo::lang::MissGrant::MissGrant::Controller (demo::lang::MissGrant::MissGrant::Controller input) {
    		msgs = toSet(checkController(implode(input)));
    		return input[@messages=msgs];
  		}),
		popup(
			menu(CONTROLLER_LANG,[
	    		action("Generate Switch", generateSwitch), 
	    		action("Generate Methods", generateMethods),
	    		action("Visualize", visualizeController),
	    		edit("Rename...", rename) 
		    ])
	  	),
	  	proposerContrib
  };
	
  registerContributions(LANG, contribs);
    */
}
