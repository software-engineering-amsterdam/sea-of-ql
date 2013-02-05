sc-ql-2012-2013-rascal
======================

* Jimi van der Woning ([@JimbowsNET](https://github.com/JimbowsNET))
* Kevin van der Vlist ([@kevinvandervlist](https://github.com/kevinvandervlist))

Code for the Rascal variant of lab assignment Software Construction 2012-2013

* Information about form generation can be found [here](output/README.md)
* [Todo list](Todo.md)
* [Notes](Notes.md)


Coding Style
============

* Spaces instead of tabs: window -> pref -> type 'imp' -> IMP -> checkbox 'use spaces instead of tabs'
* Tab Width: 2 (same dialogue)
* Curlies of functions on same line, closing on a new line:

```javascript
public str foo(int a, int b) {
  return "<a> + <b> = <a + b>";
}
```

* if/else/if parenthesis, curlies etc should be like this:

```javascript
if(foo) {
  return 1;
} else if(bar) {
  return 2;
} else {
  return 3;
}
```

* Variable and function names should be in camelCase:

```javascript
myAwesomeFooBar(int myInt, bool myBoolean) {
  return aVariable;
}
```

* Modules should start with a capital letter, and be camelcased (MyModule.rsc)

* Comprehensions should be written in the following style regarding spaces:

```javascript
a = {<x, y> | <_, x, _> <- mySet, y <- {z*z | z <- anotherSet}}
```

