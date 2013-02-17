Form generation
===============

# Introduction
A QL form consists of a plain text .q file containing a form declaration. 
The format will be explained here.

# Structure

## Formal
The formal grammar of the form can be found [here](../src/lang/ql/syntax/QL.rsc)

## Textual

### Form opening
A Form must start with the keyword *form*, followed by a title. The title must 
match the filename. The body of the form should be contained within curly 
braces. It can contain zero or more Statements. 

_Example_

```
form myForm {

} 
```

### Statements
A statement in a form is either a Question, a Calculated Question or a Conditional.

#### Question
A question is the primary resource of getting information. It can be defined 
according to a simple scheme. First is the text for the question, in quotes. 
It must be followed by the type, and finally a unique identifier must be given 
to the question.

_Example_

```
"Foo bar?" boolean myFooBool
```

#### Calculated Question
A calculated question is like a normal question, but calculates it's own value
according to a given expression. Can't be directly edited. 

_Example_

```
"Foo bar?" integer myCalc = 100 * foo / (bar + 10)
```
#### Conditional
A conditional is a c-like if statement. It has an obligatory if(<condition>), 
after which a body is declared with opening and closing curlies. The body of
an if statemunt must have at least one statement.

Next to the if statement, 0 or more else if blocks, and 0 or 1 else block can be
added to the form. Again, all of these must have at least one statement as 
their body. 

_Example_

```
if(myVal == true) {
    "myBody" boolean myBody
}

if(myVal == true) {
    "myFoo" boolean myFoo
} else {
    "myBar" boolean myBar
}
```
### Expression
* See the syntax. Most of the usual operators are in there.

### Types
The QL language contains various types
* string: An arbitrary string of text. "Foo", "B a_R", ...
* integer: An integer. 1, 3, ...
* money: A fixed-precision decimal number used for money. 1, 13.37, ...
* boolean: A boolean value. true, false
* date: A date value, in yyyy-mm-dd value, prepended by a $. $2013-02-17, $2000-01-01 
