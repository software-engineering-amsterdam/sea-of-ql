module IDE::Uninit


import Prelude;
import syntax::Abstract;
import load::Load;

import Visualization::UseDef;
import Visualization::ControlFlow;

public set[CFNode] defNodes(str Id, set[Occurrence]Defs)={statement(Occ.stat@location,occ.stat)|Occurrence occ<-Defs,occ.name==id};

public set[Occurrence] uninitForm(Form F)
{
	D=defs(F);
	CFG=cflowForm(F);
	return
		{
		occ|occ <-uses(P),any(CFNode N<-reachX(CFG.grapgh,CFG,entry, defNodes(occ.name, D)),
		N has location && occ.location<=N.location)
		};
}
	
public set[Occurrence] uninitForm(str txt)=uninitForm(load(txt));

