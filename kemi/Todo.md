# QL
* Refactoring / Adding comments
* Create awesome form to show off.

# QLS
* Update outliner: categorizing (like QL)
* Refactoring / Adding comments
* Create awesome stylesheet to show off.

# Discussion
* Syntax: all datatypes in separate modules (?)
  => No, I don't think so. It will be less clear, and we won't apply it for reuse.
    => I don't agree on it being less clear, I think it will be MORE clear
      => Well, we can split it up, but that results in a shitload of files.
         What we now have is alright in my opinion. Reusable stuff is extracted, 
         and the general QL stuff (or QLS) is just in their combined QL(s) syntax
         definition file. We now make very clear what will be reused and what not. 
* blockIdent (\<questionIdent\>Block) and similars in some public function?
* QL Outliner: Does in suffice now? 
* Maybe move the tests out of the lang::* package, and put it in tests/ql/... That way,
all tests are joined together and we can also make a single testrunner.

# BONUS:
* HTML templating
* Randomized testing for semantic checker
* Bonus exercise for Rascal variants: use SAT/SMT/Constraint solver to check for non-determinism.
