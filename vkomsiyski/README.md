sc-ql-2012-2013-rascal
======================

Rascal variant of lab assignment Software Construction 2012-2013
Author: Vladimir Komsiyski


The project registers the language QL in Eclipse, provides syntax highlight, outline, and error checking.


QL specification: each QL file has the following structure:

form <form_name> { (Statement)+ }

where

Statement = Question|Conditional

and Question has the following structure:

<type> <name> = <label> (expression)?

and Conditional is as follows:

if (condition) {Statement*} (else Conditional)* (else {Statement*})?

type = bool|int|string|float|date

Basic typecheck is performed. 

 
