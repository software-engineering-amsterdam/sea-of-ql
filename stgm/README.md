QL Interpreter
==============

* Has a parser generator for QL.
* Has separate test runners for forms and expressions.
* Has a pretty printer that should render the textual representation from the AST.

Building.
---------

Use `make` to compile everything (this will generate classfiles next to the
sources).

Running.
--------

Run the parser generator

	make run/rats

Run the parser tests

	make run/testexpr
	make run/testform

Run the pretty printer for a sample form

	make run/pretty

References.
-----------

*Assignment and AST*

* [Assignment](https://github.com/software-engineering-amsterdam/software-construction/wiki)
* [Workbench assignment](http://www.languageworkbenches.net/images/5/53/Ql.pdf)
* <http://sourcemaking.com/design_patterns/composite>
* <http://sourcemaking.com/design_patterns/interpreter>
* <http://lukaszwrobel.pl/blog/interpreter-design-pattern>

*Tools*

* [JUnit on GitHub](https://github.com/KentBeck/junit/wiki)

*Rats!*

* [Rats! Intro](http://cs.nyu.edu/rgrimm/xtc/rats-intro.html)

*Java etc.*

* [Joel on Exceptions](http://www.joelonsoftware.com/items/2003/10/13.html)
* [Packages](http://www.developer.com/java/other/article.php/10936_604651_1)
* [Naming packages](http://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html)
