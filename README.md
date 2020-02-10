## MicroJava language implementation?
The project have to be in the ~/GraalVMCourse/Source/trufflecourse/code
---
### WHAT WE HAVE DONE?
So far (during the course and after it) we implemented:
- Program (without ClassDecl)
- ConstDecl 
- VarDecl (Variables with strict typing, implemented our type system)
- MethodDecl 
- Type
- Block
- Statement (without "read")
- Assignop
- Condition
- CondTerm
- CondFact
- Relop
- Expr
- Term
- Factor (without arrays)
- Designator
- Addop
- Mulop
---
### Details
We have done almost everything except the classes and Arrays
We rewrote a lot of the code in the RecursiveDescentParser (added custom functions and a little bit have changed previous code).
Also we added a few Tokens (`false` and `true`). 
Realized Type system with Integer, Float, Boolean and Char and type checking (you can not assign the character to the integer etc.) And we have global and local variables.
Realized `break`, `continue`, `final`, all Assignops (`+=`, `-=`, `/=`, `*=`, `%=`).
Also we did the management of recursion calling of the functions, unary operations (`negation` and `logical not`).
We don\`t have to scope of variables (only global and local ones).
### In progress
Arrays are also written, but we are not ready with parsing it and working with it.
