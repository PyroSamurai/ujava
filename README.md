# ujava
A library which extends Java so it can mimic having unsigned primitive datatypes

__License__: LGPLv3+


__Compiling and Packaging__:

Assuming you have [Java JDK](http://jdk.java.net) installed,<br/>
Enter `ujava` folder via the command prompt or terminal.

Then enter:
```bash
javac -d . ./src/*.java
```

Then enter:
```bash
jar cf ujava.jar ujava
```

You are done making the library.

__To Use__:

Copy & paste `ujava.jar` to your 3rd-party lib folder.

Then add to your program:
```java
import ujava.*;
```

Don't forget to add your 3rd-party lib folder to your classpath for both 
the compile and run commands for your program.
