# SouthParkLang
A southpark inspired language


# Use
Right now, SouthParkLang is crude and very basic. It is a functional language implementeded in Java. The java runtime environment is needed to run the interpreter for the program.

Every operator and paramter right now requires a space input between. The currently availible functions print and perform basic artihmetic operations (add, subtract, multiply, and divide).

print function - cartmanSays
addition - +
subtraction - -
multiply - *
divide - /

Here is a sample function the print the output of an addition and subtraction operation.

( cartmanSays ( + ( + 1 1 ) ( - 2 4 ) ) )

Sample output: 4.0

Important to note about this language currently. Mathematical operations are conducted from right to left. So in the above program is seen as (4-2) + (1+1). Also, every integer is handled as a double value. 

One last important note for this language in the current state. There does not currently exist much checking of the langauge. So, mistypes and errors in logic will break the program and not notify the user who is operating the interpreter. 

# TO-DO
- Write documentation
- Create interpreter interface to interpret from file
- Clean up Interpreter code
- Add If-then-else feature
- Add while loop feature
- Add variable feature
