# SouthParkLang
A southpark inspired language

# Documentation

https://toddmartin.dev/docs/southparklang/


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

# Interactive Interpreter

To use the interactive interpreter, just invoke the interpreter without any arguements. However, currently, the interactive interpreter is for one-liners.

# Interpret from file

To interpret from file, invoke interpreter with an argument that is the path and file name of the source file. 

# Constants

There is not an ability to use constant values. Currently the only constant value is "treeFiddy," which give the value of 350.

# TO-DO
- Clean up Interpreter code
- Add If-then-else feature
- Add while loop feature
- Add variable feature
