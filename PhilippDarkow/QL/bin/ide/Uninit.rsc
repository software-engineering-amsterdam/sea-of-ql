module ide::Uninit

import Prelude;
import syntax::AbstractSyntax;
import util::Load;

import visualization::UseDef;
import visualization::ControlFlow;

public set[CFNode] defNodes(str id, set[Occurrence] Defs) =
   {statement(occ.stat@location, occ.stat) | Occurrence occ <- Defs, occ.name == id};

public set[Occurrence] uninitProgram(Program P) {
   D = defs(P);                     
   CFG = cflowProgram(P);           
   return { occ | occ <- uses(P),   
                  any(CFNode N <- reachX(CFG.graph, CFG.entry, defNodes(occ.name, D)),
                      N has location && occ.location <= N.location) 
          };                        
}

public set[Occurrence] uninitProgram(str txt) = uninitProgram(load(txt));