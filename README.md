# AspectJ Examples
Aspect Oriented Programming is a programming paradigm that aims to increase
modularity by allowing the separation of cross-cutting concerns. 
It does so by adding behavior to existing code without modifying the code itself,
instead separately specifying which code is modified via a "pointcut" specification, 
such as log all function calls when the function's name begins with 'set' 
[From Wikipedia]

Aspect-oriented programming is a way of modularizing crosscutting concerns much like object-oriented programming is a way of modularizing common concerns. 
AspectJ is an implementation of aspect-oriented programming for Java.
[From Aspect Documentation]


### Topics Covered 
* Looking at only Compile-time weaving (There are post-compile and load-time weaving
  which we will not cover)
* Demonstrating method call join point.
* Demonstrating named pointcut with context.
* Demonstrating various advice including before around, and after.
* Demonstrating aspectj with annotations.



[Full Documentation About AspectJ](https://www.eclipse.org/aspectj/doc/released/progguide/starting.html)