QL Interpreter
==============

* Has a parser generator for QL.
* Has a unoptimized and only partially functional AST.
* Has separate test runners for forms and expressions.
* Has a treewalker that should be able to show class names in the tree.

Building.
---------

Use `make` to compile everything (will generate classfiles next to the
sources), or use the Eclipse build tools.

Running.
--------

* Run the parser generator

		make run/rats

* Run the parser tests

		make run/testexpr
		make run/testform

* Run the tree walker for a simple form

		make run/treewalker

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
